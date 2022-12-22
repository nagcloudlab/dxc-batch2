package org.example;


/*

        FP principles

        - A function can be stored in a variable
        - A parameter of a function can be a function
        - The return value of a function can be a function

        ----------------------------------------------------------------

        design issues

        - code tangling / tight-coupling
        - code scattering / duplicating

         solution:

          at object level - we can use 'proxy' design pattern
          at function level - we can use 'hof'( higher-order function ) design pattern

       ----------------------------------------------------------------

 */


import org.example.model.Apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class FP_Principles {

    // HOF ==> composing multiple function into one, return one complex function
    public static Consumer<String> withSmileEmoji(Consumer<String> consumer) {
        return s -> {
            consumer.accept(s); // function composition
            System.out.println("\uD83D\uDE0A");
        };
    }

    public static void main(String[] args) {

        Consumer<String> hiFunction = name -> {
            System.out.println("hi " + name);

        };
        Consumer<String> helloFunction = name -> {
            System.out.println("hello " + name);
        };


//        hiFunction.accept("Bob");
//        withSmileEmoji(hiFunction).accept("Alice");

        //----------------------------------------------------------------

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(160, "red"));
        inventory.add(new Apple(120, "green"));
        inventory.add(new Apple(150, "red"));

        Comparator<Apple> byColorAsc=(a1,a2)->a1.getColor().compareTo(a2.getColor());
//        Comparator<Apple> byColorDsc=(a1,a2)->a2.getColor().compareTo(a1.getColor());
//        Comparator byColorDsc=byColorAsc.reversed();
        Comparator<Apple> byWeightAsc=(a1,a2)->Integer.compare(a1.getWeight(),a2.getWeight());

        Comparator<Apple> byColorAndThenWeight=byColorAsc.thenComparing(byWeightAsc);

        Collections.sort(inventory,byColorAndThenWeight);

        inventory
                .forEach(apple-> System.out.println(apple));

        //----------------------------------------------------------------


    }
}
