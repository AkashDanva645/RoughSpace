package org.example.design_patterns.creational;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class House {
    int numDoors;
    String roofType;
    int numRooms;
    String color;

    public static class HouseBuilder {
        private House house;

        HouseBuilder() {
            this.house = new House();
        }

        public HouseBuilder numDoors(int x) {
            this.house.setNumDoors(x);
            return this;
        }

        public HouseBuilder numRooms(int x) {
            this.house.setNumRooms(x);
            return this;
        }

        public HouseBuilder color(String x) {
            this.house.setColor(x);
            return this;
        }

        public HouseBuilder roof(String x) {
            this.house.setRoofType(x);
            return this;
        }

        public House build() {
            return this.house;
        }
    }

    public static HouseBuilder builder() {
        return new HouseBuilder();
    }
}




public class Builder {
    public static void main(String[] args) {
        House house = House.builder()
                .numDoors(4)
                .numDoors(6)
                .roof("flat")
                .color("blue")
                .build();

        System.out.println(house.getColor());
    }
}
