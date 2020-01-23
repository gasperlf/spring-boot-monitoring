#!/bin/sh

echo "\nExecuting Maven to build the apps..."

mvn clean package -DskipTests=true

if [ $? -gt 0 ]
then
    echo "\nMaven process was unsuccessful! Please check the errors :("
    exit 1;
fi
echo "\nMaven process finished!"

echo "Running docker compose [docker-compose up --no-start]"

#docker-compose up --no-start
docker-compose up -d

if [ $? -gt 0 ]
then
    echo "docker-compose process was unsuccessful! Please check the errors and try again :("
    exit 1;
fi

echo "Ended docker compose running [docker-compose up -d]"