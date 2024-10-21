import subprocess
import os

# Lista dos diretórios de microserviços
services = [
    "order-service",
    "orchestrator-service",
    "item-service",
    "search-service",
    "update-service"
]

def build_service(service_dir):
    print(f"Building {service_dir}...")
    
    # Navega para o diretório do serviço
    try:
        os.chdir(service_dir)
        
        # Limpa e builda o projeto usando Gradle/Maven (ajuste conforme necessário)
        gradle_command = "./gradlew clean build"
        maven_command = "./mvnw clean package"
        
        # Tenta buildar usando Gradle, se falhar tenta com Maven
        try:
            subprocess.run(gradle_command, shell=True, check=True)
        except subprocess.CalledProcessError:
            subprocess.run(maven_command, shell=True, check=True)
        
        # Cria a imagem Docker usando o Dockerfile no diretório do serviço
        docker_command = f"docker build -t {service_dir}:latest ."
        subprocess.run(docker_command, shell=True, check=True)
    
    finally:
        # Volta para o diretório raiz
        os.chdir("..")

# Percorre todos os serviços e executa a função de build
for service in services:
    build_service(service)

print("Todos os microserviços foram buildados e imagens Docker foram criadas.")