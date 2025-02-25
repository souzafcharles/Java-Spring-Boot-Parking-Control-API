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

***

## Requirements for LoadEnvironment Class:

- **Class Purpose:**
    - Create the `LoadEnvironment` class to load environment variables from a `.env` file and set them as system
      properties.

- **Load Environment Method:**
    - **Method:** `loadEnv`
    - **Purpose:** Loads environment variables from a `.env` file and sets them as system properties.
    - **Implementation Details:**
        - Use the `Dotenv.configure().load()` method from the `io.github.cdimascio.dotenv` library to load the
          environment variables.
        - Iterate over the entries using
          `dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()))` to set each
          environment variable as a system property.

- **External Library:**
    - **Library:** `io.github.cdimascio.dotenv`
    - **Purpose:** Used to load environment variables from a `.env` file. Ensure this library is included as a
      dependency in your project's build configuration.

- **Purpose:**
    - Ensure that environment variables defined in a `.env` file are loaded and accessible as system properties
      throughout the application.

***

## Requirements for `ParkingSpotModel` Entity Class:

- **Entity Mapping:**
    - Create the `ParkingSpotModel` class as an entity to represent a database table in the application;
    - Annotate the class with `@Entity` to define it as a persistent entity;
    - Use `@Table(name = "tb_parking_spot")` to map it to the database table named `tb_parking_spot`.

- **Attributes and Annotations:**
    - Define attributes `id`, `parkingSpotNumber`, `licensePlateCar`, `brandCar`, `modelCar`, `colorCar`,
      `registrationDate`, `responsibleName`, `apartment`, and `block` to map to the respective columns in the database;
    - Annotate the `id` field with `@Id` and `@GeneratedValue(strategy = GenerationType.AUTO)` for automatic primary key
      generation;
    - Annotate each attribute with `@Column` to specify column properties such as `nullable`, `unique`, and `length`.

- **Constructors:**
    - Create a no-argument constructor required by `JPA`;
    - Provide a constructor that initializes all attributes except `id` and `registrationDate`.

- **Accessors and Mutators:**
    - Implement `getters` and `setters` for all attributes to allow data manipulation.

- **Equals and HashCode:**
    - Override the `equals()` method to compare entities based on the `id` attribute;
    - Override `hashCode()` to provide a consistent hash for `ParkingSpotModel` objects, using `Objects.hashCode(id)`.

- **Serializable Interface:**
    - Implement the `Serializable` interface to support object serialization for the entity when necessary (e.g., when
      transferring objects between systems).

***

## Requirements DTO Pattern for ParkingSpotDTO Record Class:

- **Record Declaration:**
    - Create the `ParkingSpotDTO` as a `record` class to represent the data transfer object for parking spots.

- **Attribute Definition:**
    - Define the attributes `String parkingSpotNumber`, `String licensePlateCar`, `String brandCar`, `String modelCar`,
      `String colorCar`, `String responsibleName`, `String apartment`, and `String block` directly in the record's
      header, ensuring immutability and automatic generation of accessor methods.

- **Validation Constraints:**
    - Annotate each attribute with appropriate validation constraints, such as `@NotBlank` and `@Size`, to enforce data
      integrity and validation rules.

- **Purpose:**
    - Use this `record` for receiving and validating user input from client requests to create or update
      `ParkingSpotModel` entities within the application.

***

## Requirements for ParkingSpotRepository Interface:

- **Repository Creation:**
    - Create the `ParkingSpotRepository` interface to handle data access operations for the `ParkingSpotModel` entity.

- **JpaRepository Extension:**
    - Extend `JpaRepository<ParkingSpotModel, UUID>` to inherit common CRUD operations and JPA-specific functionalities.

- **Entity Association:**
    - Specify `ParkingSpotModel` as the associated entity and `UUID` as the type for its primary key.

- **Custom Query Methods:**
    - Define custom query methods to check for the existence of parking spots based on certain attributes:
        - `boolean existsByLicensePlateCar(String licensePlateCar);`
        - `boolean existsByParkingSpotNumber(String parkingSpotNumber);`
        - `boolean existsByApartmentAndBlock(String apartment, String block);`

- **Purpose:**
    - Use these custom query methods to validate and enforce unique constraints on parking spot attributes within the
      application.

***

## Requirements for ParkingSpotService Class:

- **Service Component Annotation:**
    - Use the `@Service` annotation to define the class as a Spring service component.

- **Dependency Injection:**
    - Inject `ParkingSpotRepository` using constructor-based injection for dependency injection.

- **Save Parking Spot Entity:**
    - **Method:** `save`
    - **Purpose:** Saves a new `ParkingSpotModel` entity in the database.
    - **Transaction Management:** Annotate with `@Transactional` to ensure this method runs within a transactional
      context, enabling database operation rollbacks in case of exceptions.

- **Check for Existing Parking Spot by License Plate:**
    - **Method:** `existsByLicensePlateCar`
    - **Purpose:** Checks if a parking spot already exists based on the license plate number.

