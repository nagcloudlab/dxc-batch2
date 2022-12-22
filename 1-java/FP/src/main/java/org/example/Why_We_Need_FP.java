package org.example;

import org.example.model.Apple;

import java.util.ArrayList;
import java.util.List;

public class Why_We_Need_FP {

    public static void main(String[] args) {

        List<Apple> inventory = List.of(
                new Apple(100, "red"),
                new Apple(120, "green"),
                new Apple(150, "red")
        );

        System.out.println(
                 filterApples(inventory, apple-> apple.getColor().equals("green"))
        );
        System.out.println(
                filterApples(inventory, apple-> apple.getColor().equals("red"))
        );
        System.out.println(
                filterApples(inventory, apple-> apple.getWeight()>=150)
        );
    }

    private static List<Apple> filterApples(List<Apple> inventory, Predicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}

interface Predicate{
    boolean test(Apple apple);
}


