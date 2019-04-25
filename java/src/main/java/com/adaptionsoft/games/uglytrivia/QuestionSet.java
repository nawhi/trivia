package com.adaptionsoft.games.uglytrivia;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuestionSet {
    private List<QuestionDeck> questions;

    public QuestionSet(String... categories) {
        questions = Arrays.stream(categories)
                .map(this::createNewQuestionDeck)
                .collect(Collectors.toList());
    }

    private QuestionDeck createNewQuestionDeck(String category) {
        QuestionDeck questionDeck = new QuestionDeck(category);
        IntStream.range(0, 50).forEach(i -> questionDeck.add());
        return questionDeck;
    }

    public String questionFor(String category) {
        return questions.stream()
                .filter(questionDeck -> questionDeck.isCategory(category))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .next();
    }
}