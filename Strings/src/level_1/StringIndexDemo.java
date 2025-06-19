package level_1;

import java.util.Scanner;

public class StringIndexDemo {

    public static void throwStringIndex() {
        String text = "Hello";
        System.out.println(text.charAt(10));
    }

    public static void handleStringIndex() {
        try {
            String text = "Hello";
            System.out.println(text.charAt(10));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        // throwStringIndex();
        handleStringIndex();
    }
}

