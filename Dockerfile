FROM openjdk:11
EXPOSE 8080
ADD target/thebestbarber.jar thebestbarber.jar
ENTRYPOINT ["java", "-jar", "thebestbarber.jar" ]
