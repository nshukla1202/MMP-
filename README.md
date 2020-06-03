# MMP-

*Run Selenium TestNG Test with Maven Command Line..**
This Project is controlled by Pom.xml.
1>Added the compiler plugin
2>Added the surefire plugin
3>Added the maven Dependency
4>Created TestNg1.xml.

Step 1>In command line type mvn clean
Step 2>mvn clean test
Stest3>All the testNg test will run
Step4>Bulid Success

*Run the  TestNg test from Eclipse*

Step1>Right click on pom.xml.
Step2>Run as>Maven Test
Step 3>All the test  will run.

Run Selenium tests on Jenkin
Set Up Jenkins
Create Job and run Slenium Test
Step 1>Set Up Jenkin
Step2>From Window open services.msc
Step 3>Start the Jenkin
Step4>Enter url:http://localhost:8080
Step5>Click on create New Item and click on freestyle project clcik ok
Step6:We will go to the next window In description:give any comment
Step6>Source code management say None or integrate with Git
Step7:Build Add the build Steps Execute windows Bat commands
Step 8:a>Give the location cd and location of Project
b>mvn clean test
c>echo:Success
Step 8>Aply and save
Step9>Run and validate go to Build Now and see the logs and console.


*Jenkins Integration With GIT.* and Provide Repo url
Step1>Under the I have select Git
Step2>Under Build Trigger POLL SCM>With scheduler just put ******(It will check for the git  reposssitory for every minute of changes)
Step3>c:
cd C:\Neha\Selenium\SeleniumJavaProject\MMPProject
mvn clean test
echo Success
Step4>Apply and Save.
Step5>




