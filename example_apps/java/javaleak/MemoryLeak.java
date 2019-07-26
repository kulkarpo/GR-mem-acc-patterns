import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MemoryLeak {
    public final long[] data;

    public MemoryLeak() {
        this.data = new long[4096];
    }

    public static void main(String args[]) {
        try {
            Map map = System.getProperties();

            for(;;) {
                map.put(new MemoryLeak(), "");
                TimeUnit.MILLISECONDS.sleep(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

