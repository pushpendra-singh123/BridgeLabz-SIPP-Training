package level_1;

import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];

        // Get 5 numbers from user
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            nums[i] = sc.nextInt();
        }

        // Check for positive/negative/zero and even/odd
        for (int i = 0; i < 5; i++) {
            if (nums[i] > 0) {
                if (nums[i] % 2 == 0) {
                    System.out.println(nums[i] + " is Positive and Even");
                } else {
                    System.out.println(nums[i] + " is Positive and Odd");
                }
            } else if (nums[i] < 0) {
                System.out.println(nums[i] + " is Negative");
            } else {
                System.out.println(nums[i] + " is Zero");
            }
        }

        // Compare first and last
        if (nums[0] == nums[4]) {
            System.out.println("First and last numbers are equal");
        } else if (nums[0] > nums[4]) {
            System.out.println("First number is greater than last");
        } else {
            System.out.println("First number is less than last");
        }
    }
}