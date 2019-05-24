## Source : https://github.com/bast/cffi-mem-alloc-example

# Client-side or library-side memory allocation with [Python CFFI](https://cffi.readthedocs.io)?

Client side is more general but we also wish a Pythonic API.
Check out [test.py](https://github.com/kulkarpo/GR-mem-acc-patterns/tree/master/example_apps/python/mem_alloc_python_cffi/test.py).


###### Dockerfile - unexpected errors debugging, 
runs locally with expected results - img/memeory_usage.jpg

![](https://github.com/kulkarpo/GR-mem-acc-patterns/blob/master/example_apps/python/mem_alloc_python_cffi/img/memory_usage.jpg "memory explosion seen from activity manager")

## How to build and run the example

```
mkdir build
cd build
cmake ..
make
cd ..
virtualenv venv
source venv/bin/activate
pip install -r requirements.txt
EXAMPLE_BUILD_DIR=build python test.py
```
