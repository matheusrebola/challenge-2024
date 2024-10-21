FROM openjdk:17-alpine
COPY build/libs/*.jar app.jar
EXPOSE 8093
ENTRYPOINT ["java", "-jar", "item.jar"]
