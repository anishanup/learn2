package test.com.math;

import org.junit.Assert;

import main.com.math.Matrix;
import main.com.math.MatrixComparator;

// Helper class to simplify comparing 2 matrices and asserting in UTs
public class MatrixAssert {
    public static void equals(Matrix expected, Matrix actual, double delta) {

        MatrixComparator comparator = new MatrixComparator(delta);
        Assert.assertEquals(comparator.compare(expected, actual), 0);
    }

    public static void equals(double[][] expected, Matrix actual, double delta) {
        
        Matrix expectedMatrix = new Matrix(expected);
        equals(expectedMatrix, actual, delta);        
    }

}
