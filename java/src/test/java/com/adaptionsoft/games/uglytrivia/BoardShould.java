package com.adaptionsoft.games.uglytrivia;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class BoardShould {

    private Player chet;
    private Player faker;
    private Player sue;

    @Before
    public void setUp() throws Exception {
        chet = new Player("chet");
        faker = new Player("faker");
        sue = new Player("sue");
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

        assertEquals(1, board.getPlayerPlace(chet));
    }
}