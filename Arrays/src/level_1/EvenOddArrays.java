package level_1;

import java.util.*;

public class EvenOddArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int num = sc.nextInt();
        if (num <= 0) {
            System.out.println("Not a natural number");
            return;
        }
        int[] evens = new int[num / 2 + 1];
        int[] odds = new int[num / 2 + 1];
        int ei = 0, oi = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) evens[ei++] = i;
            else odds[oi++] = i;
        }
        System.out.println("Even numbers: " + Arrays.toString(Arrays.copyOf(evens, ei)));
        System.out.println("Odd numbers: " + Arrays.toString(Arrays.copyOf(odds, oi)));
    }
}