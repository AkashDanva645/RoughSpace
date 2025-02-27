package DesignPatterns.Creational.FactoryMethod;


interface Transport {
    public void deliver();
}

abstract class Logistics {
    Transport createTransport() {
        return new Truck();
    };
}

class Truck implements Transport {
    Truck () {
    }

    public void deliver() {
        // do something
    }
}

class Ship implements Transport {
    Ship() {
    }

    public void deliver() {
        // do something
    }
}

class RoadLogistics extends Logistics {
    @Override
    Transport createTransport() {
        return new Truck();
    }
}

class SeaLogistics extends Logistics {
    @Override
    Transport createTransport() {
        return new Ship();
    }
}

class FactoryMethod {

    private static Logistics logistics;

    // Application
    public static void main(String[] args) {
        logistics = new SeaLogistics();
        Transport t = logistics.createTransport();
        System.out.println(t.getClass());
    }
}
