package com.example.patterns;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class DoorEvent{
    int doorNumber;
    int floorNumber;
    DoorEvent(int doorNumber, int floorNumber){
        this.doorNumber = doorNumber;
        this.floorNumber = floorNumber;
    }
}
interface DoorListener{
    void on(DoorEvent event);
    void off(DoorEvent event);
}

class Light implements DoorListener{
    public void on(DoorEvent event) {
        System.out.println("Light is on");
    }
    public void off(DoorEvent event) {
        System.out.println("Light is off");
    }
}

class Fan implements DoorListener{
    public void on(DoorEvent event) {
        System.out.println("Fan is on");
    }
    public void off(DoorEvent event) {
        System.out.println("Fan is off");
    }
}


// Subject
class Door {

    private List<DoorListener> doorListeners=new ArrayList<>();

    public  void addDoorListener(DoorListener doorListener){
        doorListeners.add(doorListener);
    }
    public void removeDoorListener(DoorListener doorListener){
        doorListeners.remove(doorListener);
    }

    public void open() {
        System.out.println("Door opened");
        DoorEvent doorEvent=new DoorEvent(1,1);
        for(DoorListener doorListener:doorListeners){
            doorListener.on(doorEvent);
        }
    }

    public void close() {
        System.out.println("Door closed");
        DoorEvent doorEvent=new DoorEvent(1,1);
        for(DoorListener doorListener:doorListeners){
            doorListener.off(doorEvent);
        }
    }
}

// Observer / Listener pattern
public class ModernRoom {
    public static void main(String[] args) throws InterruptedException {

        Door door = new Door();

        Light light=new Light();
        door.addDoorListener(light);
        door.removeDoorListener(light);
        door.addDoorListener(new Fan());

        TimeUnit.SECONDS.sleep(2);
        door.open();
        TimeUnit.SECONDS.sleep(2);
        door.close();



    }
}
