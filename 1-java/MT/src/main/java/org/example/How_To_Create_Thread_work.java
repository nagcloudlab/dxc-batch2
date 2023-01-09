package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Work implements Runnable {
    @Override
    public void run() {
        System.out.println("work...");
    }
}

//class WorkThread extends Thread{
//    @Override
//    public void run() {
//        System.out.println("other work...");
//    }
//}

public class How_To_Create_Thread_work {
    public static void main(String[] args) {

        Work w = new Work();
        Thread t = new Thread(w);
        t.start();

//
//        WorkThread wt = new WorkThread();
//        wt.start();
//
//        Thread thread=new Thread(wt);
//        thread.start();

        // Java 1.5 : Executor Framework
        ExecutorService executorService = Executors.newSingleThreadExecutor(); // thread pool
        executorService.submit(w);


    }
}
