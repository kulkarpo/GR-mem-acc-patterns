package io.arunasujith;

public class MemoryLeakMain {

    public MemoryConsumingObject head;
    public int objectCount;

    public MemoryLeakMain() {
        head = new MemoryConsumingObject();
        objectCount = 0;
    }

    public boolean addMemoryConsumingObject() {
        MemoryConsumingObject end = new MemoryConsumingObject();
        MemoryConsumingObject current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
        objectCount++;
        System.out.println("Added a new reference..");
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        MemoryLeakMain main = new MemoryLeakMain();

        while (true) {
            main.addMemoryConsumingObject();
            Thread.sleep(3000);
        }

//        while (true) {
//            new MemoryConsumingObject();
//            Thread.sleep(3000);
//        }


    }
}
