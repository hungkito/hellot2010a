package com.example.hello_t2010a_agen.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/hello_t2010a";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection(){
        try {
            if (connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
