FROM openjdk:17-alpine
COPY build/libs/*.jar app.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "vivo.jar"]
