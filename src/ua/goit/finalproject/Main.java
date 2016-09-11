package ua.goit.finalproject;

import ua.goit.finalproject.Cards.Card;
import ua.goit.finalproject.Exceptions.WrongCardNumberException;
import ua.goit.finalproject.Exceptions.WrongCardTypeException;
import ua.goit.finalproject.Exceptions.WrongAmountException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dear user!\n" +
                "This program is used for validating a variety of identification numbers to protect against " +
                "accidental errors; and for generation number of new card.");

        for (; ; ) {
            System.out.println("Choose VALIDATE or GENERATE or enter OUT for exit:");
            String choice = ScannerUtils.readString();

            try {
                switch (choice) {
                    case "VALIDATE":
                        validate();
                        break;
                    case "GENERATE":
                        generate();
                        break;
                    case "OUT":
                        System.exit(1);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validate() throws WrongCardTypeException, WrongCardNumberException, WrongAmountException {
        System.out.println("For validation of card number choose kind of card:\n" +
                "Bank,\nDiscount,\nIMEI,\nSSC,\nRailway");

        CardUtils cardUtils = new CardUtils();
        Card card = cardUtils.selectCard(ScannerUtils.readString());

        System.out.println("Enter number of your card: ");
        String number = ScannerUtils.readString();
        cardUtils.checkDigits(number);

        int amount = number.length();
        card.checkAmount(amount);

        int sum = LuhnAlgorithm.calculateSum(number);
        boolean isMod10 = card.isCardMod10(sum);

        System.out.println(isMod10 ? card.getCardInfo() + " is correct!" : card.getCardInfo() + " is not correct!");
    }

    private static void generate() throws WrongAmountException, WrongCardNumberException {
        System.out.println("For generating new cards you would need to enter 6 digits of unique bank ID " +
                "and 10 numerals of last issued card.\nIf you need to create new cards from scratch, " +
                "enter 10 zeros.\n");

        CardUtils cardUtils = new CardUtils();

        System.out.println("Enter 6 numerals of bank ID:");
        String bankId = ScannerUtils.readString();
        cardUtils.checkDigits(bankId);
        cardUtils.checkBankID(bankId);

        System.out.println("Enter 10 numerals of last issued card:");
        String issued = ScannerUtils.readString();
        cardUtils.checkDigits(issued);
        cardUtils.checkIssuedCard(issued);

        System.out.println("Enter amount of cards you'd like to generate:");
        int amount = ScannerUtils.readNumber();
        cardUtils.checkAmount(amount);

        ArrayList<String> validNumbers = LuhnAlgorithm.generateCards(bankId, issued, amount);
        String validCards = cardUtils.generateCards(validNumbers, amount);

        System.out.println(validCards);
    }
}
