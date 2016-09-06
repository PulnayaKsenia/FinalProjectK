package ua.goit.finalproject.Cards;

public class Discount extends Card {
    @Override
    public String getCardType() {
        return "Discount Card";
    }

    @Override
    public int getAmountOfNumbers() {
        return 15;
    }
}
