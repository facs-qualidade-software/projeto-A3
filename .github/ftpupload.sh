#!/bin/bash

HOST=$1
USUARIO=$2
SENHA=$3

PASTAPROJETO="facs-qualidade-software-projetoA3"
DATAHORARIO=$(date '+%F__%H-%M-%S')
NOMEPASTAJACOCO="relatorio_jacoco__parcial__${DATAHORARIO}"
ARQUIVOXML="./target/site/jacoco/jacoco.xml"

ftp -inv $HOST <<END_SCRIPT
user $USUARIO $SENHA
cd $PASTAPROJETO
passive
mkdir $NOMEPASTAJACOCO
cd $NOMEPASTAJACOCO
put $ARQUIVOXML
ls
quit
END_SCRIPT
exit 0
