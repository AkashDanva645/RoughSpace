package org.example;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class Entities {
    @Getter
    @Setter
    @Builder
    class User {
        private static int count = 0;
        private int id;
        private String username;
        private String password;
        private int age;
        private String type;
        User() {
            this.id = ++count;
        }
    }


    @Getter
    @Setter
    class ParkingSpace {
        private int size;
        private float price;
    }


    @Getter
    @Setter
    class Car {
        private String type;
        private String color;
        private String number;
    }
}


