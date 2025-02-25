![GitHub language count](https://img.shields.io/github/languages/count/souzafcharles/Java-Spring-Boot-Parking-Control-API)
![GitHub top language](https://img.shields.io/github/languages/top/souzafcharles/Java-Spring-Boot-Parking-Control-API)
![GitHub](https://img.shields.io/github/license/souzafcharles/Java-Spring-Boot-Parking-Control-API)
![GitHub last commit](https://img.shields.io/github/last-commit/souzafcharles/Java-Spring-Boot-Parking-Control-API)

# Java Spring Boot | Parking Control API

***

▶️ Project developed based on a tutorial by **Michelli Brito** - [Decoder](https://www.michellibrito.com/).

***

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

| Technology       | Version  | Description                                     |
|------------------|----------|-------------------------------------------------|
| 📐 IntelliJ IDEA | `2024.3` | Integrated Development Environment (IDE)        |
| ☕ Java           | `21`     | Backend programming language                    |
| 🌱 Spring Boot   | `3.4.3`  | Framework for creating Spring applications      |
| 🐦 Maven         | `3.9.9`  | Build automation and dependency management tool |
| 🐘 PostgreSQL    | `17`     | Relational database management system           |
| 👩‍🚀 Postman    | `11.19`  | API testing and development tool                |

***

## Dependencies:

| Dependency           | Category         | Description                                                                                                     |
|----------------------|------------------|-----------------------------------------------------------------------------------------------------------------|
| 🌐 Spring Web        | Web              | Builds web applications, including RESTful APIs, using Spring MVC. Uses Apache Tomcat as the default container. |
| 💾 Spring Data JPA   | SQL              | Facilitates database access using JPA with Spring Data and Hibernate.                                           |
| 🐘 PostgreSQL Driver | SQL              | JDBC and R2DBC driver enabling Java applications to interact with PostgreSQL databases.                         |
| ✔️ Validation        | Validation (I/O) | Enables Java Bean Validation using Hibernate Validator.                                                         |
| 🗝️ dotenv-java      | Configuration    | Loads environment variables from a `.env` file into the application, aiding in secure configuration management. |
| 🔗 Spring HATEOAS    | Web              | Simplifies the creation of hypermedia-driven REST APIs, allowing resources to include links for navigation.     |

***

## Parking Spot Model Entity:

![Parking Spot Model Entity](https://github.com/souzafcharles/Java-Spring-Boot-Parking-Control-API/blob/main/src/main/resources/static/img/parking-spot-model-entity.png)

***

## Project API Rest Architecture:

![Project API Rest Architecture](https://github.com/souzafcharles/Java-Spring-Boot-Parking-Control-API/blob/main/src/main/resources/static/img/api-rest-architecture.png)
***

## Project Logic Layered Architecture:

![Layered Architecture](https://github.com/souzafcharles/Java-Spring-Boot-Parking-Control-API/blob/main/src/main/resources/static/img/logic-layered-architecture.png)
***

## SQL script to store data in the `parkingcontrolapi` database:

````sql
-- Drop the table if it exists
drop table if exists tb_parking_spot;

-- Create the table
create table tb_parking_spot (
id uuid default gen_random_uuid() primary key,
parking_spot_number varchar(10) not null unique,
license_plate_car varchar(8) not null unique check (license_plate_car ~ '^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$'),
brand_car varchar(70) not null,
model_car varchar(70) not null,
color_car varchar(70) not null,
registration_date timestamp not null default now(),
responsible_name varchar(130) not null,
apartment varchar(30) not null,
block varchar(30) not null
);

-- Insert sample data
insert into tb_parking_spot (parking_spot_number, license_plate_car, brand_car, model_car, color_car, responsible_name, apartment, block)
values
('A01', 'ABC1234', 'Toyota', 'Corolla', 'Black', 'Balthazar de Bigode', '101', 'A'),
('B12', 'DEF5678', 'Honda', 'Civic', 'White', 'Ophelia Birrenta', '202', 'B'),
('C23', 'GHI9J45', 'Ford', 'Fiesta', 'Blue', 'Ludovico Crispim', '303', 'C'),
('D34', 'JKL6789', 'Chevrolet', 'Onix', 'Red', 'Abigail Sebastiana', '404', 'D'),
('E45', 'MNO1234', 'Volkswagen', 'Golf', 'Gray', 'Belizario Epaminondas', '505', 'E'),
('F56', 'PQR5678', 'Nissan', 'Sentra', 'Silver', 'Belarmino Gumercindo', '606', 'F'),
('G67', 'STU9V45', 'Hyundai', 'Tucson', 'Green', 'Zuleica Serafina', '707', 'G'),
('H78', 'VWX6789', 'Kia', 'Sportage', 'Yellow', 'Vitalino Simplicio', '808', 'H'),
('I89', 'YZA2345', 'Fiat', 'Uno', 'Brown', 'Cassandra Valquiria', '909', 'I'),
('J90', 'BCD3456', 'Renault', 'Duster', 'Purple', 'Abilio Prudencio', '1001', 'J');
````

***

## Setting up `application.properties` File with PostgreSQL Configurations:

```properties
# Application name
spring.application.name=parkingcontrolapi
# PostgreSQL Connection
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
# Hibernate settings
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```