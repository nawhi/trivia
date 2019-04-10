package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionSelector {
    private LinkedList popQuestions;
    private LinkedList scienceQuestions;
    private LinkedList sportsQuestions;
    private LinkedList rockQuestions;

    public QuestionSelector(LinkedList popQuestions, LinkedList scienceQuestions, LinkedList sportsQuestions, LinkedList rockQuestions) {
        this.popQuestions = popQuestions;
        this.scienceQuestions = scienceQuestions;
        this.sportsQuestions = sportsQuestions;
        this.rockQuestions = rockQuestions;
    }

    public String questionFor(String category) {
        if (category.equals("Pop"))
            return popQuestions.removeFirst().toString();
        if (category.equals("Science"))
            return scienceQuestions.removeFirst().toString();
        if (category.equals("Sports"))
            return sportsQuestions.removeFirst().toString();
        if (category.equals("Rock"))
            return rockQuestions.removeFirst().toString();
        throw new IllegalStateException();
    }
}
