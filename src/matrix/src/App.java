public class App {
    public static void main(String[] args) {
        
        Matrix matrix1 = new Matrix(new int[][]
            {
                { 9, 3, 0 },
                { 4, 8, 1 }
            });

        Matrix matrix2 = new Matrix(new int[][]
            {
                { 3, -1, 2 },
                { 4, 8, 2 }
            });

        Matrix matrix3Add = matrix1.add(matrix2);
        matrix3Add.display();

        System.out.println();

        Matrix matrix3Subtract = matrix1.subtract(matrix2);
        matrix3Subtract.display();
        
    }
}

// Matrix class
class Matrix {
    // This is the array that is used for the object creation above
    private int[][] matrixValues;
    private int rows;
    private int columns;

    // My constructor
    public Matrix(int[][] values) {
        matrixValues = values;
        rows = this.matrixValues.length;
        columns = this.matrixValues[0].length;
    }

    // Gets array values, returning the array
    public int[][] getValues() {
        return this.matrixValues;
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
}
