# **GraphQL CRUD Application**

This project is a simple **CRUD application** built with **Spring Boot** and **GraphQL**, showcasing how to manage products using modern GraphQL queries and mutations. The project adheres to **clean code principles** and uses **H2 database** for development.

---

## **Table of Contents**
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
    - [GraphQL Endpoints](#graphql-endpoints)
    - [Testing with Postman](#testing-with-postman)
    - [GraphiQL Interface](#graphiql-interface)

---

## **Features**
- **GraphQL Queries and Mutations** for CRUD operations:
    - Create, Read, Update, Delete products.
- Integrated **GraphiQL interface** for testing.
- **H2 in-memory database** for easy development and testing.
- Follows **clean code** and **best practices**.

---

## **Technologies Used**
- **Spring Boot** (v3.x)
- **Spring Data JPA**
- **GraphQL Java**
- **H2 Database**
- **Lombok**
- **Maven**

---

## **Getting Started**

### **Prerequisites**
1. **Java 17** or higher installed on your system.
2. **Maven** (v3.x or higher) installed.
3. Recommended IDE: **IntelliJ IDEA**.

### **Installation**
1. Clone the repository:
   ```bash
   git clone https://github.com/charlybutar21/springboot-graphQL.git
   cd springboot-graphQL
    ```

2. Build the project:
   ```bash
   mvn clean install
    ```
3. Run the application:
   ```bash
   mvn spring-boot:run
    ```
4. Access the application:
    * GraphQL endpoint: http://localhost:8080/graphql
    * GraphiQL interface: http://localhost:8080/graphiql?path=/graphql

---

## **Usage**
### **GraphQL Endpoints**
1. Get All Products
    ```bash
    query {
      getAllProducts {
        id
        name
        description
        price
      }
   }
   ```

2. Get Product By ID
   ```bash
    query {
      getProductById(id: "1") {
        id
        name
        description
        price
      }
    }
   ```

3. Create Product
   ```bash
    mutation {
      createProduct(input: {
        name: "New Product",
        description: "Product description",
        price: 100.0
      }) {
        id
        name
        description
        price
      }
    }
   ```

4. Update Product
    ```bash
    mutation {
      updateProduct(id: "1", input: {
        name: "Updated Product",
        description: "Updated description",
        price: 150.0
      }) {
        id
        name
        description
        price
      }
    }
   ```

5. Delete Product
    ```bash
    mutation {
      deleteProduct(id: "1")
    }
   ```

### **Testing with Postman**
1. Import the [postman-collection.json](postman-collection.json).
2. Use the pre-defined queries and mutations for testing.

### **GraphiQL Interface**
1. Open http://localhost:8080/graphiql?path=/graphql.
2. Use the interactive UI to test queries and mutations.
