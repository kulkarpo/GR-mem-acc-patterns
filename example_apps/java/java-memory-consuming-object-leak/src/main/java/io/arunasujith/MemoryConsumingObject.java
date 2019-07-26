package io.arunasujith;

public class MemoryConsumingObject {

    MemoryConsumingObject next;
    int[] data = new int[1024 * 1024]; // ~ 4 MB


    public MemoryConsumingObject() {
        System.out.println("Initializing...");
        this.next = next;
    }

    public MemoryConsumingObject getNext() {
        return next;
    }

}
