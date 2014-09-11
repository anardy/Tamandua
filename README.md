Tamandua
======

Aplicação para controle do Banco Comunitário Tamanduá.

Status do Projeto: Em Desenvolvimento!

# Requisitos para execução do Projeto

* [Maven](http://maven.apache.org/-maven)
* [WildFly](http://wildfly.org/)
* [MySQL](http://www.mysql.com/-mysql)
* [Projeto Tamandua WebService](https://github.com/anardy/TamanduaWS)

# Clone Projeto

```
git clone git://github.com/anardy/Tamandua.git
```

# Banco de Dados

1. Acesso o MySQL

```sql
> myslq create database tamandua
```

2. Importe o SQL

```sql
> mysql -u root -p tamandua < tamandua.sql
```

# Configurando o WildFly

1. DataSource

# Maven

```
$ mvn clean install
```

# Web Container

Com o `.war` faça o deploy

# Acessando

http://localhost:8080/login.do

### Dados de acesso ao Sistema

#### Login

Usuário: user

Senha: 321

#### Conta Bancária

Número da conta: 1

Senha da conta: 123456 
