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

    @Test
    public void get_a_player_by_index() {
        // given a PLayesr object with more htan one player
        // when we ask for a player by index
        // then the right Player object should be returned
        Players players = new Players();

        Player expectedPlayer = new Player("player 1");


        players.add(new Player("some other player"));
        players.add(new Player("player 1"));

        Player actualPlayer = players.getByIndex(1);

        assertEquals(actualPlayer, expectedPlayer);
    }
}