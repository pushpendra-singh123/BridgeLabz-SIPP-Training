package level_2;
import java.util.Scanner;

public class YoungestTallestFinder {
    public static void main(String[] args) {
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Input ages
        for (int i = 0; i < friends.length; i++) {
            ages[i] = getValidInput("Enter age for " + friends[i] + ": ");
        }

        // Input heights
        for (int i = 0; i < friends.length; i++) {
            heights[i] = getValidHeight("Enter height for " + friends[i] + ": ");
        }

        // Find youngest and tallest
        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        // Display results
        System.out.println("Youngest friend: " + friends[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + friends[tallestIndex] + " (Height: " + heights[tallestIndex] + ")");
    }

    private static int getValidInput(String prompt) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // clear invalid input
            }
        }
        return input;
    }

    private static double getValidHeight(String prompt) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                if (input >= 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive height.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // clear invalid input
            }
        }
        return input;
    }

    private static int findYoungest(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    private static int findTallest(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }
}