
 <p align="center">
  <img src="https://logodownload.org/wp-content/uploads/2019/10/n26-logo.png" width="170">
  </p>
  <p align="center">
 
  </p>
<div align="center">
  
 # AUTOMATION CHALLENGE
 
 This repository contains the solution for API and Mobile automation
  
 </div>
 
 #
 
 # Tools
 
  ><b>Mobile Automation</b>
 
- Intellij IDEA
-	Appium
-	Junit
-	Java 8


 ><b>API Automation</b>
 
- Visual Studio Code
-	Cypress
-	Mochawesome
-	Javascript


# Test Information

 ><b>Test Scenarios - Mobile Automation</b>

-	Add income with money
- Should not Add Negative Income
- Add Income with Card
- Add Expense WithMoney
- Add Negative Expense
- Add Expense With Card
- Add Expense By Clicking On Category
- Add New Account
- Should not Add New Account Without Image
- Change Account
- Delete Category
- Delete Income
- Delete Expense
- Edit Income
- Edit Expense
- Search Income By Description
- Search Income ByCategory
- Transfer Cash To Card
- Transfer Card To Cash
- Should not Transfer to the Same Account



<br>
 
><b>Test Scenarios - API Automation</b>

-	Should show the name of the Pets available
- Should add new pet
- Should update pet info
- Should place an order for a pet
- Should not search for an inexistent order
- Should create user
- Should login with user credentials
- Should delete user
- Check pending orders
- Should not delete inexistent order

 

<em> * This project also contains the Jenkinsfile </em>

# Approach
 > <b>Mobile Automation</b>
 <p>The Mobile Automation for this project consists in testing a native mobile application. To this end, I used Appium, because it allows to work with any test script language, including Java the language used in this project. In addition to that, it is free and open source, supports both Android and IOS and the tests can be written using the same API. Junit was used to create a flow for the test execution with different annotations. It is possible to see its use especially in the class AppTest, where the test cases are defined. The entire structure of this suite was based on Page Object Model because it helps to reduce code duplication and enhance test maintenance too. 
</p>
 <br>
<br>

 ><b>API Automation</b>
 <p>As a solution for the API Automation I have used Cypress, which is an end-to-end testing framework for web test automation. With Cypress we are able to write automated web tests in Javascript and its use brings some advantages, for example, we don’t need to worry about synchronization between the code and the browser, because the wait for the DOM to load is done automatically. Another thing to mention is about debuggability, its readable errors and stack traces make debugging much easier and faster. If we compare with Selenium, we can notice how simple it is to set up and to use, and of course the time execution it is very fast too.
</p>
 <br>
<br>
 
# How to Run
> <b>Prerequisites</b>

You must Java 8, NodeJS, Appium Server and Docker installed in your machine. 
 <br>


><b>Mobile Automation</b>
```
1. Clone Task2 project to your machine.
2. Open the project
3. Start Android Emulator
4. Start Appium server
5. Run AppTest with Junit
 
```

 ><b>API</b>
```
1. Clone Task3 project to your machine.
2. Open the project
3. Run npm install
4. Run npm update
5. Run docker pull swaggerapi/petstore
6. Run "docker run -d -e SWAGGER_HOST=http://petstore.swagger.io \ -e SWAGGER_URL=http://localhost \ -e SWAGGER_BASE_PATH=/v2 -p 80:8080 swaggerapi/petstore"
7. Run npx cypress run
 
```



 # Author
 
 LUIS MARREIROS
