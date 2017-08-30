FROM openjdk:8-jdk-alpine

RUN mkdir /homeboy

COPY target/homeboy-1.0-SNAPSHOT.jar /homeboy/homeboy-1.0-SNAPSHOT.jar

WORKDIR /homeboy

CMD ["sh", "-c", "java -Dspring.profiles.active=$JAVA_ENV -Djava.security.egd=file:/dev/./urandom -Xms128m -Xmx512m -jar homeboy-1.0-SNAPSHOT.jar"]