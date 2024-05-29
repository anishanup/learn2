package main.com.math;

public class SquareMatrix extends Matrix {

    public SquareMatrix(int[][] values) {
        super(values);

        if (getRowCount() != getColumnCount()) {
            throw new IllegalArgumentException("Number of rows and columns in 'values' has to be the same.");
        }
    }

    // Uses the getDeterminantOperation helper method to return the determinant of a matrix.
    public int getDeterminant() {
        return getDeterminantOperation(this.get());
    }

    // getDeterminant helper method.
    // This method takes in a square matrix and returns the determinant.
    // This is a private helper method because the method that is using this will use an instance of Matrix 
    // and will have no parameters.

    // If you don't pass in a square matrix, it will result in an error.
    // If you pass in null, it will result in an error.
    private static int getDeterminantOperation(int[][] matrixValues) {

        int rowCount = matrixValues.length; 
        int colCount = rowCount; // validated in ctor of this class

        if (rowCount == 1) {
            return matrixValues[0][0];
        }
        
        if(rowCount == 2) {
            return getDeterminantOperation2x2(matrixValues);
        }

        int[][] newMatrixValues = new int[rowCount - 1][colCount - 1];
        int sum = 0;
        
        // 1, 2, 3
        // 4, 5, 6
        // 7, 8, 9

        // 1 * | 5, 6 | - 2 * | 4, 6 | + 3 * | 4, 5 |
        //     | 8, 9 |       | 7, 9 |       | 7, 8 |

        for (int a = 0; a < colCount; a++) {
            for (int b = 0; b < rowCount - 1; b++) {
                int d = 0;
                for (int c = 0; c < colCount; c++) {
                    if (c != a) {
                        newMatrixValues[b][d] = matrixValues[b + 1][c];
                        d++;
                    }
                }
            }

            int multiplier = a % 2 == 0 ? 1 : -1;
            int subResult = matrixValues[0][a] * getDeterminantOperation(newMatrixValues);
            sum += multiplier * subResult;
        }
        
        return sum;
    }

    private static int getDeterminantOperation2x2(int[][] matrixValues) {
        int det = matrixValues[0][0] * matrixValues[1][1] - matrixValues[0][1] * matrixValues[1][0];
        return det;
    }
}
