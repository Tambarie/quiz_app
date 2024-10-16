package com_bptn_quiz_app.controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private JFXButton loginButton;

    @FXML
    private PasswordField password;

    @FXML
    private JFXButton signUpButton;

    @FXML
    void initialize() {
        assert confirmPassword != null : "fx:id=\"confirmPassword\" was not injected: check your FXML file 'signup.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'signup.fxml'.";
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'signup.fxml'.";
        assert lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'signup.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'signup.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'signup.fxml'.";
        assert signUpButton != null : "fx:id=\"signUpButton\" was not injected: check your FXML file 'signup.fxml'.";

    }

}
