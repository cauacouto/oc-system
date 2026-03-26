# 📦 Order Processing Microservices

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-Messaging-ff6600)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

Este projeto é uma aplicação baseada em **arquitetura de microsserviços**, desenvolvida com foco em processamento assíncrono de pedidos utilizando mensageria.

---

## 🚀 Visão Geral

O sistema é composto por **dois microsserviços principais**:

### 1️⃣ Order Service (Produtor)

Responsável por:

* Criar ordens de compra (OC)
* Persistir os dados no banco de dados
* Enviar a mensagem para fila (RabbitMQ)

### 2️⃣ Email Service (Consumer)

Responsável por:

* Consumir mensagens da fila
* Gerar um PDF com os dados da ordem
* Enviar um e-mail com o PDF anexado

---

## 🧱 Arquitetura

A comunicação entre os microsserviços é feita de forma **assíncrona** utilizando **RabbitMQ**, garantindo desacoplamento e escalabilidade.

Fluxo:

1. Cliente cria uma ordem de compra
2. Order Service salva no banco
3. Order Service envia mensagem para fila
4. Email Service consome a mensagem
5. Email Service gera PDF
6. Email Service envia e-mail com anexo

---

## 🛠️ Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* RabbitMQ
* Maven
* API REST
* Geração de PDF
* Envio de e-mail (SMTP)

---

## 📄 Estrutura da Ordem de Compra

A ordem de compra contém:

* 📌 Número da OC
* 📝 Descrição
* 💰 Valor
* 🔢 Quantidade
* 📅 Data de criação
* 📊 Status da ordem

Essas informações são utilizadas para gerar o PDF enviado por e-mail.

---

## 📬 Mensageria (RabbitMQ)

* 📤 Producer: Order Service
* 📥 Consumer: Email Service

Benefícios:

* Processamento assíncrono
* Maior resiliência
* Escalabilidade

---

## 📂 Estrutura do Projeto

```
order-service/
 ├── controller/
 ├── service/
 ├── repository/
 ├── model/
 ├── dto/
 └── config/

email-service/
 ├── consumer/
 ├── service/
 ├── dto/
 ├── model/
 └── config/
```

---

## ⚙️ Como Executar

### Pré-requisitos

* Java 17+
* Maven
* Docker (opcional)
* RabbitMQ

---

### 🐳 Subindo RabbitMQ

```bash
docker run -d --name rabbitmq \
-p 5672:5672 \
-p 15672:15672 \
rabbitmq:3-management
```

Painel: http://localhost:15672
Usuário: guest
Senha: guest

---

### ▶️ Rodar os serviços

```bash
cd order-service
mvn spring-boot:run

cd email-service
mvn spring-boot:run
```

---

## 📧 Funcionalidade de E-mail

Ao criar uma ordem:

* Um PDF é gerado automaticamente contendo:

  * Número da OC
  * Descrição
  * Valor
  * Quantidade
  * Data
  * Status

* O PDF é enviado como anexo para o e-mail configurado.

---

## 📈 Melhorias Futuras

* 🔐 Autenticação com JWT
* 📊 Monitoramento com Spring Actuator
* ☁️ Deploy na AWS
* 📦 Docker Compose
* 🔄 Retry e Dead Letter Queue

---

## 👨‍💻 Autor

**Cauã Couto**
Backend Developer | Java & Spring Boot

---
