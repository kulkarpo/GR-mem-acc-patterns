import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class JavaWeakReferenceLeak {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<Serializable> reference = new WeakReference<Serializable>(new Serializable() {
            {
                List<byte[]> array = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(200L);
                    array.add(new byte[1024 * 1024]);
                }
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        int count = 15;
        while (count-- > 0) {
            System.out.println(count);
            Thread.sleep(500L);
        }

        // trigger gc in visual vm
        while (true) {
            Thread.sleep(1000L);
	    if(reference.get() != null) {
                System.out.println("Weak reference still alive after GC");
	    }
        }

    }
}

