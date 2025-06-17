package level_2;
import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {
        final int EMPLOYEE_COUNT = 10;
        double[] salaries = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonuses = new double[EMPLOYEE_COUNT];
        double[] newSalaries = new double[EMPLOYEE_COUNT];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            while (true) {
                System.out.print("Enter salary for employee " + (i + 1) + ": ");
                salaries[i] = scanner.nextDouble();
                if (salaries[i] < 0) {
                    System.out.println("Invalid salary. Please enter a positive value.");
                    continue;
                }
                break;
            }

            while (true) {
                System.out.print("Enter years of service for employee " + (i + 1) + ": ");
                yearsOfService[i] = scanner.nextDouble();
                if (yearsOfService[i] < 0) {
                    System.out.println("Invalid years of service. Please enter a positive value.");
                    continue;
                }
                break;
            }
        }

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * 0.05;
            } else {
                bonuses[i] = salaries[i] * 0.02;
            }
            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        
        scanner.close();
    }
}