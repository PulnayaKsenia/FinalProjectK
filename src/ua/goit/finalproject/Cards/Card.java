package ua.goit.finalproject.Cards;

import ua.goit.finalproject.Exceptions.WrongCardNumberException;

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

    public void checkAmount(int amount) throws WrongCardNumberException {
        if (amount != getAmountOfNumbers()) {
            throw new WrongCardNumberException("Number of numerals of " + getCardType() + " must be " + getAmountOfNumbers() + "!");
        }
    }

    public boolean isCardMod10(int sum) {
        return sum % 10 == 0;
    }

    public String getCardInfo() {
        return "Your " + getCardType() + " with number " + getCardNumber();
    }
}

