import java.util.LinkedList;
import java.util.List;

class MemoryLeakFix {
    //public static int DEFAULT_SIZE = 10000000; // 10 MB
    public static int DEFAULT_SIZE = 1000000; // 1 MB

    public static void main (String[] args) {
		List<Byte[]> list = new LinkedList<Byte[]> ();
		int counter = 0;

		String sizeStr = System.getenv("MEM_SIZE");
		System.out.println ("Size: " + sizeStr);
		int size;
		if (sizeStr == null || "".equals(sizeStr)) {
			size = DEFAULT_SIZE;
		} else {
			size = Integer.parseInt (sizeStr);
		}

		System.out.println ("Allocating " + size + " every time");

		while (true) {
	    	    counter++;
	    	    System.out.println ("" + counter + ". Allocating memory...");
	    	    list.add (new Byte[size]);
	    	    try {
		    	Thread.sleep (300000);
		    } 
		    catch (InterruptedException e) {
                    
		    }
		    if (counter > 20) {
	    	        System.out.println ("" + counter + ". de-referencing  memory (list remove)...");
		        list.remove(0); 
		    }
		}
    }
}
