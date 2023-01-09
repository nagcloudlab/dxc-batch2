package org.example;

/*
 *
 *  step-1  : create stream for any data source ( array, colln )
 *  step-2  : compose 1 or more intermediate operations  ( using  LE or ME )
 *  step-3  : call terminal method to collect result
 *
 */


import java.util.Arrays;
import java.util.stream.Stream;

public class How_To_Work_Streams_Api {

    public static void main(String[] args) {

        // create stream for any data source ( array, colln, IO, result-set)
        String[] names = new String[] {"John", "Paul", "George", "Ringo"};

        Arrays
                .stream(names)
                .parallel()
                .filter(n-> n.length()>=5)
                .map(String::toUpperCase)
                .limit(1000)
                .forEach(System.out::println);


    }

}
