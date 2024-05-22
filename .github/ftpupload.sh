#!/bin/bash

HOST=$1
USUARIO=$2
SENHA=$3

PASTAPROJETO="facs-qualidade-software-projetoA3"
DATAHORARIO=$(date '+%F__%H-%M-%S')
NOMEPASTAJACOCO="relatorio_jacoco__parcial__${DATAHORARIO}"
ARQUIVOORIGEM="./target/site/jacoco/jacoco.xml"
ARQUIVODESTINO="jacoco.xml"

ftp -inv $HOST <<END_SCRIPT
user $USUARIO $SENHA
cd $PASTAPROJETO
mkdir $NOMEPASTAJACOCO
cd $NOMEPASTAJACOCO
put $ARQUIVOORIGEM $ARQUIVODESTINO
ls
quit
END_SCRIPT
exit 0
