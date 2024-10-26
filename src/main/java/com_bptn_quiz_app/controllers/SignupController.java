package com_bptn_quiz_app.controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com_bptn_quiz_app.database.DatabaseHandler;
import com_bptn_quiz_app.interfaces.Emails;
import com_bptn_quiz_app.interfaces.UserAuthentication;
import com_bptn_quiz_app.libraries.EmailServer;
import com_bptn_quiz_app.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.apache.commons.mail.EmailException;

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
    private Label enterValidPasswordError;

    @FXML
    private Label passwordLengthError;

    @FXML
    private Label passwordMismatchError;

    @FXML
    private Label fillAllFieldsError;

    @FXML
    private Label userAlreadyExists;

    @FXML
    void onKey(KeyEvent event) {

    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        initializeScreen();

        signUpButton.setOnAction(event -> {
            String userEmail = email.getText().trim();
            String userFirstName = firstName.getText().trim();
            String userLastName = lastName.getText().trim();
            String userPassword = password.getText().trim();
            String userConfirmPassword = confirmPassword.getText().trim();

            // Validate user inputs
            if (userEmail.isEmpty() || userFirstName.isEmpty() || userLastName.isEmpty() || userPassword.isEmpty()) {
                fillAllFieldsError.setVisible(true);
                return;
            }

            if (!userConfirmPassword.equals(userPassword)){
                passwordMismatchError.setVisible(true);
                return;
            }

            if (!userEmail.contains("@")){
                enterValidPasswordError.setVisible(true);
                return;
            }

            if (userPassword.length() < 6){
                passwordLengthError.setVisible(true);
                return;
            }

            // Instantiate the user Object
            User user = new User( userFirstName, userLastName,userEmail, userPassword);

            // invoke database handler
            UserAuthentication userAuthentication = null;
            try {
                userAuthentication = new DatabaseHandler();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            // check if user email already exists in the database
            ResultSet userRow = userAuthentication.getUserByEmail(userEmail);
            int counter = 0;
            while (true){
                try {
                    if (!userRow.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                counter++;
            }
            // check if user counter is 1
            if (counter == 1) {
                userAlreadyExists.setVisible(true);
                return;
            }




            // Signup user
            try {
                String message = userAuthentication.signUpUser(user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());
                System.out.println(message);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            String signUpMesssage = String.format("Hello %s , welcome to TD Quiz App", userFirstName);

            Emails emails = new EmailServer();

            try {
                var notifier = emails.SendEmail(userEmail,signUpMesssage);
                System.out.println(notifier);
            } catch (EmailException e) {
                e.printStackTrace();
            }


            // Navigate user to login page
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

        // Navigate user to home page
            HomeController homeController = new HomeController();
            homeController.SetScreen(homeButton, "/com_bptn_quiz_app/home.fxml","Quiz App");

    }


    //Initialize default signup screen
    private void initializeScreen() {
        enterValidPasswordError.setVisible(false);
        passwordLengthError.setVisible(false);
        passwordMismatchError.setVisible(false);
        fillAllFieldsError.setVisible(false);
        userAlreadyExists.setVisible(false);
    }


}
