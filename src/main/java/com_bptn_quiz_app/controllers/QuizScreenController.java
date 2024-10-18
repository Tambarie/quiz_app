package com_bptn_quiz_app.controllers;

import com.google.gson.Gson;
import com_bptn_quiz_app.interfaces.JsonDesirialiser;
import com_bptn_quiz_app.models.JavaQuestion;
import com_bptn_quiz_app.models.Questions;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.Optional;
import java.util.Random;

import static com_bptn_quiz_app.constants.Const.QUESTIONS;

public class QuizScreenController {

    @FXML
    private JFXRadioButton a;

    @FXML
    private JFXRadioButton b;

    @FXML
    private JFXRadioButton c;

    @FXML
    private JFXButton checkResult;

    @FXML
    private JFXRadioButton d;

    @FXML
    private JFXButton nextQuestion;

    @FXML
    private Label question;

    @FXML
    private Label questionNumber;

    @FXML
    private Label scoreText;


    @FXML
    private Label correctAnswers;

    @FXML
    private Label title;

    @FXML
    void initialize() {
        correctAnswers.setText("0");
        int counter = 1;

        a.setSelectedColor(Color.LIGHTGREEN);
        b.setSelectedColor(Color.LIGHTGREEN);
        c.setSelectedColor(Color.LIGHTGREEN);
        d.setSelectedColor(Color.LIGHTGREEN);

        ToggleGroup group = new ToggleGroup();
        a.setToggleGroup(group);
        b.setToggleGroup(group);
        c.setToggleGroup(group);
        d.setToggleGroup(group);


        nextQuestion.setOnAction(event -> {
            a.setSelected(false);
            b.setSelected(false);
            c.setSelected(false);
            d.setSelected(false);

            int number = Integer.parseInt(questionNumber.getText().trim());
            setNextQuestion(number + counter);
            a.setDisable(false);
            b.setDisable(false);
            c.setDisable(false);
            d.setDisable(false);
            checkResult.setDisable(false);

            a.setSelectedColor(Color.LIGHTGREEN);
            b.setSelectedColor(Color.LIGHTGREEN);
            c.setSelectedColor(Color.LIGHTGREEN);
            d.setSelectedColor(Color.LIGHTGREEN);

            int quizNumber = Integer.parseInt(questionNumber.getText().trim());
            if (quizNumber > 2) {
                endQuizScene();
            }
        });


        checkResult.setOnAction(event -> {
            int correct = Integer.parseInt(correctAnswers.getText().trim());
            calculateScore(correct);
            a.setDisable(!a.isSelected());
            b.setDisable(!b.isSelected());
            c.setDisable(!c.isSelected());
            d.setDisable(!d.isSelected());
            checkResult.setDisable(true);
        });

    }


    private void endQuizScene() {
        int correct = Integer.parseInt(correctAnswers.getText().trim());
        int number =   Integer.parseInt (questionNumber.getText().trim()) - 1;

        double totalScore = (double) correct / number * 100;
        String message = String.format("Your score is %s%%", totalScore);

        scoreText.setText(message);
        nextQuestion.setVisible(false);
        checkResult.setVisible(false);
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        question.setVisible(false);
        questionNumber.setVisible(false);
        scoreText.setVisible(true);

        // TODO Set Student Score to the Database
    }

    private void calculateScore(int correct) {
        boolean isASelected =  a.isSelected();
        boolean isBSelected =  b.isSelected();
        boolean isCSelected = c.isSelected();
        boolean isDSelected = d.isSelected();
        String optionA = a.getText().trim();
        String optionB = b.getText().trim();
        String optionC = c.getText().trim();
        String optionD = d.getText().trim();
        String ques = question.getText().trim();

        JavaQuestion javaQuestion = getQuestions(ques);
        Optional<JavaQuestion> opt = Optional.ofNullable(javaQuestion);

        if (opt.isPresent()) {
            if (isASelected && optionA.equals(javaQuestion.correct_answer)) {
                a.setSelectedColor(Color.LAWNGREEN);
                correct++;
            }else {
                a.setSelectedColor(Color.RED);

            }
            if (isBSelected && optionB.equals(javaQuestion.correct_answer)) {
                b.setSelectedColor(Color.LAWNGREEN);
                correct++;
            }else {
                b.setSelectedColor(Color.RED);

            }
            if (isCSelected && optionC.equals(javaQuestion.correct_answer)) {
                c.setSelectedColor(Color.LAWNGREEN);
                correct++;
            }else {
                c.setSelectedColor(Color.RED);

            }
            if (isDSelected && optionD.equals(javaQuestion.correct_answer)) {
                d.setSelectedColor(Color.LAWNGREEN);
                correct++;
            }else
                d.setSelectedColor(Color.RED);

              }
        correctAnswers.setText(String.valueOf(correct));
    }

    private JavaQuestion getRandomQuestion(Questions questions) {
        Random random = new Random();
        int randomIndex = random.nextInt(questions.javaQuestions.size());
        return questions.javaQuestions.get(randomIndex);
    }


    private void setNextQuestion( int counter) {
        Gson gson = new Gson();
        JsonDesirialiser questions = (QUESTIONS) -> gson.fromJson(QUESTIONS, Questions.class);
        Questions jQuestions = questions.deserializes(QUESTIONS);
        JavaQuestion javaQuestionBatch = getRandomQuestion(jQuestions);

        questionNumber.setText(String.valueOf(counter));
        question.setText(javaQuestionBatch.getQuestion());
        a.setText(javaQuestionBatch.options.get("a"));
        b.setText(javaQuestionBatch.options.get("b"));
        c.setText(javaQuestionBatch.options.get("c"));
        d.setText(javaQuestionBatch.options.get("d"));
    }

    private JavaQuestion getQuestions(String get) {
        Gson gson = new Gson();
        JsonDesirialiser questions = (QUESTIONS) -> gson.fromJson(QUESTIONS, Questions.class);
        Questions jQuestions = questions.deserializes(QUESTIONS);

        for (JavaQuestion javaQuestion : jQuestions.javaQuestions) {
            if (javaQuestion.getQuestion().equals(get)) {
                return javaQuestion;
            }
        }
        return null;
    }
}










