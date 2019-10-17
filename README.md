# AXA Book Store API
A RESTful API built using Spring Boot, JPA and H2 database

## Documentation and Modules
API documentation using [SWAGGER UI](https://swagger.io/tools/swagger-ui/) and can be accessed on `http://localhost:8080/swagger-ui.html`. Modules divided into two modules which are
1. `Book Management:` intended for helping store staffs manage all books in stock
2. `Book Info:` which provides book information for customer

## Installation

Run the application with command
```bash
mvn spring-boot:run
```

## Miscellaneous
- Project will be deployed on `http://localhost:8080`
- H2 database console can be accessed on`http://localhost:8080/h2-console` with default configuration
  - jdbc:h2:mem:bookstoredb
  - username: SA 
  - password: leave it empty
