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
            popQuestions.questions.addLast("Pop Question " + i);
            scienceQuestions.questions.addLast(("Science Question " + i));
            sportsQuestions.questions.addLast(("Sports Question " + i));
            rockQuestions.questions.addLast(createRockQuestion(i));
        }
    }

    private String createRockQuestion(int index){
        return "Rock Question " + index;
    }

    public String questionFor(String category) {
        if (category.equals("Pop"))
            return popQuestions.questions.removeFirst().toString();
        if (category.equals("Science"))
            return scienceQuestions.questions.removeFirst().toString();
        if (category.equals("Sports"))
            return sportsQuestions.questions.removeFirst().toString();
        if (category.equals("Rock"))
            return rockQuestions.questions.removeFirst().toString();
        throw new IllegalStateException();
    }
}
