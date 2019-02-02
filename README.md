# webtest
This is an Automation Code Project I wrote that adds a new employee to a company's employee page. I automated a manual test - 

Scenario 1: Add A New Employee - 
- I wrote this using Java/Selenium as a Maven Project in Eclipse. So the project will need to be imported as an existing Maven Project. I also use TestNG in the framework to run the test
- Test Class Code - /webtest/src/test/java/paylocity/challenge/functional/AppTest.java
- Page Class Code - /webtest/src/main/java/paylocity/challenge/employee/App.java
- TestNG file - /webtest/resources/TestNGXmls/AppTest.xml
- The web page resides on a local directory on my local machine rather than a desktop. The URL constant is a "dummy" URL.
- The Page elements are declared in their own Enum for modularity in the main project directory. 

You can run the test from running the TestNG file. There is TestNG Output Reporting located in webtest\test-output\ - HTML files

Selenium Webdriver - chromedriver.exe v2.45
