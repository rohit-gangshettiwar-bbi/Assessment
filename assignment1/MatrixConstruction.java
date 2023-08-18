
import java.util.Scanner;

public class MatrixConstruction { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
       
        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();
       
        System.out.print("Enter the number of columns: ");
        int numCols = scanner.nextInt();
       
        int[] rowSum = new int[numRows];
        int[] colSum = new int[numCols];
       
        System.out.println("Enter rowSum values:");
        for (int i = 0; i < numRows; i++) { 
            rowSum[i] = scanner.nextInt();
       
        System.out.println("Enter colSum values:");
        for (int i = 0; i < numCols; i++) {
            colSum[i] = scanner.nextInt();
        }
       
        int[][] matrix = constructMatrix(rowSum, colSum);
       
        System.out.println("Generated Matrix:");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
   
    public static int[][] constructMatrix(int[] rowSum, int[] colSum) { 
        int numRows = rowSum.length;
        int numCols = colSum.length;
        int[][] matrix = new int[numRows][numCols];
       
        for (int i = 0; i < numRows; i++) { 
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = Math.min(rowSum[i], colSum[j]);  
                colSum[j] -= matrix[i][j];
            }
        }
       
        return matrix;
    }
}

