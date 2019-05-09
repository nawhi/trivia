package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class BoardShould {

    @Test
    public void start_players_at_place_zero() {
        Board board = new Board(new Player("chet"), new Player("faker"), new Player("sue"));
        int numberOfPlayers = 3;
        IntStream.range(0, numberOfPlayers).forEach(i ->
                assertEquals(0, board.getPlayerPlace(i)));
    }

    @Test
    public void move_a_player_by_the_roll_amount() {
        Player chet = new Player("chet");
        Player faker = new Player("faker");
        Board board = new Board(chet, faker);

        board.movePlayer(chet, 1);

        assertEquals(1, board.getPlayerPlace(chet));
    }
}