FROM openjdk:17-alpine
COPY build/libs/*.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "price.jar"]
