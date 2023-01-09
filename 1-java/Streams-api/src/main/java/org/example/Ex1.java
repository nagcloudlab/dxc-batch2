package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8,9,10);

        System.out.println(
           integers
                   .stream()
                   .filter(i->i%2!=0)
                   .collect(Collectors.toList())
        );
        System.out.println(
           integers
                  .stream()
                   .filter(i->i%2==0)
                   .collect(Collectors.toList())
        );


    }



}
