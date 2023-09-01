# Use a base image with a JRE to run the Java application
FROM openjdk:8-jre-alpine

# Install curl (if not already installed)
RUN apk --no-cache add curl

# Define environment variables for Nexus repository authentication
ENV NEXUS_USER=admin
ENV NEXUS_PASSWORD=nexus

# Define the Nexus repository URL and artifact coordinates
ENV NEXUS_REPO_URL=http://192.168.1.14:8081/repository/maven-releases
ENV ARTIFACT_GROUP=com/exemple
ENV ARTIFACT_NAME=BiatDSI
ENV ARTIFACT_VERSION=1.0

# Set the working directory inside the container
WORKDIR /app

# Download the JAR file from Nexus and name it app.jar
RUN curl -u $NEXUS_USER:$NEXUS_PASSWORD -o app.jar "$NEXUS_REPO_URL/$ARTIFACT_GROUP/$ARTIFACT_NAME/$ARTIFACT_VERSION/$ARTIFACT_NAME-$ARTIFACT_VERSION.jar" -L

# Expose the port that the Spring Boot application will listen on
EXPOSE 8089

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
