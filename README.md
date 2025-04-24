# Relacionamento Autor e Livro com Spring Boot

Este projeto é uma aplicação Spring Boot que implementa operações CRUD (Create, Read, Update, Delete) com relacionamentos entre entidades Autor e Livro, utilizando o banco de dados relacional MariaDB.

## Estrutura do Projeto

```
relacionamento-autor-livro
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── matheus
│   │   │           └── relacionamentos
│   │   │               ├── controller
│   │   │               ├── exception
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               ├── model
│   │   │               ├── repository
│   │   │               └── RelacionamentoAutorLivroApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql
├── pom.xml
└── README.md
```

## Dependências

Este projeto utiliza Maven como gerenciador de dependências. As principais dependências incluem:

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MariaDB Java Client
- Lombok (para reduzir boilerplate)

## Configuração do Banco de Dados

As configurações do banco de dados estão localizadas no arquivo `src/main/resources/application.properties`. O projeto utiliza MariaDB como banco de dados relacional. Certifique-se de que o MariaDB está em execução e configurado corretamente.

## Inicialização do Projeto

Para iniciar o projeto, você pode usar o comando Maven:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API

### **Autores**

1. **GET - Listar todos os autores**  
   ```bash
   curl -X GET "http://localhost:8080/autores"
   ```

2. **GET - Buscar autor por ID**  
   ```bash
   curl -X GET "http://localhost:8080/autores/<id>"
   ```

3. **POST - Criar um novo autor**  
   ```bash
   curl -X POST "http://localhost:8080/autores" -H "Content-Type: application/json" -d '{"nome":"Autor A", "biografia":"Biografia do Autor A"}'
   ```

4. **PUT - Atualizar um autor existente**  
   ```bash
   curl -X PUT "http://localhost:8080/autores/<id>" -H "Content-Type: application/json" -d '{"nome":"Autor B", "biografia":"Biografia atualizada"}'
   ```

5. **DELETE - Excluir um autor por ID**  
   ```bash
   curl -X DELETE "http://localhost:8080/autores/<id>"
   ```

### **Livros**

1. **GET - Listar todos os livros**  
   ```bash
   curl -X GET "http://localhost:8080/livros"
   ```

2. **GET - Buscar livro por ID**  
   ```bash
   curl -X GET "http://localhost:8080/livros/<id>"
   ```

3. **POST - Criar um novo livro**  
   ```bash
   curl -X POST "http://localhost:8080/livros" -H "Content-Type: application/json" -d '{"titulo":"Livro A", "autor":{"id":1}}'
   ```

4. **PUT - Atualizar um livro existente**  
   ```bash
   curl -X PUT "http://localhost:8080/livros/<id>" -H "Content-Type: application/json" -d '{"titulo":"Livro B", "autor":{"id":2}}'
   ```

5. **DELETE - Excluir um livro por ID**  
   ```bash
   curl -X DELETE "http://localhost:8080/livros/<id>"
   ```

## Tratamento de Exceções

O projeto inclui um manipulador global de exceções (`GlobalExceptionHandler`) para lidar com erros, como entidades não encontradas, retornando respostas apropriadas com códigos de status HTTP.

## Contribuição

Contribuições são bem-vindas! Para contribuir, faça um fork do repositório, crie uma branch para suas alterações e envie um pull request.

## Licença

Este projeto está licenciado sob a MIT License. Veja o arquivo LICENSE para mais detalhes.
