#!/bin/bash

cd backoffice
mvn clean package
cd ../transaction-validator
mvn clean package
cd ..
docker-compose -f docker-compose-prod.yaml up
