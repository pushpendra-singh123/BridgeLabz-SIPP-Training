package level_1;
import java.util.Scanner;

public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();  
        String result = (number % 5 == 0) ? "Yes" : "No";
        System.out.println("Is the number " + number + " divisible by 5? " + result);
    }
}
