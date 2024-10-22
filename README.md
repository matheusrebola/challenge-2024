# Sistema de Gerenciamento de Produtos - Vivo

## Descrição do Projeto
O Sistema de Gerenciamento de Produtos é uma plataforma desenvolvida para a empresa do Challenge da FIAP de 2024 que permite aos usuários acessarem informações sobre os produtos disponíveis, incluindo telefonia móvel, internet, TV por assinatura, entre outros. O sistema fornece uma API RESTful para consulta de produtos por usuário e oferece uma variedade de funcionalidades, incluindo listagem de produtos, detalhes do produto e preços associados.

## Arquitetura
O projeto é desenvolvido com base em uma arquitetura de microsserviços Saga Orquestrado, utilizando tecnologias como Spring Boot, Apache Kafka, Redpandas e MongoDB. Os microsserviços são responsáveis por capturar dados dos sistemas legados, normalizá-los, armazená-los em um banco de dados canônico e fornecer acesso aos dados através de uma API.

## Endpoints da API
A API oferece os seguintes endpoints para consulta de produtos:

- `GET /order/{user_id}/products`: Lista os produtos associados a um usuário específico.

## Especificação da API
A especificação da API é descrita no arquivo `api-spec.yaml`, seguindo o padrão OpenAPI 3.0.0. Este arquivo define os endpoints disponíveis, os parâmetros necessários, os tipos de resposta e outras informações relevantes para o uso da API.

## Tecnologias Utilizadas
- Spring Boot: Para desenvolvimento rápido de microsserviços em Java.
- Redpandas: Para monitoramento dos tópicos do Kafka.
- Kubernets: Para balanceamento dos microserviços e bancos NoSQL.
- Apache Kafka: Para captura de eventos em tempo real e processamento assíncrono de mensagens.
- MongoDB: Para armazenamento de dados canônicos.
- Swagger/OpenAPI: Para documentação automática da API.

## Como Executar o Projeto
1. Clone o repositório para sua máquina local.
2. Certifique-se de ter o Java 21, Maven, Python e Docker instalados.
3. Rode os scripts start_containers.py e build_microservices.py
4. Acesse a documentação da API em `http://localhost:43000/swagger-ui.html`.
5. Acesse o Redpandas em `http://localhost:58081/`
