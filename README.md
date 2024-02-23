## Abstract Idea about the task:
Automation testing task (UI)

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

 1. src/main/java/com.stcTv- It contains all framework packages
 2.	src/test/java/ - It contains test cases and base class.
 3.	src/test/resources – It contains config file.
 4.	pom file which has all needed dependency
 5.	testng.xml to run the test script
 6.	My framework will support parallel execution,I have implemented it with the help of thread local
 7.	It will also support other browsers.
 8.	I have created separate tests and page classes for each pages to show page object model approach.
 9.	I have saved validation data under src/test/resources in config.properties file and testdata.xlsx.


## Web Report

 <img src="WebResult.png">
     
## Execution from CMD

•	git clone https://github.com/Athirassabu/DemocranceProjectCode
•	cd DemocranceProjectCode
•	Run mvn clean test in cmd prompt for parallel execution.

## Execution from IDE
Execution is possible from both testng.xml and maven commands so jenkins integration will be easy

	You can start execution from testng.xml file after cloning the project and see the report in index.html
	You can run the project from terminal using mvn clean test

## Set-Up prerequisites.
1.	Java version - jdk 1.9
2.	Maven version - apache maven 3.8.1,
3.	maven-surefire-plugin - 2.14.1
4.	IntelliJ/Eclipse Cucumber plugins







