package com_bptn_quiz_app.models;

import com_bptn_quiz_app.interfaces.UserAuthentication;

public class Authentication  extends  User implements UserAuthentication  {
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public Authentication(String firstName, String lastName, String email, String password) {
      super(firstName, lastName, email, password);
    }

    @Override
    public String loginUser(String email, String password) {
        return "";
    }

    @Override
    public String signUpUser(String email, String password, String firstName, String lastName) {
        return "";
    }
}
