package level_1;

import java.util.Scanner;

public class NumberFormatDemo {

    public static void throwNumberFormat(String text) {
        int num = Integer.parseInt(text);
        System.out.println("Number: " + num);
    }

    public static void handleNumberFormat(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println("Parsed Number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to parse as number: ");
        String input = sc.next();
        // throwNumberFormat(input);
        handleNumberFormat(input);
    }
}

