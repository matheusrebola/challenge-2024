import os
import threading

threads = []


def build_application(app):
    threads.append(app)
    print("Building application {}".format(app))
    os.system("cd {} && gradle build -x test".format(app))
    print("Application {} finished building!".format(app))
    threads.remove(app)


def docker_compose_up():
    print("Running containers!")
    os.popen("docker-compose up --build -d").read()
    print("Pipeline finished!")


def build_all_applications():
    print("Starting to build applications!")
    applications = [
        "auth-service",
        "description-service",
        "order-service",
        "orchestrator-service",
        "product-validation-service",
        "price-service",
        "vivo-api"
    ]
    for app in applications:
        thread = threading.Thread(target=build_application, args=(app,))
        thread.start()
        thread.join()  # Aguarda o término de cada thread


def remove_remaining_containers():
    print("Removing all containers.")
    os.system("docker-compose down")
    containers = os.popen('docker ps -aq').read().split('\n')
    containers.remove('')
    if len(containers) > 0:
        print("There are still {} containers created".format(containers))
        for container in containers:
            print("Stopping container {}".format(container))
            os.system("docker container stop {}".format(container))
        os.system("docker container prune -f")


if __name__ == "__main__":
    print("Pipeline started!")
    build_all_applications()
    remove_remaining_containers()
    threading.Thread(target=docker_compose_up).start()

