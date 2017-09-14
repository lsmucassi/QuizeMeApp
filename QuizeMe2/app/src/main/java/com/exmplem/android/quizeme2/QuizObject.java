package com.exmplem.android.quizeme2;

/**
 * Created by User on 10/27/2016.
 */

public class QuizObject
{

    private  String question;
    private  String correctAnswer;
    private  String dummy1;
    private  String getDummy2;
    private  String getDummy3;

    public QuizObject(String question, String correctAnswer, String dummy1, String getDummy2, String getDummy3) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.dummy1 = dummy1;
        this.getDummy2 = getDummy2;
        this.getDummy3 = getDummy3;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getDummy1() {
        return dummy1;
    }

    public void setDummy1(String dummy1) {
        this.dummy1 = dummy1;
    }

    public String getGetDummy2() {
        return getDummy2;
    }

    public void setGetDummy2(String getDummy2) {
        this.getDummy2 = getDummy2;
    }

    public String getGetDummy3() {
        return getDummy3;
    }

    public void setGetDummy3(String getDummy3) {
        this.getDummy3 = getDummy3;
    }
}
