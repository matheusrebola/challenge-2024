FROM openjdk:17-alpine
COPY build/libs/*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "orchestrator.jar"]
