package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.Players;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;

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
    public void get_first_player_initially() {
        Player player1 = new Player("player 1");
        Player player2 = new Player("player 2");
        Players players = playersInstanceWith(player1, player2);

        assertEquals(new Player("player 1"), players.getCurrent());
    }

    @Test
    public void get_next_player() {
        Player player1 = new Player("player 1");
        Player player2 = new Player("player 2");
        Players players = playersInstanceWith(player1, player2);

        players.next();

        assertEquals(new Player("player 2"), players.getCurrent());
    }

    @Test
    public void wrap_around_when_final_player_reached() {
        Players players = playersInstanceWith(
                new Player("p1"),
                new Player("p2"),
                new Player("p3")
        );

        doNTimes(3, players::next);

        assertEquals(new Player("p1"), players.getCurrent());
    }

    private static void doNTimes(int n, Runnable callback) {
        IntStream.range(0, n).forEach(i -> callback.run());
    }

    private static Players playersInstanceWith(Player... players) {
        Players playersInstance = new Players();

        Arrays.stream(players).forEach(playersInstance::add);

        return playersInstance;
    }
}