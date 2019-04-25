package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionSelector {
    private final QuestionDeck questionDeck;
    private QuestionDeck scienceQuestions;
    private QuestionDeck sportsQuestions;
    private QuestionDeck rockQuestions;

    public QuestionSelector(LinkedList popQuestions, LinkedList scienceQuestions, LinkedList sportsQuestions, LinkedList rockQuestions) {
        questionDeck = new QuestionDeck("Pop");
        this.questionDeck.questions = popQuestions;
        this.scienceQuestions = new QuestionDeck("Science");
        this.scienceQuestions.questions = scienceQuestions;

        this.sportsQuestions = new QuestionDeck("Sports");
        this.sportsQuestions.questions = sportsQuestions;

        this.rockQuestions = new QuestionDeck("Rock");
        this.rockQuestions.questions = rockQuestions;

    }

    public QuestionSelector() {
        questionDeck = new QuestionDeck("Pop");
        scienceQuestions = new QuestionDeck("Science");
        sportsQuestions = new QuestionDeck("Sports");
        rockQuestions = new QuestionDeck("Rock");

        for (int i = 0; i < 50; i++) {
            questionDeck.questions.addLast("Pop Question " + i);
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
            return questionDeck.questions.removeFirst().toString();
        if (category.equals("Science"))
            return scienceQuestions.questions.removeFirst().toString();
        if (category.equals("Sports"))
            return sportsQuestions.questions.removeFirst().toString();
        if (category.equals("Rock"))
            return rockQuestions.questions.removeFirst().toString();
        throw new IllegalStateException();
    }
}
