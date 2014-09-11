Tamandua
======

Aplica��o para controle do Banco Comunit�rio Tamandu�.

Status do Projeto: Em Desenvolvimento!

# Requisitos para execu��o do Projeto

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

Com o `.war` fa�a o deploy

# Acessando

http://localhost:8080/login.do

### Dados de acesso ao Sistema

#### Login

Usu�rio: user

Senha: 321

#### Conta Banc�ria

N�mero da conta: 1

Senha da conta: 123456 
