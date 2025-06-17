package level_2;
import java.util.Scanner;
public class LargestSecondLargest {
    public static void main(String[] args) {
        int number;
        int[] digits = new int[10];
        int index = 0;
        int maxDigit = 10;

        // Take user input for the number
        System.out.print("Enter a number: ");
        number = new java.util.Scanner(System.in).nextInt();

        // Extract digits and store them in the array
        while (number != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp;
            }
            digits[index++] = number % 10;
            number /= 10;
        }

        // Find the largest and second largest digits
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] < largest) {
                secondLargest = digits[i];
            }
        }

        // Display the results
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}