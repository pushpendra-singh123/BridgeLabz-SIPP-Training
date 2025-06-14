package level_3;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int physics = sc.nextInt();
        int chemistry = sc.nextInt();
        int maths = sc.nextInt();

        int total = physics + chemistry + maths;
        double percentage = total / 3.0;

        System.out.println("Average Marks: " + percentage);

        if (percentage >= 80) {
            System.out.println("Grade: A");
            System.out.println("Remarks: Level 4, above agency-normalized standards");
        } else if (percentage >= 70) {
            System.out.println("Grade: B");
            System.out.println("Remarks: Level 3, at agency-normalized standards");
        } else if (percentage >= 60) {
            System.out.println("Grade: C");
            System.out.println("Remarks: Level 2, below, but approaching agency-normalized standards");
        } else if (percentage >= 50) {
            System.out.println("Grade: D");
            System.out.println("Remarks: Level 1, well below agency-normalized standards");
        } else if (percentage >= 40) {
            System.out.println("Grade: E");
            System.out.println("Remarks: Level 1-, too below agency-normalized standards");
        } else {
            System.out.println("Grade: F");
            System.out.println("Remarks: Remedial standards");
        }
    }
}
