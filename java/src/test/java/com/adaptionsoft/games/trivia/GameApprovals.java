package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GameApprovals {
    @Test
    public void add_a_player() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(baos);
        System.setOut(outputStream);

        Game game = new Game();

        game.add("Test");

        System.out.flush();
        Approvals.verify(baos.toString());
    }
}
