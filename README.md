## Abstract Idea about the task:
Automation testing task #1 (UI)
Resource: Democrance
Using the Selenium with base language Java, please create a test with the convenient framework structure for the policy sales journey starting here:
https://client-platform2.democrance.com/d2c/policy/critical-illness-one-product/form/information
You can use this sample Emirates ID to test: 784-1000-0000000-0
Phone number: You can enter any phone number of 9 digits starting with 50/56/58.
At the end to land on the confirmation page, you can choose the General Invoice option with any random 4 or 5-digit number.

Please ensure that you can download the policy schedule at the end of the journey.
# selenium-TestNG-java-maven
Automation Testing Using Java, Selenium with TestNg.
TestNG is a powerful testing framework, an enhanced version of JUnit which was in use for a long time before TestNG came into existence. NG stands for 'Next Generation'.
TestNG framework provides the following features −
•	Annotations help us organize the tests easily.
•	Flexible test configuration.
•	Test cases can be grouped more easily.
•	Parallelization of tests can be achieved using TestNG.
•	Support for data-driven testing.
•	Inbuilt reporting.

## Framework Architecture
•	src/main/java/com.wsp- It contains all framework packages
•	src/test/java/ - It contains test cases and base class.
•	src/test/resources – It contains config file and test data excel.

## Execution from CMD

•	git clone https://github.com/Athirassabu/WeatherShopperProject
•	cd weathershopper
•	Run mvn clean test in cmd prompt for parallel execution.

## Execution from IDE

•	You can start execution from testing.xml file.
•	You can run mvn clean install Or mvn clean verify Or mvn clean testing cmd for parallel execution from terminal.

## Set-Up prerequisites.

•	Java version - jdk 1.8.0_281,
•	Maven version - apache maven 3.8.1,
•	maven-surefire-plugin - 3.0.0-M1
•	IntelliJ/Eclipse Cucumber plugins

## Maven Dependencies.

•	Testng - 7.4.0
•	owner - 1.0.12
•	junit - 4.13.2
•	webdrivermanager - 5.0.3
•	selenium-java - 4.0.0






