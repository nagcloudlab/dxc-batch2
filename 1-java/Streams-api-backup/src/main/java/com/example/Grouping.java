package com.example;

import com.model.Dish;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Grouping {

    private static List<Dish> menu = Dish.menu;

    enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {

        Map<Dish.Type, List<Dish>> result1 =
                menu
                        .stream()
                        .collect(groupingBy(Dish::getType));
        System.out.println(result1);


        Map<CaloricLevel, List<Dish>> result2 =
                menu
                        .stream()
                        .collect(groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }));

        System.out.println(result2);

        Map<Dish.Type, Long> result4 =
                menu
                        .stream()
                        .collect(groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(result4);

        Map<Dish.Type, Integer> result5 =
                menu.stream()
                        .collect(groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
        System.out.println(result5);

        Map<Dish.Type, Set<CaloricLevel>> result6 =
                menu
                        .stream()
                        .collect(groupingBy(Dish::getType, Collectors.mapping(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                }, Collectors.toSet()
                        )));

        System.out.println(result6);


    }
}
