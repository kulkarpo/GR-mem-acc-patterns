import java.util.ArrayList;
import java.util.List;

public class JavaStaticMemberLeak {

    private static final int SIZE = 1024 * 1024;

    public static void main (String[] args) throws InterruptedException {
	while(true){
            for (int i = 0; i < 10; i++) {
		System.out.println ("" + i + ". Allocating memory : leaking...");
                ContentHolder.HOLDER.add(new byte[SIZE]);
                Thread.sleep(1000L);
	    }
	    // GC will not be able to claim the static member
	    System.out.println ("force garbage collection, to avoid leaking..");
            System.gc();
            Thread.sleep(1000L);
        }

        // observe this in visual vm
        //while (true) {
           // System.gc();
            //Thread.sleep(1000L);
        //}
    }

}

class ContentHolder {

    public static final List<byte[]> HOLDER = new ArrayList<>();
}



