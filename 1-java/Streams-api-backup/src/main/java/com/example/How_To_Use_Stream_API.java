package com.example;

import java.util.List;
import java.util.stream.Stream;

public class How_To_Use_Stream_API {

    public static void main(String[] args) {

        // 3 steps to work stream api

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


//        // step-1: create stream from any data-source ( array, collection, sql-resultset , compute .. )
//        Stream<Integer> stream = integers.stream();
//
//        // step-2: compose with 1 or many intermediate operations ( e.g filter,transforming,sort ... )
//        stream=stream
//                .filter(n -> {
//                    return n % 2 == 0;
//                })
//                .map(n -> n * n)
//                .filter(n -> n > 50);
//
//        //step-3: call terminal-operation to collect result
//        stream
//                .forEach(n -> {
//                    System.out.println(n);
//                });


        integers
                .stream()
                .filter(n->n%2==0)
                .map(n->n*n)
                .filter(n->n>50)
                .forEach(System.out::println);



    }

}
