package com.hug.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost/octotung?user=root&password=root"; 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url);
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }  
    }
}
