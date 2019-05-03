package com.adaptionsoft.games.uglytrivia;

import java.util.Objects;

public class Player {
    private String name;
    private int purse;

    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
    }

    public void incrementPurse() {
        purse++;
    }

    public int getPurse() {
        return purse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
