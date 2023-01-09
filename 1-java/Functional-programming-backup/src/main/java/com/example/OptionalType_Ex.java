package com.example;


import com.example.model.Car;
import com.example.model.Insurance;
import com.example.model.Person;

import java.util.Optional;

public class OptionalType_Ex {
    public static void main(String[] args) {

        Insurance insurance = new Insurance();
        insurance.name = "XYZ insurance";
        Car car = new Car();
        car.insurance = Optional.of(insurance);
        Person person = new Person();
        person.car = Optional.of(car);

        System.out.println(
                person.car
                        .flatMap(c -> c.insurance)
                        .map(i -> i.name)
                        .orElse("Nil")
        );

        //--------------------------------------------

        Person person2 = new Person();

        System.out.println(
                person2.car
                        .flatMap(c -> c.insurance)
                        .map(i -> i.name)
                        .orElse("Nil")
        );


        //--------------------------------------------------
    }
}
