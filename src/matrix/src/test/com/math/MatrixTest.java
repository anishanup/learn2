package test.com.math;
import org.junit.Assert;
import org.junit.Test;

import main.com.math.Matrix;

public class MatrixTest {
    
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
        int[][] values = result.getValues();

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
        int[][] values = result.getValues();

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
        int[][] values = result.getValues();

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
        int[][] values = result.getValues();

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
        int[][] values = result.getValues();

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
        int[][] values = result.getValues();

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
        int[][] values = result.getValues();

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
        int[][] values = result.getValues();

        Assert.assertEquals(1, values[0][0]);
        Assert.assertEquals(2, values[1][0]);
    }
}
