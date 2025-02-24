![GitHub language count](https://img.shields.io/github/languages/count/souzafcharles/Java-Spring-Boot-Parking-Control-API)
![GitHub top language](https://img.shields.io/github/languages/top/souzafcharles/Java-Spring-Boot-Parking-Control-API)
![GitHub](https://img.shields.io/github/license/souzafcharles/Java-Spring-Boot-Parking-Control-AP)
![GitHub last commit](https://img.shields.io/github/last-commit/souzafcharles/Java-Spring-Boot-Parking-Control-API)

# Java Spring Boot | Parking Control API

## Introduction:

<p align="justify">
This introduction details the development of the Parking Control API, a backend system built using the <code>Java Spring</code> framework. This API manages parking spot registrations, providing a solution for controlling and monitoring parking availability. The project leverages key Spring technologies, including <code>Spring Boot</code>, <code>Spring Data JPA</code>, and <code>Spring Validation</code>. The API follows <code>RESTful</code> principles, offering an interface for interacting with parking spot data. Core functionalities include creating new parking spot registrations, retrieving parking spot information (individual and paginated lists), updating existing registrations, and deleting registrations.  The system uses validation rules to prevent duplicate entries and ensure data consistency.
</p>

<p align="justify">
The development uses a <code>Spring Boot</code> project and configures a connection to a <code>PostgreSQL</code> database. The data model for a parking spot includes information such as the parking spot number, vehicle license plate, vehicle brand and model, color, registration date, responsible party's name, apartment number, and block. These models are used to create <code>RESTful</code> controllers that handle <code>CRUD</code> operations. <code>Spring Data JPA</code> simplifies database interactions. Input validation is implemented using <code>Spring Validation</code> annotations. The API implements pagination for retrieving lists of parking spots.
</p>

<p align="justify">
The Parking Control API's architecture is designed for maintainability and scalability. The use of <code>Java Spring</code>'s dependency injection and inversion of control principles ensures loose coupling. The <code>RESTful</code> design allows for integration with other systems. The validation contributes to the system's robustness. This API serves as a foundation for a parking management system.
</p>

***

## Project Stack:

| Technology        | Version   | Description                                               |
|-------------------|-----------|-----------------------------------------------------------|
| 📐 IntelliJ IDEA  | `2024.3`  | Integrated Development Environment (IDE)                  |
| ☕ Java           | `21`      | Backend programming language                              |
| 🌱 Spring Boot    | `3.4.3`   | Framework for creating Spring applications                |
| 🐦 Maven          | `3.9.9`   | Build automation and dependency management tool           |
| 🐘 PostgreSQL     | `17`      | Relational database management system                     |
| 👩‍🚀 Postman        | `11.19`   | API testing and development tool                          |

***

## Dependencies:

| Dependency              | Category         | Description                                                                                                    |
|-------------------------|------------------|----------------------------------------------------------------------------------------------------------------|
| 🌐 Spring Web           | Web              | Build web applications, including RESTful APIs, using Spring MVC. Uses Apache Tomcat as the default container  |
| 💾 Spring Data JPA      | SQL              | Facilitates database access using JPA with Spring Data and Hibernate                                           |
| 🐘 PostgreSQL Driver    | SQL              | JDBC and R2DBC driver enabling Java applications to interact with PostgreSQL databases                         |
| ✔️ Validation           | Validation (I/O) | Enables Java Bean Validation using Hibernate Validator                                                         |
| 🗝️ dotenv-java          | Configuration    | Loads environment variables from a `.env` file into the application, aiding in secure configuration management |


