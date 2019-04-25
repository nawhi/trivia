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

    public QuestionSelector() {
        popQuestions = new LinkedList();
        scienceQuestions = new LinkedList();
        sportsQuestions = new LinkedList();
        rockQuestions = new LinkedList();

        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    private String createRockQuestion(int index){
        return "Rock Question " + index;
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
