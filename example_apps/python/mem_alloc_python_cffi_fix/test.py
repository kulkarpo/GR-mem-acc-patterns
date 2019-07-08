import example
import time


def leaky_function(length):
    array = example.get_array_leaky(length)

def safe_function(length):
    array = example.get_array_safe(length)


if __name__ == '__main__':
    length = 10000
    while True:
        time.sleep(0.1)
        print("Leaking ....but will be garbage collected! _\../")
        #leaky_function(length)
        safe_function(length)
