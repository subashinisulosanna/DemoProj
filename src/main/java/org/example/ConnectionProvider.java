package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionProvider {
    Connection getConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/r1", "root", "suba");
            return con;
        }catch (Exception e){
            return null;
        }
    }
}
