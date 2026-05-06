# Lonis Backend (Spring Boot)

Backend Spring Boot 4.0.6 (MVC) qui expose les données du domaine **Lonis** stockées
dans une base PostgreSQL externe à Liferay. Les modules Liferay
`lonisVenteRest` / `lonisReseauRest` consomment ce backend en HTTP.

## Stack

- Spring Boot 4.0.6 (stable)
- Java 17
- Spring MVC + Spring Data JPA + Bean Validation
- PostgreSQL + Flyway
- springdoc-openapi (Swagger UI)
- Maven (`./mvnw`)

## Périmètre actuel (v1)

3 domaines exposés sous `/api/v1/...` :

| Endpoint                                    | Description                              |
|---------------------------------------------|------------------------------------------|
| `GET    /api/v1/concessionnaires`           | Liste paginée + recherche                |
| `GET    /api/v1/concessionnaires/{id}`      | Détail                                   |
| `GET    /api/v1/concessionnaires/{id}/produits` | Liaison concessionnaire-produit       |
| `POST   /api/v1/concessionnaires`           | Création                                 |
| `PUT    /api/v1/concessionnaires/{id}`      | Mise à jour                              |
| `DELETE /api/v1/concessionnaires/{id}`      | Suppression                              |
| `GET    /api/v1/produits`                   | Liste paginée + recherche                |
| `… CRUD produits …`                         |                                          |
| `GET    /api/v1/terminals`                  | Liste paginée + filtres `statutValidation` |
| `… CRUD terminals …`                        |                                          |

Les autres entités (Site, ChiffreAffaires, Commission, Operation, Commercial,
SiteCommercial, Visite, Objectif, Evaluation) seront ajoutées dans des
migrations Flyway `V2__…sql`, `V3__…sql`, etc.

## Prérequis

- JDK 17
- Maven Wrapper inclus (`./mvnw` / `mvnw.cmd`)
- PostgreSQL local accessible. Par défaut le profil `local` se connecte à :
  - `jdbc:postgresql://localhost:5432/l_caisse_new_db`
  - user : `diginUser` / pwd : `admin1234`

Crée la base si nécessaire :

```sql
CREATE DATABASE l_caisse_new_db;
CREATE USER "diginUser" WITH PASSWORD 'admin1234';
GRANT ALL PRIVILEGES ON DATABASE l_caisse_new_db TO "diginUser";
```

## Lancer en local

```bash
# Depuis ce dossier
./mvnw spring-boot:run
```

ou

```bash
./mvnw clean package
java -jar target/lonisBackendApplication-0.0.1-SNAPSHOT.jar
```

L'app écoute sur **http://localhost:9090** (variable `SERVER_PORT`).

Au démarrage Flyway exécute `db/migration/V1__init.sql` qui crée les 4 tables
`concessionnaires`, `produits`, `concessionnaire_produit`, `terminals`.

## Authentification

Toutes les routes `/api/**` exigent le header :

```
X-API-Key: dev-change-me
```

Surchargeable via la variable d'environnement `LONIS_API_KEY`.

Sont exemptés : `/actuator/health`, `/actuator/info`, `/swagger-ui`, `/v3/api-docs`.

## Documentation interactive

- Swagger UI : http://localhost:9090/swagger-ui.html
- OpenAPI JSON : http://localhost:9090/v3/api-docs

## Tests

```bash
./mvnw test
```

Les tests utilisent H2 (déclaré en `scope=test`).

## Connexion depuis Liferay

Le module `modules/lonisVenteRest/lonisVenteRest-impl` expose un client OSGi
(`BackendHttpClient`) configuré par le fichier :

```
configs/local/osgi/configs/com.df.lonis.ventesrest.internal.backend.BackendClientConfiguration.config
```

Aligner les valeurs `baseUrl` et `apiKey` côté Liferay et `lonis.security.api-key` ici.

## Roadmap

- [ ] Migrer Site, ChiffreAffaires, Commission, Operation
- [ ] Migrer Commercial, SiteCommercial, Visite, Objectif, Evaluation
- [ ] Endpoint d'agrégation `/api/v1/concessionnaires/top-actifs` (remplace
      `getTopConcessionnairesActifs` côté Liferay)
- [ ] Brancher `lonisReseauRest-impl`
- [ ] Durcir l'auth (JWT ou mTLS) après validation du POC
