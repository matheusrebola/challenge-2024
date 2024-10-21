import os
import subprocess

# Diretórios com os arquivos docker-compose.yml
SERVICES = [
    ".",
    "order-service"
    "orchestrator-service"
    "item-service"
    "search-service"
]

def is_container_running(service_name):
    """
    Verifica se o container do serviço está em execução.
    """
    try:
        result = subprocess.run(
            ["docker", "ps", "--filter", f"name={service_name}", "--format", "{{.Names}}"],
            capture_output=True, text=True
        )
        return service_name in result.stdout
    except Exception as e:
        print(f"Erro ao verificar o container {service_name}: {e}")
        return False

def start_service(service_dir):
    """
    Executa o comando docker-compose up -d no diretório do serviço.
    """
    try:
        print(f"Iniciando containers no diretório: {service_dir}")
        subprocess.run(["docker-compose", "up", "-d"], cwd=service_dir, check=True)
    except subprocess.CalledProcessError as e:
        print(f"Erro ao iniciar o serviço no diretório {service_dir}: {e}")

def main():
    for service_dir in SERVICES:
        # Extraia o nome do container principal do serviço a partir do diretório
        service_name = os.path.basename(os.path.normpath(service_dir))
        
        # Verifique se o container está rodando
        if not is_container_running(service_name):
            start_service(service_dir)
        else:
            print(f"O serviço {service_name} já está em execução.")

if __name__ == "__main__":
    main()
