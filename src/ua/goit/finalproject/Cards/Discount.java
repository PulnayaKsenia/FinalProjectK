package ua.goit.finalproject.Cards;

import ua.goit.finalproject.Cards.Card;

public class Discount extends Card {
    @Override
    public String getCardType() {
        return "Discount";
    }

    @Override
    public int getAmountOfNumbers() {
        return 15;
    }
}
