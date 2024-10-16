package com_bptn_quiz_app.controllers;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private JFXButton homeButton;

    @FXML
    private JFXButton signUpButton;

    @FXML
    void initialize() {


        if    (signUpButton != null && homeButton != null)  {
            HomeController homeController = new HomeController();
            homeController.SetScreen(signUpButton, "/com_bptn_quiz_app/login.fxml","Login");
            homeController.SetScreen(homeButton, "/com_bptn_quiz_app/home.fxml","Quiz App");
        }




    }

}
