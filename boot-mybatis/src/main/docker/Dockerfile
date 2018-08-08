FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER docker_maven docker_maven@email.com
WORKDIR /ROOT
COPY boot-mybatis-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-version"]
ENTRYPOINT ["java", "-jar", "app.jar"]