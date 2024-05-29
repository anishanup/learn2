package test.com.math;

import org.junit.Assert;
import org.junit.Test;

import main.com.math.SquareMatrix;

public class SquareMatrixTest extends MatrixTest {

    @Test
    public void squareMatrix_constructor_validation() {
        squareMatrix_constructor_validation_impl(
            new int[][] {{ 1, 2 } }, 
            "Number of rows and columns in 'values' has to be the same.");
    }

    @Test
    public void getDeterminant_3x3_basic() {
        
        SquareMatrix matrix1 = new SquareMatrix(new int[][]
        {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        });

        int determinant = matrix1.getDeterminant();
        
        Assert.assertEquals(determinant, 0);
    }

    @Test
    public void getDeterminant_3x3_basic_two() {
        
        SquareMatrix matrix1 = new SquareMatrix(new int[][]
        {
            { 3, 5, 1 },
            { 2, 7, 6 },
            { 4, 9, 8 }
        });

        int determinant = matrix1.getDeterminant();
        
        Assert.assertEquals(determinant, 36);
    }

    @Test
    public void getDeterminant_4x4_basic() {
        
        SquareMatrix matrix1 = new SquareMatrix(new int[][]
        {
            {  1,  2,  3,  4 },
            {  5,  6,  7,  8 },
            {  9, 10, 11, 12 },
            { 13, 14, 15, 16 }
        });

        int determinant = matrix1.getDeterminant();
        
        Assert.assertEquals(determinant, 0);
    }

    
    private static void squareMatrix_constructor_validation_impl(int[][] values, String expectedMessage) {
        try {
            SquareMatrix m = new SquareMatrix(values);
            Assert.fail("This line must not be hit. Instead, execution must go to the catch block.");

        } catch (IllegalArgumentException ex) {
            catchExpectedException(ex, expectedMessage);
        }
    }
}
