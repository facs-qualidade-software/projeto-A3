#!/bin/bash

HOST=$1
USUARIO=$2
SENHA=$3
PASTAPROJETO=$4
NOMEPASTAJACOCO=$5

ftp -inv $HOST <<END_SCRIPT
user $USUARIO $SENHA
cd $PASTAPROJETO
mkdir $NOMEPASTAJACOCO
cd $NOMEPASTAJACOCO
mput index.html jacoco.csv jacoco.xml jacoco-sessions.html
ls
quit
END_SCRIPT
exit 0
