package org.example;


public class WaitNotify {


    static Object lock = new Object();
    static volatile boolean isEven = true;


    public static void main(String[] args) {

        Runnable oddNumTask = () -> {
            int i = 0;
            while (i < 100) {
                if (i % 2 != 0) {
                    synchronized (lock) {
                        try {
                            if (isEven) {
                                lock.wait();
                            }
                            System.out.println(i);
                            isEven=true;
                            lock.notify();
                            Thread.sleep(3000);

                        } catch (Exception e) {
                        }
                    }
                }
                i++;
            }
        };
        Runnable evenNumTask = () -> {
            int i = 0;
            while (i < 100) {
                if (i % 2 == 0) {
                    try {
                        synchronized (lock){
                            if(!isEven){
                                lock.wait();
                            }
                            System.out.println(i);
                            isEven=false;
                            lock.notify();
                            Thread.sleep(5000);
                        }
                    } catch (Exception e) {
                    }
                }
                i++;
            }
        };

        Thread oddNumGenThread = new Thread(oddNumTask);
        Thread evenNumGenThread = new Thread(evenNumTask);

        oddNumGenThread.start();
        evenNumGenThread.start();

    }
}
