# Use a imagem base do OpenJDK 11
FROM openjdk:21

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da aplicação para o diretório de trabalho no contêiner
COPY target/your-application.jar /app/challenge-application.jar

# Define o comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "challenge-application.jar"]