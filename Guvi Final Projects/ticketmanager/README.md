# Video Recording


## Instructions## Instructions
### Prerequisites

Ensure you have the following installed:
- Java 11 or later
- Maven (Optional: Maven Wrapper is included in the project)
- Git (Optional: To clone the repository)
- IDE (e.g., Visual Studio Code, IntelliJ IDEA)

### Installation

1. Clone the Repository
   
   If you haven’t already, clone the repository:
   ```bash
   git clone <repository-url>
   cd ticketmanager
   ```

2. Build the Project

   If you have Maven installed:
   ```bash
   mvn clean install
   ```

   If you prefer using the Maven Wrapper:
   ```bash
   ./mvnw clean install  # On Unix-based systems
   mvnw.cmd clean install  # On Windows
   ```

### Running the Application

1. Run the Application

   You can start the Spring Boot application using Maven or the Maven Wrapper:
   ```bash
   mvn spring-boot:run
   ```

   Or using the Maven Wrapper:
   ```bash
   ./mvnw spring-boot:run  # On Unix-based systems
   mvnw.cmd spring-boot:run  # On Windows
   ```

2. Access the Application

   Once the application is running, you can access it in your web browser at:
   ```
   http://localhost:8080
   ```

### Testing

To run the tests, use:
```bash
mvn test
```

Or with the Maven Wrapper:
```bash
./mvnw test  # On Unix-based systems
mvnw.cmd test  # On Windows
```

