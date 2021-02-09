#!/bin/bash

cd backoffice
mvn clean package
cd ..
cd transation-validator
mvn clean package
cd ..
docker-compose -f docker-compose-prod.yaml up
