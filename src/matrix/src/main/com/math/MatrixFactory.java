package main.com.math;

public class MatrixFactory {
    public static Matrix zeroMatrix(int rowCount, int columnCount) {
        return new Matrix(new double[rowCount][columnCount]);
    }

    public static SquareMatrix zeroMatrix(int rowOrColumnCount) {
        return new SquareMatrix(new double[rowOrColumnCount][rowOrColumnCount]);
    }

    public static SquareMatrix identityMatrix(int rowOrColumnCount) {
        double[][] identityMatrixValues = new double[rowOrColumnCount][rowOrColumnCount];

        for (int r = 0; r < rowOrColumnCount; r++) {
            for (int c = 0; c < rowOrColumnCount; c++) {
                if (r == c) {
                    identityMatrixValues[r][c] = 1;
                }
            }
        }

        return new SquareMatrix(identityMatrixValues);
    }
}
