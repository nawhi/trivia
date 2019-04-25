package com.adaptionsoft.games.uglytrivia;

import java.util.Set;

public class QuestionSelector {
    private final QuestionDeck popQuestions;
    private final QuestionDeck scienceQuestions;
    private final QuestionDeck sportsQuestions;
    private final QuestionDeck rockQuestions;
    Set<QuestionDeck> questions;

    public QuestionSelector() {
        popQuestions = new QuestionDeck("Pop");
        scienceQuestions = new QuestionDeck("Science");
        sportsQuestions = new QuestionDeck("Sports");
        rockQuestions = new QuestionDeck("Rock");

        for (int i = 0; i < 50; i++) {
            popQuestions.add();
            scienceQuestions.add();
            sportsQuestions.add();
            rockQuestions.add();
        }
        questions = Set.of(popQuestions, scienceQuestions, sportsQuestions, rockQuestions);
    }

    public String questionFor(String category) {
        for (QuestionDeck questionDeck : questions) {
            if (questionDeck.isCategory(category))
                return questionDeck.next();
        }
        throw new IllegalStateException();
    }
}
