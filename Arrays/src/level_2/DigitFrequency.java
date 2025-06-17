package level_2;
import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        // Convert the number to a string to easily access each digit
        String numberStr = Long.toString(number);
        int[] frequency = new int[10];

        // Count the frequency of each digit
        for (char digit : numberStr.toCharArray()) {
            frequency[digit - '0']++;
        }

        // Display the frequency of each digit
        System.out.println("Digit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Digit " + i + ": " + frequency[i]);
        }

        scanner.close();
    }
}