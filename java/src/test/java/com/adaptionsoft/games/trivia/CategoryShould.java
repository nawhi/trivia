package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Category;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryShould {
    @Test
    public void add_questions_to_the_end_of_the_que_and_retrieve_from_front() {
        Category category = new Category("Pop");

        category.addQuestion();
        category.addQuestion();
        category.addQuestion();

        assertEquals("Pop Question 0", category.nextQuestion());
        assertEquals("Pop Question 1", category.nextQuestion());
    }
}
