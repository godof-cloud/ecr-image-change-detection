#!/bin/bash

echo Introduce aws profile [default]:
read profile

echo Introduce your ECR repository [xxxxxxxxxxxx.dkr.ecr.us-east-1.amazonaws.com/hellocloud]:
read repository

sudo docker build -t hellocloud ./hellocloud
docker tag hellocloud $repository

$(aws --profile $profile ecr get-login --no-include-email)

docker push $repository
