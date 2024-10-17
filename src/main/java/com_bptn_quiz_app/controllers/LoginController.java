package com_bptn_quiz_app.controllers;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private JFXButton homeButton;

    @FXML
    private JFXButton loginButton;

    @FXML
    void
    initialize() {
        // TODO 1. Get the inputs, 2. Create a database 3. Refactor SetScreen method to a static method

        if    (loginButton != null && homeButton != null)  {
            HomeController homeController = new HomeController();
            homeController.SetScreen(loginButton, "/com_bptn_quiz_app/quiz_screen.fxml","Quiz App");
            homeController.SetScreen(homeButton, "/com_bptn_quiz_app/home.fxml","Quiz App");
        }

    }

}
