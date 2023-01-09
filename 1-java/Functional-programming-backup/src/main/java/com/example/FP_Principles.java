package com.example;

/*

FP principles

        - A function can be stored in a variable
        - A parameter of a function can be a function
        - The return value of a function can be a function


 */

import com.example.model.Apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class FP_Principles {

    // Higher-Order-Function  ==> function-composition
    public static Predicate<Integer> and(Predicate<Integer> f1, Predicate<Integer> f2) {
        return n -> {
            return f1.test(n) && f2.test(n);
        };
    }

    public static void main(String[] args) {

        Predicate<Integer> isMin = n -> n > 100;
        Predicate<Integer> isMax = n -> n < 1000;
        Predicate isMinAndMax = and(isMin, isMax);

        //--------------------------------------------------------------

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(160, "red"));
        inventory.add(new Apple(120, "green"));
        inventory.add(new Apple(150, "red"));

        Comparator<Apple> byColorAsc = (a1, a2) -> a1.getColor().compareTo(a2.getColor());
        // -or-
        byColorAsc=Comparator.comparing(Apple::getColor);
        Comparator<Apple> byWeightAsc = (a1, a2) -> Integer.compare(a1.getWeight(), a2.getWeight());
        // -or-
        byWeightAsc=Comparator.comparing(Apple::getWeight);
        Comparator<Apple> byColorAndWeightAsc = byColorAsc.thenComparing(byWeightAsc);


        Collections.sort(inventory, byColorAndWeightAsc);


        inventory
                .forEach(apple -> {
                    System.out.println(apple);
                });

        //-----------------------------------------------------------------------------------------------

    }
}
