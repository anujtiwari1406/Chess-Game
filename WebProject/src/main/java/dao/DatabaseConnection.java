package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database details
    private static final String URL = "jdbc:postgresql://localhost:5432/Chess_game";
    private static final String USER = "postgres"; // Replace with your PostgreSQL username
    private static final String PASSWORD = "password"; // Replace with your PostgreSQL password

    public static Connection getConnection() throws SQLException {
        // Register the PostgreSQL driver
        try {
            Class.forName("org.postgresql.Driver"); // This manually loads the driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("PostgreSQL JDBC Driver not found.", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the PostgreSQL database successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed. Please check your connection details.");
            e.printStackTrace();
        }
    }
}
