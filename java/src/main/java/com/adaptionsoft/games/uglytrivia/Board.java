package com.adaptionsoft.games.uglytrivia;

public class Board {
    int[] places = new int[6];

    public Board() {
    }

    void movePlayer(int roll, int currentPlayerIndex) {
        places[currentPlayerIndex] = places[currentPlayerIndex] + roll;
        if (places[currentPlayerIndex] > 11)
            places[currentPlayerIndex] = places[currentPlayerIndex] - 12;
    }

    int getPlayerPlace(int currentPlayerIndex) {
        return places[currentPlayerIndex];
    }

    void initialisePlayerAt(int playerIndex) {
        places[playerIndex] = 0;
    }
}