#include "example.h"

double *get_array_leaky(const int len)
{
    double *array = new double[len];

    for (int i = 0; i < len; i++)
    {
        array[i] = (double)i;
    }

    return array;
}

void get_array_safe(const int len, double array[])
{
    for (int i = 0; i < len; i++)
    {
        array[i] = (double)i;
    }
}
