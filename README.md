# GR-mem-acc-patterns
Guided research module : Identification and Analysis of memory access patterns in virtual infrastructure and cloud application
## Initial Reading
1.  "Understanding Object-level Memory Access Patterns Across the Spectrum" - https://dl.acm.org/citation.cfm?id=3126917
2.  "Performance Analysis of High Performance Computing Applications on the Amazon Web Services Cloud" - https://opac-ub-tum-de.eaccess.ub.tum.de/TouchPoint/singleHit.do?methodToCall=showHit&curPos=1&identifier=5_PRIMO_RESULTSET_259246941



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
3. Application build and run steps, docker images for docker applications - ** New **



