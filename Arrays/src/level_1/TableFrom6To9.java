package level_1;

import java.util.*;

public class TableFrom6To9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int[] table = new int[4];
        for (int i = 6; i <= 9; i++) {
            int res = num * i;
            table[i - 6] = res;
            System.out.println(num + " * " + i + " = " + res);
        }
    }
}