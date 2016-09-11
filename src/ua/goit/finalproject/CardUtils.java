package ua.goit.finalproject;

import ua.goit.finalproject.Cards.*;
import ua.goit.finalproject.Exceptions.WrongCardNumberException;
import ua.goit.finalproject.Exceptions.WrongCardTypeException;
import ua.goit.finalproject.Exceptions.WrongAmountException;

import java.util.ArrayList;

public class CardUtils {
    public Card selectCard(String card) throws WrongCardTypeException {
        try {
            CardsEnum cards = CardsEnum.valueOf(card);
            switch (cards) {
                case Bank:
                    return new Bank();
                case Discount:
                    return new Discount();
                case IMEI:
                    return new IMEI();
                case SSC:
                    return new SSC();
                case Railway:
                    return new Carriage();
            }
        } catch (Exception e) {
            throw new WrongCardTypeException("Enter correct card type!");
        }
        return null;
    }

    public void checkBankID(String bankID) throws WrongCardNumberException {
        if (bankID.length() != 6) {
            throw new WrongCardNumberException("Make sure you enter 6 numerals!");
        }
    }

    public void checkIssuedCard(String issuedCard) throws WrongCardNumberException {
        if (issuedCard.length() != 10) {
            throw new WrongCardNumberException("Make sure you enter 10 numerals!");
        }
    }

    public void checkDigits(String input) throws WrongCardNumberException {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new WrongCardNumberException("Make sure you enter only numbers!");
            }
        }
    }

    public void checkAmount(int amount) throws WrongAmountException {
        if (amount <= 0) {
            throw new WrongAmountException("Amount should be a positive number!");
        }
    }

    public String generateCards(ArrayList<String> validNumbers, int amount) {
        ArrayList<Card> validCards = new ArrayList<>();

        for (String cardNumber : validNumbers) {
            validCards.add(new Bank(cardNumber));
        }

        if (validCards.size() == amount) {
            return "New valid cards are " + validCards.toString() + ".";
        } else {
            return "It was not possible to generate " + amount + " cards.\n" +
                    "There was not enough combinations for this amount.\n" +
                    "New possible numbers of cards are:\n" + validCards.toString();
        }
    }
}
