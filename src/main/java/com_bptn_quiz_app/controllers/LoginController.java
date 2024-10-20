package com_bptn_quiz_app.controllers;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com_bptn_quiz_app.database.DatabaseHandler;
import com_bptn_quiz_app.interfaces.UserAuthentication;
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

        if (homeButton != null) {
            HomeController homeController = new HomeController();
            homeController.SetScreen(homeButton, "/com_bptn_quiz_app/home.fxml", "Quiz App");
        }

        loginButton.setOnAction(event -> {

            String email = enterEmailField.getText().trim();
            String password = enterPasswordField.getText().trim();


            if (email.isEmpty() || password.isEmpty()) {
                // TODO Return an error message to the user
                System.out.println("Enter email or password");
                return;
            }

            UserAuthentication userAuthentication = null;
            try {
                userAuthentication = new DatabaseHandler();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            ResultSet userRow = userAuthentication.getUser(email, password);
            int counter = 0;
            while (true){
                try {
                    if (!userRow.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                counter++;
            }
            if (counter != 1) {
                // TODO send an error message to the user
                System.out.println("Login failed");
                return;
            }

            loginButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com_bptn_quiz_app/quiz_screen.fxml"));

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Quiz App");
            stage.setScene(new Scene(root));
            stage.show();
        });

    }
}
