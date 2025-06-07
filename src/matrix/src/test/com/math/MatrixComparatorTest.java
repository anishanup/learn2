package test.com.math;

import org.junit.Assert;
import org.junit.Test;

import main.com.math.Matrix;
import main.com.math.MatrixComparator;
import main.com.math.MatrixConstants;

public class MatrixComparatorTest {

    @Test
    public void compare_null_imputs() {
        Matrix matrix1 = null;
        Matrix matrix2 = null;

        compareAndAssert(matrix1, matrix2, 0);
    }

    @Test
    public void compare_null_imput_with_regular_input() {
        Matrix matrix1 = null;
        Matrix matrix2 = new Matrix(new double[][]
        {
            { 0 },
            { 1 }
        });;

        compareAndAssert(matrix1, matrix2, 1);
    }

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

        compareAndAssert(matrix1, matrix2, 1);
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

        compareAndAssert(matrix1, matrix2, 0);
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

        compareAndAssert(matrix1, matrix2, 1);
    }
    
    private void compareAndAssert(Matrix expected, Matrix actual, int expectedCompareResult) {
        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);
        int actualCompareResult = comparator.compare(expected, actual);
        
        Assert.assertEquals(expectedCompareResult, actualCompareResult);
    }
}
