FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:nexus -o Pidev_4SAE2.jar "http://192.168.0.4:8081/repository/maven-releases/com/exemple/Pidev_4SAE2/1.0/Pidev_4SAE2-1.0.jar" -L
ENTRYPOINT ["java","-jar","/Pidev_4SAE2.jar"]
EXPOSE 8089


