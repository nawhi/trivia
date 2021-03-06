package com.adaptionsoft.games.uglytrivia;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class BoardShould {

    private Player chet;
    private Player faker;

    @Before
    public void setUp() throws Exception {
        chet = new Player("chet");
        faker = new Player("faker");
    }

    @Test
    public void start_players_at_place_zero() {
        Board board = new Board(chet, faker);

        assertEquals(0, board.getPlayerPlace(chet));
        assertEquals(0, board.getPlayerPlace(faker));
    }

    @Test
    public void move_a_player_by_the_roll_amount() {
        Board board = new Board(chet, faker);

        board.movePlayer(chet, 1);
        board.movePlayer(chet, 1);

        assertEquals(2, board.getPlayerPlace(chet));
    }

    @Test
    public void have_a_size_of_twelve_and_wrap() {
        Board board = new Board(chet);

        board.movePlayer(chet, 6);
        board.movePlayer(chet, 6);

        assertEquals(0, board.getPlayerPlace(chet));
    }
}