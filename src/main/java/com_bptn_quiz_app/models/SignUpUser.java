package com_bptn_quiz_app.models;

import com_bptn_quiz_app.interfaces.UserAuthentication;

public class SignUpUser extends  User   {
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public SignUpUser(String firstName, String lastName, String email, String password) {
      super(firstName, lastName, email, password);
    }

}
