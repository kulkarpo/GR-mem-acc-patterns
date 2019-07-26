FROM openjdk:latest

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp

RUN javac JavaWeakReferenceLeak.java

CMD ["java", "JavaWeakReferenceLeak"]
