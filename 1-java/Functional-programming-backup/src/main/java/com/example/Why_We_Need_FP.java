package com.example;

import com.example.model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/*

    why we need functional programming ?

    reason1: to write compact / concise code
    reason2: with function composition, can build complex algorithms with small functions
    reason3: for Lazy computation
    reason4: for better concurrent/parallel application ( later )

 */

public class Why_We_Need_FP {
    public static void main(String[] args) {

        List<Apple> inventory = List.of(
                new Apple(100, "red"),
                new Apple(120, "green"),
                new Apple(150, "red"));

        //A. Local Inner class
//        class GreenApplesPredicate implements Predicate {
//            public boolean test(Apple apple) {
//                return apple.getColor().equals("green");
//            }
//        }
//        B. Anonymous Inner class
//        Predicate greenApplesPredicate = new Predicate() {
//            public boolean test(Apple apple) {
//                return apple.getColor().equals("green");
//            }
//        };

//        C. Labmda Expression a.k.a function

        System.out.println(
                filterApples(inventory, apple -> apple.getColor().equals("green"))
        );
        System.out.println(
                filterApples(inventory, apple -> apple.getColor().equals("red"))
        );
        System.out.println(
                filterApples(inventory, apple -> apple.getWeight() == 150)
        );


    }

    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> filtered = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                filtered.add(apple);
            }
        }
        return filtered;
    }


}
