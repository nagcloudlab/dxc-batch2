package org.example;

class NewCounter {

    private long count = 0;

    public void increment() {
        count++;
    }

    public long getCount() {
        return count;
    }


}

public class Volatile {
    public static void main(String[] args) throws InterruptedException {

        NewCounter counter = new NewCounter(); // this in heap

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        // 1000 * 1000 = 1000000
        System.out.println(counter.getCount());

    }

}
