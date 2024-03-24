# Documentação do Projeto Java - Sistema Transacional

## Índice

- [Visão Geral](#visão-geral)
- [Criação do Projeto](#1-criação-do-projeto)
    - [Tecnologias Utilizadas](#11-tecnologias-utilizadas)
    - [Ferramentas Utilizadas](#12-ferramentas-utilizadas)
- [Configuração das Classes e Banco de Dados](#2-configuração-das-classes-e-banco-de-dados)
    - [pom.xml](#21-pomxml)
    - [application.properties](#22-applicationproperties)
    - [Classes de Modelo](#23-classes-de-modelo)
    - [Repositórios JPA](#24-repositórios-jpa)
- [Implementação da Interface Web](#3-implementação-da-interface-web)
    - [index.html](#31-indexhtml)
    - [Controladores](#32-controladores)
    - [Funcionalidades](#33-funcionalidades)
- [Testes](#4-testes)
    - [CpfValidatorTest](#41-cpfvalidatortest)
    - [Outros Testes](#42-outros-testes)
- [Validadores de CPF e CNPJ](#5-validadores-de-cpf-e-cnpj)
    - [CPF](#51-cpf)
    - [CNPJ](#52-cnpj)
- [Estrutura de Dados](#6-estrutura-de-dados)

---

## Visão Geral

O projeto Java - Sistema Transacional visa oferecer uma solução para gerenciamento de transações financeiras entre clientes e empresas. Utiliza tecnologias modernas para desenvolvimento web, incluindo Java, Spring Boot, Hibernate e H2 Database. A interface de usuário é implementada em HTML, proporcionando uma experiência intuitiva para os usuários.

*OBS: No estado atual o sistema não tem integração com o Front e as validações de funcionamento foram feitas através dos testes:*

- ClienteRepositoryTest
- EmpresatRepositoryTest
- CnpjValidatorTest
- CpfValidatorTest
- TransacaoControllerTest (Corrigir Bug)*

## 1. Criação do Projeto

### 1.1 Tecnologias Utilizadas

- Java 17
- Spring Boot 2.6.3
- Hibernate 6.4.4
- H2 Database
- HTML

### 1.2 Ferramentas Utilizadas

- IntelliJ IDEA
- Maven

## 2. Configuração das Classes e Banco de Dados

### 2.1 pom.xml

Adicionou-se as dependências necessárias para o Spring Boot, Hibernate e H2 Database.

### 2.2 application.properties

Configurou-se o arquivo application.properties para definir o nome da aplicação, a URL do banco de dados H2 em memória e as credenciais de acesso ao banco de dados.

### 2.3 Classes de Modelo

- Cliente
- Empresa
- Taxa
- Transação

### 2.4 Repositórios JPA

Implementou-se os repositórios JPA para as classes de modelo Cliente, Empresa, Taxa e Transação.

## 3. Implementação da Interface Web

### 3.1 index.html

Criou-se uma página HTML (index.html) com três botões: "Clientes", "Empresas" e "Realizar Transação".

### 3.2 Controladores

Implementou-se controladores para as rotas /clients, /companies e /transacao.

### 3.3 Funcionalidades

Ao clicar nos botões "Clientes", "Empresas" e "Realizar Transação", o usuário é redirecionado para as páginas correspondentes.

## 4. Testes

### 4.1 CpfValidatorTest

O teste CpfValidatorTest verifica a validação de CPFs no sistema. Ele utiliza casos de teste para garantir que a validação esteja funcionando corretamente, considerando diferentes formatos e situações de CPF.

### 4.2 Outros Testes

Além do CpfValidatorTest, outros testes foram implementados para validar diferentes aspectos do sistema, incluindo testes de integração para os repositórios JPA, testes de unidade para os serviços e controladores, e testes de aceitação para a interface web.

## 5. Validadores de CPF e CNPJ

### 5.1 CPF

O validador de CPF verifica se um número de CPF é válido ou não. Ele utiliza o algoritmo de validação padrão para CPFs, verificando se o número possui a estrutura correta e se o dígito verificador está correto.

### 5.2 CNPJ

O validador de CNPJ verifica se um número de CNPJ é válido ou não.

## 6. Estrutura de Dados

A estrutura de dados do projeto é composta pelas entidades Cliente, Empresa, Taxa e Transação. Essas entidades representam os principais elementos do sistema, incluindo os participantes das transações financeiras (clientes e empresas), as taxas aplicadas a essas transações e as próprias transações.

Cada entidade possui atributos específicos que são armazenados no banco de dados, permitindo o registro e a recuperação de informações relevantes para o gerenciamento das transações financeiras. Os repositórios JPA são responsáveis por interagir com o banco de dados, fornecendo métodos para realizar operações CRUD (Create, Read, Update, Delete) nas entidades.
