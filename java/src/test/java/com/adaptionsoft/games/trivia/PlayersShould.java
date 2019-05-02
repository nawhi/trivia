package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Players;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayersShould {

    @Test
    public void add_a_new_player() {
        Players players = new Players();

        players.add(new Player("Player 1"));

        assertEquals(1, players.numberOfPlayers());
    }
}