package com_bptn_quiz_app.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com_bptn_quiz_app.constants.Const;
import com_bptn_quiz_app.interfaces.JsonDeserializer;
import com_bptn_quiz_app.interfaces.JsonSirialiser;
import com_bptn_quiz_app.models.JavaQuestion;
import com_bptn_quiz_app.models.Questions;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com_bptn_quiz_app.models.Score;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;


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
    private JFXButton logout;

    @FXML
    private Label quizEnded;

    @FXML
    private JFXButton startNewQuiz;

    @FXML
    private Label questionTag;


    @FXML
    void initialize() {
        int counter = 1;
        initialScreenMount();
        setQuestion(counter);
        nextQuestion.setOnAction(event -> {
            a.setSelected(false);
            b.setSelected(false);
            c.setSelected(false);
            d.setSelected(false);

            int number = Integer.parseInt(questionNumber.getText().trim());
            setQuestion(number + counter);
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
            if (quizNumber > Const.NUMBER_OF_QUESTIONS) {
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

        startNewQuiz.setOnAction(event -> {
            SetScreen(startNewQuiz,"/com_bptn_quiz_app/quiz_screen.fxml","Quiz App");
        });

        logout.setOnAction(event -> {
            SetScreen(logout,"/com_bptn_quiz_app/home.fxml","Quiz App");
        });
    }

    private void initialScreenMount() {
        correctAnswers.setText("0");

        quizEnded.setVisible(false);
        logout.setVisible(false);
        startNewQuiz.setVisible(false);
        scoreText.setVisible(false);

        a.setSelectedColor(Color.LIGHTGREEN);
        b.setSelectedColor(Color.LIGHTGREEN);
        c.setSelectedColor(Color.LIGHTGREEN);
        d.setSelectedColor(Color.LIGHTGREEN);

        ToggleGroup group = new ToggleGroup();
        a.setToggleGroup(group);
        b.setToggleGroup(group);
        c.setToggleGroup(group);
        d.setToggleGroup(group);
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
        quizEnded.setVisible(true);
        logout.setVisible(true);
        startNewQuiz.setVisible(true);
        questionTag.setVisible(false);

        //  Saves user score to JSON
        saveUserScore(totalScore);
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


    private void setQuestion(int counter) {
        JsonDeserializer questions = getJsonDesirialiser();
        Questions jQuestions = questions.deserializes();
        JavaQuestion javaQuestionBatch = getRandomQuestion(jQuestions);

        questionNumber.setText(String.valueOf(counter));
        question.setText(javaQuestionBatch.getQuestion());
        a.setText(javaQuestionBatch.options.get("a"));
        b.setText(javaQuestionBatch.options.get("b"));
        c.setText(javaQuestionBatch.options.get("c"));
        d.setText(javaQuestionBatch.options.get("d"));
    }

    private JavaQuestion getQuestions(String get) {
        JsonDeserializer questions = getJsonDesirialiser();
        Questions jQuestions = questions.deserializes();
        for (JavaQuestion javaQuestion : jQuestions.javaQuestions) {
            if (javaQuestion.getQuestion().equals(get)) {
                return javaQuestion;
            }
        }
        return null;
    }

    @NotNull
    private static JsonDeserializer getJsonDesirialiser() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return () -> {
            try {
                FileReader fileReader = new FileReader("src/main/java/com_bptn_quiz_app/assets/quiz.json");
              return   gson.fromJson(fileReader, Questions.class);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private void saveUserScore (Double userSores){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonSirialiser saveScoreToJSon = (score) -> {
            try {
                FileWriter writer = new FileWriter("src/main/java/com_bptn_quiz_app/assets/scores.json");
                gson.toJson(score, writer);
                writer.close();
                System.out.println("Score saved");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        saveScoreToJSon.serializes(new Score(userSores,"user"));
    }

    public  static void SetScreen(JFXButton jfxButton, String url, String title) {
        jfxButton.setOnAction(event -> {
            jfxButton.getScene().getWindow().hide();
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
            stage.show();
        });
    }
}










