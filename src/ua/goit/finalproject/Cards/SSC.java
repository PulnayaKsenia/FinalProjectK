package ua.goit.finalproject.Cards;

import ua.goit.finalproject.Cards.Card;

public class SSC extends Card {
    @Override
    public String getCardType() {
        return "SSC";
    }

    @Override
    public int getAmountOfNumbers() {
        return 9;
    }
}
