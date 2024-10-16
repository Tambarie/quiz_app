package com_bptn_quiz_app.controllers;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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



        if (homeLoginButton != null) {

            SetScreen(homeLoginButton, "/com_bptn_quiz_app/login.fxml","Login");
        }

        if (homeSignUpButton != null) {
            SetScreen(homeSignUpButton, "/com_bptn_quiz_app/signup.fxml","Sign Up");
        }

    }

    // TODO: refactor this method to a static helper method
    public void SetScreen(JFXButton jfxButton, String url, String title) {
        jfxButton.setOnAction(event -> {
            jfxButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(url));

            try {
                fxmlLoader.load();
            }catch (IOException e){
                e.printStackTrace();
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

        });
    }

}
