package org.example;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LazyComputation {

    public static void main(String[] args) {

        System.out.println(
            getHash("hello","world")
        );

    }

    private static long getHash(String s1, String s2) {
        Objects.requireNonNull(s1, ()->"LOG + " + getSystemStatus());
        Objects.requireNonNull(s2,()-> "LOG + " + getSystemStatus());
        return s1.hashCode() ^ s2.hashCode();
    }


    private static String getSystemStatus() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SYSTEM-STATUS";
    }


}
