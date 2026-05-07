# Lonis Backend (Spring Boot)

Backend Spring Boot 4.0.6 (MVC) qui expose les données du domaine **Lonis** stockées
dans une base PostgreSQL externe à Liferay. Les modules Liferay
`lonisVenteRest` / `lonisReseauRest` consomment ce backend en HTTP via
le header `X-API-Key`.

## Stack

- Spring Boot 4.0.6 (stable)
- Java 17
- Spring MVC + Spring Data JPA + Bean Validation
- PostgreSQL
- springdoc-openapi (Swagger UI)
- Maven (`./mvnw`)

## Endpoints (50, sous `/api/v1/...`)

**Vente** (consommé par `lonisVenteRest`) :
- `/dashboard/kpis`
- `/concessionnaire(s)` (liste, détail 360°, top-actifs, produits, commissions, terminaux)
- `/produits`
- `/sites`, `/sites-all`
- `/terminaux`, `/terminaux/top-actifs`
- `/operations`, `/operations/{id}`
- `/commissions`, `/commissions/{id}`
- `/chiffres-affaires`

**Réseau** (consommé par `lonisReseauRest`) :
- `/terminals` CRUD + `/a-valider`, `/{id}/valider`, `/{id}/rejeter`, `/cartographie`, `/cartographie/top20`, `/{id}/visites`
- `/commerciaux` CRUD + affectations sites
- `/sites/{id}/commerciaux`
- `/visites`, `/visites/temps-reel`, `/commerciaux/{id}/visites`, `/visites/planning`
- `/objectifs`, `/commerciaux/{id}/objectifs`
- `/evaluations/classement`, `/commerciaux/{id}/evaluations`, `/evaluations/generer`

Documentation interactive : `http://localhost:9090/swagger-ui.html`

## Authentification

Toutes les routes `/api/**` exigent le header `X-API-Key` (par défaut `dev-change-me`,
surchargeable via `LONIS_API_KEY`). Sont exemptés : `/actuator/health`, `/actuator/info`,
`/swagger-ui`, `/v3/api-docs`.

## Base de données

⚠️ **Flyway est désactivé** (`spring.flyway.enabled=false`) et `ddl-auto=none` : la base
PostgreSQL doit déjà exister et être pré-remplie avec le schéma. Les scripts de référence
sont dans `src/main/resources/db/migration/V1__init.sql`, `V2__lot1.sql`, `V3__lot2.sql` —
à appliquer manuellement (`psql -f …`) avant le premier démarrage.

```sql
CREATE DATABASE l_caisse_new_db;
CREATE USER "diginUser" WITH PASSWORD 'admin1234';
GRANT ALL PRIVILEGES ON DATABASE l_caisse_new_db TO "diginUser";
```

Puis :

```bash
psql -U diginUser -d l_caisse_new_db -f src/main/resources/db/migration/V1__init.sql
psql -U diginUser -d l_caisse_new_db -f src/main/resources/db/migration/V2__lot1.sql
psql -U diginUser -d l_caisse_new_db -f src/main/resources/db/migration/V3__lot2.sql
```

---

## 🐳 Lancer en conteneur Docker

### Build de l'image

```bash
docker build -t lonis-backend .
```

### Exécution simple

```bash
docker run --rm -p 9090:9090 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/l_caisse_new_db \
  -e SPRING_DATASOURCE_USERNAME=diginUser \
  -e SPRING_DATASOURCE_PASSWORD=admin1234 \
  -e LONIS_API_KEY=dev-change-me \
  lonis-backend
```

> Sous **Linux** ajouter `--add-host=host.docker.internal:host-gateway` pour que le
> conteneur puisse joindre un PostgreSQL tournant sur l'hôte.

### Avec Docker Compose

Le fichier `docker-compose.yml` lance le backend uniquement (PostgreSQL doit tourner ailleurs) :

```bash
# Build + run
docker compose up --build

# Arrêt
docker compose down
```

Tu peux surcharger les variables via un fichier `.env` à côté du `docker-compose.yml` :

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://10.0.0.5:5432/lonis_prod
SPRING_DATASOURCE_USERNAME=lonis_prod
SPRING_DATASOURCE_PASSWORD=********
LONIS_API_KEY=********
JAVA_OPTS=-Xms512m -Xmx1g
```

### Variables d'environnement supportées

| Variable                    | Défaut                                                       | Description                          |
|-----------------------------|--------------------------------------------------------------|--------------------------------------|
| `SPRING_PROFILES_ACTIVE`    | `docker` (dans l'image)                                      | Profil Spring                        |
| `SPRING_DATASOURCE_URL`     | `jdbc:postgresql://host.docker.internal:5432/l_caisse_new_db`| URL JDBC                             |
| `SPRING_DATASOURCE_USERNAME`| `diginUser`                                                  | Utilisateur BD                       |
| `SPRING_DATASOURCE_PASSWORD`| `admin1234`                                                  | Mot de passe BD                      |
| `LONIS_API_KEY`             | `dev-change-me`                                              | Clé attendue dans le header `X-API-Key` |
| `SERVER_PORT`               | `9090`                                                       | Port HTTP du conteneur               |
| `JAVA_OPTS`                 | (vide)                                                       | Options JVM additionnelles           |

### Healthcheck

L'image expose `/actuator/health`. Docker considère le conteneur sain dès que la BD répond.

### Image multi-stage

Le `Dockerfile` est en 2 étapes :
1. **build** (`eclipse-temurin:17-jdk-alpine`) — `mvnw package`
2. **runtime** (`eclipse-temurin:17-jre-alpine`) — JRE seul, utilisateur non-root

Image finale : ≈ 200 Mo.

---

## Lancer en local (hors conteneur)

```bash
# Mode dev (profil "local" → localhost:5432)
./mvnw spring-boot:run

# ou JAR auto-exécutable
./mvnw clean package
java -jar target/lonisBackendApplication-0.0.1-SNAPSHOT.jar
```

L'app écoute sur **http://localhost:9090** (variable `SERVER_PORT`).

## Tests

```bash
./mvnw test
```

## Connexion depuis Liferay

Les modules `lonisVenteRest-impl` et `lonisReseauRest-impl` exposent chacun une config OSGi :

```
configs/local/osgi/configs/com.df.lonis.ventesrest.internal.backend.BackendClientConfiguration.config
configs/local/osgi/configs/com.df.lonis.reseaurest.internal.backend.BackendClientConfiguration.config
```

Aligner `baseUrl` et `apiKey` côté Liferay avec `LONIS_API_KEY` ici.

## Roadmap

- [x] Lot 1 : Concessionnaire, Produit, Site, Terminal vente, Operation, Commission, ChiffreAffaires, Dashboard
- [x] Lot 2 : Terminal réseau (validation, cartographie), Commercial, SiteCommercial, Visite, Objectif, Evaluation
- [x] Conteneurisation Docker
- [ ] Durcir l'auth (JWT ou mTLS)
- [ ] CI/CD (build de l'image + push registre)
