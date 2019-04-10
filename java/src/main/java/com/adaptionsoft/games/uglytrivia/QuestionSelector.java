package com.adaptionsoft.games.uglytrivia;

public class QuestionSelector {
    private Game game;

    public QuestionSelector(Game game) {
        this.game = game;
    }

    public void invoke(String category) {
        if (category == "Pop")
            System.out.println(game.popQuestions.removeFirst());
        if (category == "Science")
            System.out.println(game.scienceQuestions.removeFirst());
        if (category == "Sports")
            System.out.println(game.sportsQuestions.removeFirst());
        if (category == "Rock")
            System.out.println(game.rockQuestions.removeFirst());
    }
}
