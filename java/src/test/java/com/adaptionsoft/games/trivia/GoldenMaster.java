package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Test;

import java.util.Random;

public class GoldenMaster {

    private static final int TEST_SEED = 12345;

    @Test
    public void run_with_predetermined_random_numbers() {
        Random rand = new Random(TEST_SEED);
        GameRunner.run(rand);
    }
}
