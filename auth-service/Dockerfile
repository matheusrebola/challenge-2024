FROM openjdk:17-alpine
COPY build/libs/*.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "auth.jar"]
