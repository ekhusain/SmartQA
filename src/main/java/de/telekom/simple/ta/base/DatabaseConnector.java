package de.telekom.simple.ta.base;

import java.sql.*;

public class DatabaseConnector {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "HE125469.emea1.cds.t-internal.com";
    private static final String USERNAME = "simple_sql_user";
    private static final String PASSWORD = "76Y6ZZVLRK8iqcwvsPi6MDAeF36pQ";

    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

                // Execute a SQL query
                String sqlQuery = "SELECT * FROM your_table";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                     ResultSet resultSet = preparedStatement.executeQuery()) {

                    // Process the result set
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String columnName = resultSet.getString("column_name");

                        // Do something with the data
                        System.out.println("ID: " + id + ", Column Name: " + columnName);
                    }
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}