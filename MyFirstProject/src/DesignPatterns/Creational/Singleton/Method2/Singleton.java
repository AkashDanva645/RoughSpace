package DesignPatterns.Creational.Singleton.Method2;


import DesignPatterns.Creational.Singleton.Method2.Database.DatabaseConnection;
import DesignPatterns.Creational.Singleton.Method2.Database.DatabaseSingletonFactory;

public class Singleton {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseSingletonFactory.getInstance();
        dbConnection.query("SELECT * FROM Users;");
        DatabaseConnection dbConnection2 = DatabaseSingletonFactory.getInstance();

        if (dbConnection == dbConnection2) {
            System.out.println("SAMMEEE");
        }
    }
}


