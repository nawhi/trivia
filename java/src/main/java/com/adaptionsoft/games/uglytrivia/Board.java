package com.adaptionsoft.games.uglytrivia;

public class Board {
    int[] places = new int[6];

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

    int getPlayerPlace(int playerId) {
        return places[playerId];
    }
}