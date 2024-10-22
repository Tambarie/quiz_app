package com_bptn_quiz_app.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserAuthentication {
    ResultSet getUser(String email, String password);
    String signUpUser(String email, String password, String firstName, String lastName) throws SQLException, ClassNotFoundException;
    ResultSet getUserByEmail(String email);
}
