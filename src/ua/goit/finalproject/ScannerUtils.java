package ua.goit.finalproject;

import java.util.Scanner;

public class ScannerUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readString() {
        return SCANNER.next();
    }

    public static int readNumber() {
        return SCANNER.nextInt();
    }
}
