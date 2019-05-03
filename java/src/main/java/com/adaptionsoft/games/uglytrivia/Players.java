package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> listOfPlayers;
    private int currentPlayerIndex;

    public Players() {
        listOfPlayers = new ArrayList<>();
        currentPlayerIndex = 0;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public int numberOfPlayers() {
        return listOfPlayers.size();
    }

    public void add(Player player) {
        listOfPlayers.add(player);
    }

    public String getNameByIndex(int index) {
        return listOfPlayers.get(index).getName();
    }

    public Player getCurrent() {
        return listOfPlayers.get(currentPlayerIndex);
    }

    public void next() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= listOfPlayers.size())
            currentPlayerIndex = 0;
    }
}
