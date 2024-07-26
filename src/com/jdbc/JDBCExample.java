package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExample {

    // JDBC URL, username and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // JDBC variables for opening and managing connection
    private static Connection connection;

    public static void main(String[] args) {
        try {
            // Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Create the table if it doesn't exist
            createTable();
            
            // Insert data into the table
            insertData(101, "Jenny", 25, 10000);
            insertData(102, "Jacky", 30, 20000);
            insertData(103, "Jor", 20, 40000);
            insertData(104, "Joha", 40, 80000);
            insertData(105, "Shameer", 25, 90000);

            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Employee (" +
                                "empcode INT PRIMARY KEY," +
                                "empname VARCHAR(50)," +
                                "empage INT," +
                                "esalary DECIMAL(10, 2))";

        try (PreparedStatement pstmt = connection.prepareStatement(createTableSQL)) {
            pstmt.execute();
        }
    }

    private static void insertData(int empcode, String empname, int empage, double esalary) throws SQLException {
        String insertSQL = "INSERT INTO Employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setInt(1, empcode);
            pstmt.setString(2, empname);
            pstmt.setInt(3, empage);
            pstmt.setDouble(4, esalary);
            pstmt.executeUpdate();
        }
    }
}