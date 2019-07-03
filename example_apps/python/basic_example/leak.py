import random
import time 

def leak():
    dataList = [];
    while True:
        dataList.append(1337L);
        time.sleep(300)

leak()
