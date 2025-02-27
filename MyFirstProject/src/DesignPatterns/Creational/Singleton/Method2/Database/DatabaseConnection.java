package DesignPatterns.Creational.Singleton.Method2.Database;

public class DatabaseConnection {
    private String url;
    private String username;
    private String password;
    private String createdAt;

    protected DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        connect();
    }

    private void connect() {
        System.out.println("Connected to Database.");
    }

    public void query(String query) {
        System.out.println("Fetching Data......");
    }
}