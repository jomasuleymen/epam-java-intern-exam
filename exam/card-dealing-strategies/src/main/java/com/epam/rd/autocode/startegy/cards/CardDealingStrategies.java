package com.epam.rd.autocode.startegy.cards;

import java.util.List;

public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        List<CardStackWithCount> additionalStacks = List.of(
                new CardStackWithCount(CardStack.COMMUNITY, 5)
        );

        return new CardDealingStrategyImpl(2, additionalStacks);
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new CardDealingStrategyImpl(5);
    }

    public static CardDealingStrategy bridgeCardDealingStrategy() {
        return new CardDealingStrategyImpl(13);
    }

    public static CardDealingStrategy foolCardDealingStrategy() {
        List<CardStackWithCount> additionalStacks = List.of(
                new CardStackWithCount(CardStack.TRUMP_CARD, 1)
        );

        return new CardDealingStrategyImpl(6, additionalStacks);
    }

}
