package com.example;

import com.model.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*

    It enables to process collection of items in declarative style using Lambda-Expressions.

 */

public class Stream_Api_Intro {

    public static void main(String[] args) {


        List<Dish> menu = Dish.menu;
        System.out.println(
                getLowCaloricDishNamesV2(menu)
        );


    }

    private static List<String> getLowCaloricDishNamesV1(List<Dish> menu) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400)
                lowCaloricDishes.add(dish);
        }
        Collections.sort(lowCaloricDishes, (d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()));
        List<String> lowCaloricDishNames = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishNames.add(dish.getName());
        }
        return lowCaloricDishNames;
    }

    private static List<String> getLowCaloricDishNamesV2(List<Dish> menu) {
        return menu
                .stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

}
