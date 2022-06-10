# SignUpPage
Build an API server backend to • Signup • Login • Reset Password

## Basic OverView
A Signup • Login • Reset Password UI backed by Spring Boot, Spring Security, Hibernate.

For FrontEnd Thymeleaf(Java Template Engine for processing HTML) is used.

For Storage MySQL is used (Hibernate takes care of CREATE READ UPDATE DELETE from MySQL Table)

<p align="center">
  <img src="https://github.com/mohitrewtani/SignUpPage/blob/master/images/Singup.png">
</p>

## Deployment

Directly Open Project in Spring Tool Suite

pom.xml will load all dependencies

Before Running the application make sure JDK/Maven Dependencies are properly loaded

MYSQL is connected and there should be a table name "demo"

### Set up MySQL
By default below configuration is used so in so in application.properties please mention the table name and username password
```
## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url = jdbc:mysql://localhost:3306/demo?useSSL=false
spring.datasource.username = root
spring.datasource.password = root
```

After all dependcies are downloaded and mysql setup is complete

Run the Application

In browser open below mentioned signup link

### SignUp 
Link: http://localhost:8080/registration

In SignUp need to insert FirstName, LastName , Email (this is your Username for login) and Password

Password Constraints
•Min: 1 lowercase and 1 uppercase alphabet • Min: 1 number • Min: 1 special character from this (@#$%)
• 8-16 character length • Shouldn’t be the same as the username

After inserting details as per above rule
Registration successful message wil be seen else error message can be seen.

These entry can be seen in MySQL database after successful registration

This page has link to go to Login API

### Login 

Link: http://localhost:8080/login

Username and Password used in above registered link is used here to login

If correct username password is not put Error will be seen

Else Login will redirect to Home Page

<img src="https://github.com/mohitrewtani/SignUpPage/blob/master/images/Login.png">

The above page has link to resetpassword page and again going back to signup page

### ResetPassword
Link: http://localhost:8080/resetpassword

This Page will have Username Old Password and New Password entries for User to Put and reset their new password

New Password follows password constraints as mentioned above for password in registration

New Password cannot be same as old password

Once successfull User in MySQL is updated with New Password and user can only login with new Password


<img src="https://github.com/mohitrewtani/SignUpPage/blob/master/images/ResetPassword.png">


### Welcome Page on successful login
<img src="https://github.com/mohitrewtani/SignUpPage/blob/master/images/Welcome.png">


