package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.Player;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> listOfPlayers;

    public Players() {
        listOfPlayers = new ArrayList<>();
    }

    public int numberOfPlayers() {
        return listOfPlayers.size();
    }

    public void add(Player player) {
        listOfPlayers.add(player);
    }

    public Player getByIndex(int index) {
        return listOfPlayers.get(index);
    }
}
