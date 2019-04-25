package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.QuestionDeck;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionDeckShould  {
    @Test
    public void add_questions_to_the_end_of_the_que_and_retrieve_from_front() {
        QuestionDeck questionDeck = new QuestionDeck("Pop");

        questionDeck.add();
        questionDeck.add();
        questionDeck.add();

        assertEquals("Pop Question 0", questionDeck.next());
        assertEquals("Pop Question 1", questionDeck.next());
    }
}
