# projeto-A3
Projeto A3 - Qualidade de Software

DATABASE QUERY (postgreSQL in Supabase):

CREATE DATABASE mercadinho;

CREATE TABLE IF NOT EXISTS clientes (
id SERIAL PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(20) NOT NULL UNIQUE,
data_de_nascimento VARCHAR(10) NOT NULL
);

