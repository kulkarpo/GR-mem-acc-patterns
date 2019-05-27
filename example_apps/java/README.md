# java-memoryleak-examples
Java Docker images for testing memory leaks.

#### Garbage collection in Java : 

##### Generational GC :

This strategy focusses on categorizing the objects by their age. The rationale behind generational garbage collection is that most objects are short-lived and will be ready for garbage collection soon after creation.

JVM heap is divided into 3 section (based on object's lifetime):
- Young generation
- Old generation
- Permanent generation

##### The Four Garbage Collectors
More here https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
1. Serial GC
**-XX:+UseSerialGC**
usage :
```
#java -Xmx12m -Xms3m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseSerialGC -jar Java2demo.jar
```
2. Prallel GC
**-XX:+UseParallelGC**
Usage :
```
java -Xmx12m -Xms3m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseParallelGC -jar Java2demo.jar
```
**-XX:+UseParallelOldGC**
Usage :
```
java -Xmx12m -Xms3m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseParallelOldGC -jar Java2demo.jar
```

3. CMS (Concurrent Mark Sweep)
To enable the CMS Collector use:
**-XX:+UseConcMarkSweepGC**
and to set the number of threads use:
**-XX:ParallelCMSThreads=`\<n>`**
Usage:
```
java -Xmx12m -Xms3m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseConcMarkSweepGC -XX:ParallelCMSThreads=2 -jar Java2demo.jar
```

4. G1 (Garbage First)
To enable the G1 Collector use:
**-XX:+UseG1GC**
Usage:
```
java -Xmx12m -Xms3m -XX:+UseG1GC -jar Java2demo.jar
```
More here : https://www.dynatrace.com/resources/ebooks/javabook/how-garbage-collection-works/
