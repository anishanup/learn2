package main.com.math;
import java.util.ArrayList;
import java.util.List;

// Matrix class
public class Matrix {
    // This is the array that is used for the object creation above
    private int[][] matrixValues;
    private int rows;
    private int columns;

    // My constructor
    public Matrix(int[][] values) {
        if (values == null) {
            throw new IllegalArgumentException("'values' must not be null.");
        }

        if (values.length == 0 || values[0].length == 0) {
            throw new IllegalArgumentException("'values' must not be empty.");
        }

        matrixValues = values;
        rows = this.matrixValues.length;
        columns = this.matrixValues[0].length;
    }

    public int getValue(int rowPos, int colPos) {
        return this.matrixValues[rowPos][colPos];
    }

    public List<Integer> getRow(int rowPos) {
        List<Integer> matrixRow = new ArrayList<Integer>();
        for (int counter = 0; counter < this.columns; counter++) {
            matrixRow.add(this.matrixValues[rowPos][counter]);
        }
        return matrixRow;
    }

    public List<Integer> getColumn(int colPos) {
        List<Integer> matrixRow = new ArrayList<Integer>();
        for (int counter = 0; counter < this.rows; counter++) {
            matrixRow.add(this.matrixValues[counter][colPos]);
        }
        return matrixRow;
    }

    // Gets array values, returning the array
    public int[][] get() {
        return this.matrixValues;
    }

    public void setValue(int value, int rowPos, int colPos) {
        this.matrixValues[rowPos][colPos] = value;
    }

    // Displaying array values
    public void display() {

        for (int x = 0; x < this.rows; x ++) {
            for (int y = 0; y < this.columns; y ++) {
                System.out.print(this.matrixValues[x][y] + " ");
            }

            System.out.println();
        }

    }

    // Add and Subtract methods helper method.
    // This method takes in a matrix, uses its values to perform an operation, then returns a new matrix.
    // The parameter other is the matrix that is being added or subtracted from the originial matrix.
    // The parameter operation is telling what operation the method should perform. (Add or subtract).

    // if you pass in null, it is an error
    // if rows of other or columns of other are not matching with the matrixValues, then it is an error
    private Matrix performOperation(Matrix other, String operation) {
        if (other == null) {
            throw new IllegalArgumentException("Input parameter 'other' must not be null.");
        }

        if (this.rows != other.matrixValues.length || this.columns != other.matrixValues[0].length) {

            String s  = String.format(
                "Dimensions (rows and columns) of input parameter 'other' must match those of this matrix. " + 
                "This matrix's dimensions are: [%d][%d], input dimensions are: [%d][%d]", 
                rows, columns, other.matrixValues.length, other.matrixValues[0].length);
            throw new IllegalArgumentException(s);
        }

        int[][] newMatrixValues = new int[this.rows][this.columns];
        Matrix newMatrix = new Matrix(newMatrixValues);

        for (int x = 0; x < this.rows; x ++) {
            for (int y = 0; y < this.columns; y ++) {
                int item;
                if (operation == "add") {
                    item = this.matrixValues[x][y] + other.matrixValues[x][y];
                }

                else {
                    item = this.matrixValues[x][y] - other.matrixValues[x][y];
                }
                newMatrixValues[x][y] = item;
            }
        }

        return newMatrix;
    }

    public Matrix add(Matrix matrix2) {
        Matrix newM = performOperation(matrix2, "add");
        return newM;
    }

    public Matrix subtract(Matrix matrix2) {
        Matrix newM = performOperation(matrix2, "subtract");
        return newM;
    }

    public Matrix multiply(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("Input parameter 'other' must not be null.");
        }
        
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("The columns of the first matrix must match the rows of the second matrix.");
        }

        int[][] newMatrixValues = new int[this.rows][other.columns];
        Matrix newMatrix = new Matrix(newMatrixValues);
        int item;
        int sum;

        for (int x = 0; x < this.rows; x ++) {
            for (int y = 0; y < other.columns; y ++) {
                sum = 0;
                for (int z = 0; z < this.columns; z ++) {
                    item = this.matrixValues[x][z] * other.matrixValues[z][y];
                    sum = sum + item;
                    newMatrixValues[x][y] = sum;
                }
            }
        }

        return newMatrix;
    }

    public Matrix transpose() {
        int[][] newMatrixValues = new int[this.columns][this.rows];
        Matrix newMatrix = new Matrix(newMatrixValues);
        int item;

        for (int x = 0; x < this.rows; x++) {
            for (int y = 0; y < this.columns; y++) {
                item = this.get()[x][y];
                newMatrixValues[y][x] = item;
            }
        }

        return newMatrix;
    }
}