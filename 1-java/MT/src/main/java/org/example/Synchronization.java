package org.example;


class House {

    private final static Object lock=new Object();

    public void room1() throws InterruptedException {
        synchronized (lock){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is in the room1");
            Thread.sleep(100000); // IO or Computation
            System.out.println(threadName + " is out the room1");
        }
    }

    public void room2() throws InterruptedException {
        synchronized (lock){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is in the room2");
            Thread.sleep(3000);
            System.out.println(threadName + " is out the room2");
        }
    }
}

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {

        House house1 = new House();
        House house2 = new House();


        Runnable task1 = () -> {
            try {
                house1.room1();
            } catch (Exception e) {
            }
        };
        Runnable task2 = () -> {
            try {
                house2.room1();
            } catch (Exception e) {
            }
        };

        Thread thread1 = new Thread(task1, "foo");
        Thread thread2 = new Thread(task2, "bar");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }
}
