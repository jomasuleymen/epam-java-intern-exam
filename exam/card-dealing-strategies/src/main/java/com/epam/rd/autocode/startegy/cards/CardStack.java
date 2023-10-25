package com.epam.rd.autocode.startegy.cards;

public enum CardStack {
    COMMUNITY("Community"),
    REMAINING("Remaining"),
    TRUMP_CARD("Trump card"),

    PLAYER("Player");

    private final String name;

    CardStack(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}