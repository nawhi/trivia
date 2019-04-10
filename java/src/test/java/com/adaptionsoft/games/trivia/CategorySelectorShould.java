package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.CategorySelector;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
@RunWith(JUnitParamsRunner.class)
public class CategorySelectorShould {

    @Test
    @Parameters({
            "0|Pop",
            "1|Science",
            "2|Sports",
            "3|Rock",
            "4|Pop",
            "5|Science",
            "6|Sports",
            "7|Rock",
            "8|Pop",
            "9|Science",
            "10|Sports",
            "11|Rock"
    })
    public void selects_category(int place, String expectedCategory) {
        CategorySelector categorySelector = new CategorySelector();
        assertEquals(expectedCategory, categorySelector.invoke(place));
    }

}
