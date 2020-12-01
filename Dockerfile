FROM openjdk:8
WORKDIR /csvapp
ADD target/csv-render.jar csv-render.jar
MAINTAINER patel patelavinashbirgunj@gmail.com
EXPOSE 8088

#CMD [ "mongod", "--bind_ip", "0.0.0.0" ]

ENTRYPOINT ["java", "-jar", "csv-render.jar"]
