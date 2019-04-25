package com.adaptionsoft.games.uglytrivia;

import static java.util.Arrays.asList;

public class QuestionSelector {
    final QuestionSet questionSet = new QuestionSet("Pop", "Science");
    private final QuestionDeck popQuestions;
    private final QuestionDeck scienceQuestions;
    private final QuestionDeck sportsQuestions;
    private final QuestionDeck rockQuestions;


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
        questionSet.questions = asList(popQuestions, scienceQuestions, sportsQuestions, rockQuestions);
    }

    public String questionFor(String category) {
        return questionSet.nextForCategory(category);
    }
}
