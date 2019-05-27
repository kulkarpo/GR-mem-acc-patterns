# Sampling Heap Profiler

[![style badge][gts-image]][gts-url]
[![Build Status][travis-image]][travis-url]

**EXPERIMENTAL**

This module adds supports for the experimental Sampling Heap Profiler in V8.
This works by taking a random sample of objects, as they are allocated, to keep
a statistical sample of what is live in the heap at any given time. This also
keeps track of the stack that allocated a given sampled object. This means that
you know not only what is live, but what code path allocated it. This is
motivated by, and functions similarly to, the heap profiler built into tcmalloc.

* This is supposed to be lightweight enough for in-production use on servers.
* The generated snapshots can be saved offline, and be opened in DevTools later.

![app.get seems to be leaking](doc/devtools-allocation-profile.png)

## Usage

```javascript
const heapProfile = require('heap-profile');

heapProfile.start();

// Write a snapshot to disk every hour
setInterval(() => {
  heapProfile.write((err, filename) => {
    console.log(`heapProfile.write. err: ${err} filename: ${filename}`);
  });
}, 60 * 60 * 1000).unref();
```

### start()

Starts sampling. You probably want to call this as close to the program startup
as possible.

### get()

Returns the profile composed of a tree of nodes.

### write([filename], cb)

Writes the current heap sample to a file. If the filename parameter is omitted,
a default pattern of `heap-profile-${Date.now()}.heapprofile`.

The callback returns error if profiling was not active at the time of call.
Otherwise the name of the file is returned via the callback.

### stop()

Stops sampling and discard the current set of tracked sampled objects. You can
call `start` again to start sampling again, but any objects allocated before
`start` is called cannot be sampled, which means that the profile will not
be representative of the state of the heap.

The sampling overhead is low enough that you probably don't need to use `stop`.


[gts-image]: https://img.shields.io/badge/code%20style-Google-blue.svg
[gts-url]: https://www.npmjs.com/package/gts
[travis-image]: https://travis-ci.org/v8/sampling-heap-profiler.svg?branch=master
[travis-url]: https://travis-ci.org/v8/sampling-heap-profiler
