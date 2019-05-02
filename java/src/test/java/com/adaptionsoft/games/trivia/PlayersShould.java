package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Player;
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

    @Test
    public void get_a_player_by_index() {
        Players players = new Players();

        players.add(new Player("some other player"));
        players.add(new Player("player 1"));

        assertEquals(players.getByIndex(1), new Player("player 1"));
    }
}