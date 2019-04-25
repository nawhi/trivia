package com.adaptionsoft.games.uglytrivia;

public class QuestionSelector {
    private final QuestionDeck popQuestions;
    private QuestionDeck scienceQuestions;
    private QuestionDeck sportsQuestions;
    private QuestionDeck rockQuestions;

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
