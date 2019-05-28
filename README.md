# GR-mem-acc-patterns
Guided research module : Identification and Analysis of memory access patterns in virtual infrastructure and cloud application
## Initial Reading
1.  "Understanding Object-level Memory Access Patterns Across the Spectrum" - https://dl.acm.org/citation.cfm?id=3126917
2.  "Performance Analysis of High Performance Computing Applications on the Amazon Web Services Cloud" - https://opac-ub-tum-de.eaccess.ub.tum.de/TouchPoint/singleHit.do?methodToCall=showHit&curPos=1&identifier=5_PRIMO_RESULTSET_259246941
3. "LeakSpot: detection and diagnosis of memory leaksin JavaScript applications" https://onlinelibrary-wiley-com.eaccess.ub.tum.de/doi/epdf/10.1002/spe.2406
4. "Cork: Dynamic Memory Leak Detection for Garbage-Collected Languages" http://delivery.acm.org.eaccess.ub.tum.de/10.1145/1200000/1190224/p31-jump.pdf?ip=129.187.254.46&id=1190224&acc=ACTIVE%20SERVICE&key=2BA2C432AB83DA15%2EB4538F6A74FA55F8%2E4D4702B0C3E38B35%2E4D4702B0C3E38B35&__acm__=1559054162_b87e424763f067d29d35ff27a8dd6453
5. "Precise Memory Leak Detection for Java Software Using Container Profiling" http://delivery.acm.org.eaccess.ub.tum.de/10.1145/2500000/2491511/a17-xu.pdf?ip=129.187.254.46&id=2491511&acc=ACTIVE%20SERVICE&key=2BA2C432AB83DA15%2EB4538F6A74FA55F8%2E4D4702B0C3E38B35%2E4D4702B0C3E38B35&__acm__=1559054229_228c2737bd1ecb5a8df568a6bd049a6d
6. "BLeak: Automatically Debugging Memory Leaks in Web Applications" http://delivery.acm.org.eaccess.ub.tum.de/10.1145/3200000/3192376/pldi18main-p39-p.pdf?ip=129.187.254.46&id=3192376&acc=ACTIVE%20SERVICE&key=2BA2C432AB83DA15%2EB4538F6A74FA55F8%2E4D4702B0C3E38B35%2E4D4702B0C3E38B35&__acm__=1559054341_2b825f872ca0064daef6987c8beb936c



## Applications for the experiments -

Initial reading *paper 1* refers to some benchmark applications, could take a look at those.

### Java
#### Memeory leaking examples -
1. https://github.com/bogdangherca/memory-leaks-example/tree/master/src
2. https://github.com/rmelick/java-memory-leak-demo

### JavaScript


#### Memory leaking examples -
1. https://github.com/ufocoder/javascript.memory-leaks/tree/master/docs

### Python
1. https://github.com/thefangbear/p.py/blob/master/p.py - Dockerized
2. https://github.com/daniel-ziegler/tuple_leak
3. https://github.com/bast/cffi-mem-alloc-example

### Node js
#### Memory leaking examples -
1. https://github.com/felixge/node-memory-leak-tutorial


### C/C++
1. https://github.com/ramkumarrammohan/memory_leak_concepts


## Open Questions
* Define "application" in the current context
	* Add 2 numbers, Allocate memory in infinite loop ? <- are these "applications" in the current context?
    * How complex should the application be to see the actual behavior of a faulty application?
    * ~~Does the application need to do some complex processing also ?~~
        * ~~Because, To measure the performance of app wrt time (increasing memory)~~
    * Currently, all the example applications (faulty case) look similar (Same type of logic liek a growing list)
    * Is the initial motivation is just to see memory access/usage pattern exhibited by different programming languages?

* Garbage collecting algorithms
	*  example application for each algorithm ? same application but different algorithms ?

* What could be the other **faulty cases** ? other than memory leak ? because ultimately the topic is to be able to classify the memory access patterns - if possible that is.

* Regular - non faulty application examples?
	* Perhaps the same codes with leak fixes can be used?
	* Or perhaps some benchmark applications can be used ? again how simple/complex should an application be ?


### Activity tracking
1. Literature survey - initial reading **In progress**
2. Application Search - **In progress**
3. Application build and run steps, docker images for docker applications - **In progress**
	4. python applications (2)- dockerized
	5. nodejs application (4) - dockerized

#### Notes from Meeting on 28/05
1. Collect and run the applications from BLeak publication.
2. Run Java applications with different garbage collectors and collect the memeory and CPU utilization data.
3. Store the memory utilzation values in a db , which can be used to plot graphs later without repeatedly running them
4. Add the statement to automatically restart docker when it stops.
5. For step 3, look at docker node monitoring by Anshul here https://github.com/ansjin/docker-node-monitoring and learn to make use of it to collect the data.
6. Example application : ASP.NET 



