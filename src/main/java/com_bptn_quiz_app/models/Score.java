package com_bptn_quiz_app.models;

public class Score {
    private Double score;
    private final String user;

    public Score(Double score, String user) {
        this.score = score;
        this.user = user;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
    public String getUser() {
        return user;
    }
}
