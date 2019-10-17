# AXA Book Store API
A RESTful API built using Spring Boot, Spring Security, JPA and H2 database

- Project will be deployed on `http://localhost:8080`
- Interactive API documentation using [Swagger UI](https://swagger.io/tools/swagger-ui/) and can be accessed on `http://localhost:8080/swagger-ui.html`
- H2 database console can be accessed on`http://localhost:8080/h2-console` with default configuration
  - jdbc:h2:mem:bookstoredb
  - username: SA 
  - password: leave it empty

## Modules
Modules divided into two modules which are
1. `Book Management:` 
    - Secured with authentication `username: admin` | `password:admin`
    - Intended for helping store staffs manage (create, update, delete) all books in stock
2. `Book Info:` which provides book information for customer

## Installation

Run the application with command
```bash
mvn spring-boot:run
```
