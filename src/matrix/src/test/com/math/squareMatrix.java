package test.com.math;

import main.com.math.Matrix;

public class squareMatrix extends Matrix {

    public int[][] matrixValues;

    public squareMatrix(int[][] values) {
        super(values);
        matrixValues = values;

        if (getRowCount() != getColumnCount()) {
            throw new IllegalArgumentException("Number of rows and columns in 'matrixValues' has to be the same.");
        }
    }

    // Uses the getDeterminantOperation helper method to return the determinant of a matrix.
    public int getDeterminant() {
        return getDeterminantOperation(this.matrixValues);
    }

    // getDeterminant helper method.
    // This method takes in a square matrix and returns the determinant.
    // This is a private helper method because the method that is using this will use an instance of Matrix 
    // and will have no parameters.

    // If you don't pass in a square matrix, it will result in an error.
    // If you pass in null, it will result in an error.
    private static int getDeterminantOperation(int[][] matrixValues) {

        if (matrixValues == null) {
            throw new IllegalArgumentException("matrixValues must not be null.");
        }

        if (matrixValues.length != matrixValues[0].length) {
            throw new IllegalArgumentException("Number of rows in 'matrixValues' should number of columns in 'matrixValues'.");
        }

        if(matrixValues.length == 2) {
            return matrixValues[0][0] * matrixValues[1][1] - matrixValues[0][1] * matrixValues[1][0];
        }
        int[][] newMatrixValues = new int[matrixValues.length - 1][matrixValues.length - 1];
        int sum = 0;
        
        for (int a = 0; a < matrixValues.length; a++) {
            for (int b = 0; b < matrixValues.length - 1; b++) {
                int d = 0;
                for (int c = 0; c < matrixValues.length; c++) {
                    if (c != a) {
                        newMatrixValues[b][d] = matrixValues[b + 1][c];
                        d++;
                    }
                }
            }

            if (a % 2 == 0) {
                sum += matrixValues[0][a] * getDeterminantOperation(newMatrixValues);
            }
            else {
                sum -= matrixValues[0][a] * getDeterminantOperation(newMatrixValues);
            }
        }
        return sum;
    }
}
