package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class QuestionSet {
    List<QuestionDeck> questions;

    public QuestionSet(String... categories) {
        questions = new ArrayList<>();
        for (String category : categories) {
            questions.add(createNewQuestionDeck(category));
        }
    }

    private QuestionDeck createNewQuestionDeck(String category) {
        QuestionDeck questionDeck = new QuestionDeck(category);
        for (int i = 0; i < 50; i++) {
           questionDeck.add();
        }
        return questionDeck;
    }

    public String questionFor(String category) {
        for (QuestionDeck questionDeck : questions) {
            if(questionDeck.isCategory(category))
                return questionDeck.next();
        }
        throw new IllegalArgumentException();
    }
}