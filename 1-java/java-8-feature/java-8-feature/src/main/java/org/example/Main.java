package org.example;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person();
        person1.name = "Nag";
        person1.age = 40;

        Car car = new Car();
        car.make = "Toyota";
        car.model = "Prius";

        Insurance insurance = new Insurance();
        insurance.type = "GOLD";

        car.insurance = Optional.of(insurance);
        person1.car = Optional.of(car);

        //----------------------------------------------------

        String p1CarInsType =
                person1.car
                        .flatMap(c->c.insurance)
                        .map(i->i.type)
                       .orElse("No Car/Insurance");

        System.out.println(p1CarInsType);

        //----------------------------------------------------


        Person person2=new Person();

        String p2CarInsType =
                person2.car
                        .flatMap(c->c.insurance)
                        .map(i->i.type)
                        .orElse("No Car/Insurance");

        System.out.println(p2CarInsType);

        System.out.println(person2.car.get());


        //----------------------------------------------------

    }
}