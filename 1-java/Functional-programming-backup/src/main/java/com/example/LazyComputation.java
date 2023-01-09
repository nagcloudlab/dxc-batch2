package com.example;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LazyComputation {

    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = null;

        long code = getHash(s1, s2);
        System.out.println(code);

    }

    private static long getHash(String s1, String s2) {
        Objects.requireNonNull(s1, () -> getSystemStatus());
        Objects.requireNonNull(s2, () -> getSystemStatus());
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
