package com_bptn_quiz_app.models;


import java.util.ArrayList;

public class Questions {
   public ArrayList<JavaQuestion> javaQuestions;

    @Override
    public String toString() {
        return "Questions{" +
                "questions=" + javaQuestions +
                '}';
    }
}
