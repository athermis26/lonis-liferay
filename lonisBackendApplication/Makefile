IMAGE_NAME=lonis-backend-spring
PREPROD_TAG=preprod-lonis-backend-spring-1.0.29
PROD_TAG=prod-lonis-backend-spring-1.0.0
REPOSITORY=dfteam/df

# =========================
# PREPROD
# =========================
docker-build-preprod:
	mvn clean install -DskipTests
	docker build -t $(IMAGE_NAME):$(PREPROD_TAG) .
	docker tag $(IMAGE_NAME):$(PREPROD_TAG) $(REPOSITORY):$(PREPROD_TAG)
	echo $$DOCKER_PASSWORD | docker login -u $$DOCKER_USERNAME --password-stdin
	docker push $(REPOSITORY):$(PREPROD_TAG)

# =========================
# PROD
# =========================
docker-build-prod:
	mvn clean install -DskipTests
	docker build --platform linux/amd64 -t $(IMAGE_NAME):$(PROD_TAG) .
	docker tag $(IMAGE_NAME):$(PROD_TAG) $(REPOSITORY):$(PROD_TAG)
	echo $$DOCKER_PASSWORD | docker login -u $$DOCKER_USERNAME --password-stdin
	docker push $(REPOSITORY):$(PROD_TAG)