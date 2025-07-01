# Projeto Web Services - API com Spring Boot

Este projeto é uma API RESTful desenvolvida com Spring Boot, JPA e Hibernate. Simula um sistema de e-commerce básico, incluindo endpoints para gerenciamento de usuários, produtos, categorias e pedidos. O projeto demonstra boas práticas de desenvolvimento, como arquitetura em camadas, tratamento de exceções e uso de perfis de configuração (profiles).

## ✅ Funcionalidades Principais

-   **Arquitetura em Camadas**: Organização do projeto em camadas de `Controller`, `Service` e `Repository`.
-   **Endpoints REST**: Implementação de rotas para os principais recursos da aplicação.
-   **CRUD Completo**: Operações de Criar, Ler, Atualizar e Deletar para as entidades `User`, `Product` e `Order`.
-   **Relacionamentos Complexos**: Mapeamento de relacionamentos entre entidades:
    -   `One-to-One`: Pedido e Pagamento.
    -   `One-to-Many`: Usuário e Pedidos.
    -   `Many-to-Many`: Produtos e Categorias.
    -   `Many-to-Many` (com classe de associação): Pedidos, Itens de Pedido e Produtos.
-   **Tratamento de Exceções**: Manipulação de erros comuns da aplicação, como recursos não encontrados (`404 Not Found`) e violações de integridade de dados (`400 Bad Request`).
-   **Perfis de Configuração (Profiles)**:
    -   Perfil `test` configurado para uso com o banco de dados em memória H2.
    -   Perfil `dev` preparado para conexão com um banco de dados PostgreSQL.
-   **População de Dados (Seeding)**: Inserção automática de dados de teste ao iniciar a aplicação no perfil `test`.

## Endpoints da API

| Recurso | Método HTTP | Rota | Descrição |
| :--- | :--- | :--- | :--- |
| **Users** | `GET` | `/users` | Lista todos os usuários. |
| | `GET` | `/users/{id}` | Busca um usuário por ID. |
| | `POST` | `/users` | Insere um novo usuário. |
| | `PUT` | `/users/{id}` | Atualiza um usuário existente. |
| | `DELETE` | `/users/{id}` | Deleta um usuário. |
| **Products** | `GET` | `/products` | Lista todos os produtos. |
| | `GET` | `/products/{id}` | Busca um produto por ID. |
| | `POST` | `/products` | Insere um novo produto. |
| | `PUT` | `/products/{id}` | Atualiza um produto existente. |
| | `DELETE` | `/products/{id}` | Deleta um produto. |
| **Orders** | `GET` | `/orders` | Lista todos os pedidos. |
| | `GET` | `/orders/{id}` | Busca um pedido por ID. |
| | `POST` | `/orders` | Insere um novo pedido. |
| | `PUT` | `/orders/{id}` | Atualiza o status de um pedido. |
| | `DELETE` | `/orders/{id}` | Deleta um pedido. |

## 🛠️ Tecnologias Utilizadas

-   Java 17
-   Spring Boot 3.1.0
-   Spring Web
-   Spring Data JPA
-   H2 Database (para o perfil `test`)
-   PostgreSQL (driver configurado para o perfil `dev`)
-   Maven

## 🚀 Como Executar o Projeto

**Pré-requisitos:**
-   JDK 17 ou superior
-   Maven 3.8 ou superior

**Passos:**
1.  Clone o repositório:
    ```bash
    git clone [https://github.com/lfocarvalho/Projeto-web-services.git](https://github.com/lfocarvalho/Projeto-web-services.git)
    cd Projeto-web-services
    ```
2.  Execute a aplicação com o Maven:
    ```bash
    mvn spring-boot:run
    ```
3.  A aplicação iniciará na porta `8085`. Por padrão, o perfil `test` está ativo, utilizando um banco de dados em memória H2.
4.  Para acessar o console do H2 e visualizar os dados, navegue para `http://localhost:8085/h2-console` e utilize a URL JDBC `jdbc:h2:mem:testdb`.

---

## Informações Acadêmicas:

-   **Universidade**: Universidade Federal do Tocantins
-   **Curso**: Ciências da Computação
-   **Disciplina**: Programação Orientada a Objetos - Semestre 2025.1
-   **Professor**: David Nadler Prata

#### Equipe
| Nome | Github |
| -------------------------------- | ------------------------------------------ |
| Luiz Fernando De Oliveira Carvalho. | [@Lfocarvalho](https://github.com/lfocarvalho) |
| Natália Morais Nerys. | [@Natalia-Nerys](https://github.com/natalia-nerys) |
| **Link para o repositório** | [**Projeto-web-services**](https://github.com/lfocarvalho/Projeto-web-services.git) |
