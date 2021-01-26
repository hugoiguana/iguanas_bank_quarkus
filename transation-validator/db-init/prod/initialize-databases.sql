CREATE ROLE iguanasbank WITH LOGIN PASSWORD 'iguanasbank';
CREATE ROLE iguanasbanktransactionvalidator WITH LOGIN PASSWORD 'iguanasbanktransactionvalidator' NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

CREATE DATABASE iguanas_bank_transaction_validator;

GRANT ALL PRIVILEGES ON DATABASE iguanas_bank_backoffice TO iguanasbank ;
GRANT ALL PRIVILEGES ON DATABASE iguanas_bank_backoffice TO iguanasbanktransactionvalidator;