package com_bptn_quiz_app.database;

import com_bptn_quiz_app.interfaces.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDriver extends Configs implements DatabaseConnection {
    Connection conn;

    SQLDriver(){}

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connection_string = "jdbc:mysql:// " + dbHost +":" + dbPort +"/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(connection_string, dbUser, dbPass);
        System.out.println("Connected to the database successfully");
        return conn;
    }
}
