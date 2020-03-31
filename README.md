# Spring_boot_AWS_CICD_Pipeline

Instructions:


This Project uses Spring Web Services and it is deployed to AWS Beanstalk using AWS Code Pipeline


Requirements :

#add pom.xml file
You need to add pom.xml with the maven dependencies 

#add buildspec.yml file
1. You need to add buildspec.yml file for the AWS Code Build Service to do the build based on the instructions

2. Mention the path target/jar_name to deploy the jar to AWS Elastic Beanstalk

#Create AWS RDS MySQL DB

1. Create a RDS MYSQL Database
2. Set the RDS DB to public accessibility to YES (just for testing purposes. in real projects its in a private VPC and can be used only from a authorized VPC)
3. Copy the DB endpoint url, user name and pwd
4. Open the Port 3306 for your elastic beanstalk security grop in RDS Security group for the type MYSQL/Aurora. 

#Create AWS Beanstalk Java platform 8

1. Create a AWS Beanstalk Environment with Java 8 version.

2. The following configurations must be define in AWS Beanstalk Enviroment variables under software configuration

SERVER_PORT : 5000
SPRING_DATASOURCE_URL : AWS RDS MYSQL DB URL
spring.datasource.username : username
spring.datasource.password : password
SPRING_JPA_DATABASE_PLATFORM : org.hibernate.dialect.MySQL8Dialect
SPRING_JPA_HIBERNATE_DDL_AUTO : update

#AWS CodeCommit Repo
Create a Code Commit Repsitory to Push the Code

#AWS CodeBuild
Create a Code Build to build the code

#Create AWS Code Pipeline
Create a Code Pipeline to automate the CICD

The Code Pipeline follows the below flow which is auto triggered when the code is pushed to AWS CodeCommit Repo

CodeCommit Repo -> CodeBuild -> AWS Beanstalk (It deploys the Spring Boot Jar file to the EC2 instance)


