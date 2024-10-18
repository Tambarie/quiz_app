package com_bptn_quiz_app.models;

import java.util.Map;

public class QuestionBatch extends JavaQuestion {
    public String question;
    public Map<String, String> options;
    public String correct_answer;

    public QuestionBatch(String question, String correct_answer, Map<String, String> options) {
        super(question, correct_answer, options);
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public Map<String, String> getOptions() {
        return options;
    }

    @Override
    public String getCorrect_answer() {
        return correct_answer;
    }
}
