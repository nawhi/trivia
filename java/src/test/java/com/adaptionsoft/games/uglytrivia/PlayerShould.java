package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerShould {

    @Test
    public void increment_the_purse() {
        Player player = new Player("player 1");
        player.incrementPurse();
        assertEquals(1, player.getPurse());
    }
}