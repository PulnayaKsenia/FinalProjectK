package ua.goit.finalproject.Cards;

import ua.goit.finalproject.Exceptions.WrongAmountException;

public abstract class Card {
    String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public abstract String getCardType();

    public abstract int getAmountOfNumbers();

    public void checkAmount(int amount) throws WrongAmountException {
        if (amount != getAmountOfNumbers()) {
            throw new WrongAmountException("Number of numerals of " + getCardType() + " must be " + getAmountOfNumbers() + "!");
        }
    }

    public boolean isCardMod10(int sum) {
        return sum % 10 == 0;
    }

    public String getCardInfo() {
        return "Your " + getCardType() + " with number " + getCardNumber();
    }
}

