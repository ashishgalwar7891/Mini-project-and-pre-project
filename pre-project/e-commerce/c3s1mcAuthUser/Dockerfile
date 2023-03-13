FROM openjdk
WORKDIR usr/lib
ADD target/c3s1mcAuthUser-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT ["java","-jar","user.jar"]