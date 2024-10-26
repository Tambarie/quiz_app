package com_bptn_quiz_app.models;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionTest {

    @Test
    void getOptions() {
        Map<String, String> options = new HashMap<>();
        options.put("a", "class");
        options.put("b", "try");
        options.put("c", "if");
        options.put("d", "then");

        String question = "Which of the following is not a Java keyword?";
        String correctAnswer = "then";

        JavaQuestion javaQuestion = new JavaQuestion(question, correctAnswer, options);
        assertEquals(options, javaQuestion.getOptions());

    }

    @Test
    void getCorrect_answer() {

        Map<String, String> options = new HashMap<>();
        options.put("a", "class");
        options.put("b", "try");
        options.put("c", "if");
        options.put("d", "then");
        String question = "Which of the following is not a Java keyword?";
        String correctAnswer = "then";
        JavaQuestion questions = new JavaQuestion(question, correctAnswer, options);
        assertEquals("then", questions.getCorrect_answer());
    }

    @Test
    void getQuestion() {
        Map<String, String> options = new HashMap<>();
        options.put("a", "class");
        options.put("b", "try");
        options.put("c", "if");
        options.put("d", "then");

        String question = "Which of the following is not a Java keyword?";
        String correctAnswer = "then";

        JavaQuestion javaQuestion = new JavaQuestion(question, correctAnswer, options);
        assertEquals(question, javaQuestion.getQuestion());
    }

}