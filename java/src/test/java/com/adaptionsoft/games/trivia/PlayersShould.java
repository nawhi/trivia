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
        String expectedPlayerName = "player 1";
        players.add(new Player(expectedPlayerName));

        assertEquals(players.getNameByIndex(1), expectedPlayerName);
    }
}