- **Check for Existing Parking Spot by Spot Number:**
    - **Method:** `existsByParkingSpotNumber`
    - **Purpose:** Checks if a parking spot already exists based on the parking spot number.

- **Check for Existing Parking Spot by Apartment and Block:**
    - **Method:** `existsByApartmentAndBlock`
    - **Purpose:** Checks if a parking spot already exists based on the apartment and block.

- **Retrieve All Parking Spot Entities:**
    - **Method:** `findAll`
    - **Purpose:** Fetches all entries from the database with pagination support.
    - **Transaction Management:** This method does not require explicit transaction management.

- **Retrieve Parking Spot Entity by ID:**
    - **Method:** `findById`
    - **Purpose:** Fetches a single `ParkingSpotModel` entity by its identifier.
    - **Transaction Management:** This method does not require explicit transaction management.

- **Delete Parking Spot Entity:**
    - **Method:** `delete`
    - **Purpose:** Deletes a `ParkingSpotModel` entity from the database.
    - **Transaction Management:** Annotate with `@Transactional` to ensure the operation is part of a transaction,
      allowing rollback in case of failure.

***

## Requirements for ParkingSpotController Class:

- **Controller Component Annotation:**
    - Use the `@RestController` annotation to mark the class as a REST controller for Spring.

- **Request Mapping:**
    - Use the `@RequestMapping` annotation to map requests to the `/parking-spot` endpoint.

- **Dependency Injection:**
    - Inject `ParkingSpotService` using constructor-based dependency injection.

- **Centralized Message Management:**
    - Utilize a separate utility class `ParkingSpotMessages` para armazenar mensagens constantes, garantindo melhor
      organização e reutilização.

- **Save Parking Spot Endpoint:**
    - **Method:** `saveParkingSpot`
    - **Purpose:** Handles the creation of a new `ParkingSpot` resource.
    - **Mapping Annotation:** Use `@PostMapping` to map POST requests to `/parking-spot`.
    - **Parameters:**
        - `@RequestBody @Valid ParkingSpotDTO parkingSpotDTO`: Captures the details for the new parking spot from the
          request body.
    - **Validations:**
        - Checks for conflicts using the `ParkingSpotService`.
        - Uses predefined messages from `ParkingSpotMessages` for conflict responses.
    - **Response:** Returns a `ResponseEntity<Object>` with:
        - HTTP 201 (Created) and the created `ParkingSpot` object if successful.
        - HTTP 409 (Conflict) if the parking spot number, license plate, or apartment/block is already in use.

- **Retrieve All Parking Spots Endpoint:**
    - **Method:** `getAllParkingSpots`
    - **Purpose:** Retrieves all available parking spot resources.
    - **Mapping Annotation:** Use `@GetMapping` to map GET requests to `/parking-spot`.
    - **Parameters:**
        - `@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable`:
          Supports pagination and sorting.
    - **Response:** Returns a `ResponseEntity<Page<ParkingSpotModel>>` with an HTTP 200 (OK) status and the list of
      parking spots.

- **Retrieve Parking Spot by ID Endpoint:**
    - **Method:** `getOneParkingSpot`
    - **Purpose:** Fetches a specific `ParkingSpot` by its identifier.
    - **Mapping Annotation:** Use `@GetMapping(value = "/{id}")` to map GET requests for a specific parking spot.
    - **Parameters:**
        - `@PathVariable UUID id`: Captures the identifier of the parking spot from the URI.
    - **Response:** Returns a `ResponseEntity<Object>` with:
        - HTTP 200 (OK) and the corresponding parking spot object if found.
        - HTTP 404 (Not Found) with a message from `ParkingSpotMessages` if the spot is not found.

- **Delete Parking Spot by ID Endpoint:**
    - **Method:** `deleteParkingSpot`
    - **Purpose:** Deletes a specific `ParkingSpot` resource by its identifier.
    - **Mapping Annotation:** Use `@DeleteMapping(value = "/{id}")` to map DELETE requests for a specific parking spot.
    - **Parameters:**
        - `@PathVariable UUID id`: Captures the identifier of the parking spot to be deleted from the URI.
    - **Response:** Returns a `ResponseEntity<Object>` with:
        - HTTP 200 (OK) and a success message from `ParkingSpotMessages` if deletion is successful.
        - HTTP 404 (Not Found) if the spot does not exist.

- **Update Parking Spot by ID Endpoint:**
    - **Method:** `updateParkingSpot`
    - **Purpose:** Updates an existing `ParkingSpot` resource by its identifier.
    - **Mapping Annotation:** Use `@PutMapping(value = "/{id}")` to map PUT requests for updating a specific parking
      spot.
    - **Parameters:**
        - `@PathVariable UUID id`: Captures the identifier of the parking spot from the URI.
        - `@RequestBody @Valid ParkingSpotDTO parkingSpotDTO`: Captures the updated parking spot details from the
          request body.
    - **Response:** Returns a `ResponseEntity<Object>` with:
        - HTTP 200 (OK) and the updated parking spot object if successful.
        - HTTP 404 (Not Found) with a message from `ParkingSpotMessages` if the spot does not exist.

