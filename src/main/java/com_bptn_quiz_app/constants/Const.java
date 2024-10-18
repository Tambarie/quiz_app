package com_bptn_quiz_app.constants;

public class Const {
    public static final String USER_TABLE = "users";
    public static final String SCORE_TABLE = "scores";

    // USERS TABLE  Columns
    public static final String USER_ID = "user_id";
    public static final String FIRST_NAME = "firstname";
    public static final String LAST_NAME = "lastname";
    public static final String USER_EMAIL = "email";
    public static final String DATE_CREATED = "date_created";
    public static final String USER_PASSWORD = "password";

    // SCORES TABLE  Columns
    public static final String SCORE_ID = "score_id";
    public static final String USER_SCORE_ID = "user_id";
    public static final String SCORES = "scores";

    public static final String QUESTIONS = """
            
            
            {
            "javaQuestions": [
              {
                "question": "Which of the following is not a Java keyword?",
                "options": {
                  "a": "class",
                  "b": "try",
                  "c": "if",
                  "d": "then"
                },
                "correct_answer": "d"
              },
              {
                "question": "What is the default value of a boolean variable in Java?",
                "options": {
                  "a": "true",
                  "b": "false",
                  "c": "0",
                  "d": "null"
                },
                "correct_answer": "b"
              },
              {
                "question": "Which method must be implemented by a Java class to support multi-threading?",
                "options": {
                  "a": "run()",
                  "b": "start()",
                  "c": "execute()",
                  "d": "main()"
                },
                "correct_answer": "a"
              },
              {
                "question": "What is the size of an int in Java?",
                "options": {
                  "a": "16 bits",
                  "b": "8 bits",
                  "c": "32 bits",
                  "d": "64 bits"
                },
                "correct_answer": "c"
              },
                {
                  "question": "Which of the following is a wrapper class in Java?",
                  "options": {
                    "a": "int",
                    "b": "char",
                    "c": "float",
                    "d": "Integer"
                  },
                  "correct_answer": "d"
                },
                {
                  "question": "Which of the following is not a valid access modifier in Java?",
                  "options": {
                    "a": "public",
                    "b": "private",
                    "c": "protected",
                    "d": "friendly"
                  },
                  "correct_answer": "d"
                },
                {
                  "question": "What is the default value of a local variable in Java?",
                  "options": {
                    "a": "0",
                    "b": "null",
                    "c": "false",
                    "d": "None of the above"
                  },
                  "correct_answer": "d"
                },
                {
                  "question": "Which of the following is used to define a constant in Java?",
                  "options": {
                    "a": "static final",
                    "b": "constant",
                    "c": "final only",
                    "d": "static only"
                  },
                  "correct_answer": "a"
                },
                {
                  "question": "Which of the following is not a type of exception in Java?",
                  "options": {
                    "a": "IOException",
                    "b": "SQLException",
                    "c": "ClassNotFoundException",
                    "d": "NumberFormat"
                  },
                  "correct_answer": "d"
                },
                {
                  "question": "What is the return type of the hashCode() method in Java?",
                  "options": {
                    "a": "int",
                    "b": "long",
                    "c": "boolean",
                    "d": "float"
                  },
                  "correct_answer": "a"
                },
                {
                  "question": "Which of the following is a checked exception in Java?",
                  "options": {
                    "a": "ArrayIndexOutOfBoundsException",
                    "b": "IOException",
                    "c": "ArithmeticException",
                    "d": "NullPointerException"
                  },
                  "correct_answer": "b"
                },
                {
                  "question": "What does the 'super' keyword represent in Java?",
                  "options": {
                    "a": "Current instance of a class",
                    "b": "Parent class object",
                    "c": "Method reference",
                    "d": "Static method"
                  },
                  "correct_answer": "b"
                },
                {
                  "question": "Which package contains the 'String' class in Java?",
                  "options": {
                    "a": "java.lang",
                    "b": "java.util",
                    "c": "java.io",
                    "d": "java.text"
                  },
                  "correct_answer": "a"
                },
                {
                  "question": "Which of the following is a marker interface?",
                  "options": {
                    "a": "Runnable",
                    "b": "Cloneable",
                    "c": "Serializable",
                    "d": "Readable"
                  },
                  "correct_answer": "c"
                },
                {
                  "question": "Which of these is not a feature of Java?",
                  "options": {
                    "a": "Object-oriented",
                    "b": "Platform independent",
                    "c": "Manual memory management",
                    "d": "Multithreading"
                  },
                  "correct_answer": "c"
                },
                {
                  "question": "Which operator is used to compare two values in Java?",
                  "options": {
                    "a": "=",
                    "b": "==",
                    "c": "!=",
                    "d": "equals()"
                  },
                  "correct_answer": "b"
                },
                {
                  "question": "Which method is used to stop a thread in Java?",
                  "options": {
                    "a": "suspend()",
                    "b": "stop()",
                    "c": "terminate()",
                    "d": "interrupt()"
                  },
                  "correct_answer": "d"
                },
                {
                  "question": "What is the output of 10 + 20 + \\"30\\" in Java?",
                  "options": {
                    "a": "1030",
                    "b": "3030",
                    "c": "102030",
                    "d": "30"
                  },
                  "correct_answer": "a"
                },
                {
                  "question": "Which collection does not allow duplicates in Java?",
                  "options": {
                    "a": "List",
                    "b": "Set",
                    "c": "Queue",
                    "d": "Map"
                  },
                  "correct_answer": "b"
                },
                {
                  "question": "Which of the following methods is not defined in the Object class?",
                  "options": {
                    "a": "equals()",
                    "b": "hashCode()",
                    "c": "clone()",
                    "d": "finalizeAll()"
                  },
                  "correct_answer": "d"
                }
              ]
            }
            
            
            """;
}
