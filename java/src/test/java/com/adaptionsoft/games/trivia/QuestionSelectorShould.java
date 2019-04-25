package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.QuestionSelector;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class QuestionSelectorShould {

    @Test
    @Parameters({
            "Pop|Pop Question 0",
            "Science|Science Question 0",
            "Sports|Sports Question 0",
            "Rock|Rock Question 0"
    })
    public void selects_a_pop_question_for_pop_category(String category, String expectedQuestion) {
        assertEquals(expectedQuestion, new QuestionSelector().questionFor(category));
    }
}