# MultiStage build

FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests



FROM openjdk:17
WORKDIR /app
COPY --from=build ./build/target/*.jar ./convidados.jar
ENTRYPOINT java -jar convidados.jar