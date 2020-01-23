FROM openjdk:11

ARG version=0.0.1-SNAPSHOT
ARG nameArtifactory=api-finance-service
COPY target/${nameArtifactory}-${version}.jar /${nameArtifactory}.jar

ENV JAVA_OPTS ""

ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /api-finance-service.jar