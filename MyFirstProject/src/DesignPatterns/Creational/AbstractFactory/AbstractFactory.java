package DesignPatterns.Creational.AbstractFactory;

interface Chair {
}

interface Sofa {
}

interface CoffeeTable {
}

interface FurnitureFactory {
    public Chair createChair();
    public CoffeeTable createCoffeeTable();
    public Sofa createSofa();
}

class VictorianChair implements Chair {
}

class VictorianSofa implements Sofa {
}

class VictorianCoffeeTable implements CoffeeTable {
}

class ModernChair implements Chair {
}

class ModernSofa implements Sofa {
}

class ModernCoffeeTable implements CoffeeTable {
}


class VictorianFurnitureFactory implements FurnitureFactory {

    public Chair createChair() {
        System.out.println("Victorian Chair Created");
        return new VictorianChair();
    }

    public Sofa createSofa() {
        System.out.println("Victorian Sofa Created");
        return new VictorianSofa();
    }

    public CoffeeTable createCoffeeTable() {
        System.out.println("Victorian Coffee Table Created");
        return new VictorianCoffeeTable();
    }
}


class ModernFurnitureFactory implements FurnitureFactory {

    public Chair createChair() {
        System.out.println("Modern Chair Created");
        return new ModernChair();
    }

    public Sofa createSofa() {
        System.out.println("Modern Sofa Created");
        return new ModernSofa();
    }

    public CoffeeTable createCoffeeTable() {
        System.out.println("Modern Coffer Table Created");
        return new ModernCoffeeTable();
    }
}

class FurnitureService {
    private FurnitureFactory factory;

    public void setFactory(FurnitureFactory factory) {
        this.factory = factory;
    }

    void createFurniture() {
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();
        CoffeeTable coffeeTable = factory.createCoffeeTable();
    }
}

// Application
public class AbstractFactory {

    public static VictorianFurnitureFactory vFactory = new VictorianFurnitureFactory();
    public static ModernFurnitureFactory mFactory = new ModernFurnitureFactory();

    public static void main(String[] args) {
        FurnitureService service = new FurnitureService();
        service.setFactory(vFactory);
        service.createFurniture();
        service.setFactory(mFactory);
        service.createFurniture();
    }
}
