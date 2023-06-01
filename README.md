#JAVA
This spring boot project has been created for the java 8 version. 
When you are going to run it, verify that you have correctly installed 
the java 17 version in your machine, as well as that in your environment variables, 
JAVA_HOME points to the folder in which you have your jdk-8 [eg: 'C:\Program Files\Java\jdk-1.8.0']

#MAVEN
Whith the command 'mvn --version' also verify that your maven is pointing against the java 8 version.

#ECLIPSE
In Eclipse, if you right click on the "redsys-transaction-service" project and select "properties" you
have to configure the "Java Compiler" option to use the "JavaSE-8" execution environment.

#COMPILATION & RUNNING (FROM CONSOLE)
To compile the project you simply have to access into its folder and run the command: 
    'mvn clean install -U'
To running the project, in the same folder, you must run the command:
     './mvnw spring-boot:run'
     
#COMPILATION & RUNNING (FROM ECLIPSE)
First, if the "Boot Dashboard" tab does not appear in your Eclipse, follow these steps:
    Window > Show View > Boot Dashboard
From the "Boot Dashboard" tab, go over the project and right-click to "(Re)Start"
