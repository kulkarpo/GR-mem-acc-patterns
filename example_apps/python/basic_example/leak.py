import random
import time
import sys

def leak():
    dataList = [];
    while True:
        #dataList.append(1337L)
        print(len(dataList))
        dataList.append(' ' * 10**6)
        time.sleep(180)
leak()
