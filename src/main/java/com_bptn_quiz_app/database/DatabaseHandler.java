package com_bptn_quiz_app.database;

import com_bptn_quiz_app.constants.Const;
import com_bptn_quiz_app.interfaces.DatabaseConnection;
import com_bptn_quiz_app.interfaces.UserAuthentication;
import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler implements UserAuthentication {

    public DatabaseHandler() throws SQLException, ClassNotFoundException {
    }

    DatabaseConnection database = new SQLDriver();

    Connection conn = database.getConnection();


    @Override
    public String loginUser(String email, String password) {
        return "";
    }

    @Override
    public String signUpUser(String email, String password, String firstName, String lastName) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + " (" + Const.FIRST_NAME + ", " + Const.LAST_NAME + ", " + Const.USER_EMAIL + ", " + Const.USER_PASSWORD + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3,email );
            ps.setString(4, password);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());  ;
        }

        return "Saved successfully";
    }

}


