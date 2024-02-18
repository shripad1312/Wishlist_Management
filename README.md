Xindus Assignment: Wishlist Management Backend
Welcome to the Xindus Assignment repository! This backend application serves as the backend solution for managing wishlists in an e-commerce platform. The application is built using Spring Boot, Spring Security , and Spring Data JPA.

Features
User Authentication: Secure signup and login functionality using Spring Security.
Wishlist Management: RESTful API endpoints for managing user wishlists, including creation and deletion of wishlist items.
Database Integration: Integration with a relational database using Spring Data JPA for storing user information and wishlist items.

Setup and Usage
Prerequisites
Java Development Kit (JDK) version 8 or higher
Maven
Installation
Step1:- Clone the repository to your local machine:

git clone [https://github.com/shripad1312/Wishlist_Management.git]
Step2:- Navigate to the project directory:

cd XindusWishlistManagement
Step3:- Build the project using Maven:

mvn clean install


#Steps
1)#Create a database with name "Xi" in mysql
2)run the spring application make sure  mysql server should be on at same time
3)after sucessfully run of project open postman for api 
4)Add User first all the api's are follwed with proper data below by using this yoou can make your custom users also
5)Add a Product then all the api's are follwed with proper req body and you can add you custom product also
6)After that you can perform any Wishlist relataed api given below only Basic Auth is necessary to Access that api
#End

The application will start on the default port 8080.
API Usage
NOTE:Open Postman or any HTTP client application.

#Sign Up:Add a User
Send a POST request to [http://localhost:8080/Public/User/add] with JSON body containing user details:
{
"name":"user1",
"username":"user1",
"password":"user1"
}
Username always should be unique whil adding user
Note:by using above attributes you can make custom users

#Add a Product
Send a POST request to [http://localhost:8080/Public/Product/addProduct] with JSON body containing user credentials:
{
"name":"HIVE",
"qty":12
}
Note: You can can add your custom products also using above

#Note:For now on Api' you should use "Basic Auth from postman" and enter there registerd username and valid password

#Post req:for adding product into User's wishlist
post url:[http://localhost:8080/api/wishlists/addToCart/{valid product id here}]
product id you will get when you add a product after adding 1 product you can use 1 as a default value which you can change later
here Authorization should be "Basic Auth" from postman if we enter wrong details it will throw 401 error on postman

#Get req:It will Give all wishlist og logged in user
get Url :[http://localhost:8080/api/wishlists/getList]

Delete req:it will take product id as a parameter and delete the Product from wishlist
#delete Url:[http://localhost:8080/api/wishlists/delete/3]
Note:only authorized user and valid product user can be delete from wishlist if user is not valid or invalid product is there it will throw custom Exception with proper response

#Note:Only Authorized user can use above 3 api's

Thank you for exploring the Xindus Assignment backend repository! We hope this documentation provides clear guidance on setting up, configuring, and using the application.
