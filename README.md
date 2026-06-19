<div align="center">

# 📚 Biblioteca API

Sistema de gerenciamento de biblioteca desenvolvido com **Java**, **Spring Boot**, **HTML**, **CSS** e **JavaScript**.

![Java](https://img.shields.io/badge/Java-8+-ED8B00?style=for-the-badge\&logo=java\&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.7-green?style=for-the-badge\&logo=springboot)
![REST API](https://img.shields.io/badge/API-REST-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Active-success?style=for-the-badge)

</div>

---

## 📌 Sobre o Projeto

Sistema de biblioteca desenvolvido para praticar conceitos de desenvolvimento Back-end e integração com Front-end.

A aplicação permite o gerenciamento de livros, empréstimos, devoluções e filas de espera, simulando o funcionamento de uma biblioteca real.

---

## 🚀 Funcionalidades

* 📖 Cadastro de livros
* 📚 Listagem de livros
* 🔄 Empréstimo de livros
* ✅ Devolução de livros
* 🗑️ Exclusão de livros
* 👤 Identificação do usuário que está com o livro
* ⏳ Fila de espera para livros indisponíveis
* 🔁 Empréstimo automático para o próximo usuário da fila
* 🌐 Integração entre Front-end e API REST

---

## 🛠️ Tecnologias Utilizadas

### Back-end

* Java
* Spring Boot
* Maven
* REST API

### Front-end

* HTML5
* CSS3
* JavaScript

### Ferramentas

* Eclipse IDE
* Git
* GitHub

---

## 📂 Estrutura Completa do Projeto

```text
biblioteca-api/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── biblioteca/
│   │   │
│   │   │           ├── BibliotecaApplication.java
│   │   │           │
│   │   │           ├── controller/
│   │   │           │   └── LivroController.java
│   │   │           │
│   │   │           ├── model/
│   │   │           │   └── Livro.java
│   │   │           │
│   │   │           └── service/
│   │   │               └── LivroService.java
│   │   │
│   │   └── resources/
│   │         └──static/
|   |            ├── index.html 
│   │            ├── style.css            
│   │            └── script.js
│   │              
│   ├── main/
│   └── test/
│
│
├── pom.xml
├── .gitignore
└── README.md
```

---

## 🔗 Endpoints Disponíveis

### Listar Livros

```http
GET /livros
```

### Cadastrar Livro

```http
POST /livros
```

### Emprestar Livro

```http
PUT /livros/emprestar/{id}
```

### Devolver Livro

```http
PUT /livros/devolver/{id}
```

### Excluir Livro

```http
DELETE /livros/{id}
```

### Consultar Fila de Espera

```http
GET /livros/fila/{id}
```

---

## ⚙️ Como Executar

### 1️⃣ Clonar o Repositório

```bash
git clone https://github.com/dropeesz/biblioteca-api.git
```

### 2️⃣ Entrar na Pasta

```bash
cd biblioteca-api
```

### 3️⃣ Executar a Aplicação

Abra o projeto no Eclipse e execute:

```text
BibliotecaApplication.java
```

A API será iniciada em:

```text
http://localhost:8080
```

---

## 🧠 Conceitos Aplicados

* Programação Orientada a Objetos (POO)
* Encapsulamento
* Estruturas de Dados (List, Map e Queue)
* APIs REST
* Integração Front-end e Back-end
* Manipulação de JSON
* Controle de estado dos livros
* Gerenciamento de fila de espera
* Versionamento com Git e GitHub

---

## 🎯 Próximas Melhorias

* Persistência com MySQL
* Spring Data JPA
* Histórico de empréstimos
* Pesquisa de livros
* Sistema de autenticação
* Dashboard administrativo

---

## 👨‍💻 Autor

**Pedro Henrique (Drope)**

GitHub: https://github.com/dropeesz

LinkedIn: https://www.linkedin.com/in/pedro-henrique-2708a12b5/

</div>