***

### Requirements for ParkingSpotMessages Utility Class:

- **Class Declaration:**
    - Create the `ParkingSpotMessages` class as a utility class to hold constant messages used throughout the
      application.

- **Private Constructor:**
    - Define a private constructor to prevent instantiation of the utility class.
    - Throw an `IllegalStateException` with the message `"Utility class"` to enforce non-instantiability.

- **Constant Message Definitions:**
    - **LICENSE_PLATE_IN_USE:** Define a public static final string with the value
      `"Conflict: License Plate Car is already in use!"` to indicate when a license plate is already in use.
    - **PARKING_SPOT_IN_USE:** Define a public static final string with the value
      `"Conflict: Parking Spot is already in use!"` to indicate when a parking spot is already in use.
    - **APARTMENT_BLOCK_IN_USE:** Define a public static final string with the value
      `"Conflict: Parking Spot already registered for this apartment/block!"` to indicate when a parking spot is already
      registered for a specific apartment and block.
    - **PARKING_SPOT_NOT_FOUND:** Define a public static final string with the value `"Parking Spot not found."` to
      indicate when a parking spot is not found.
    - **PARKING_SPOT_DELETED_SUCCESS:** Define a public static final string with the value
      `"Parking Spot deleted successfully."` to indicate successful deletion of a parking spot.

***

## Requirements for GlobalExceptionHandler Class:

- **Controller Advice Annotation:**
    - Use the `@RestControllerAdvice` annotation to mark the class as a global exception handler for REST controllers.

- **Handle IllegalArgumentException:**
    - **Method:** `handleIllegalArgumentException`
    - **Purpose:** Handles `IllegalArgumentException` exceptions globally.
    - **Exception Handler Annotation:** Use `@ExceptionHandler(IllegalArgumentException.class)` to indicate that this
      method handles `IllegalArgumentException`.
    - **Response Construction:**
        - Create a `Map<String, Object>` to store error details including `timestamp`, `status`, `error`, and `message`.
        - Populate the map with appropriate values:
            - `timestamp`: Current date and time (`LocalDateTime.now()`).
            - `status`: HTTP status code for conflict (`HttpStatus.CONFLICT.value()`).
            - `error`: Error type as "Conflict".
            - `message`: Exception message (`ex.getMessage()`).
    - **Response Entity:** Return a `ResponseEntity<Object>` with HTTP status 409 (Conflict) and the constructed error
      response map.

- **Handle General Exception:**
    - **Method:** `handleGeneralException`
    - **Purpose:** Handles all uncaught `Exception` exceptions globally.
    - **Exception Handler Annotation:** Use `@ExceptionHandler(Exception.class)` to indicate that this method handles
      general exceptions.
    - **Response Construction:**
        - Create a `Map<String, Object>` to store error details including `timestamp`, `status`, `error`, and `message`.
        - Populate the map with appropriate values:
            - `timestamp`: Current date and time (`LocalDateTime.now()`).
            - `status`: HTTP status code for internal server error (`HttpStatus.INTERNAL_SERVER_ERROR.value()`).
            - `error`: Error type as "Internal Server Error".
            - `message`: Exception message (`ex.getMessage()`).
    - **Response Entity:** Return a `ResponseEntity<Object>` with HTTP status 500 (Internal Server Error) and the
      constructed error response map.

***

## Requirements for DateConfig Class:

- **Configuration Annotation:**
    - Use the `@Configuration` annotation to mark the class as a configuration class for Spring.

- **DateTime Format Definition:**
    - Define a public static final string `DATETIME_FORMAT` with the desired date-time format (
      `"yyyy-MM-dd'T'HH:mm:ss'Z'"`).

- **LocalDateTime Serializer Definition:**
    - Define a public static `LocalDateTimeSerializer` named `LOCAL_DATETIME_SERIALIZER` using the
      `DateTimeFormatter.ofPattern(DATETIME_FORMAT)` to apply the date-time format.

- **ObjectMapper Bean Creation:**
    - **Method:** `objectMapper`
    - **Purpose:** Configures and returns an `ObjectMapper` bean with the custom date-time serializer.
    - **Bean Annotation:** Use the `@Bean` annotation to indicate that this method produces a bean managed by the Spring
      container.
    - **Primary Annotation:** Use the `@Primary` annotation to mark this `ObjectMapper` bean as the primary bean when
      multiple candidates are present.
    - **Configuration Details:**
        - Create a `JavaTimeModule` instance and add the custom `LOCAL_DATETIME_SERIALIZER` to it.
        - Register the `JavaTimeModule` with the `ObjectMapper` instance and return it.

- **Purpose:**
    - Ensure consistent date-time serialization and deserialization across the application using the defined date-time
      format.