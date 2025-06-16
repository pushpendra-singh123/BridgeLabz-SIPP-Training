package level_1;

import java.util.*;

public class MatrixTo1DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element at (" + i + "," + j + "): ");
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] array = new int[rows * cols];
        int index = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                array[index++] = val;
            }
        }
        System.out.println("1D Array: " + Arrays.toString(array));
    }
}