package test.com.math;

import org.junit.Assert;
import org.junit.Test;

import main.com.math.SquareMatrix;
import main.com.math.Matrix;

@SuppressWarnings("deprecation")
public class SquareMatrixTest extends MatrixTest {

    @Test
    public void squareMatrix_constructor_validation() {
        squareMatrix_constructor_validation_impl(
            new double[][] {{ 1, 2 } }, 
            "Number of rows and columns in 'values' has to be the same.");
        squareMatrix_constructor_validation_impl(4, 5, "Number of rows and columns in 'values' has to be the same.");
    }

    @Test
    public void getDeterminant_3x3_basic() {
        
        SquareMatrix matrix1 = new SquareMatrix(new double[][]
        {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        });

        double determinant = matrix1.getDeterminant();
        
        Assert.assertEquals(determinant, 0, 0);
    }

    @Test
    public void getDeterminant_3x3_basic_two() {
        
        SquareMatrix matrix1 = new SquareMatrix(new double[][]
        {
            { 3, 5, 1 },
            { 2, 7, 6 },
            { 4, 9, 8 }
        });

        double determinant = matrix1.getDeterminant();
        
        Assert.assertEquals(determinant, 36, 0);
    }

    @Test
    public void getDeterminant_4x4_basic() {
        
        SquareMatrix matrix1 = new SquareMatrix(new double[][]
        {
            {  1,  2,  3,  4 },
            {  5,  6,  7,  8 },
            {  9, 10, 11, 12 },
            { 13, 14, 15, 16 }
        });

        double determinant = matrix1.getDeterminant();
        
        Assert.assertEquals(determinant, 0, 0);
    }

