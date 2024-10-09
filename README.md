Hello, and thank you for viewing my submission for the receipt-processor API. 
There are two main ways to run this application. 
1) Using Java 17 and gradle
2) Using Docker and building an image/container via the Dockerfile provided


1. Spring Boot Application
   -
   This application was created in Java 17 using the Spring Boot framework, and runs in gradle.
    - After downloading, simply navigate in your terminal to the main project folder (receipt-processor)
    - Please be sure that you have Java installed by running "java -version"
        - if you do not have java installed, please install it here (https://www.oracle.com/java/technologies/downloads/)
    - Please be sure that you have Gradle installed by running "./gradlew -v". 
      - If you do not have it installed, please download it here (https://gradle.org/install/)
    - At the home directory of the project, run "./gradlew bootRun" in your terminal to start the project

2. Docker
   -
   - Please confirm that you have docker installed by running "docker --version"
     - If you do not have it installed, please install it here (https://docs.docker.com/get-started/get-docker/)
   - After navigating to the home directory, simply run "docker build --tag=receipt-processor ." 
   to create your docker image and then "docker run -p 8080:8080 receipt-processor" to run it