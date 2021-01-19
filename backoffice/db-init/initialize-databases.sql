CREATE ROLE iguanasbank WITH LOGIN PASSWORD 'iguanasbank';
CREATE ROLE iguanasbankbackoffice WITH LOGIN PASSWORD 'iguanasbankbackoffice' NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

CREATE DATABASE iguanas_bank_backoffice;

GRANT ALL PRIVILEGES ON DATABASE iguanas_bank_backoffice TO iguanasbank ;
GRANT ALL PRIVILEGES ON DATABASE iguanas_bank_backoffice TO iguanasbankbackoffice;