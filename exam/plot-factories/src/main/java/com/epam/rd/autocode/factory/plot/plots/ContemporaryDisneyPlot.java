package com.epam.rd.autocode.factory.plot.plots;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.EpicCrisis;
import com.epam.rd.autocode.factory.plot.Plot;

import java.text.MessageFormat;

public class ContemporaryDisneyPlot implements Plot {

    private final Character hero;
    private final EpicCrisis epicCrisis;
    private final Character funnyFriend;

    private final String plotTemplate =
            "In the beginning, {0} feels a bit awkward and uncomfortable. " +
                    "But personal issue fades, when a big trouble comes - {1}. " +
                    "{0} stands up against it, but with no success at first. " +
                    "But then, by putting self together and with the help of friends, " +
                    "including spectacular, funny {2}, {0} restores the spirit, overcomes the crisis and gains gratitude and respect.";

    public ContemporaryDisneyPlot(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.funnyFriend = funnyFriend;
    }

    @Override
    public String asText() {
        return MessageFormat.format(plotTemplate, hero.name(), epicCrisis.name(), funnyFriend.name());
    }
}
