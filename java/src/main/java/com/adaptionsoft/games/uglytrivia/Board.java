package com.adaptionsoft.games.uglytrivia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Board {
    private Map<Player, Integer> positions = new HashMap<>();

    Board(Player... players) {
        Arrays.stream(players)
                .forEach(player -> positions.put(player, 0));
    }

    void movePlayer(Player player, int roll) {
        int currentPlace = positions.get(player);
        int newPlace = (currentPlace + roll) % 12;
        positions.put(player, newPlace);
    }

    int getPlayerPlace(Player player) {
        return positions.get(player);
    }
}