## Project Directory
```
ticketmanager/
│
├── .gitignore                        # Git ignore file
├── folder-structure.txt             # This file listing the folder structure
├── HELP.md                           # Project help documentation
├── mvnw                              # Maven Wrapper executable
├── mvnw.cmd                          # Maven Wrapper command file for Windows
├── pom.xml                           # Maven build file
│
├── .mvn/                             # Maven Wrapper files
│   └── wrapper/
│       └── maven-wrapper.properties  # Maven Wrapper properties
│
├── .vscode/                          # Visual Studio Code settings
│   └── settings.json                 # VSCode settings
│
├── src/                              # Source code
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── ticketmanager/
│   │   │               ├── ticketmanagerApplication.java # Main Spring Boot application class
│   │   │               ├── controller/
│   │   │               │   ├── BusController.java
│   │   │               │   ├── HomeController.java
│   │   │               │   ├── PaymentMethodController.java
│   │   │               │   ├── RouteController.java
│   │   │               │   ├── TicketController.java
│   │   │               │   └── UserController.java
│   │   │               ├── dto/
│   │   │               │   ├── BusSearchResponseDTO.java
│   │   │               │   ├── PaymentMethodDTO.java
│   │   │               │   ├── TicketDTO.java
│   │   │               │   └── UserDTO.java
│   │   │               ├── model/
│   │   │               │   ├── Bus.java
│   │   │               │   ├── HomeResponse.java
│   │   │               │   ├── LoginResponse.java
│   │   │               │   ├── PaymentMethod.java
│   │   │               │   ├── PaymentStatus.java
│   │   │               │   ├── RegisterResponse.java
│   │   │               │   ├── Route.java
│   │   │               │   ├── Ticket.java
│   │   │               │   ├── TicketStatus.java
│   │   │               │   └── User.java
│   │   │               ├── repository/
│   │   │               │   ├── BusRepository.java
│   │   │               │   ├── PaymentMethodRepository.java
│   │   │               │   ├── RouteRepository.java
│   │   │               │   ├── TicketRepository.java
│   │   │               │   └── UserRepository.java
│   │   │               ├── security/
│   │   │               │   └── JwtUtil.java
│   │   │               └── service/
│   │   │                   ├── BusService.java
│   │   │                   ├── PaymentMethodService.java
│   │   │                   ├── RouteService.java
│   │   │                   ├── TicketService.java
│   │   │                   └── UserService.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties  # Spring Boot configuration
│   │       ├── static/                 # Static files (CSS, JS, images)
│   │       └── templates/              # Thymeleaf templates (if using Thymeleaf)
│   │           ├── add-payment.html
│   │           ├── bookinghistory.html
│   │           ├── edit-payment.html
│   │           ├── error.html
│   │           ├── home.html
│   │           ├── login.html
│   │           ├── profile.html
│   │           ├── register.html
│   │           ├── seating.html
│   │           ├── show-bus.html
│   │           └── show-ticket.html
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── ticketmanager/
│                       └── TicketmanagerApplicationTests.java # Test class for the main application
│
├── target/                           # Build output directory
│   ├── ticketmanager-0.0.1-SNAPSHOT.jar
│   ├── ticketmanager-0.0.1-SNAPSHOT.jar.original
│   ├── classes/
│   │   ├── application.properties
│   │   ├── com/
│   │   │   └── example/
│   │   │       └── ticketmanager/
│   │   │           ├── ticketmanagerApplication.class
│   │   │           ├── controller/
│   │   │           │   ├── BusController.class
│   │   │           │   ├── HomeController.class
│   │   │           │   ├── PaymentMethodController.class
│   │   │           │   ├── RouteController.class
│   │   │           │   ├── TicketController.class
│   │   │           │   └── UserController.class
│   │   │           ├── dto/
│   │   │           │   ├── BusSearchResponseDTO$RouteDTO.class
│   │   │           │   ├── BusSearchResponseDTO.class
│   │   │           │   ├── PaymentMethodDTO.class
│   │   │           │   ├── TicketDTO.class
│   │   │           │   └── UserDTO.class
│   │   │           ├── model/
│   │   │           │   ├── Bus.class
│   │   │           │   ├── HomeResponse.class
│   │   │           │   ├── LoginResponse.class
│   │   │           │   ├── PaymentMethod.class
│   │   │           │   ├── PaymentStatus.class
│   │   │           │   ├── RegisterResponse.class
│   │   │           │   ├── Route.class
│   │   │           │   ├── Ticket.class
│   │   │           │   ├── TicketStatus.class
│   │   │           │   └── User.class
│   │   │           ├── repository/
│   │   │           │   ├── BusRepository.class
│   │   │           │   ├── PaymentMethodRepository.class
│   │   │           │   ├── RouteRepository.class
│   │   │           │   ├── TicketRepository.class
│   │   │           │   └── UserRepository.class
│   │   │           ├── security/
│   │   │           │   └── JwtUtil.class
│   │   │           └── service/
│   │   │               ├── BusService.class
│   │   │               ├── PaymentMethodService.class
│   │   │               ├── RouteService.class
│   │   │               ├── TicketService.class
│   │   │               └── UserService.class
│   │   └── templates/
│   │       ├── add-payment.html
│   │       ├── bookinghistory.html
│   │       ├── edit-payment.html
│   │       ├── error.html
│   │       ├── home.html
│   │       ├── login.html
│   │       ├── profile.html
│   │       ├── register.html
│   │       ├── seating.html
│   │       ├── show-bus.html
│   │       └── show-ticket.html
│   ├── generated-sources/
│   │   └── annotations/
│   ├── generated-test-sources/
│   │   └── test-annotations/
│   ├── maven-archiver/
│   │   └── pom.properties
│   ├── maven-status/
│   │   └── maven-compiler-plugin/
│   │       ├── compile/
│   │       │   ├── default-compile/
│   │       │   │   ├── createdFiles.lst
│   │       │   │   └── inputFiles.lst
│   │       └── testCompile/
│   │           └── default-testCompile/
│   │               ├── createdFiles.lst
│   │               └── inputFiles.lst
│   ├── surefire-reports/
│   │   ├── com.example.ticketmanager.ticketmanagerApplicationTests.txt
```

# Ticket Manager API Documentation

## Base URL
```
http://localhost:8080/api
```

## Authentication

All endpoints require a Bearer token for authorization. Include the token in the `Authorization` header.

## 1. User Endpoints

### Register User

- POST `/register`
- Request Body:
  ```json
  {
    "firstName": "string",
    "lastName": "string",
    "email": "string",
    "password": "string"
  }
  ```
- Response:
  - 200 OK
    ```json
    {
      "message": "Registration successful"
    }
    ```

### Login User

- POST `/login`
- Request Body:
  ```json
  {
    "email": "string",
    "password": "string"
  }
  ```
- Response:
  - 200 OK
    ```json
    {
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "token": "string",
      "message": "optional string"
    }
    ```

### Home Page

- GET `/home`
- Headers:
  - `Authorization: Bearer {token}`
- Response:
  - 200 OK
    ```json
    {
      "message": "Welcome, {firstName}"
    }
    ```
  - 401 Unauthorized (if token is expired or invalid)
  - 404 Not Found (if user is not found)

