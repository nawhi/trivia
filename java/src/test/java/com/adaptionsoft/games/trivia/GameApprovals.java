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
