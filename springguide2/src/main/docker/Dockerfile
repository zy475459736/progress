FROM gcr.io/distroless/java
ADD /testApp2.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]



FROM maven:3.5-jdk-8 AS build
COPY ./src /tmp/src
COPY ./pom.xml /tmp
RUN mvn -f /tmp/pom.xml clean package

FROM gcr.io/distroless/java
COPY --from=build /tmp/target/testApp2.jar /tmp/testApp2.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/tmp/testApp2.jar"]

#FROM gcr.io/distroless/java
#VOLUME /tmp
#ADD testApp2.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#
#RUN sh -c 'touch /app.jar'
#ENV JAVA_OPTS=""
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]


#FROM openjdk:8-jdk-alpine AS build-env
#ADD . /app/examples
#WORKDIR /app
#RUN javac examples/*.java
#RUN jar cfe main.jar examples.HelloJava examples/*.class
#
#FROM gcr.io/distroless/java
#COPY --from=build-env /app /app
#WORKDIR /app
#CMD ["main.jar"]