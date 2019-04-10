package com.adaptionsoft.games.uglytrivia;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class QuestionSelectorShould {

    private LinkedList popQuestions;
    private LinkedList scienceQuestions;
    private LinkedList sportsQuestions;
    private LinkedList rockQuestions;
    private QuestionSelector selector;

    @Before
    public void setUp() {
        popQuestions = new LinkedList(asList("pop question 1", "pop question 2"));
        scienceQuestions = new LinkedList(asList("science question 1", "science question 2"));
        sportsQuestions = new LinkedList(asList("sports question 1", "sports question 2"));
        rockQuestions = new LinkedList(asList("rock question 1", "rock question 2"));
        selector = new QuestionSelector(popQuestions, scienceQuestions, sportsQuestions, rockQuestions);
    }

    @Test
    @Parameters({
            "Pop|pop question 1",
            "Science|science question 1",
            "Sports|sports question 1",
            "Rock|rock question 1"
    })
    public void selects_a_pop_question_for_pop_category(String category, String expectedQuestion) {
        assertEquals(expectedQuestion, selector.questionFor(category));
    }
}