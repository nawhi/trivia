package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.Players;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PlayersShould {

    @Test
    public void add_a_new_player() {
        Players players = playersInstanceWith(new Player("player 1"));
        assertEquals(1, players.numberOfPlayers());
    }

    @Test
    public void get_a_player_by_index() {
        String expectedPlayerName = "target player";
        final Player player1 = new Player("some other player");
        final Player expectedPlayer = new Player(expectedPlayerName);
        Players players = playersInstanceWith(player1, expectedPlayer);

        assertEquals(expectedPlayerName, players.getNameByIndex(1));
    }

    @Test
    public void get_next_player() {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Players players = playersInstanceWith(player1, player2);

        players.next();

        assertEquals(new Player("Player2"), players.getCurrent());
    }

    private static Players playersInstanceWith(Player... players) {
        Players playersInstance = new Players();

        Arrays.stream(players).forEach(playersInstance::add);

        return playersInstance;
    }
}