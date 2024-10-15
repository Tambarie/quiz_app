package com_bptn_quiz_app.interfaces;

public interface UserAuthentication {
    String loginUser(String email, String password);
    String signUpUser(String email, String password, String firstName, String lastName);
}
