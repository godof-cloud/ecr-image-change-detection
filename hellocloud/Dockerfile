FROM openjdk:8-jre-alpine
LABEL service="hellocloud"
LABEL owner="godof.cloud"

# Install hellocloud artifact and its properties file
VOLUME /data
ADD hellocloud-service/target/hellocloud.jar /data/hellocloud.jar

EXPOSE 8080

WORKDIR /data
ENTRYPOINT ["java","-jar", "hellocloud.jar"]