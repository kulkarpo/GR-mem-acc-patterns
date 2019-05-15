FROM openjdk:latest

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp

RUN javac MemoryLeak.java

CMD ["java", "MemoryLeak"]
