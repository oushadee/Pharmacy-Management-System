
package Model;

import java.sql.*;

public class DBConnection {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Register the MySQL JDBC driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
    }

    // Create a method to establish a database connection
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException ex) {
            // Handle any potential errors here
            throw ex;
        }
        return connection;
    }
}

