package ua.goit.finalproject;

import ua.goit.finalproject.Cards.*;
import ua.goit.finalproject.Exceptions.WrongCardNumberException;
import ua.goit.finalproject.Exceptions.WrongCardTypeException;

import java.util.ArrayList;

public class CardUtils {
    public Card selectCard() throws WrongCardTypeException {
        try {
            CardsEnum cards = CardsEnum.valueOf(ScannerUtils.readString());
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

    public String getNumberOfCard(String number, int amount, Card card) throws WrongCardNumberException {
        if (!checkDigits(number)) {
            throw new WrongCardNumberException("Make sure you enter only numbers!");
        } else if (card.checkAmount(amount)) {
        }
        return number;
    }

    public String getBankID(String bankID) {
        if (!checkDigits(bankID) | bankID.length() != 6) {
            System.out.println("Make sure you enter 6 numerals!");
        }
        return bankID;
    }

    public String getIssuedCard(String issuedCard) {
        if (!checkDigits(issuedCard) | issuedCard.length() != 10) {
            System.out.println("Make sure you enter 10 numerals!");
        }
        return issuedCard;
    }

    public boolean checkDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public int getAmount(int amount) {
        if (amount <= 0) {
            System.out.println("Amount should be a positive number!");
        }
        return amount;
    }

    public String generateCards(ArrayList<String> validNumbers, int amount) {
        ArrayList<Card> validCards = new ArrayList<>();

        for (String cardNumber : validNumbers) {
            validCards.add(new Bank(cardNumber));
        }

        if (validCards.size() == amount) {
            return "New valid cards are " + validCards.toString();
        } else
            return "It was not possible to generate " + amount + " cards.\n" +
                    "There was not enough combinations for this amount.\n" +
                    "New possible numbers of cards are:\n" + validCards.toString();
    }
}
