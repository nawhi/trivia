package com.adaptionsoft.games.uglytrivia;

public class QuestionSelector {
    private Game game;

    public QuestionSelector(Game game) {
        this.game = game;
    }

    public String invoke(String category) {

        if (category == "Pop") {
            return game.popQuestions.removeFirst().toString();
        }
        if (category == "Science") {
            return game.scienceQuestions.removeFirst().toString();
        }
        if (category == "Sports") {
            return game.sportsQuestions.removeFirst().toString();
        }
        if (category == "Rock") {
            return game.rockQuestions.removeFirst().toString();
        }
        throw new IllegalArgumentException();
    }
}
