https://github.com/ember-best-practices/memory-leak-examples
https://github.com/bmancini55/node-memory-usage
https://github.com/iwanaga/node-gc-test

#### Garbage Collection in javascript
1. Reference-counting garbage collection
2. Mark-and-sweep algorithm

##### Reference-counting GC
When there is no reference to an object then it will be automatically garbage collected. zero referencing object as an object that is no longer used by the application.
###### Example of memory leaks uncaught by reference-counting GC:
- Cyclic references
```
var o = { a: { b: 2 } }; o = 1;
function func() {
var o = {};
var o2 = {};
o.a = o2;
o2.a = o;
return 'true';
}
func();
```
In this code snippet, when func() finishes executing, o and o2 being local objects, are no longer needed. But even when execution moves out of the function, both of the useless objects continue  to hold references to each other making it seem like needed objects. Thus the garbage collector will not be able to release the memory held by the objects o and o2.

##### Mark-and-sweep algorithm
This algorithm will free the memory when an object is unreachable rather than zero referencing object. cycle limitation will be solved by this algorithm. From the above example, when the execution is moved outside o and o2 objects are marked unreachable thus releasing the memory held by the objects.

#### Garbage Collection in nodejs
Refer the following :
http://jayconrod.com/posts/55/a-tour-of-v8--garbage-collection
https://blog.codeship.com/understanding-garbage-collection-in-node-js/

