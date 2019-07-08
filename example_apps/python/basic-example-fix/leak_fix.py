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

        if len(dataList) < 20:
            del dataList[0]
            print("deleting from list (de-reference-ing)...")

leak()
