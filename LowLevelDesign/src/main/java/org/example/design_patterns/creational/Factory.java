package org.example.design_patterns.creational;

interface Vehicle {
    void start();
    int getNumWheels();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car Started");
    }
    public int getNumWheels() {
        return 4;
    }
}

class Truck implements Vehicle {
    public void start() {
        System.out.println("Truck Started");
    }
    public int getNumWheels() {
        return 8;
    }
}

interface VehicleFactory {
    Vehicle createVehicle();
}

class CarFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Car();
    }
}

class TruckFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Truck();
    }
}


public class Factory {
    public static void main(String[] args) {
        VehicleFactory vf = new CarFactory();
        vf.createVehicle().start();

        vf = new TruckFactory();
        vf.createVehicle().start();
    }
}
