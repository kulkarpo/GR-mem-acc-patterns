import example


def leaky_function(length):
    array = example.get_array_leaky(length)


def safe_function(length):
    array = example.get_array_safe(length)


if __name__ == '__main__':
    length = 1000
    while True:
        print("Leaking ....")
        leaky_function(length)
        #safe_function(length)
