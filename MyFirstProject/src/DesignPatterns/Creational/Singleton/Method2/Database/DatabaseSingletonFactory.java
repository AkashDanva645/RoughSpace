package DesignPatterns.Creational.Singleton.Method2.Database;

public class DatabaseSingletonFactory {
    private static DatabaseConnection dbConnection;

    private static String url = "http://localhost:5432";
    private static String username = "root";
    private static String password = "12345";

    public static DatabaseConnection getInstance() {
        if (dbConnection != null) {
            return dbConnection;
        }
        dbConnection = new DatabaseConnection(url, username, password);
        return dbConnection;
    }
}
