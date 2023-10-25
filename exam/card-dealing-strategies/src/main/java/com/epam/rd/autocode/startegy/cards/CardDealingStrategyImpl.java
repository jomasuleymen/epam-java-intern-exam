package com.epam.rd.autocode.startegy.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardDealingStrategyImpl implements CardDealingStrategy {
    private final List<CardStackWithCount> additionalStacks;
    private final int CARDS_PER_PLAYER;

    public CardDealingStrategyImpl(int cardsPerPlayer, List<CardStackWithCount> additionalStacks) {
        this.additionalStacks = additionalStacks;
        CARDS_PER_PLAYER = cardsPerPlayer;
    }

    public CardDealingStrategyImpl(int cardsPerPlayer) {
        this.additionalStacks = new ArrayList<>();
        CARDS_PER_PLAYER = cardsPerPlayer;
    }


    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> result = new HashMap<>();

        dealCardToPlayers(deck, result, players);
        dealCardToAdditionalStacks(deck, result);

        if (deck.size() > 0) {
            result.put(CardStack.REMAINING.toString(), deck.restCards());
        }

        return result;
    }

    private void dealCardToAdditionalStacks(Deck deck, Map<String, List<Card>> result) {
        for (CardStackWithCount additionalStack : additionalStacks) {
            List<Card> stackCards = new ArrayList<>();
            String stackName = additionalStack.getStack().toString();
            int cardCount = additionalStack.getCount();

            for (int i = 0; i < cardCount; i++) {
                Card dealedCard = deck.dealCard();
                if (dealedCard == null) break;

                stackCards.add(dealedCard);
            }

            if (!stackCards.isEmpty()) {
                result.put(stackName, stackCards);
            } else {
                return;
            }
        }
    }

    private void dealCardToPlayers(Deck deck, Map<String, List<Card>> result, int players) {
        int playersRound = CARDS_PER_PLAYER;
        List<List<Card>> playersCard = new ArrayList<>();

        for (int i = 0; i < players; i++) {
            playersCard.add(new ArrayList<>());
        }

        while (playersRound > 0 && deck.size() > 0) {
            for (int i = 0; i < players; i++) {
                List<Card> playerCards = playersCard.get(i);
                Card dealedCard = deck.dealCard();
                if (dealedCard == null) break;

                playerCards.add(dealedCard);
            }

            playersRound -= 1;
        }

        for (int i = 0; i < players; i++) {
            result.put(CardStack.PLAYER + " " + (i + 1), playersCard.get(i));
        }
    }
}
