package com_bptn_quiz_app.models;

import java.util.Map;

public class JavaQuestion {
    public String question;
    public Map<String, String> options;
    public String correct_answer;



    public JavaQuestion(String question, String correct_answer, Map<String, String> options) {
        this.question = question;
        this.correct_answer = correct_answer;
        this.options = options;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "JavaQuestion{" +
                "question='" + question + '\'' +
                ", options=" + options +
                ", correct_answer='" + correct_answer + '\'' +
                '}';
    }
}
