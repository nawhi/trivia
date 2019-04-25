package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionDeck {
    LinkedList questions;
    private String category;

    public QuestionDeck() {
    }

    public QuestionDeck(String category) {
        this.category = category;
        questions = new LinkedList();
    }
}