Tamandua
======

Aplicação para controle do Banco Comunitário Tamanduá.

Status do Projeto: `Em Desenvolvimento`

Requisitos para execução do Projeto
======

* [Maven](http://maven.apache.org/-maven)
* [Tomcat](http://tomcat.apache.org/-tomcat)
* [MySQL](http://www.mysql.com/-mysql)
* [Projeto Tamandua WebService](https://github.com/anardy/TamanduaWS)

Banco de Dados
======

1. Acesso o Mysql
`myslq create database tamandua`

2. Importe o SQL
`mysql -u root -p tamandua < tamandua.sql`


Clone Projeto
======

`git clone git://github.com/anardy/Tamandua.git`

Maven
======

1. Acesse a pasta do projeto
2. Execute o seguinte comando: `mvn package`

Tomcat
======

Com o `.war` faça o deploy no Tomcat
