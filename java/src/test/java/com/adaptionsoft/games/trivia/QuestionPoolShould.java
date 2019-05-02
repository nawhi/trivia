package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.QuestionPool;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionPoolShould {
    @Test
    public void create_questions_for_a_category() {
        QuestionPool questionPool = new QuestionPool("Pop", "Science");
        assertEquals("Pop Question 0", questionPool.questionFor("Pop"));
    }

    @Test
    public void create_questions_for_multiple_categories() {
        QuestionPool questionPool = new QuestionPool("Pop", "Science");
        assertEquals("Pop Question 0", questionPool.questionFor("Pop"));
        assertEquals("Science Question 0", questionPool.questionFor("Science"));
    }

    @Test
    public void creates_50_questions_for_a_category() {
        QuestionPool questionPool = new QuestionPool("Science", "Pop");
        for(int i = 0; i < 50; i++)
        {
            assertEquals("Pop Question " + i, questionPool.questionFor("Pop"));
        }
    }

    @Test
    public void creates_50_questions_for_each_category() {
        QuestionPool questionPool = new QuestionPool("Cat1", "Cat2");
        for(int i = 0; i < 50; i++)
        {
            assertEquals("Cat1 Question " + i, questionPool.questionFor("Cat1"));
            assertEquals("Cat2 Question " + i, questionPool.questionFor("Cat2"));
        }
    }
}
