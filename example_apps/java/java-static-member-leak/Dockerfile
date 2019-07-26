FROM openjdk:latest

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp

RUN javac JavaStaticMemberLeak.java

CMD ["java", "JavaStaticMemberLeak"]
