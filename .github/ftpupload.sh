#!/bin/bash

HOST=$1
USUARIO=$2
SENHA=$3
DATAHORARIO=$4

PASTAPROJETO="facs-qualidade-software-projetoA3"
NOMEPASTAJACOCO="relatorio_jacoco__${DATAHORARIO}"
PASTAJACOCORESOURCES="jacoco-resources"
PASTAMERCADINHOAPP="mercadinho.app"

ftp -inv $HOST <<END_SCRIPT
user $USUARIO $SENHA
cd $PASTAPROJETO
mkdir $NOMEPASTAJACOCO
cd $NOMEPASTAJACOCO
mput index.html jacoco.csv jacoco.xml jacoco-sessions.html
mkdir $PASTAJACOCORESOURCES
cd $PASTAJACOCORESOURCES
mput $PASTAJACOCORESOURCES/*
cd ..
mkdir $PASTAMERCADINHOAPP
cd $PASTAMERCADINHOAPP
mput $PASTAMERCADINHOAPP/*
ls
quit
END_SCRIPT
exit 0
