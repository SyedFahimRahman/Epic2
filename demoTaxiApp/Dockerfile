#
# Build stage
#
FROM maven:latest AS build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN --mount=type=cache,target=/root/.m2 mvn -f $HOME/pom.xml clean package

#
# Package stage
#
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

ARG JAR_FILE=/usr/app/target/taxiapp.jar
COPY --from=build $JAR_FILE /app/runner.jar

# Bring in the graph.json file to seed the application
ENTRYPOINT java -jar /app/runner.jar