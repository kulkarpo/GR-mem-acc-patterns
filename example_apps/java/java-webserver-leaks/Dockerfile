FROM gradle:5.5-jdk

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp

RUN ls -lrt

EXPOSE 8080

CMD ["./gradlew", "run"]
