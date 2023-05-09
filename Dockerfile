# Stage 1: Build
FROM maven:3.8.1-jdk-8-slim AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:go-offline
COPY src /app/src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/spring-demo.jar /app
ENTRYPOINT ["java", "-jar", "spring-demo.jar"]