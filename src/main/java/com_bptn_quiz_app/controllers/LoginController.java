package com_bptn_quiz_app.controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField enterEmailField;

    @FXML
    private TextField enterPasswordField;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton signUpButton;

    @FXML
    void initialize() {
        assert enterEmailField != null : "fx:id=\"enterEmailField\" was not injected: check your FXML file 'login.fxml'.";
        assert enterPasswordField != null : "fx:id=\"enterPasswordField\" was not injected: check your FXML file 'login.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'login.fxml'.";
        assert signUpButton != null : "fx:id=\"signUpButton\" was not injected: check your FXML file 'login.fxml'.";

    }

}
