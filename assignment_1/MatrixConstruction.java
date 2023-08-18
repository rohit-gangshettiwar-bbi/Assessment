
import java.util.Scanner;//Use to input scanner class take input from user

public class MatrixConstruction { // class declaration 
    public static void main(String[] args) { // Main method entry point of execution 
        Scanner scanner = new Scanner(System.in); 
       
        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();// read integer valuefrom user and stored it in numRows
       
        System.out.print("Enter the number of columns: ");
        int numCols = scanner.nextInt();
       
        int[] rowSum = new int[numRows];// Assign value to arrays rowSum and 
        int[] colSum = new int[numCols];
       
        System.out.println("Enter rowSum values:");
        for (int i = 0; i < numRows; i++) { 
            rowSum[i] = scanner.nextInt();// store values in rowSum arrays
        }
       
        System.out.println("Enter colSum values:");
        for (int i = 0; i < numCols; i++) {
            colSum[i] = scanner.nextInt();// store values in rowSum arrays
        }
       
        int[][] matrix = constructMatrix(rowSum, colSum);// return 2d matrix stored in matrix variable.
       
        System.out.println("Generated Matrix:");// to iterate through each element of matrix array and print its values
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
   
    public static int[][] constructMatrix(int[] rowSum, int[] colSum) { //take 2 parameter and return 2d array
        int numRows = rowSum.length;
        int numCols = colSum.length;
        int[][] matrix = new int[numRows][numCols];//2x2 numRows 3 8 numCols  4 7
       
        for (int i = 0; i < numRows; i++) { 
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = Math.min(rowSum[i], colSum[j]);  //
                rowSum[i] -= matrix[i][j];
                colSum[j] -= matrix[i][j];
            }
        }
       
        return matrix;
    }
}

