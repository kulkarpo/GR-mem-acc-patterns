# Memory leaks:
## Hashmap key without equals() and hashCode()
  Problem: they key in a hashmap does not implement equals() or hashCode()
  Class: DeviceId
  How to discover it:  Biggest objects - Dominators shows the hashmap within the DeviceMessageDB 
  uses 93% of the memory

# False memory leaks:
These may look like a memory leak, but they mirror actual scenarios you see in production code
## Lots of strings
  Each message contains many strings, and these messages are persisted in hash maps, etc.


# Cpu performance problems:
## Expensive hashCode 
  Problem: An expensive hashcode is defined for something used as a key in a HashMap
  Class: GuidAndName
  How to discover it: Cpu profiling.  Go to "method list", sort by self time, and look for methods from our code
  (com.github.rmelick)
  
# False cpu performance problems:
## Jackson deserialization
  We need to deserialize messages as they come in.  We cannot escape the cpu usage of jackson.
  
# Suggestions that could be added
## Memory leaks
### Database connections not closed
  Problem: The connection should be closed in the exception handler
  Class: DeviceDB
  How to discover it: Look for h2 related things in the memory usage graph