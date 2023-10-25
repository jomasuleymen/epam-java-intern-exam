package com.epam.rd.autocode.factory.plot;

import com.epam.rd.autocode.factory.plot.plots.ClassicDisneyPlot;
import com.epam.rd.autocode.factory.plot.plots.ContemporaryDisneyPlot;
import com.epam.rd.autocode.factory.plot.plots.MarvelPlot;

class PlotFactories {

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        return () -> new ClassicDisneyPlot(hero, beloved, villain);
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        return () -> new ContemporaryDisneyPlot(hero, epicCrisis, funnyFriend);
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        return () -> new MarvelPlot(heroes, epicCrisis, villain);
    }
}
