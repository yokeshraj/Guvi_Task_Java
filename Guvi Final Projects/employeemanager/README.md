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

### employeemanager/

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
|   |   |           \---employeemanager
|   |   |               |   EmployeemanagerApplication.java
|   |   |               |   
|   |   |               +---controller
|   |   |               |       EmployeeController.java
|   |   |               |       
|   |   |               +---model
|   |   |               |       Employee.java
|   |   |               |       
|   |   |               +---repository
|   |   |               |       EmployeeRepository.java
|   |   |               |       
|   |   |               \---service
|   |   |                       EmployeeService.java
|   |   |                       
|   |   \---resources
|   |       |   application.properties
|   |       |   
|   |       +---static
|   |       |       style.css
|   |       |       
|   |       \---templates
|   |           \---employee
|   |                   form.html
|   |                   list.html
|   |                   view.html
|   |                   
|   \---test
|       \---java
|           \---com
|               \---example
|                   \---employeemanager
|                           EmployeemanagerApplicationTests.java
|                           
\---target
    |   employeemanager-0.0.1-SNAPSHOT.jar
    |   employeemanager-0.0.1-SNAPSHOT.jar.original
    |   
    +---classes
    |   |   application.properties
    |   |   
    |   +---com
    |   |   \---example
    |   |       \---employeemanager
    |   |           |   EmployeemanagerApplication.class
    |   |           |   
    |   |           +---controller
    |   |           |       EmployeeController.class
    |   |           |       
    |   |           +---model
    |   |           |       Employee.class
    |   |           |       
    |   |           +---repository
    |   |           |       EmployeeRepository.class
    |   |           |       
    |   |           \---service
    |   |                   EmployeeService.class
    |   |                   
    |   +---static
    |   |       style.css
    |   |       
    |   \---templates
    |       \---employee
    |               form.html
    |               list.html
    |               view.html
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
    |       com.example.employeemanager.EmployeemanagerApplicationTests.txt
    |       TEST-com.example.employeemanager.EmployeemanagerApplicationTests.xml
    |       
    \---test-classes
        \---com
            \---example
                \---employeemanager
                        EmployeemanagerApplicationTests.class
```

## EmployeeController Page URL Mapping

### List Employees

- **URL:** `/employees`
- **Method:** GET
- **Description:** Displays a list of all employees.

### Show Add Employee Form

- **URL:** `/employees/add`
- **Method:** GET
- **Description:** Displays the form to add a new employee.

### Save Employee

- **URL:** `/employees/save`
- **Method:** POST
- **Description:** Processes the form submission to save a new employee or update an existing employee. Redirects to the employee list upon success.

### Show Edit Employee Form

- **URL:** `/employees/edit/{id}`
- **Method:** GET
- **Description:** Displays the form to edit an existing employee based on the provided ID. Redirects to the employee list if the employee is not found.

### Delete Employee

- **URL:** `/employees/delete/{id}`
- **Method:** GET
- **Description:** Deletes the employee with the specified ID. Redirects to the employee list upon success.

### View Employee

- **URL:** `/employees/view/{id}`
- **Method:** GET
- **Description:** Displays detailed information about the employee with the specified ID. Redirects to the employee list if the employee is not found.