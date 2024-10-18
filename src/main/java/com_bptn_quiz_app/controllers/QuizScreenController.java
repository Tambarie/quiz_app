package com_bptn_quiz_app.controllers;

import com.google.gson.Gson;
import com_bptn_quiz_app.interfaces.JsonDesirialiser;
import com_bptn_quiz_app.models.JavaQuestion;
import com_bptn_quiz_app.models.Questions;







import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static com_bptn_quiz_app.constants.Const.QUESTIONS;

public class QuizScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label title;

    @FXML
    void initialize() {



        Gson gson = new Gson();
        JsonDesirialiser questions =  (QUESTIONS) -> gson.fromJson(QUESTIONS, Questions.class);


        Questions q = questions.deserializes(QUESTIONS);

        for (JavaQuestion quest : q.javaQuestions){
            if (quest != null){
                System.out.println(quest);
            }

        }

    }

}










