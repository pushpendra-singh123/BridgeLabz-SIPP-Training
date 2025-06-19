package level_1;

import java.util.Scanner;

public class ArrayIndexDemo {

    public static void throwArrayIndex(String[] names, int index) {
        System.out.println(names[index]);
    }

    public static void handleArrayIndex(String[] names, int index) {
        try {
            System.out.println(names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index to access: ");
        int index = sc.nextInt();
        // throwArrayIndex(names, index);
        handleArrayIndex(names, index);
    }
}

