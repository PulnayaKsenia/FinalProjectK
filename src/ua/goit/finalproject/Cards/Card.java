package ua.goit.finalproject.Cards;

public abstract class Card {
    String cardNumber;

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public abstract String getCardType();

    public abstract int getAmountOfNumbers();

    public boolean checkAmount(int amount) {
        if (amount != getAmountOfNumbers()) {
            System.out.println("Number of numerals of " + getCardType() + " must be " + getAmountOfNumbers() + "!");
        }
        return false;
    }

    public String getCardInfo() {
        return "Your " + getCardType() + " with number " + getCardNumber();
    }
}

