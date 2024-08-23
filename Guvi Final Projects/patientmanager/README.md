# Video Recording


## Instructions
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

### patientmanager/

```
|   .gitignore
|   folder-structure.txt
|   HELP.md
|   mvnw
|   mvnw.cmd
|   pom.xml
|   
+---.mvn
|   \---wrapper
|           maven-wrapper.properties
|           
+---src
|   +---main
|   |   +---java
|   |   |   \---com
|   |   |       \---example
|   |   |           \---patientmanager
|   |   |               |   PatientmanagerApplication.java
|   |   |               |   
|   |   |               +---controller
|   |   |               |       UserController.java
|   |   |               |       
|   |   |               +---dto
|   |   |               |       AppointmentDTO.java
|   |   |               |       
|   |   |               +---model
|   |   |               |       Appointment.java
|   |   |               |       HomeResponse.java
|   |   |               |       LoginResponse.java
|   |   |               |       Medication.java
|   |   |               |       RegisterResponse.java
|   |   |               |       User.java
|   |   |               |       
|   |   |               +---repository
|   |   |               |       AppointmentRepository.java
|   |   |               |       MedicationRepository.java
|   |   |               |       UserRepository.java
|   |   |               |       
|   |   |               +---security
|   |   |               |       JwtUtil.java
|   |   |               |       
|   |   |               \---service
|   |   |                       AppointmentService.java
|   |   |                       MedicationService.java
|   |   |                       UserService.java
|   |   |                       
|   |   \---resources
|   |       |   application.properties
|   |       |   
|   |       +---static
|   |       \---templates
|   |               add-appointment.html
|   |               add-medication.html
|   |               edit-medication.html
|   |               home.html
|   |               login.html
|   |               register.html
|   |               
|   \---test
|       \---java
|           \---com
|               \---example
|                   \---patientmanager
|                           PatientmanagerApplicationTests.java
|                           
\---target
    |   patientmanager-0.0.1-SNAPSHOT.jar
    |   patientmanager-0.0.1-SNAPSHOT.jar.original
    |   
    +---classes
    |   |   application.properties
    |   |   
    |   +---com
    |   |   \---example
    |   |       \---patientmanager
    |   |           |   PatientmanagerApplication.class
    |   |           |   
    |   |           +---controller
    |   |           |       UserController.class
    |   |           |       
    |   |           +---dto
    |   |           |       AppointmentDTO.class
    |   |           |       
    |   |           +---model
    |   |           |       Appointment.class
    |   |           |       HomeResponse.class
    |   |           |       LoginResponse.class
    |   |           |       Medication.class
    |   |           |       RegisterResponse.class
    |   |           |       User.class
    |   |           |       
    |   |           +---repository
    |   |           |       AppointmentRepository.class
    |   |           |       MedicationRepository.class
    |   |           |       UserRepository.class
    |   |           |       
    |   |           +---security
    |   |           |       JwtUtil.class
    |   |           |       
    |   |           \---service
    |   |                   AppointmentService.class
    |   |                   MedicationService.class
    |   |                   UserService.class
    |   |                   
    |   \---templates
    |           add-appointment.html
    |           add-medication.html
    |           edit-medication.html
    |           home.html
    |           login.html
    |           register.html
    |           
    +---generated-sources
    |   \---annotations
    +---generated-test-sources
    |   \---test-annotations
    +---maven-archiver
    |       pom.properties
    |       
    +---maven-status
    |   \---maven-compiler-plugin
    |       +---compile
    |       |   \---default-compile
    |       |           createdFiles.lst
    |       |           inputFiles.lst
    |       |           
    |       \---testCompile
    |           \---default-testCompile
    |                   createdFiles.lst
    |                   inputFiles.lst
    |                   
    +---surefire-reports
    |       com.example.patientmanager.PatientmanagerApplicationTests.txt
    |       TEST-com.example.patientmanager.PatientmanagerApplicationTests.xml
    |       
    \---test-classes
        \---com
            \---example
                \---patientmanager
                        PatientmanagerApplicationTests.class
```

Here’s the page mapping for the `PatientManager` project in Markdown format, based on the `UserController` and other files provided:

---

## UserController Page URL Mapping

### User Login Page

- **URL:** `/api/users/login`
- **Method:** GET
- **Description:** Displays the user login form.

### User Login Processing

- **URL:** `/api/users/login`
- **Method:** POST
- **Description:** Processes the user login form submission. Redirects to the home page upon successful login.

### User Registration Page

- **URL:** `/api/users/register`
- **Method:** GET
- **Description:** Displays the user registration form.

### User Registration Processing

- **URL:** `/api/users/register`
- **Method:** POST
- **Description:** Processes the user registration form submission. Redirects to the login page upon successful registration.

### Home Page

- **URL:** `/api/users/home`
- **Method:** GET
- **Description:** Displays the home page after user login. Redirects to the login page if the session is invalid or token is expired. Shows user details, medications, and appointments.

### Add Medication Page

- **URL:** `/api/users/medications/add`
- **Method:** GET
- **Description:** Displays the form to add a new medication. Redirects to the login page if the token is expired.

### Add Medication Processing

- **URL:** `/api/users/medications/add`
- **Method:** POST
- **Description:** Processes adding a new medication. Redirects to the home page upon success or login page if the token is expired.

### Edit Medication Page

- **URL:** `/api/users/medications/edit/{id}`
- **Method:** GET
- **Description:** Displays the form to edit an existing medication. Redirects to the home page if the medication is not found or login page if the token is expired.

### Update Medication Processing

- **URL:** `/api/users/medications/update/{id}`
- **Method:** POST
- **Description:** Processes updates to an existing medication. Redirects to the home page upon success or login page if the token is expired.

### Delete Medication

- **URL:** `/api/users/medications/delete/{id}`
- **Method:** GET
- **Description:** Handles the deletion of a medication. Redirects to the home page upon success.

### Add Appointment Page

- **URL:** `/api/users/appointments/add`
- **Method:** GET
- **Description:** Displays the form to add a new appointment. Redirects to the login page if the token is expired.

### Add Appointment Processing

- **URL:** `/api/users/appointments/add`
- **Method:** POST
- **Description:** Processes adding a new appointment. Redirects to the home page upon success or login page if the token is expired.

### Delete Appointment

- **URL:** `/api/users/appointments/delete/{id}`
- **Method:** GET
- **Description:** Handles the deletion of an appointment. Redirects to the home page upon success.

---