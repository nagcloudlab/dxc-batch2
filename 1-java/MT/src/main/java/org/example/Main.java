package org.example;

/*

    s/w

    task-1: read input from user & greet him
    task-2: loop numbers 1- 100


    how to create new thread in java appln?

      => create an instance of Thread class, assign work ( runnable )

      steps playing with thread

      1. create a new thread with work
      2. start the thread ( allocating stack memory )
      3. mange thread life-cycle
      4. synchronize resources

 */

import java.util.Scanner;

public class Main {

    public static void doTask1() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started IO");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name ");
        String name = scanner.nextLine();
        System.out.println("hello " + name);
        scanner.close();
        System.out.println(threadName + " ends IO");
    }

    public static void doTask2() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started Computation");
        System.out.println();
        for (int i = 1; i <= 1000000;i++) {
            System.out.println(i);
        }
        System.out.println(threadName + " ends Computation");
    }

    public static void main(String[] args) {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started Main");

        Runnable task1 = () -> {
            doTask1();
        };
        Thread ioThread = new Thread(task1, "T1");

        Runnable task2 = () -> {
            doTask2();
        };
        Thread computationThread = new Thread(task2, "T2");

        ioThread.start();
        computationThread.start();



    }
}