# RestfulAPI
Restful API
Employee Department Project - Spring Boot CRUD Application
This project is a simple CRUD application built using Java and Spring Boot. It allows managing employees, departments, and projects, and supports basic operations such as Create, Read, Update, and Delete for each entity. The application uses a built-in H2 in-memory database for storing data and provides REST APIs to interact with the application.

Features:
1. Employee Management (CRUD operations)
2. Department and Project Management (CRUD operations)
3. Employee Assignment to Departments/Projects (Incomplete)
4. H2 Database for local in-memory storage
5. API Testing via Postman

Project Setup
Prerequisites:
1. Java 8+ installed
2. Maven installed
3. Postman for testing the APIs
4. VS Code (Visual Studio Code) for development
5. Spring Boot dependencies (automatically handled via pom.xml)

Database Configuration
The application uses an H2 in-memory database for quick and lightweight testing. No additional database setup is required.
The database schema will be created automatically on application startup based on your @Entity classes.

Testing the API with Postman
You can use Postman to test the API endpoints by sending requests to http://localhost:9011. Make sure the application is running before sending requests.
- Please refer to the Postman URL.docx
