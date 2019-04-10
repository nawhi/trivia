package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionSelector {
    private LinkedList popQuestions;
    private LinkedList scienceQuestions;
    private LinkedList sportsQuestions;
    private LinkedList rockQuestions;
    private CategorySelector categorySelector;
    private int place;

    public QuestionSelector(LinkedList popQuestions, LinkedList scienceQuestions, LinkedList sportsQuestions, LinkedList rockQuestions, CategorySelector categorySelector, int place) {
        this.popQuestions = popQuestions;
        this.scienceQuestions = scienceQuestions;
        this.sportsQuestions = sportsQuestions;
        this.rockQuestions = rockQuestions;
        this.categorySelector = categorySelector;
        this.place = place;
    }

    public String invoke() {
        if (categorySelector.categoryFor(place) == "Pop")
            return popQuestions.removeFirst().toString();
        if (categorySelector.categoryFor(place) == "Science")
            return scienceQuestions.removeFirst().toString();
        if (categorySelector.categoryFor(place) == "Sports")
            return sportsQuestions.removeFirst().toString();
        if (categorySelector.categoryFor(place) == "Rock")
            return rockQuestions.removeFirst().toString();
        throw new IllegalStateException();
    }
}
