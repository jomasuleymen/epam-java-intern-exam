package com.epam.rd.autocode.factory.plot.plots;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.Plot;

import java.text.MessageFormat;

public class ClassicDisneyPlot implements Plot {

    private final Character hero;
    private final Character beloved;
    private final Character villain;

    private final String plotTemplate = "{0} is young and adorable. {0} and {1} love each other. {2} interferes with their happiness, but loses in the end.";

    public ClassicDisneyPlot(Character hero, Character beloved, Character villain) {
        this.hero = hero;
        this.beloved = beloved;
        this.villain = villain;
    }

    @Override
    public String asText() {
        return MessageFormat.format(plotTemplate, hero.name(), beloved.name(), villain.name());
    }
}
