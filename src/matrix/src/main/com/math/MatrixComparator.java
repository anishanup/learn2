package main.com.math;

import java.util.Comparator;

public class MatrixComparator implements Comparator<Matrix> {
    private final double tolerance;

    public MatrixComparator(double tolerance) {
        this.tolerance = tolerance;
    }

    // compare method returns 0 if matrices equal and 1 if parameters not equal
    @Override
    public int compare(Matrix matrixA, Matrix matrixB) {

        if (matrixA == null && matrixB == null) {
            return 0;
        }

        if (matrixA == null || matrixB == null) {
            return 1;
        }

        double[][] valuesA = matrixA.get();
        double[][] valuesB = matrixB.get();

        if (valuesA.length != valuesB.length || valuesA[0].length != valuesB[0].length) {
            return 1;
        }

        for (int r = 0; r < valuesA.length; r++) {
            for (int c = 0; c < valuesA[0].length; c++) {

                double diff = Math.abs(valuesA[r][c] - valuesB[r][c]);

                if (diff > this.tolerance) { 
                    return 1;
                }
            }
        }

        return 0;
    }
}