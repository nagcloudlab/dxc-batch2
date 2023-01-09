package com.example;


import java.util.function.*;

public class How_To_Create_Function {
    public static void main(String[] args) {


        Predicate<String> predicate = s -> s.isEmpty();
        Consumer<String> consumer = s -> System.out.println(s);
        Supplier<String> supplier = () -> "hello";
        Function<String, Integer> function = s -> 123;
        UnaryOperator<String> unaryOperator = s -> s;

        BiPredicate<String, Integer> biPredicate = (s, i) -> s.length() > i;
        BiConsumer<String, String> biConsumer = (s1, s2) -> {
        };
        BiFunction<Integer, Integer, Integer> biFunction = (n1, n2) -> n1 + n2;
        BinaryOperator<Integer> binaryOperator = (n1, n2) -> n1 + n2;

        //------------------------------------------------------------------------


        BiFunction<Integer, Integer, Integer> add1 = (n1, n2) -> n1 + n2;
        System.out.println(
                add1.apply(12,13)
        );

        IntBinaryOperator add2=(n1,n2)->n1+n2;
        System.out.println(
                add2.applyAsInt(12,13)
        );

        //------------------------------------------------------------------------


    }
}
