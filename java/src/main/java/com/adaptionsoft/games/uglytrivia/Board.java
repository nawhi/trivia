package com.adaptionsoft.games.uglytrivia;

import java.util.HashMap;
import java.util.Map;

public class Board {
    int[] places = new int[6];
    private Map<Player, Integer> newPlaces = new HashMap<>();

    public Board() {
    }

    public Board(Player... players) {
    }

    void initialisePlayerAt(int playerId) {
        places[playerId] = 0;
    }

    void movePlayer(int roll, int playerId) {
        places[playerId] = places[playerId] + roll;
        if (places[playerId] > 11)
            places[playerId] = places[playerId] - 12;
    }

    void movePlayer(Player player, int roll) {
        newPlaces.put(player, roll);
    }

    int getPlayerPlace(int playerId) {
        return places[playerId];
    }

    int getPlayerPlace(Player player) {
        return newPlaces.get(player);
    }
}