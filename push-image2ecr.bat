@echo off

set /p profile=Introduce aws profile [default]: 
set /p repository=Introduce your ECR repository [xxxxxxxxxxxx.dkr.ecr.us-east-1.amazonaws.com/hellocloud]: 

docker build -t hellocloud ./hellocloud
docker tag hellocloud %repository%

for /f "delims=" %%i in ('aws --profile %profile% ecr get-login --no-include-email') do set docker_login=%%i

%docker_login%

docker push %repository%