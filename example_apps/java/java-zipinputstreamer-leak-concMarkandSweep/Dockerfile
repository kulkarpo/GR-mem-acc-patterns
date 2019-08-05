FROM openjdk:latest

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp/target

RUN ls

CMD ["java", "-XX:+UseConcMarkSweepGC", "-cp", "memory-leaks.jar", "pl.kordulewski.memory.leaks.runners.ZipInputStreamNotProperlyClosedRunner"]
