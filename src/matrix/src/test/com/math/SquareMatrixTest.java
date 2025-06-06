package test.com.math;

import org.junit.Assert;
import org.junit.Test;

import main.com.math.*;

public class SquareMatrixTest extends MatrixTest {

    @Test
    public void squareMatrix_constructor_validation() {
        squareMatrixConstructorValidationImpl(
            new double[][] {{ 1, 2 } }, 
            "Number of rows and columns in 'values' has to be the same.");
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
        
        Assert.assertEquals(determinant, 0, MatrixConstants.ZERO_DELTA);
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
        
        Assert.assertEquals(determinant, 36, MatrixConstants.ZERO_DELTA);
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
        
        Assert.assertEquals(determinant, 0, MatrixConstants.ZERO_DELTA);
    }

    @Test
    public void getCofactorMatrix_1x1_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 1 }
        });

        SquareMatrix cofactorMatrix = matrix1.getCofactorMatrix();

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 1 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(cofactorMatrix, comparisionMatrix), 0);
    }

    @Test 
    public void getCofactorMatrix_2x2_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 1, 2 },
            { 3, 4 }
        });

        SquareMatrix cofactorMatrix = matrix1.getCofactorMatrix();

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 4, -3 },
            { -2, 1 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(cofactorMatrix, comparisionMatrix), 0);
    }

    @Test 
    public void getCofactorMatrix_2x2_zeroes() {
        SquareMatrix matrix1 = MatrixFactory.zeroMatrix(2);

        SquareMatrix cofactorMatrix = matrix1.getCofactorMatrix();

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 0, 0 },
            { 0, 0 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(cofactorMatrix, comparisionMatrix), 0);
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

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { -3, 6, -3 },
            { 6, -12, 6 },
            { -3, 6, -3 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(cofactorMatrix, comparisionMatrix), 0);
    }
    
    @Test
    public void getAdjointMatrix_1x1_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 1 }
        });

        SquareMatrix adjointMatrix = matrix1.getAdjointMatrix();

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 1 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(adjointMatrix, comparisionMatrix), 0);
    }

    @Test
    public void getAdjointMatrix_2x2_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 1, 2 },
            { 3, 4 }
        });

        SquareMatrix adjointMatrix = matrix1.getAdjointMatrix();

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 4, -2 },
            { -3, 1 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(adjointMatrix, comparisionMatrix), 0);
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

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { -3, 6, -3 },
            { 6, -12, 6 },
            { -3, 6, -3 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(adjointMatrix, comparisionMatrix), 0);
    }

    @Test
    public void getInverseMatrix_1x1_basic() {
        SquareMatrix matrix1 = new SquareMatrix(new double[][] {
            { 5 }
        });

        SquareMatrix inverseMatrix = matrix1.getInverseMatrix();
        Matrix result = matrix1.multiply(inverseMatrix);

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 1 },
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.IDEAL_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
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
            catchExpectedException(ex, "For computing the inverse, the 'determinant' should be a non-zero number.");
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

        Matrix comparisionMatrix = MatrixFactory.identityMatrix(2);

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.IDEAL_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
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

        Matrix comparisionMatrix = MatrixFactory.identityMatrix(3);

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.IDEAL_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    private static void squareMatrixConstructorValidationImpl(double[][] values, String expectedMessage) {
        try {
            SquareMatrix m = new SquareMatrix(values);
            Assert.fail("This line must not be hit. Instead, execution must go to the catch block.");

        } catch (IllegalArgumentException ex) {
            catchExpectedException(ex, expectedMessage);
        }
    }
}
