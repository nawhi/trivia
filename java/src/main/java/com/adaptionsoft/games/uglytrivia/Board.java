package com.adaptionsoft.games.uglytrivia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {
    int[] places = new int[6];
    private Map<Player, Integer> playerPlaces = new HashMap<>();

    public Board() {
    }

    public Board(Player... players) {
        Arrays.stream(players)
                .forEach(player -> playerPlaces.put(player, 0));
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
        int currentPlace = playerPlaces.get(player);
        int newPlace = (currentPlace + roll) % 12;
        playerPlaces.put(player, newPlace);
    }

    int getPlayerPlace(int playerId) {
        return places[playerId];
    }

    int getPlayerPlace(Player player) {
        return playerPlaces.get(player);
    }
}