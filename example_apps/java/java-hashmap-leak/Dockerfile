FROM anapsix/alpine-java

COPY . /usr/src/myleakyapp
WORKDIR /usr/src/myleakyapp/target

#RUN ls -lrt 
CMD ["java", "-jar", "memoryleak.jar"]
