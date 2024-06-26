---

# Sistema de Gerenciamento de Produtos - Challenge FIAP 2024

## Descrição do Projeto
O Sistema de Gerenciamento de Produtos é uma plataforma que permite aos usuários acessarem informações sobre os produtos disponíveis. O sistema fornece uma API RESTful para consulta de produtos por usuário e oferece uma variedade de funcionalidades, incluindo listagem de produtos, detalhes do produto e preços associados.

## Arquitetura
O projeto é desenvolvido com base em uma arquitetura de microsserviços, utilizando tecnologias como Spring Boot, Spring Integration, Apache Kafka e MongoDB. Os microsserviços são responsáveis por capturar dados dos sistemas legados, normalizá-los, armazená-los em um banco de dados canônico e fornecer acesso aos dados através de uma API.

## Endpoints da API
A API oferece os seguintes endpoints para consulta de produtos:

- `GET /users/{user_id}/products`: Lista os produtos associados a um usuário específico.

## Especificação da API
A especificação da API é descrita no arquivo `api-spec.yaml`, seguindo o padrão OpenAPI 3.0.0. Este arquivo define os endpoints disponíveis, os parâmetros necessários, os tipos de resposta e outras informações relevantes para o uso da API.

## Tecnologias Utilizadas
<br>[![SkillIcons](https://skillicons.dev/icons?i=java,aws,spring,mongo,docker,kafka,sass)](https://skillicons.dev)<br/>

## Como Executar o Projeto
1. Clone o repositório para sua máquina local.
2. Certifique-se de ter o Java 21 e o Maven instalados.
3. Navegue até o diretório raiz do projeto e execute `mvn spring-boot:run`.
4. Acesse a documentação da API em `http://localhost:8080/swagger-ui.html`.

---
