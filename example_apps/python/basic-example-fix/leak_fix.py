import random

def leak():
    dataList = [];
    while True:
        dataList.append(1337L);
        print("Appending to list...")

        if len(dataList) < 20:
            del dataList[0]
            print("deleting from list (de-reference-ing)...")
leak()
