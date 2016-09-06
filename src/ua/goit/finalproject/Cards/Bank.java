package ua.goit.finalproject.Cards;

public class Bank extends Card {
    public Bank(String cardNumber) {
        super.cardNumber = cardNumber;
    }

    public Bank() {
    }

    @Override
    public String getCardType() {
        return "Bank Card";
    }

    @Override
    public int getAmountOfNumbers() {
        return 16;
    }

    @Override
    public String toString() {
        return super.cardNumber;
    }
}
