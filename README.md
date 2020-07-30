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
