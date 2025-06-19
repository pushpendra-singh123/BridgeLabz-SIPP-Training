package level_1;

import java.util.Scanner;

public class CaseConverter {

    public static String toUpperCaseManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static String toLowerCaseManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static boolean areStringsEqual(String s1, String s2) {
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String manualUpper = toUpperCaseManual(text);
        String builtInUpper = text.toUpperCase();
        System.out.println("Uppercase equal: " + areStringsEqual(manualUpper, builtInUpper));

        String manualLower = toLowerCaseManual(text);
        String builtInLower = text.toLowerCase();
        System.out.println("Lowercase equal: " + areStringsEqual(manualLower, builtInLower));
    }
}

