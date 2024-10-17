package com_bptn_quiz_app.interfaces;

import java.sql.SQLException;

public interface UserAuthentication {
    String loginUser(String email, String password);
    String signUpUser(String email, String password, String firstName, String lastName) throws SQLException, ClassNotFoundException;
}
