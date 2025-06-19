package level_1;

import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void throwIllegalArgument() {
        String text = "Java";
        System.out.println(text.substring(3, 2));
    }

    public static void handleIllegalArgument() {
        try {
            String text = "Java";
            System.out.println(text.substring(3, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
        }
    }

    public static void main(String[] args) {
        // throwIllegalArgument();
        handleIllegalArgument();
    }
}

