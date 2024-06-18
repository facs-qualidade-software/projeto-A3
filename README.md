# projeto-A3

Projeto A3 - Qualidade de Software

## Documentação

[Link da documentação do projeto](https://github.com/facs-qualidade-software/docs)

Link para o vídeo da [Apresentação final](https://youtu.be/O7IDIvj921U).

## Banco de Dados:

DATABASE QUERY (postgreSQL in Supabase):

USE DATABASE postgres (SUPABASE somente aceita database padrão postgres na versão gratuita);

CREATE TABLE IF NOT EXISTS clientes (
id SERIAL PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(20) NOT NULL UNIQUE,
data_de_nascimento VARCHAR(10) NOT NULL
);
