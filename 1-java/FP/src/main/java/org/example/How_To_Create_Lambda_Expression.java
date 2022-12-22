package org.example;

import java.util.function.*;
import java.util.function.Predicate;

public class How_To_Create_Lambda_Expression {

    public static void main(String[] args) {


        Supplier<String> supplier = () -> "hello";

        Predicate<String> predicate = s -> s.length() > 3;
        Consumer<String> consumer = s -> System.out.println(s);
        Function<String, Integer> function = s -> 123;
        UnaryOperator<String> unaryOperator = s -> s.toUpperCase();

        BiPredicate<String, String> biPredicate = (s1, s2) -> true;
        BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + s1);
        BiFunction<String, String, Integer> biFunction = (s1, s2) -> 123;
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1 + s2;

//
//        BiFunction<Integer,Integer,Integer> addFunction=(n1,n2)->n1+n2;
//        System.out.println(addFunction.apply(12,13));

        IntBinaryOperator intBinaryOperator = (n1, n2) -> n1 + n2;

        Joiner<String,String> joiner= (s1,s2)-> {
            return s1+s2;
        };

    }

}


interface Joiner<A,B>{
    String join(A s1, A s2);
}
