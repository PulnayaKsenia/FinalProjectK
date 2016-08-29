package ua.goit.finalproject.Cards;

import ua.goit.finalproject.Cards.Card;

public class IMEI extends Card {
    @Override
    public String getCardType() {
        return "IMEI";
    }

    @Override
    public int getAmountOfNumbers() {
        return 15;
    }
}
