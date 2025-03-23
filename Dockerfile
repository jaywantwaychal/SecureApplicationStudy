FROM openjdk:23
EXPOSE 8080:8282
COPY /build/libs/secureappstudy-0.0.1-SNAPSHOT.jar secureappstudy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/secureappstudy-0.0.1-SNAPSHOT.jar"]