    @Test
    public void getCofactorMatrix_1x1_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 1 }
        });

        SquareMatrix cofactorMatrix = matrix1.getCofactorMatrix();
        double[][] values = cofactorMatrix.get();

        Assert.assertEquals(values[0][0], 1, 0);
    }

    @Test 
    public void getCofactorMatrix_2x2_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 1, 2 },
            { 3, 4 }
        });

        SquareMatrix cofactorMatrix = matrix1.getCofactorMatrix();
        double[][] values = cofactorMatrix.get();

        Assert.assertEquals(values[0][0], 4, 0);
        Assert.assertEquals(values[0][1], -3, 0);
        Assert.assertEquals(values[1][0], -2, 0);
        Assert.assertEquals(values[1][1], 1, 0);
    }

    @Test 
    public void getCofactorMatrix_2x2_zeroes() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 0, 0 },
            { 0, 0 }
        });

        SquareMatrix cofactorMatrix = matrix1.getCofactorMatrix();
        double[][] values = cofactorMatrix.get();

        Assert.assertEquals(values[0][0], 0, 0);
        Assert.assertEquals(values[0][1], 0, 0);
        Assert.assertEquals(values[1][0], 0, 0);
        Assert.assertEquals(values[1][1], 0, 0);
    }

    @Test
    public void getCofactorMatrix_3x3_basic() {
        
        SquareMatrix matrix1 = new SquareMatrix(new double[][]
        {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        });

        SquareMatrix cofactorMatrix = matrix1.getCofactorMatrix();
        double[][] values = cofactorMatrix.get();
        
        Assert.assertEquals(-3, values[0][0], 0);
        Assert.assertEquals(6, values[0][1], 0);
        Assert.assertEquals(-3, values[0][2], 0);
        Assert.assertEquals(6, values[1][0], 0);
        Assert.assertEquals(-12, values[1][1], 0);
        Assert.assertEquals(6, values[1][2], 0);
        Assert.assertEquals(-3, values[2][0], 0);
        Assert.assertEquals(6, values[2][1], 0);
        Assert.assertEquals(-3, values[2][2], 0);
    }
    
    @Test
    public void getAdjointMatrix_1x1_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 1 }
        });

        SquareMatrix adjoinMatrix = matrix1.getAdjointMatrix();
        double[][] values = adjoinMatrix.get();

        Assert.assertEquals(values[0][0], 1, 0);
    }

    @Test
    public void getAdjointMatrix_2x2_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 1, 2 },
            { 3, 4 }
        });

        SquareMatrix adjointMatrix = matrix1.getAdjointMatrix();
        double[][] values = adjointMatrix.get();

        Assert.assertEquals(values[0][0], 4, 0);
        Assert.assertEquals(values[0][1], -2, 0);
        Assert.assertEquals(values[1][0], -3, 0);
        Assert.assertEquals(values[1][1], 1, 0);
    }

    @Test
    public void getAdjointMatrix_3x3_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][]
        {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        });

        SquareMatrix adjointMatrix = matrix1.getAdjointMatrix();
        double[][] values = adjointMatrix.get();
        
        Assert.assertEquals(-3, values[0][0], 0);
        Assert.assertEquals(6, values[0][1], 0);
        Assert.assertEquals(-3, values[0][2], 0);
        Assert.assertEquals(6, values[1][0], 0);
        Assert.assertEquals(-12, values[1][1], 0);
        Assert.assertEquals(6, values[1][2], 0);
        Assert.assertEquals(-3, values[2][0], 0);
        Assert.assertEquals(6, values[2][1], 0);
        Assert.assertEquals(-3, values[2][2], 0);
    }

    @Test
    public void getInverseMatrix_1x1_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 5 }
        });

        SquareMatrix inverseMatrix = matrix1.getInverseMatrix();
        Matrix result = matrix1.multiply(inverseMatrix);

        double[][] values = result.get();

        Assert.assertEquals(1, values[0][0], 0.00000001);
    }

    @Test
    public void getInverseMatrix_1x1_zero() {
        

        try {
            SquareMatrix matrix1 = new SquareMatrix(new double[][] {
                { 0 }
            });
            matrix1.getInverseMatrix();
            Assert.fail("This line must not be hit. Instead, execution must go to the catch block.");

        } catch (IllegalArgumentException ex) {
            catchExpectedException(ex, "'determinant' should be a non-zero number.");
        }
    }

    @Test
    public void getInverseMatrix_2x2_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 1, 2 },
            { 3, 4 }
        });

        SquareMatrix inverseMatrix = matrix1.getInverseMatrix();
        Matrix result = matrix1.multiply(inverseMatrix);

        double[][] values = result.get();

        Assert.assertEquals(1, values[0][0], 0.00000001);
        Assert.assertEquals(0, values[0][1], 0.00000001);
        Assert.assertEquals(0, values[1][0], 0.00000001);
        Assert.assertEquals(1, values[1][1], 0.00000001);
    }

    @Test
    public void getInverseMatrix_3x3_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 1, 7, -8 },
            { -6, 4, 6 },
            { 5, 3, -2 }
        });

        SquareMatrix inverseMatrix = matrix1.getInverseMatrix();
        Matrix result = matrix1.multiply(inverseMatrix);

        double[][] values = result.get();

        Assert.assertEquals(1, values[0][0], 0.00000001);
        Assert.assertEquals(0, values[0][1], 0.00000001);
        Assert.assertEquals(0, values[0][2], 0.00000001);
        Assert.assertEquals(0, values[1][0], 0.00000001);
        Assert.assertEquals(1, values[1][1], 0.00000001);
        Assert.assertEquals(0, values[1][2], 0.00000001);
        Assert.assertEquals(0, values[2][0], 0.00000001);
        Assert.assertEquals(0, values[2][1], 0.00000001);
        Assert.assertEquals(1, values[2][2], 0.00000001);
    }

    private static void squareMatrix_constructor_validation_impl(double[][] values, String expectedMessage) {
        try {
            SquareMatrix m = new SquareMatrix(values);
            Assert.fail("This line must not be hit. Instead, execution must go to the catch block.");

        } catch (IllegalArgumentException ex) {
            catchExpectedException(ex, expectedMessage);
        }
    }

    private static void squareMatrix_constructor_validation_impl(int rows, int columns, String expectedMessage) {
        try {
            SquareMatrix m = new SquareMatrix(rows, columns);
            Assert.fail("This line must not be hit. Instead, execution must go to the catch block.");

        } catch (IllegalArgumentException ex) {
            catchExpectedException(ex, expectedMessage);
        }
    }
}
