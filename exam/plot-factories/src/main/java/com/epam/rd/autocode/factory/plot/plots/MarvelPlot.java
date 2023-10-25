package com.epam.rd.autocode.factory.plot.plots;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.EpicCrisis;
import com.epam.rd.autocode.factory.plot.Plot;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MarvelPlot implements Plot {

    private final Character[] heroes;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    private final String plotTemplate = "{0} threatens the world. But {1} {3} on guard. So, no way that intrigues of {2} will bend the willpower of {4}.";

    public MarvelPlot(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public String asText() {
        boolean isSingleHero = heroes.length == 1;
        String heroesJoinText = getHeroesText();

        return MessageFormat.format(plotTemplate,
                epicCrisis.name(), heroesJoinText, villain.name(),
                isSingleHero ? "is" : "are",
                isSingleHero ? "the inflexible hero" : "inflexible heroes");
    }

    private String getHeroesText() {
        String heroPrefix = "the brave";
        String separator = ", ";

        // join characters name with ", " separator
        String heroesJoinText = Arrays.stream(heroes)
                .map(character -> heroPrefix + " " + character.name())
                .collect(Collectors.joining(separator));

        // replace last separator to "and"
        int lastIndex = heroesJoinText.lastIndexOf(separator);
        if (lastIndex >= 0) {
            heroesJoinText = heroesJoinText.substring(0, lastIndex) + " and " + heroesJoinText.substring(lastIndex + separator.length());
        }

        return heroesJoinText;
    }
}
