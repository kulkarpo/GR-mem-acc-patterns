#!/usr/bin/env python2
from multiprocessing import Process
import thread
import time

"""
Script inspired by Kevin Lu's analysis of Python GC.
"""

class ClassA():
    def __init__(self):
        print 'object born, id:%s'%str(hex(id(self)))

    def __del__(self):
        print 'object del, id:%s'%str(hex(id(self)))

def do_evil():
    while True:
        c1 = ClassA()
        c2 = ClassA()
        c3 = ClassA()
        c4 = ClassA()
        c5 = ClassA()
        c6 = ClassA()
        c7 = ClassA()
        c8 = ClassA()
        c1.t = c2
        c1.t2 = c3
        c1.t3 = c4
        c1.t4 = c5
        c1.t5 = c6
        c1.t6 = c7
        c1.t8 = c8
        c2.t = c1
        c2.t2 = c3
        c2.t3 = c4
        c2.t4 = c5
        c2.t5 = c6
        c2.t6 = c7
        c2.t7 = c8
        c3.t = c1
        c3.t2 = c2
        c3.t3 = c4
        c3.t4 = c5
        c3.t5 = c6
        c3.t6 = c7
        c3.t7 = c8
        c4.t = c1
        c4.t2 = c2
        c4.t3 = c3
        c4.t4 = c5
        c4.t5 = c6
        c4.t6 = c7
        c4.t7 = c8
        c5.t1 = c1
        c5.t2 = c2
        c5.t3 = c3
        c5.t4 = c4
        c5.t5 = c6
        c5.t6 = c7
        c5.t7 = c8
        c6.t1 = c1
        c6.t2 = c2
        c6.t3 = c3
        c6.t4 = c4
        c6.t5 = c5
        c6.t6 = c7
        c6.t7 = c8
        c7.t1 = c1
        c7.t2 = c2
        c7.t3 = c3
        c7.t4 = c4
        c7.t5 = c5
        c7.t6 = c6
        c7.t7 = c8
        c8.t1 = c1
        c8.t2 = c2
        c8.t3 = c3
        c8.t4 = c4
        c8.t5 = c5
        c8.t6 = c6
        c8.t7 = c7
        del c1
        del c2
        del c3
        del c4
        del c5
        del c6
        del c7
        del c8


def midd_stager():
    while True:
        try:
            thread.start_new_thread(do_evil)
        except:
            do_evil()

def multi_evil():
    while True:
        try:
            thread.start_new_thread(midd_stager)
        except:
            midd_stager()  # do directly



def fork_evil():
    p = Process(target=multi_evil)
    p.start()


def main():
    while True:
        fork_evil()


if __name__ == "__main__":
    main()

