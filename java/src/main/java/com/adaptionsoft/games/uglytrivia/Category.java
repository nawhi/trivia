package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Category {
    private LinkedList<String> questions;
    private String name;
    private int questionIndex;

    public Category(String name) {
        questionIndex = 0;
        this.name = name;
        questions = new LinkedList<>();
    }

    public String nextQuestion() {
        return questions.removeFirst();
    }

    public void addQuestion() {
        questions.add(name + " Question " + questionIndex++);
    }

    boolean hasName(String name) {
        return this.name.equals(name);
    }
}