FROM adoptopenjdk/openjdk11
EXPOSE 8080
ADD /build/libs/alura-forum-0.0.1-SNAPSHOT.jar alura-forum.jar
ENTRYPOINT ["java", "-jar", "alura-forum.jar"]
