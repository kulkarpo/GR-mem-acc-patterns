# java-memory-leak-demo
Example project with a few memory leaks and cpu performance problems that can be found with a profiler (like Yourkit)

The actual leaks are describe in problems.md.  Please do not look there until you think you have solved everything.

## Application overview
This test application is meant to mirror a somewhat normal web service that serves as an in memory cache
of an event stream.  Messages come in, and the values within the cache are updated.  There are two components
to the app
### Web service
This can be started with
```
./gradlew run
```
### Load generator
The unit test creates fake load and calls the web service.  This can be started by calling
```
./gradlew test
```


## Suggested testing procedure
### Generate heap dump
The normal case for memory problems is that you only have a heap dump, you cannot attach a live profiler to your
production code.  If you run the application with gradle, it has been configured to generate a heap dump on 
OutOfMemoryError.  After running the app and test for about 3-5 minutes, you will start to see 
`java.lang.OutOfMemoryError: Java heap space` errors in the application logs, and you should see a heap dump file
in the root directory with a name similar to java_pid16163.hprof.

### Live profiling
Sometimes, it is significantly easier to troubleshoot with a live view.  To do this, start the application but do
not start the test.  Then, from the profiler ui, attach your profiler to the pid of the running application.  Be
careful not to attach to the gradle process.  The process should have a name called App.  After successfully 
attaching, start the test.