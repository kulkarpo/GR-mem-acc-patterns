import random
import time

def leak():
    dataList = [];
    while True:
        dataList.append(1337L);
        print("Appending to list...")
        time.sleep(300)

        if len(dataList) < 20:
            del dataList[0]
            print("deleting from list (de-reference-ing)...")
leak()
