Simple RESTful API for Book Management
This project is a simple RESTful API built using Java Spring Boot for managing a collection of books. It supports basic CRUD operations (Create, Read, Update, Delete) for interacting with the book collection.

Requirements
Book Model: The API utilizes a Java class to represent a book with attributes such as title, author, publication year, and ISBN.
Repository: A repository has been implemented to manage the collection of books. Initially, books are stored in memory.
Controller: REST endpoints have been created to perform CRUD operations on the book collection:
GET /api/books: Retrieve all books
GET /api/books/{id}: Retrieve a single book by ID
POST /api/books: Add a new book
PUT /api/books/{id}: Update an existing book
DELETE /api/books/{id}: Delete a book
Validation: Basic validation has been implemented for book attributes. For instance, ensuring that the publication year is a valid year and that ISBN follows a certain format.
Documentation: The API endpoints have been documented using Swagger for easy reference.
Testing: Unit tests have been written to ensure the functionality of the API endpoints.
Exception Handling: Proper exception handling has been implemented for error cases such as resource not found and validation errors.
Logging: Logging has been added to the application to track important events and errors.
Usage
To use this API, follow these steps:

Clone the repository: git clone <repository-url>
Navigate to the project directory: cd <project-directory>
Build the project: ./mvnw clean install
Run the application: ./mvnw spring-boot:run
Once the application is running, you can interact with the API endpoints using tools like Postman or cURL.

Dependencies
This project uses the following dependencies:

Spring Boot
Spring Web
Spring Data JPA
H2 Database (for testing purposes)
Swagger (for API documentation)
Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or create a pull request.
