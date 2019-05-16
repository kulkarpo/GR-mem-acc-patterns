package wasdev.sample.servlet;

import java.util.LinkedList;
import java.util.List;

class MemoryLeak {
    public static int SIZE = 100000;

    public void run() {
	List<Byte[]> list = new LinkedList<Byte[]> ();
	int counter = 0;

	while (true) {
	    counter++;
	    System.out.println ("" + counter + ". Allocating memory...");
	    list.add (new Byte[SIZE]);
	}
    }
}