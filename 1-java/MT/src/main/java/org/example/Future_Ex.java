package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Future_Ex {
    public static void main(String[] args) {

        Callable<String> callableTask = () -> {
            System.out.println(Thread.currentThread().getName() + " executing callable task");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            if (1 == 1)
                throw new IllegalStateException("oops");
            return "hello";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        java.util.concurrent.Future<String> future = executorService.submit(callableTask);
        //..
        //..
        try {
            String result = future.get();
            System.out.println("Main Thread received result : " + result);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("Main Thread Received exception :" + e.getMessage());
        }


    }
}
