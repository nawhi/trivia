package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionDeck {
    private LinkedList<String> questions;
    private String category;
    private int questionIndex;

    public QuestionDeck(String category) {
        questionIndex = 0;
        this.category = category;
        questions = new LinkedList<>();
    }

    public String next() {
        return questions.removeFirst();
    }

    public void add() {
        questions.add(category + " Question " + questionIndex++);
    }
}