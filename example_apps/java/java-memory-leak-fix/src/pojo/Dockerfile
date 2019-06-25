FROM openjdk:latest

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp

RUN javac MemoryLeakFix.java

CMD ["java", "MemoryLeakFix"]
