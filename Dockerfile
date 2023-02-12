FROM openjdk:11
EXPOSE 8080
ADD target/thebestbarber.jar thebestbarber.jar
ENTRPOINT["java", "-jar", "thebestbarber.jar" ]