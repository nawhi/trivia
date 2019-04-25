package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.QuestionSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionSetShould {
    @Test
    public void create_questions_for_a_category() {
        QuestionSet questionSet = new QuestionSet("Pop", "Science");
        assertEquals("Pop Question 0", questionSet.nextForCategory("Pop"));
    }

    @Test
    public void create_questions_for_multiple_categories() {
        QuestionSet questionSet = new QuestionSet("Pop", "Science");
        assertEquals("Pop Question 0", questionSet.nextForCategory("Pop"));
        assertEquals("Science Question 0", questionSet.nextForCategory("Science"));
    }

    @Test
    public void creates_50_questions_for_a_category() {
        QuestionSet questionSet = new QuestionSet("Science", "Pop");
        for(int i = 0; i < 50; i++)
        {
            assertEquals("Pop Question " + i, questionSet.nextForCategory("Pop"));
        }
    }

    @Test
    public void creates_50_questions_for_each_category() {
        QuestionSet questionSet = new QuestionSet("Cat1", "Cat2");
        for(int i = 0; i < 50; i++)
        {
            assertEquals("Cat1 Question " + i, questionSet.nextForCategory("Cat1"));
            assertEquals("Cat2 Question " + i, questionSet.nextForCategory("Cat2"));
        }
    }
}
