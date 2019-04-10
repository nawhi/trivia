package com.adaptionsoft.games.uglytrivia;

public class CategorySelector {
    public String invoke(int place) {
        if (place > 11)
            throw new IllegalArgumentException("place should be less than 12");

        switch(place % 4)
        {
            case 0:  return "Pop";
            case 1:  return "Science";
            case 2:  return "Sports";
            default: return "Rock";
        }
    }
}