## 2. Payment Method Endpoints

### Add Payment Method

- POST `/payment-method/add`
- Request Body:
  ```json
  {
    "cardNumber": "string",
    "cardHolderName": "string",
    "expiryDate": "string",
    "cardType": "string"
  }
  ```
- Headers:
  - `Authorization: Bearer {token}`
- Response:
  - 201 Created
    ```json
    {
      "id": 1,
      "cardNumber": "string",
      "cardHolderName": "string",
      "expiryDate": "string",
      "cardType": "string"
    }
    ```
  - 404 Not Found (if user is not found)

### Get All Payment Methods

- GET `/payment-methods`
- Headers:
  - `Authorization: Bearer {token}`
- Response:
  - 200 OK
    ```json
    [
      {
        "id": 1,
        "cardNumber": "string",
        "cardHolderName": "string",
        "expiryDate": "string",
        "cardType": "string"
      }
    ]
    ```
  - 404 Not Found (if user is not found)

### Delete Payment Method

- DELETE `/payment-methods/delete/{id}`
- Headers:
  - `Authorization: Bearer {token}`
- Response:
  - 204 No Content
  - 404 Not Found (if payment method or user is not found)

## 3. Bus Endpoints

### Create Bus

- POST `/buses/create`
- Request Body:
  ```json
  {
    "busNumber": "string",
    "capacity": 50,
    "timing": "string",
    "routeId": 1
  }
  ```
- Response:
  - 201 Created
    ```json
    {
      "id": 1,
      "busNumber": "string",
      "capacity": 50,
      "timing": "string",
      "route": {
        "id": 1,
        "startLocation": "string",
        "destinationLocation": "string"
      }
    }
    ```
  - 404 Not Found (if route is not found)

### Get All Buses

- GET `/buses/all`
- Response:
  - 200 OK
    ```json
    [
      {
        "id": 1,
        "busNumber": "string",
        "capacity": 50,
        "timing": "string",
        "route": {
          "from": "string",
          "to": "string"
        },
        "bookedSeats": 10,
        "availableSeats": 40
      }
    ]
    ```

### Update Bus

- PUT `/buses/update/{id}`
- Request Body:
  ```json
  {
    "busNumber": "string",
    "capacity": 50,
    "timing": "string",
    "routeId": 1
  }
  ```
- Response:
  - 200 OK
    ```json
    {
      "id": 1,
      "busNumber": "string",
      "capacity": 50,
      "timing": "string",
      "route": {
        "id": 1,
        "startLocation": "string",
        "destinationLocation": "string"
      }
    }
    ```
  - 404 Not Found (if bus or route is not found)

### Delete Bus

- DELETE `/buses/delete/{id}`
- Response:
  - 204 No Content
  - 404 Not Found (if bus is not found)

### Search Buses

- GET `/buses/search`
- Parameters:
  - `from` (start location)
  - `to` (destination location)
- Response:
  - 200 OK
    ```json
    [
      {
        "id": 1,
        "busNumber": "string",
        "capacity": 50,
        "timing": "string",
        "route": {
          "from": "string",
          "to": "string"
        },
        "bookedSeats": 10,
        "availableSeats": 40
      }
    ]
    ```

## 4. Ticket Endpoints

### Create Ticket

- POST `/tickets/create`
- Request Body:
  ```json
  {
    "seatNumbers": "string",
    "busId": 1,
    "paymentMethodId": 1,
    "ticketNumber": "string",
    "date": "string"
  }
  ```
- Response:
  - 201 Created
    ```json
    {
      "id": 1,
      "busNumber": "string",
      "seatNumbers": "string",
      "user": {
        "id": 1,
        "firstName": "string",
        "lastName": "string",
        "email": "string"
      },
      "ticketStatus": "INITIATED",
      "paymentStatus": "PENDING",
      "paymentMethod": {
        "id": 1,
        "cardNumber": "string",
        "cardHolderName": "string",
        "expiryDate": "string",
        "cardType": "string"
      },
      "ticketNumber": "string",
      "date": "string"
    }
    ```
  - 404 Not Found (if bus or payment method is not found)

### Update Ticket

