Student Management System
A simple backend application for managing students, courses, and payments using Spring Boot. This project demonstrates CRUD operations, many-to-many relationships, transactions, and custom queries with a basic understanding of the MVC architecture.

Features
Student CRUD Operations: Add, update, retrieve, and delete student records.
Course CRUD Operations: Manage course data including adding, updating, and deleting courses.
Many-to-Many Relationship: Students can enroll in multiple courses, and each course can have multiple students.
Transaction Management: A student can make a payment for their enrollment, with a transaction between Enrollment and Payment.
Custom Queries: SQL queries to fetch data combining the Enrollment and Payment entities.
Exception Handling: Proper error handling for various edge cases.
Standardized Responses: Consistent and standardized responses for API requests.

Technologies Used
Spring Boot: The main framework used to build the backend.
Spring Data JPA: For handling CRUD operations and custom queries.
MySQL: Database for storing the student, course, and payment information.
Lombok: For reducing boilerplate code (Getters, Setters, Constructor).
Maven: For project dependency management.

Project Structure
The project is divided into several key packages:
model: Contains entity classes (Student, Course, Enrollment, Payment).
repository: Interfaces for handling CRUD operations with Spring Data JPA.
service: Business logic of the application, like enrolling a student or processing payments.
controller: RESTful API controllers for handling incoming HTTP requests.
exception: Custom exception handling for errors.
dto: Data Transfer Objects for standardized responses.

Endpoints
Student Endpoints
GET /students - Retrieve a list of all students.
POST /students - Add a new student.
PUT /students/{id} - Update an existing student by ID.
DELETE /students/{id} - Delete a student by ID.

Course Endpoints
GET /courses - Retrieve a list of all courses.
POST /courses - Add a new course.
PUT /courses/{id} - Update an existing course by ID.
DELETE /courses/{id} - Delete a course by ID.

Enrollment Endpoints
POST /enrollments - Enroll a student in a course.
GET /enrollments - List all student enrollments.

Payment Endpoints
POST /payments - Make a payment for an enrollment.
GET /payments - List all payments.

Custom Query Endpoint
GET /enrollments/payments - Retrieve data combining Enrollment and Payment.

How to Run
Clone the repository:

bash
Copy
Edit
git clone https://github.com/HIMESH-BCS0006/StudentCRUD_Practice.git
Navigate to the project directory:

bash
Copy
Edit
cd StudentCRUD_Practice
Install the dependencies and run the project using Maven:

bash
Copy
Edit
mvn spring-boot:run
The application will start running on http://localhost:8080.

Database Configuration
Make sure you have a MySQL database running. You can use the following application.properties for the database connection:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
Exception Handling
The application handles various exceptions and provides meaningful error messages in a standardized format. For example:

Student not found: 404

Invalid input: 400

Internal server error: 500

Contributing
If you'd like to contribute, feel free to fork this repository, make your changes, and submit a pull request.

License
This project is licensed under the MIT License.

