FROM gradle:8.10.2-jdk17 AS build
WORKDIR /app

COPY settings.gradle .
COPY build.gradle .

COPY event-handler/ event-handler/
COPY core-service/ core-service/
COPY common/ common/

RUN gradle clean build

FROM openjdk:17-jdk-slim
COPY --from=build /app/core-service/build/libs/core-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]