package com.adaptionsoft.games.uglytrivia;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionSet {
    private List<QuestionDeck> questions;

    public QuestionSet(String... categories) {
        questions = Arrays.stream(categories)
                .map(this::createNewQuestionDeck)
                .collect(Collectors.toList());
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