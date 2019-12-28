# ECR Image Change Detection

## Description

This is a fully functional example of how to deploy automatically a new task when a new image is pushed to a repository in AWS ECR.

This example will build:

- Log Group

- Security Groups

- Application Load Balancer

- Target Groups

- ALB Listeners

- ECS Cluster

- ECS Task Definition

- ECS Service

- Lambda Role

- Lambda Function

- CloudWatch Rule

## Requirements

- AWS Account with a VPC and a NatGateway

- Bucket with the lambda function that starts the new task

- ECR Repository with the docker image that will be use by the task definition, 

- Maven 3.x

- Docker

## Content

- cloudformation.yml: The cloudformation template that builds all the AWS infraestructure. The template  expects the following parameters:
  
  - vpcId: The VPC id where all the infraestructure will be built.
  
  - elbSubnet1Id: A public subnet that will be associated with the Load Balancer.
  
  - elbSubnet2Id: Another public subnet that will be associated with the Load Balancer.
  
  - containerSubnet1Id: A private subnet that will be associated with the ECS Service
  
  - containerSubnet2Id: Another private subnet that will be associated with the ECS Service
  
  - containerImage: Image repository, for example, xxxxxxxxxxxx.dkr.ecr.eu-central-1.amazonaws.com/hellocloud
  
  - lambdaS3Bucket: S3 Bucket where the lambda function is stored
  
  - lambdaS3Key: S3 key to the lambda function
  
  - repositoryName: ECR Repository Name that contains the image
  
  - prefix: A prefix that will be set in the name of all the resources to be sure that all the names used are unique, by default is ecr-icd

- hellocloud: An Spring Boot project dockerized that will be deployed using AWS Fargate

- lambda-ecr.py: The lambda function that will listen the ECR events and launch a new task

- push-image2ecr.sh: An script that creates the docker image of the target jar and push it to ECR (requires two parameters cli profile and ECR repository)
