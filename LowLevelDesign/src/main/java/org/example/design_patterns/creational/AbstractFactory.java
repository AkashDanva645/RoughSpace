package org.example.design_patterns.creational;

interface Chair {
}

interface Sofa {
}

class VictorianChair implements Chair {
}

class VictorianSofa implements Sofa {
}

class ModernChair implements Chair {
}

class ModernSofa implements Sofa {
}


interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

class VictorianFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new VictorianChair();
    }

    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

class ModernFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new ModernChair();
    }

    public Sofa createSofa() {
        return new ModernSofa();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        FurnitureFactory factory = new VictorianFurnitureFactory();
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();

        System.out.println(sofa.getClass() + " " + chair.getClass());

        factory = new ModernFurnitureFactory();
        chair = factory.createChair();
        sofa = factory.createSofa();
        System.out.println(sofa.getClass() + " " + chair.getClass());
    }
}
