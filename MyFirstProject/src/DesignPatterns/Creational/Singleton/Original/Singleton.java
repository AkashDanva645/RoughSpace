package DesignPatterns.Creational.Singleton.Original;

import javax.xml.crypto.Data;

class Database {
    private static Database db;

    private static String url;
    private static String name;
    private static String password;

    private Database(String url, String name, String password) {
        this.url = url;
        this.name = name;
        this.password = password;
        connect();
    }

    public static Database getInstance() {
        if (db != null) {
            return db;
        }
        db = new Database(url, name, password);
        return db;
    }

    private void connect() {
        System.out.println("Connected to Database");
    }

    private void query(String query) {
        System.out.println("Fetching Results......");
    }
}

public class Singleton {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        Database db2 = Database.getInstance();
        System.out.println(db == db2);
    }
}
