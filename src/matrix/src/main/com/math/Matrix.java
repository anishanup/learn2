package main.com.math;

import java.util.ArrayList;
import java.util.List;

// This is a library, a user imports this library 
// so that they can use the methods in this class.
public class Matrix {
    
    // This is the array that is used for the object creation above.
    private int[][] matrixValues;
    private int rows;
    private int columns;

    public Matrix(int[][] values) {
        if (values == null) {
            throw new IllegalArgumentException("'values' must not be null.");
        }
        if (values.length == 0 || values[0].length == 0) {
            throw new IllegalArgumentException("'values' must not be empty.");
        }

        this.rows = values.length;
        this.columns = values[0].length;
        this.matrixValues = values;
    }   
    
    // Overloaded constructor for convenience.
    // Allows a 1D array to be passed in, which is then converted to a matrix.
    public Matrix(int rowCount, int columnCount, int[] values) {
        if (rowCount <= 0) {
            throw new IllegalArgumentException("'rowCount' must be greater than 0.");
        }
        if (columnCount <= 0) {
            throw new IllegalArgumentException("'columnCount' must be greater than 0.");
        }
        if (values == null) {
            throw new IllegalArgumentException("'values' must not be null.");
        }
        if (rowCount * columnCount != values.length) {
            throw new IllegalArgumentException("'rowCount' * 'columnCount' must be equal to 'values.length'.");
        }

        int[][] values2D = new int[rowCount][columnCount];
        int index = 0;
        
        for (int i = 0; i < rowCount; i ++) {
            for (int j = 0; j < columnCount; j ++) {
                values2D[i][j] = values[index];
                index++;
            }
        }

        this.rows = rowCount;
        this.columns = columnCount;
        this.matrixValues = values2D;
    }

    // Method to return any value from the matrix that the user asks for.
    // Asks for the value's position in the matrix.
    public int getValue(int rowPos, int colPos) {
        return this.matrixValues[rowPos][colPos];
    }

    // Method to return any row from the matrix that the user asks for.
    // Asks for the row's position in the matrix.
    public List<Integer> getRow(int rowPos) {
        List<Integer> matrixRow = new ArrayList<Integer>();
        for (int counter = 0; counter < this.columns; counter++) {
            matrixRow.add(this.matrixValues[rowPos][counter]);
        }
        return matrixRow;
    }

    // Method to return any column from the matrix that the user asks for.
    // Asks for the column's position in the matrix.
    public List<Integer> getColumn(int colPos) {
        List<Integer> matrixRow = new ArrayList<Integer>();
        for (int counter = 0; counter < this.rows; counter++) {
            matrixRow.add(this.matrixValues[counter][colPos]);
        }
        return matrixRow;
    }

    // Gets array values, returning the array.
    public int[][] get() {
        return this.matrixValues;
    }
    
    // Gets number of rows.
    public int getRowCount() {
        return this.rows;
    }

    // Gets number of columns.
    public int getColumnCount() {
        return this.columns;
    }
    // Changes a value in the matrix.
    // Asks for new value and where to put it in the matrix (0 based indexing).
    public void setValue(int row, int col, int value) {
        this.matrixValues[row][col] = value;
    }

    // Builds the matrixValues in a string to display.
    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (int x = 0; x < this.rows; x ++) {
            for (int y = 0; y < this.columns; y ++) {
                builder.append(this.matrixValues[x][y] + " ");
            }

            builder.append("\n");
        }

        return builder.toString();
    }

    // Displaying array values.
    public void display() {

        System.out.println(this.toString());
    }

    // Uses the "performOperation" method to subtract to matrices.
    public Matrix add(Matrix matrix2) {
        Matrix newM = performOperation(matrix2, "add");
        return newM;
    }

    // Uses the "performOperation" method to subtract two matrices.
    public Matrix subtract(Matrix matrix2) {
        Matrix newM = performOperation(matrix2, "subtract");
        return newM;
    }

    // This method multiplies two matrices.
    // The parameter other represents the matrix that is being multiplied with the original matrix.
    // For this method to perform correctly, the columns of this matrix must match to the rows
    // of the matrix getting multiplied.
    // If that is not the case, it will throw an exception and will not perform the method.
    // It will also not perfrom the method if other is null.
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

    // Makes the columns of the matrix into rows and vice versa.
    public Matrix transpose() {
        int[][] newMatrixValues = new int[this.columns][this.rows];
        Matrix newMatrix = new Matrix(newMatrixValues);
        int item;

        for (int x = 0; x < this.rows; x++) {
            for (int y = 0; y < this.columns; y++) {
                item = this.matrixValues[x][y];
                newMatrixValues[y][x] = item;
            }
        }

        return newMatrix;
    }

    // Add and Subtract methods helper method.
    // This method takes in a matrix, uses its values to perform an operation, then returns a new matrix.
    // The parameter other is the matrix that is being added or subtracted from the originial matrix.
    // The parameter operation is telling what operation the method should perform. (Add or subtract).

    // if you pass in null, it will result in an error.
    // if rows of other or columns of other are not matching with the matrixValues,it will result in an error.
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
}