- PUT `/tickets/update/{id}`
- Request Body:
  ```json
  {
    "seatNumbers": "string",
    "busId": 1,
    "paymentMethodId": 1,
    "ticketNumber": "string",
    "date": "string"
  }
  ```
- Response:
  - 200 OK
    ```json
    {
      "id": 1,
      "busNumber": "string",
      "seatNumbers": "string",
      "user": {
        "id": 1,
        "firstName": "string",
        "lastName": "string",
        "email": "string"
      },
      "ticketStatus": "BOOKED",
      "paymentStatus": "PAID",
      "paymentMethod": {
        "id": 1,
        "cardNumber": "string",
        "cardHolderName": "string",
        "expiryDate": "string",
        "cardType": "string"
      },
      "ticketNumber": "string",
      "date": "string"
    }
    ```
  - 404 Not Found (if ticket is not found)

### Get All Tickets for User

- GET `/tickets`
- Headers:
  - `Authorization: Bearer {token}`
- Response:
  - 200 OK
    ```json
    [
      {
        "id": 1,
        "busNumber": "string",
        "seatNumbers": "string",
        "user": {
          "id": 1,
          "firstName": "string",
          "lastName": "string",
          "email": "string"
        },
        "ticketStatus": "BOOKED",
        "paymentStatus": "PAID",
        "paymentMethod": {
          "id": 1,
          "cardNumber": "string",
          "cardHolderName": "string",
          "expiryDate": "string",
          "cardType": "string"
        },
        "ticketNumber": "string",
        "date": "string"
      }
    ]
    ```
  - 404 Not Found (if user is not found)

---
---

## UserController Page URL Mapping

### User Registration Page

- URL: `/user/register`
- Method: GET
- Description: Displays the user registration form.

### User Registration Processing

- URL: `/user/register`
- Method: POST
- Description: Processes the user registration form submission.

### User Login Page

- URL: `/user/login`
- Method: GET
- Description: Displays the user login form.

### User Login Processing

- URL: `/user/login`
- Method: POST
- Description: Processes the user login form submission. Redirects to the home page upon successful login.

### Home Page

- URL: `/user/home`
- Method: GET
- Description: Displays the home page after user login. Redirects to the login page if the session is invalid or token is expired.

### User Profile Page

- URL: `/user/profile`
- Method: GET
- Description: Displays the user's profile page with user details. Redirects to the login page if the session is invalid or token is expired.

### Update User Profile

- URL: `/user/profile/update`
- Method: POST
- Description: Processes updates to the user's profile information. Redirects to the profile page if update is successful or login page if token is expired.

### Add Payment Method Page

- URL: `/user/add-payment`
- Method: GET
- Description: Displays the form to add a new payment method. Redirects to the login page if the session is invalid or token is expired.

### Add Payment Method Processing

- URL: `/user/add-payment`
- Method: POST
- Description: Processes adding a new payment method. Redirects to the profile page upon success or login page if token is expired.

### Edit Payment Method Page

- URL: `/user/edit-payment/{paymentMethodId}`
- Method: GET
- Description: Displays the form to edit an existing payment method. Redirects to the profile page if the payment method is not found or login page if token is expired.

### Update Payment Method Processing

- URL: `/user/update-payment`
- Method: POST
- Description: Processes updates to an existing payment method. Redirects to the profile page upon success or login page if token is expired.

### Delete Payment Method

- URL: `/user/delete-payment/{id}`
- Method: GET
- Description: Handles the deletion of a payment method. Redirects to the profile page upon success or login page if token is expired.

### Available Bus Page

- URL: `/user/show-bus`
- Method: GET
- Description: Displays available buses based on search criteria. Redirects to the login page if the session is invalid or token is expired.

### Book Ticket Page

- URL: `/user/book-ticket/{busNumber}/{date}`
- Method: GET
- Description: Displays the seating arrangement for a specific bus. Redirects to the login page if the session is invalid or token is expired.

### Ticket Confirmation Page

- URL: `/user/book-confirm`
- Method: GET
- Description: Displays the confirmed ticket details based on the ticket number. Redirects to the login page if the session is invalid or token is expired.

### Booking History Page

- URL: `/user/booking-history`
- Method: GET
- Description: Displays the booking history of the user. Redirects to the login page if the session is invalid or token is expired.

### User Logout

- URL: `/user/logout`
- Method: GET
- Description: Logs out the user and invalidates the session. Redirects to the login page.

---