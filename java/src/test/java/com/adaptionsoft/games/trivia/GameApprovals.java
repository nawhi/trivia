package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameApprovals {
    @Test
    public void add_a_player() {
        String output = catchSystemOutFor(() -> new Game().add("Test"));
        Approvals.verify(output);
    }

    @Test
    public void add_two_players() {
        String output = catchSystemOutFor(() -> {
            Game game = new Game();
            game.add("Test1");
            game.add("Test2");
        });
        Approvals.verify(output);
    }

    @Test
    public void a_player_rolls_a_one() {
        String output = catchSystemOutFor(() -> {
            Game game = new Game();

            game.add("Test");

            game.roll(1);
        });

        Approvals.verify(output);
    }

    @Test
    public void a_player_rolls_a_six_and_answers_correctly() {
        String output = catchSystemOutFor(() -> {
            Game game = new Game();

            game.add("Test");

            game.roll(6);
            game.wasCorrectlyAnswered();
        });

        Approvals.verify(output);
    }

    private static String catchSystemOutFor(Runnable action) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(baos);

        PrintStream originalOut = System.out;
        System.setOut(outputStream);

        try {
            action.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.flush();
            System.setOut(originalOut);
        }

        return baos.toString();
    }
}
