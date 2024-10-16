package com_bptn_quiz_app.controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton homeLoginButton;

    @FXML
    private JFXButton homeSignUpButton;

    @FXML
    void initialize() {
            homeLoginButton.setOnAction(event -> {
                System.out.println("Login Button pressed");
            });

    }

}
