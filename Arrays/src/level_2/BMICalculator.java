package level_2;
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        int numberOfPersons;
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        numberOfPersons = scanner.nextInt();

        double[] weights = new double[numberOfPersons];
        double[] heights = new double[numberOfPersons];
        double[] bmi = new double[numberOfPersons];
        String[] weightStatus = new String[numberOfPersons];

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.print("Enter weight for person " + (i + 1) + ": ");
            weights[i] = scanner.nextDouble();
            while (weights[i] < 0) {
                System.out.print("Please enter a positive weight: ");
                weights[i] = scanner.nextDouble();
            }

            System.out.print("Enter height for person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            while (heights[i] < 0) {
                System.out.print("Please enter a positive height: ");
                heights[i] = scanner.nextDouble();
            }

            bmi[i] = calculateBMI(weights[i], heights[i]);
            weightStatus[i] = determineWeightStatus(bmi[i]);
        }

        System.out.println("Height\tWeight\tBMI\tStatus");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s%n", heights[i], weights[i], bmi[i], weightStatus[i]);
        }

        scanner.close();
    }

    private static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    private static String determineWeightStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}