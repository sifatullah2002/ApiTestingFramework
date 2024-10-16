# API Testing Framework

This is a simple API testing framework built using Java, RestAssured, and JUnit 5. It demonstrates how to test basic HTTP methods like GET, POST, PUT, and DELETE for a public API.

### Technologies Used:
- Java 17
- RestAssured
- JUnit 5
- Maven

### How to Run:
1. Clone the repository.
2. Import it as a Maven project in IntelliJ IDEA.
3. Run the tests using IntelliJ's test runner or by executing `mvn test`.

### Tested API:
- JSONPlaceholder (https://jsonplaceholder.typicode.com)

### Test Cases:
- `testGetPosts()`: Fetches posts and validates the response.
- `testCreatePost()`: Creates a new post and validates the response.
- `testUpdatePost()`: Updates a post and validates the response.
- `testDeletePost()`: Deletes a post and checks the response.
