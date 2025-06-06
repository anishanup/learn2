package test.com.math;

import org.junit.Assert;
import org.junit.Test;

import main.com.math.Matrix;
import main.com.math.MatrixComparator;
import main.com.math.MatrixConstants;

public class MatrixComparatorTest {

    @Test
    public void compare_matrices_dimension_mismatch() {
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 0, 1 }
        });
        Matrix matrix2 = new Matrix(new double[][]
        {
            { 0 },
            { 1 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(matrix1, matrix2), 1);
    }

    @Test
    public void compare_basic() {
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 0, 1 }
        });
        Matrix matrix2 = new Matrix(new double[][]
        {
            { 0, 1 },
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(matrix1, matrix2), 0);
    }

    @Test
    public void compare_basic_two() {
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 0, 1 }
        });
        Matrix matrix2 = new Matrix(new double[][]
        {
            { 1, 0 },
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(matrix1, matrix2), 1);
    }
}
