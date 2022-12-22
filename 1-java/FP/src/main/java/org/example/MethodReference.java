package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;


class FoodUtils {
    static List nonVegItems = List.of("biryani", "fish");

    public static boolean isNonVegItem(String item) {
        return nonVegItems.contains(item);
    }
}

public class MethodReference {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>();
        menu.add("pizza");
        menu.add("burger");
        menu.add("biryani");
        menu.add("fish");
        menu.add("fruits");


        // imperative style
//        Iterator<String> iterator = menu.iterator();

//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if (nonVegItems.contains(item)) {
//                iterator.remove();
//            }
//        }
//        System.out.println(menu);

        // declarative with LE
        menu.removeIf(FoodUtils::isNonVegItem);
        System.out.println(menu);


        Function<String,Integer> fn1=s->s.length();
        Function<String,Integer> fn2=String::length;

        System.out.println(
                fn1.apply(
                        "pizza"
                )
        );
        System.out.println(
                fn2.apply(
                        "pizza"
                )
        );

        Supplier<String> getEmptyString=String::new;

    }
}
