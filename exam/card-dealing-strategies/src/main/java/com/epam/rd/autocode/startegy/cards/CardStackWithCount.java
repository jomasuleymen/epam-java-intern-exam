package com.epam.rd.autocode.startegy.cards;

public class CardStackWithCount {
    private CardStack stack;
    private Integer count;

    public CardStackWithCount(CardStack stack, Integer count) {
        this.stack = stack;
        this.count = count;
    }

    public CardStack getStack() {
        return stack;
    }

    public void setStack(CardStack stack) {
        this.stack = stack;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

