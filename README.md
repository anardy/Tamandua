[![Build Status](https://travis-ci.org/anardy/Tamandua.svg?branch=master)](https://travis-ci.org/anardy/Tamandua)

# Tamandua

Aplicação para controle do Banco Comunitário Tamanduá.

# Próxima Versão

- Spring Security
- Upgrade Spring Framework (3.2.8)

# Requisitos para execução do Projeto

* [Maven](http://maven.apache.org/-maven)
* [WildFly](http://wildfly.org/)
* [Projeto Tamandua WebService](https://github.com/anardy/TamanduaWS)

# Clone Projeto

```
$ git clone git://github.com/anardy/Tamandua.git
```

# Maven

```
$ mvn clean install
```

# Configurando Log

Altere o caminho do arquivo WebContent/classes/log4j.xml

```xml
<param name="File" value="SeuCaminho\tamandua.log"/>
```

Obs: Caso rode no Windows use duas barras `SeuCaminho\\tamandua.log`

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
