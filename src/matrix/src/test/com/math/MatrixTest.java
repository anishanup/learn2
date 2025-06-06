package test.com.math;

import org.junit.Assert;
import org.junit.Test;

import main.com.math.Matrix;
import main.com.math.MatrixComparator;
import main.com.math.MatrixConstants;
import main.com.math.MatrixFactory;

public class MatrixTest {

    @Test
    public void constructor_validation() {

        constructor_validation_impl(null, "'values' must not be null.");
        constructor_validation_impl(new double[0][0], "'values' must not be empty.");

        constructor_validation_impl(0, 1, new double[] {}, "'rowCount' must be greater than 0.");
        constructor_validation_impl(1, 0, new double[] {}, "'columnCount' must be greater than 0.");
        constructor_validation_impl(1, 1, null, "'values' must not be null.");
        constructor_validation_impl(1, 1, new double[] { 1, 1 }, "'rowCount' * 'columnCount' must be equal to 'values.length'.");
        constructorValidationImpl(0, 1, "'rowCount' must be greater than 0.");
        constructorValidationImpl(1, 0, "'columnCount' must be greater than 0.");


        double[] input = new double[] { 1, 2, 3, 4, 5, 6 };
        Matrix m = new Matrix(2, 3, input);

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { input[0], input[1], input[2] },
            { input[3], input[4], input[5] },
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(m, comparisionMatrix), 0);
    }

    @Test
    public void add_basic() {

        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix matrix2 = new Matrix(new double[][]
        {
            { 5, 6 },
            { 7, 8 }
        });

        Matrix result = matrix1.add(matrix2);

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 6, 8 },
            { 10, 12 },
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    @Test
    public void add_matrices_dimension_mismatch() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1, 2 }
        });

        Matrix matrix2 = new Matrix(new double[][]
        {
            { 5 },
            { 6 }
        });

        try {
            matrix1.add(matrix2);
            Assert.fail("IllegalArgumentException must be thrown since the dimensions of the 2 matrices are not same.");

        } catch (IllegalArgumentException ex) {
            String s = ex.getMessage();
            boolean expected = s.startsWith("Dimensions");
            Assert.assertTrue(expected);
        }
    }

    @Test
    public void add_null_input() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix matrix2 = null;

        try {
            matrix1.add(matrix2);
            Assert.fail("IllegalArgumentException must be thrown since one or both the matrices are null.");

        } catch (IllegalArgumentException ex) {
            String s = ex.getMessage();
            boolean expected = s.startsWith("Input");
            Assert.assertTrue(expected);
        }
    }

    @Test
    public void subtract_basic() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 5, 6 },
            { 7, 8 }
        });

        Matrix matrix2 = new Matrix(new double[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix result = matrix1.subtract(matrix2);

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 4, 4 },
            { 4, 4 },
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    @Test
    public void subtract_matrices_dimension_mismatch() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1, 2 }
        });

        Matrix matrix2 = new Matrix(new double[][]
        {
            { 5 },
            { 6 }
        });

        try {
            matrix1.subtract(matrix2);
            Assert.fail("IllegalArgumentException must be thrown since the dimensions of the 2 matrices are not same.");

        } catch (IllegalArgumentException ex) {
            String s = ex.getMessage();
            boolean expected = s.startsWith("Dimensions");
            Assert.assertTrue(expected);
        }
    }

    @Test
    public void subtract_null_input() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix matrix2 = null;

        try {
            matrix1.subtract(matrix2);
            Assert.fail("IllegalArgumentException must be thrown since one or both the matrices are null.");

        } catch (IllegalArgumentException ex) {
            String s = ex.getMessage();
            boolean expected = s.startsWith("Input");
            Assert.assertTrue(expected);
        }
    }

    @Test
    public void multiply_basic() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix matrix2 = new Matrix(new double[][]
        {
            { 5, 6 },
            { 7, 8 }
        });

        Matrix result = matrix1.multiply(matrix2);

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 19, 22 },
            { 43, 50 },
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    @Test
    public void multiply_basic_two() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 5, 6 }
        });

        Matrix matrix2 = new Matrix(new double[][]
        {
            { 1 },
            { 2 }
        });

        Matrix result = matrix1.multiply(matrix2);

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 17 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    @Test
    public void multiply_basic_three() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 5 },
            { 6 }
        });

        Matrix matrix2 = new Matrix(new double[][]
        {
            { 1, 2 }
        });

        Matrix result = matrix1.multiply(matrix2);

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 5, 10 },
            { 6, 12 },
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    @Test
    public void multiply_basic_four() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1 }
        });

        Matrix matrix2 = new Matrix(new double[][]
        {
            { 5 }
        });

        Matrix result = matrix1.multiply(matrix2);

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 5 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    @Test
    public void multiply_matrices_dimension_mismatch() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 2, 3, 4 },
            { 5, 6, 7 }
        });

        Matrix matrix2 = new Matrix(new double[][]
        {
            { 1, 2, 3 }
        });

        try {
            matrix1.multiply(matrix2);
            Assert.fail("IllegalArgumentException must be thrown since the dimensions of the 2 matrices are not same.");

        } catch (IllegalArgumentException ex) {
            String s = ex.getMessage();
            boolean expected = s.startsWith("The");
            Assert.assertTrue(expected);
        }
    }

    @Test
    public void multiply_null_input() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix matrix2 = null;

        try {
            matrix1.multiply(matrix2);
            Assert.fail("IllegalArgumentException must be thrown since one or both the matrices are null.");

        } catch (IllegalArgumentException ex) {
            String s = ex.getMessage();
            boolean expected = s.startsWith("Input");
            Assert.assertTrue(expected);
        }
    }

    @Test
    public void transpose_basic() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix result = matrix1.transpose();

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 1, 3 },
            { 2, 4 },
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    @Test
    public void transpose_basic_two() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1, 2 }
        });

        Matrix result = matrix1.transpose();

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 1 },
            { 2 },
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    @Test
    public void transpose_basic_three() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1 }
        });

        Matrix result = matrix1.transpose();

        Matrix comparisionMatrix = new Matrix(new double[][]
        {
            { 1 }
        });

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    @Test
    public void transpose_basic_zeroes() {
        
        Matrix matrix1 = MatrixFactory.zeroMatrix(2);

        Matrix result = matrix1.transpose();

        Matrix comparisionMatrix = MatrixFactory.zeroMatrix(2);

        MatrixComparator comparator = new MatrixComparator(MatrixConstants.ZERO_DELTA);

        Assert.assertEquals(comparator.compare(result, comparisionMatrix), 0);
    }

    @Test
    public void getRow() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 0, 1, 2, 3 },
            { 3, 6, 7, 1 }
        });

        double[] row = matrix1.getRow(0);

        for (int i = 0; i < matrix1.get()[0].length; i++) {
            Assert.assertEquals(i, row[i], MatrixConstants.ZERO_DELTA);
        }
    }

    @Test
    public void getColumn() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 0, 2 },
            { 1, 9 },
            { 2, 4 },
            { 3, 7 }
        });

        double[] col = matrix1.getColumn(0);

        for (int i = 0; i < matrix1.get()[0].length; i++) {
            Assert.assertEquals(i, col[i], MatrixConstants.ZERO_DELTA);
        }
    }

    @Test
    public void setValue() {
        
        Matrix matrix1 = new Matrix(new double[][]
        {
            { 1, 2 },
            { 2, 9 },
        });

        matrix1.setValue(1, 1, 502);
        double[][] values = matrix1.get();
        Assert.assertEquals(502, values[1][1], MatrixConstants.ZERO_DELTA);
    }

    
    private static void constructor_validation_impl(double[][] values, String expectedMessage) {
        try {
            Matrix m = new Matrix(values);
            Assert.fail("This line must not be hit. Instead, execution must go to the catch block.");

        } catch (IllegalArgumentException ex) {
            catchExpectedException(ex, expectedMessage);
        }
    }

    private static void constructor_validation_impl(int rowCount, int columnCount, double[] values, String expectedMessage) {
        try {
            Matrix m = new Matrix(rowCount, columnCount, values);
            Assert.fail("This line must not be hit. Instead, execution must go to the catch block.");

        } catch (IllegalArgumentException ex) {
            catchExpectedException(ex, expectedMessage);
        }
    }

    private static void constructorValidationImpl(int rows, int columns, String expectedMessage) {
        try {
            Matrix m = new Matrix(rows, columns);
            Assert.fail("This line must not be hit. Instead, execution must go to the catch block.");

        } catch (IllegalArgumentException ex) {
            catchExpectedException(ex, expectedMessage);
        }
    }

    private static void assertEqualsImpl(double[] expectedVals, double[] actualVals, double[] deltaVals) {
        for (int i = 0; i < expectedVals.length; i++) {
            Assert.assertEquals(expectedVals[i], actualVals[i], deltaVals[i]);
        }
    }

    protected static void catchExpectedException(IllegalArgumentException ex, String expectedMessage) {
        String s = ex.getMessage();
        boolean expected = s.startsWith(expectedMessage);
        Assert.assertTrue(expected);
    }
}
