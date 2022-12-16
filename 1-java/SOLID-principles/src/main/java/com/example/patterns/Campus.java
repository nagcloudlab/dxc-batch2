package com.example.patterns;


class Security {
    public void doSec() {
        System.out.println("do sec check");
    }
}

/**
 * design issues
 * <p>
 * - code tangling / tight-coupling
 * - code scattering / duplication
 */

class Building1 {
//    Security security=new Security();

    public void getIntoRoom1() {
//        security.doSec(); // security concern
        System.out.println("employee working in room-1 building-1"); // real business logic
    }

    public void getIntoRoom2() {
//        security.doSec(); // security concern
        System.out.println("employee working in room-2 building-1");
    }
}

class Building1Proxy {

    Building1 building1 = new Building1();

    Security security = new Security();

    public void getIntoRoom1() {
        security.doSec(); // security concern
        building1.getIntoRoom1();
    }

    public void getIntoRoom2() {
        security.doSec(); // security concern
        building1.getIntoRoom2();
    }

}


// Proxy Pattern
public class Campus {

    public static void main(String[] args) {

        Building1Proxy building1 = new Building1Proxy();
        building1.getIntoRoom1();
        building1.getIntoRoom2();

    }

}
