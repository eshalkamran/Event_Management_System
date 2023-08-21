# Use the official maven/Java 11 image to create a build artifact.
# This is based on Debian and sets the MAVEN_HOME environment variable
FROM maven:3.8.2-jdk-11-slim AS build
WORKDIR /usr/src/app
COPY pom.xml .
# download all required dependencies for building
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package

# Use the official Java runtime base image based on Debian
FROM openjdk:11-jre-slim
# set the app home folder
WORKDIR /app
# copy only the built artifact from the build stage and unpack it
COPY --from=build /usr/src/app/target/*.jar ./app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]