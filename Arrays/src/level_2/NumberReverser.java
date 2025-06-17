package level_2;
import java.util.Scanner;
public class NumberReverser {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Find the count of digits in the number
        int count = 0;
        int temp = number;
        while (temp != 0) {
            temp /= 10;
            count++;
        }
        
        // Create an array to store the digits
        int[] digits = new int[count];
        temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        
        // Display the digits in reverse order
        System.out.print("Reversed number: ");
        for (int digit : digits) {
            System.out.print(digit);
        }
        System.out.println();
        
        scanner.close();
    }
}