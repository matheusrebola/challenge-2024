#!/bin/bash

# Lista dos diretórios de microserviços
SERVICES=(
    "order-service"
    "orchestrator-service"
    "item-service"
    "search-service"
)

# Função para buildar e criar imagem Docker para cada serviço
build_service() {
    SERVICE_DIR=$1
    echo "Building $SERVICE_DIR..."
    
    # Navega para o diretório do serviço
    cd $SERVICE_DIR || exit
    
    # Limpa e builda o projeto usando Gradle/Maven (ajuste conforme necessário)
    ./gradlew clean build || ./mvnw clean package
    
    # Cria a imagem Docker usando o Dockerfile no diretório do serviço
    docker build -t $SERVICE_DIR:latest .
    
    # Volta para o diretório raiz
    cd ..
}

# Percorre todos os serviços e executa a função de build
for SERVICE in "${SERVICES[@]}"
do
    build_service $SERVICE
done

echo "Todos os microserviços foram buildados e imagens Docker foram criadas."
