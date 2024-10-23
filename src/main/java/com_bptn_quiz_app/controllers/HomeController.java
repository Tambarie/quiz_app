package com_bptn_quiz_app.controllers;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private JFXButton homeLoginButton;

    @FXML
    private JFXButton homeSignUpButton;

    @FXML
    private ImageView displayPicture;

    @FXML
    private ImageView tdLogo;



    @FXML
    void initialize() {

        Image logo = new Image(getClass().getResource("/com_bptn_quiz_app/td-logo-en.png").toExternalForm());
        tdLogo.setImage(logo);

        Image image = new Image(getClass().getResource("/com_bptn_quiz_app/landing_page.jpg").toExternalForm());
        displayPicture.setImage(image);


        if (homeLoginButton != null) {
            SetScreen(homeLoginButton, "/com_bptn_quiz_app/login.fxml","Login");
        }

        if (homeSignUpButton != null) {
            SetScreen(homeSignUpButton, "/com_bptn_quiz_app/signup.fxml","Sign Up");
        }

    }

    public  static void SetScreen(JFXButton jfxButton, String url, String title) {
        jfxButton.setOnAction(event -> {
            jfxButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(HomeController.class.getResource(url));

            try {
                fxmlLoader.load();
            }catch (IOException e){
                e.printStackTrace();
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });
    }

}
