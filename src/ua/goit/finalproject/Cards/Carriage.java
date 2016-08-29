package ua.goit.finalproject.Cards;

import ua.goit.finalproject.Cards.Card;

public class Carriage extends Card {
    @Override
    public String getCardType() {
        return "Railway";
    }

    @Override
    public int getAmountOfNumbers() {
        return 8;
    }
}
