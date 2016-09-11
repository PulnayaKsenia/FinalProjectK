package ua.goit.finalproject;

import ua.goit.finalproject.Cards.Card;
import ua.goit.finalproject.Exceptions.WrongCardNumberException;
import ua.goit.finalproject.Exceptions.WrongCardTypeException;
import ua.goit.finalproject.Exceptions.WrongGenerateCardException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dear user!\n" +
                "This program is used for validating a variety of identification numbers to protect against " +
                "accidental errors; and for generation number of new card.\n" +
                "If you need to do this choose VALIDATE or GENERATE or enter OUT for exit:");

        for (; ; ) {
            System.out.println("Choose VALIDATE or GENERATE or enter OUT for exit:");
            String choice = ScannerUtils.readString();

            try {
                switch (choice) {
                    case "VALIDATE":
                        printValidationParams();
                        validate();
                        break;
                    case "GENERATE":
                        printGenerationParams();
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

    private static void printValidationParams() {
        System.out.println("For validation of card number choose kind of card:\n" +
                "Bank,\nDiscount,\nIMEI,\nSSC,\nRailway");
    }

    private static void validate() throws WrongCardTypeException, WrongCardNumberException {
        CardUtils cardUtils = new CardUtils();
        Card card = cardUtils.selectCard(ScannerUtils.readString());

        System.out.println("Enter number of your card: ");
        String number = ScannerUtils.readString();
        int amount = number.length();

        String cardNumber = cardUtils.getNumberOfCard(number, amount, card);
        card.setCardNumber(cardNumber);

        int sum = LuhnAlgorithm.calculateSum(cardNumber);
        boolean isMod10 = card.isCardMod10(sum);

        System.out.println(isMod10 ? card.getCardInfo() + " is correct!" :
                card.getCardInfo() + " is not correct");
    }

    private static void printGenerationParams() {
        System.out.println("For generating new cards you would need to enter 6 digits of unique bank ID " +
                "and 10 numerals of last issued card.\nIf you need to create new cards from scratch, " +
                "enter 10 zeros.\n");
    }

    private static void generate() throws WrongGenerateCardException {
        CardUtils cardUtils = new CardUtils();

        System.out.println("Enter 6 numerals of bank ID:");
        String bankId = ScannerUtils.readString();
        String bankID = cardUtils.getBankID(bankId);

        System.out.println("Enter 10 numerals of last issued card:");
        String issued = ScannerUtils.readString();
        String issuedCard = cardUtils.getIssuedCard(issued);

        System.out.println("Enter amount of cards you'd like to generate:");
        int sum = ScannerUtils.readNumber();
        int amount = cardUtils.getAmount(sum);

        ArrayList<String> validNumbers = LuhnAlgorithm.generateCards(bankID, issuedCard, amount);
        String validCards = cardUtils.generateCards(validNumbers, amount);

        System.out.println(validCards);
    }
}
