#!/bin/bash

# Esperar Kafka e Debezium estarem prontos
sleep 100

# Criar conector Debezium
curl -X POST http://localhost:8083/connectors -H "Content-Type: application/json" -d '{
  "name": "vivo-api-connector",
  "config": {
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
    "database.hostname": "postgres",
    "database.port": "5432",
    "database.user": "debezium",
    "database.password": "dbz",
    "database.dbname": "vivo_api",
    "database.server.name": "vivo-api",
    "plugin.name": "pgoutput",
    "slot.name": "debezium",
    "database.history.kafka.bootstrap.servers": "kafka:9092",
    "database.history.kafka.topic": "dbhistory.vivo-api",
    "table.include.list": "public.product,public.price,public.description"
  }
}'
