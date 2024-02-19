Xindus Assignment: Wishlist Management Backend
Welcome to the Xindus Assignment repository! This backend application serves as the backend solution for managing wishlists in an e-commerce platform. The application is built using Spring Boot, Spring Security, and Spring Data JPA.

Features
User Authentication: Secure signup and login functionality using Spring Security.
Wishlist Management: RESTful API endpoints for managing user wishlists, including creation and deletion of wishlist items.
Database Integration: Integration with a relational database using Spring Data JPA for storing user information and wishlist items.
Setup and Usage
Prerequisites

Java Development Kit (JDK) version 8 or higher
Maven Installation
Installation Steps

Clone the repository to your local machine:

bash
Copy code
git clone https://github.com/shripad1312/Wishlist_Management.git<br/>
Navigate to the project directory:

bash
Copy code
cd XindusWishlistManagement
Build the project using Maven:

bash
Copy code
mvn clean install
Database Setup:

Create a database with the name "Xi" in MySQL.
Run the Spring application, ensuring the MySQL server is on simultaneously.

After successfully running the project, open Postman for API testing.

Add User: Use the provided API endpoint and JSON body to add a user.

Add a Product: Utilize the API endpoint and JSON body to add a product.

Perform wishlist-related API operations using Basic Auth for authentication.

API Usage
Note: Open Postman or any HTTP client application.

Sign Up: Add a User

Send a POST request to <br/>[http://localhost:8080/Public/User/add]<br/>
with JSON body containing user details:
<br/>
Copy code
{<br/>
    "name":"user1",<br/>
    "username":"user1",<br/>
    "password":"user1"<br/>
}
<br/>
Username must be unique when adding a user.

Add a Product: Send a POST request to<br/>
[http://localhost:8080/Public/Product/addProduct] <br/>with JSON body containing product details:
<br/>
{<br/>
    "name":"HIVE",<br/>
    "qty":12<br/>
}
<br/>
You can add custom products using the above format.

<br/>
Adding Product to Wishlist:

Send a POST request to <br/>http://localhost:8080/api/wishlists/addToCart/{valid product id} <br/>
Authorization should be "Basic Auth" from Postman.
Get Wishlist: Retrieve all wishlist items of the logged-in user.

Send a GET request to <br/>http://localhost:8080/api/wishlists/getList<br/>


Delete Product from Wishlist:
Send a DELETE request to 
<br/>http://localhost:8080/api/wishlists/delete/{product id}<br/>
Only authorized users can perform this action.

Thank you for exploring the Xindus Assignment backend repository! We hope this documentation provides clear guidance on setting up, configuring, and using the application.
