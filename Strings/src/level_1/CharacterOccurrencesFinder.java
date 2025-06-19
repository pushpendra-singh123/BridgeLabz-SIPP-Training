package level_1;

import java.util.Scanner;

public class CharacterOccurrencesFinder {

    public static int[] findCharacterIndexes(String text, char ch) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) count++;
        }

        int[] indexes = new int[count];
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) indexes[j++] = i;
        }
        return indexes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        int[] indexes = findCharacterIndexes(text, ch);
        System.out.print("Indexes: ");
        for (int index : indexes) {
            System.out.print(index + " ");
        }
    }
}

