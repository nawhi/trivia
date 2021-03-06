package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class GoldenMaster {

    private static final int TEST_SEED = 12345;

    @Test
    public void run_with_predetermined_random_numbers() throws IOException {
        Path goldenMasterPath = Paths.get("./goldenMaster.txt");
        Path outputPath = Paths.get("./output.txt");

        PrintStream originalOut = System.out;

        try (FileOutputStream outputStream = new FileOutputStream("./output.txt")){
            System.setOut(new PrintStream(new BufferedOutputStream(outputStream), true));

            Random rand = new Random(TEST_SEED);
            GameRunner.run(rand);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.setOut(originalOut);
        }

        List<String> goldenMaster = Files.readAllLines(goldenMasterPath);
        List<String> output = Files.readAllLines(outputPath);

        assertEquals(goldenMaster, output);
    }
}
