package test.com.math;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import main.com.math.Matrix;

public class MatrixTest {

    @Test
    public void constructor_validation() {

        constructor_validation_impl(null, "'values' must not be null.");
        constructor_validation_impl(new int[0][0], "'values' must not be empty.");

        constructor_validation_impl(0, 1, new int[] {}, "'rowCount' must be greater than 0.");
        constructor_validation_impl(1, 0, new int[] {}, "'columnCount' must be greater than 0.");
        constructor_validation_impl(1, 1, null, "'values' must not be null.");
        constructor_validation_impl(1, 1, new int[] { 1, 1 }, "'rowCount' * 'columnCount' must be equal to 'values.length'.");


        int[] input = new int[] { 1, 2, 3, 4, 5, 6 };
        Matrix m = new Matrix(2, 3, input);
        int[][] values = m.get();
        Assert.assertEquals(input[0], values[0][0]);
        Assert.assertEquals(input[1], values[0][1]);
        Assert.assertEquals(input[2], values[0][2]);
        Assert.assertEquals(input[3], values[1][0]);
        Assert.assertEquals(input[4], values[1][1]);
        Assert.assertEquals(input[5], values[1][2]);
    }

    @Test
    public void add_basic() {

        Matrix matrix1 = new Matrix(new int[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix matrix2 = new Matrix(new int[][]
        {
            { 5, 6 },
            { 7, 8 }
        });

        Matrix result = matrix1.add(matrix2);
        int[][] values = result.get();

        Assert.assertEquals(6, values[0][0]);
        Assert.assertEquals(8, values[0][1]);
        Assert.assertEquals(10, values[1][0]);
        Assert.assertEquals(12, values[1][1]);
    }

    @Test
    public void add_matrices_dimension_mismatch() {
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 1, 2 }
        });

        Matrix matrix2 = new Matrix(new int[][]
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
        
        Matrix matrix1 = new Matrix(new int[][]
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
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 5, 6 },
            { 7, 8 }
        });

        Matrix matrix2 = new Matrix(new int[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix result = matrix1.subtract(matrix2);
        int[][] values = result.get();

        Assert.assertEquals(4, values[0][0]);
        Assert.assertEquals(4, values[0][1]);
        Assert.assertEquals(4, values[1][0]);
        Assert.assertEquals(4, values[1][1]);
    }

    @Test
    public void subtract_matrices_dimension_mismatch() {
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 1, 2 }
        });

        Matrix matrix2 = new Matrix(new int[][]
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
        
        Matrix matrix1 = new Matrix(new int[][]
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
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix matrix2 = new Matrix(new int[][]
        {
            { 5, 6 },
            { 7, 8 }
        });

        Matrix result = matrix1.multiply(matrix2);
        int[][] values = result.get();

        Assert.assertEquals(19, values[0][0]);
        Assert.assertEquals(22, values[0][1]);
        Assert.assertEquals(43, values[1][0]);
        Assert.assertEquals(50, values[1][1]);
    }

    @Test
    public void multiply_basic_two() {
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 5, 6 }
        });

        Matrix matrix2 = new Matrix(new int[][]
        {
            { 1 },
            { 2 }
        });

        Matrix result = matrix1.multiply(matrix2);
        int[][] values = result.get();

        Assert.assertEquals(17, values[0][0]);
    }

    @Test
    public void multiply_basic_three() {
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 5 },
            { 6 }
        });

        Matrix matrix2 = new Matrix(new int[][]
        {
            { 1, 2 }
        });

        Matrix result = matrix1.multiply(matrix2);
        int[][] values = result.get();

        Assert.assertEquals(5, values[0][0]);
        Assert.assertEquals(10, values[0][1]);
        Assert.assertEquals(6, values[1][0]);
        Assert.assertEquals(12, values[1][1]);
    }

    @Test
    public void multiply_basic_four() {
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 1 }
        });

        Matrix matrix2 = new Matrix(new int[][]
        {
            { 5 }
        });

        Matrix result = matrix1.multiply(matrix2);
        int[][] values = result.get();

        Assert.assertEquals(5, values[0][0]);
    }

    @Test
    public void multiply_matrices_dimension_mismatch() {
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 2, 3, 4 },
            { 5, 6, 7 }
        });

        Matrix matrix2 = new Matrix(new int[][]
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
        
        Matrix matrix1 = new Matrix(new int[][]
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
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 1, 2 },
            { 3, 4 }
        });

        Matrix result = matrix1.transpose();
        int[][] values = result.get();

        Assert.assertEquals(1, values[0][0]);
        Assert.assertEquals(3, values[0][1]);
        Assert.assertEquals(2, values[1][0]);
        Assert.assertEquals(4, values[1][1]);
    }

    @Test
    public void transpose_basic_two() {
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 1, 2 }
        });

        Matrix result = matrix1.transpose();
        int[][] values = result.get();

        Assert.assertEquals(1, values[0][0]);
        Assert.assertEquals(2, values[1][0]);
    }

    @Test
    public void getRow() {
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 1, 2, 8, 5 },
            { 3, 6, 7, 1 }
        });

        List<Integer> row = matrix1.getRow(0);

        assertEquals(Integer.valueOf(1), row.get(0));
        assertEquals(Integer.valueOf(2), row.get(1));
        assertEquals(Integer.valueOf(8), row.get(2));
        assertEquals(Integer.valueOf(5), row.get(3));
    }

    @Test
    public void getColumn() {
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 1, 2 },
            { 2, 9 },
            { 8, 4 },
            { 5, 7 }
        });

        List<Integer> col = matrix1.getColumn(0);
        
        assertEquals(Integer.valueOf(1), col.get(0));
        assertEquals(Integer.valueOf(2), col.get(1));
        assertEquals(Integer.valueOf(8), col.get(2));
        assertEquals(Integer.valueOf(5), col.get(3));
    }

    @Test
    public void setValue() {
        
        Matrix matrix1 = new Matrix(new int[][]
        {
            { 1, 2 },
            { 2, 9 },
        });

        matrix1.setValue(1, 1, 502);
        int[][] values = matrix1.get();
        Assert.assertEquals(502, values[1][1]);
    }

    
    private static void constructor_validation_impl(int[][] values, String expectedMessage) {
        try {
            Matrix m = new Matrix(values);
            Assert.fail("This line must not be hit. Instead, execution must go to the catch block.");

        } catch (IllegalArgumentException ex) {
            catchExpectedException(ex, expectedMessage);
        }
    }

    private static void constructor_validation_impl(int rowCount, int columnCount, int[] values, String expectedMessage) {
        try {
            Matrix m = new Matrix(rowCount, columnCount, values);
            Assert.fail("This line must not be hit. Instead, execution must go to the catch block.");

        } catch (IllegalArgumentException ex) {
            catchExpectedException(ex, expectedMessage);
        }
    }

    protected static void catchExpectedException(IllegalArgumentException ex, String expectedMessage) {
        String s = ex.getMessage();
        boolean expected = s.startsWith(expectedMessage);
        Assert.assertTrue(expected);
    }
}
