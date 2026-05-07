# =====================================================================
# Lonis Backend (Spring Boot 4.0.6) — image conteneurisée
#
# Build      :  docker build -t lonis-backend .
# Run        :  docker run --rm -p 9090:9090 \
#                  -e SPRING_DATASOURCE_URL=jdbc:postgresql://<host>:5432/l_caisse_new_db \
#                  -e SPRING_DATASOURCE_USERNAME=diginUser \
#                  -e SPRING_DATASOURCE_PASSWORD=admin1234 \
#                  -e LONIS_API_KEY=<your-api-key> \
#                  -e SPRING_DATASOURCE_PASSWORD=<bd-password>
#                  lonis-backend
# =====================================================================

# =========================
# STAGE 1 — BUILD
# =========================
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY .mvn/ .mvn/
RUN mvn -B -q dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests -B

# =========================
# STAGE 2 — RUNTIME
# =========================
FROM eclipse-temurin:17-jre

# Install wget for healthcheck
RUN apt-get update && apt-get install -y wget && rm -rf /var/lib/apt/lists/*

# Create non-root user
RUN groupadd --system spring && \
    useradd --system --gid spring --create-home --shell /usr/sbin/nologin spring

WORKDIR /app

# Create folders
RUN mkdir -p /app/uploads /app/logs && \
    chown -R spring:spring /app

# Copy jar
COPY --from=build --chown=spring:spring /app/target/*.jar app.jar

USER spring:spring

EXPOSE 9090

# Non-sensitive defaults only
ENV TZ=Africa/Abidjan

# Healthcheck
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:9090/actuator/health || exit 1

# Start app
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -Duser.timezone=$TZ $JAVA_OPTS -jar /app/app.jar"]













#FROM eclipse-temurin:17-jdk-alpine AS build
#
#WORKDIR /workspace
#
## Cache des dépendances Maven : on copie d'abord pom.xml + mvnw, puis on
## pré-télécharge les deps. Tant que pom.xml ne change pas, ce layer est
## réutilisé sur les rebuilds suivants.
#COPY mvnw mvnw.cmd ./
#COPY .mvn .mvn
#COPY pom.xml ./
#RUN chmod +x ./mvnw && ./mvnw -B -ntp dependency:go-offline
#
## Build effectif
#COPY src ./src
#RUN ./mvnw -B -ntp -DskipTests package \
#    && cp target/*.jar /workspace/app.jar
#
## ---------- Stage 2 : runtime ----------
#FROM eclipse-temurin:17-jre-alpine
#
## Utilisateur non-root pour la sécurité.
#RUN addgroup -S lonis && adduser -S lonis -G lonis
#
#WORKDIR /app
#COPY --from=build /workspace/app.jar /app/app.jar
#
## Profil par défaut "docker" — variables d'env attendues :
##   SPRING_DATASOURCE_URL, SPRING_DATASOURCE_USERNAME, SPRING_DATASOURCE_PASSWORD
##   LONIS_API_KEY  (header X-API-Key attendu côté Liferay)
##   SERVER_PORT    (défaut 9090)
#ENV SPRING_PROFILES_ACTIVE=docker \
#    JAVA_OPTS=""
#
#USER lonis:lonis
#EXPOSE 9090
#
## Healthcheck via Actuator
#HEALTHCHECK --interval=30s --timeout=5s --start-period=30s --retries=3 \
#    CMD wget -qO- http://localhost:9090/actuator/health | grep -q '"status":"UP"' || exit 1
#
#ENTRYPOINT ["sh","-c","exec java $JAVA_OPTS -jar /app/app.jar"]
