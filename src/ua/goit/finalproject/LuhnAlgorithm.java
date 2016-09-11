package ua.goit.finalproject;

import java.util.ArrayList;

public class LuhnAlgorithm {
    public static int calculateSum(String card) {
        char[] cardChars = card.toCharArray();
        int[] cardInts = new int[cardChars.length];

        for (int i = 0; i < cardChars.length; i++) {
            cardInts[i] = Character.getNumericValue(cardChars[i]);
        }

        int sum = 0;

        for (int i = 0; i < cardInts.length; i++) {
            if (i % 2 == 0) {
                cardInts[i] *= 2;
                if (cardInts[i] > 9) {
                    cardInts[i] -= 9;
                }
            }
            sum += cardInts[i];
        }
        return sum;
    }

 public static ArrayList<String> generateCards(String bankID, String initCardNumber, int amountOfCards) {
        ArrayList<String> validCardsList = new ArrayList<>();

        int bankIDSum = calculateSum(bankID);
        long initCardNumberLong = Long.parseLong(initCardNumber);

        do {
            initCardNumberLong++;
            initCardNumber = String.format("%010d", initCardNumberLong);

            if (initCardNumber.length() > 10) break;

            int cardSum = calculateSum(initCardNumber);
            int finalSum = bankIDSum + cardSum;
            boolean cardMod10 = finalSum % 10 == 0;

            String smallCard = String.copyValueOf(initCardNumber.toCharArray(), 0, initCardNumber.length() - 1);
            String smallCardSum = String.valueOf((calculateSum(smallCard) + bankIDSum) * 9);

            char lastCharSmallCard = smallCardSum.charAt(smallCardSum.length() - 1);
            int lastIntSmallCard = Character.getNumericValue(lastCharSmallCard);

            char lastCharFullCard = initCardNumber.charAt(initCardNumber.length() - 1);
            int lastIntFullCard = Character.getNumericValue(lastCharFullCard);

            StringBuilder validCard = new StringBuilder();

            if (cardMod10 && lastIntSmallCard == lastIntFullCard) {
                validCard.append(bankID).append(initCardNumber);
                validCardsList.add(validCard.toString());
                amountOfCards--;
            }
        } while (amountOfCards > 0);

        return validCardsList;
    }
}
