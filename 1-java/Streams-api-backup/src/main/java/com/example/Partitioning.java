package com.example;

import com.model.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Partitioning {
    private static List<Dish> menu = Dish.menu;

    public static void main(String[] args) {


        Map<Boolean, List<Dish>> result1 =
                menu
                        .stream()
                        .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(result1);

        Map<Boolean, Map<Dish.Type, List<Dish>>> result2 =
                menu
                        .stream()
                        .collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println(result2);

        Map<Boolean, Object> result3 =
                menu
                        .stream()
                        .collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println(result3);

    }
}
