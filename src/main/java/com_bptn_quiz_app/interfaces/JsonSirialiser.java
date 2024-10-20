package com_bptn_quiz_app.interfaces;

import com_bptn_quiz_app.models.Questions;
import com_bptn_quiz_app.models.Score;

import java.io.FileReader;
import java.io.FileWriter;

@FunctionalInterface
public interface JsonSirialiser {
    void serializes(Score score);
}
