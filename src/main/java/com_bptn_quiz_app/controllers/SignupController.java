package com_bptn_quiz_app.controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com_bptn_quiz_app.database.DatabaseHandler;
import com_bptn_quiz_app.interfaces.UserAuthentication;
import com_bptn_quiz_app.models.SignUpUser;
import com_bptn_quiz_app.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController  {

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
    void initialize() throws SQLException, ClassNotFoundException {


        // TODO validate the user inputs
        // TODO check for confirmation of password
        // TODO Hash the password
        // TODO check if password and confirm password are equal

        signUpButton.setOnAction(event -> {

            String userEmail = email.getText().trim();
            String userFirstName = firstName.getText().trim();
            String userLastName = lastName.getText().trim();
            String userPassword = password.getText().trim();
            String userConfirmPassword = confirmPassword.getText().trim();

            if (!userConfirmPassword.equals(userPassword)){
                System.out.println("Passwords mismatch");
                return;
            }

            if (userEmail.isEmpty() || userFirstName.isEmpty() || userLastName.isEmpty() || userPassword.isEmpty()) {
                System.out.println("Please fill all the fields");
                return;
            }

            User user = new User( userFirstName, userLastName,userEmail, userPassword);


            UserAuthentication userAuthentication = null;
            try {
                userAuthentication = new DatabaseHandler();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


            try {
                String message = userAuthentication.signUpUser(user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());
                System.out.println(message);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

                signUpButton.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com_bptn_quiz_app/login.fxml"));

                try {
                    fxmlLoader.load();
                }catch (IOException e){
                    e.printStackTrace();
                }

                Parent root = fxmlLoader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Login");
                stage.setScene(new Scene(root));
                stage.showAndWait();
            });

            HomeController homeController = new HomeController();
            homeController.SetScreen(homeButton, "/com_bptn_quiz_app/home.fxml","Quiz App");

    }


}
