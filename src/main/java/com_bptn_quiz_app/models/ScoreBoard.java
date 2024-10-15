package com_bptn_quiz_app.models;

import com_bptn_quiz_app.interfaces.Score;

public class ScoreBoard  implements Score {
    private final String userName;
    private final Integer questions;
    private final Integer correctAnswers;
    private final  Integer wrongAnswers;

    public ScoreBoard (String userName, Integer questions, Integer correctAnswers, Integer wrongAnswers){
        this.userName = userName;
        this.questions = questions;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getQuestions() {
        return questions;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public Integer getWrongAnswers() {
        return wrongAnswers;
    }

    @Override
    public Integer calculateScore(Integer questions, Integer correctAnswers, Integer wrongAnswers) {
        return null;
    }
}
