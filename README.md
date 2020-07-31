# Longest-Palindromic-Substring-REST-API
The project involves getting string from a user at one endpoint. Longest Palindromic substring is calculated for the input string. 
The second endpoint returns this palindromic string back to the user in JSON format. The database used is an in-memory mongo database
so that the application can be run without needing an external database.
Providing suitable database properties in application.properties file and uncommenting the test scope for embedded mongo dependency
will ensure that the application works with an external database.

The commands for the given endpoints are - 

curl --location --request PUT 'localhost:8080/savePalindrome?_s_=vatsal'

curl --location --request GET 'localhost:8080/getPalindrome?_s_=randomness'

The same can be achieved using Postman Client.

Below are two test wih two endpoints each, first endpoint "PUT" inserts the string in the database and the "GET" method 
gets the calculated longest palindrome substring for the corresponding string.

<img width="1000" height="400" alt="palindrome_test2" src="https://user-images.githubusercontent.com/48147101/89000854-749c9d80-d2c6-11ea-8610-ad54c23434d4.PNG">

<img width="1000" height="400" alt="palindrome_test3" src="https://user-images.githubusercontent.com/48147101/89001104-23d97480-d2c7-11ea-97d7-19ef66bc5cda.PNG">

<img width="1000" height="400" alt="palindrome_test5" src="https://user-images.githubusercontent.com/48147101/89001225-964a5480-d2c7-11ea-85f2-67a0fa447f5c.PNG">

<img width="1000" height="400" alt="palindrome_test4" src="https://user-images.githubusercontent.com/48147101/89001244-ad894200-d2c7-11ea-8161-1622141581a3.PNG">
