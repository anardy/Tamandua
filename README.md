Tamandua
======

Aplicação para controle do Banco Comunitário Tamanduá.

Status do Projeto: ```Em Desenvolvimento

Requisitos para execução do Projeto
======

* [Maven](link-maven)
* [Tomcat](link-tomcat)
* [MySQL](link-mysql)
* [Projeto Tamandua WebService](link-projetows)

Banco de Dados
======

Preparaçao

```sql

1. Acesso o Mysql
Myslq create database tamandua

2. Importe o SQL
Mysql -u root -p tamandua < tamandua.sql

Clone Projeto
======

Comando do git clone

Maven
======

Mvn package

Tomcat

Com o ```.war faça o deploy no Tomcat
