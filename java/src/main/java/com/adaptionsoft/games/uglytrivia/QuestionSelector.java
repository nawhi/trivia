package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionSelector {
    private final QuestionDeck popQuestions;
    private QuestionDeck scienceQuestions;
    private QuestionDeck sportsQuestions;
    private QuestionDeck rockQuestions;

    public QuestionSelector(LinkedList popQuestions, LinkedList scienceQuestions, LinkedList sportsQuestions, LinkedList rockQuestions) {
        this.popQuestions = new QuestionDeck("Pop");
        this.popQuestions.questions = popQuestions;
        this.scienceQuestions = new QuestionDeck("Science");
        this.scienceQuestions.questions = scienceQuestions;

        this.sportsQuestions = new QuestionDeck("Sports");
        this.sportsQuestions.questions = sportsQuestions;

        this.rockQuestions = new QuestionDeck("Rock");
        this.rockQuestions.questions = rockQuestions;

    }

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
    }

    public String questionFor(String category) {
        if (category.equals("Pop"))
            return popQuestions.next();
        if (category.equals("Science"))
            return scienceQuestions.next();
        if (category.equals("Sports"))
            return sportsQuestions.next();
        if (category.equals("Rock"))
            return rockQuestions.next();
        throw new IllegalStateException();
    }
}
