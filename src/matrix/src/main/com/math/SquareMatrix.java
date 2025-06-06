package main.com.math;

public class SquareMatrix extends Matrix {

    public SquareMatrix(double[][] values) {
        super(values);

        if (getRowCount() != getColumnCount()) {
            throw new IllegalArgumentException("Number of rows and columns in 'values' has to be the same.");
        }
    }

    public SquareMatrix(int rowOrColumnCount) {
        super(rowOrColumnCount, rowOrColumnCount);
    }

    // Uses the getDeterminantOperation helper method to return the determinant of a matrix.
    public double getDeterminant() {
        return getDeterminantOperation(this.get());
    }

    public SquareMatrix getCofactorMatrix() {
        return getCofactorMatrixOperation(this.get());
    }

    public SquareMatrix getAdjointMatrix() {
        SquareMatrix cofactorMatrix = getCofactorMatrixOperation(this.get());
        //Matrix adjointMatrixTemp = cofactorMatrix.transpose();
        SquareMatrix adjointMatrix = new SquareMatrix(cofactorMatrix.transpose().get());
        
        return adjointMatrix;
    }

    public SquareMatrix getInverseMatrix() {
        double determinant = getDeterminant();
        if (determinant == 0) {
            throw new IllegalArgumentException("For computing the inverse, the 'determinant' should be a non-zero number.");
        }

        SquareMatrix adjointMatrix = getAdjointMatrix();
        SquareMatrix inverseMatrix = new SquareMatrix(this.getRowCount());

        if (this.getRowCount() == 1) {
            inverseMatrix.setValue(0, 0, 1 / determinant);
            return inverseMatrix;
        }

        for (int r = 0; r < inverseMatrix.getRowCount(); r++) {
            for (int c = 0; c < inverseMatrix.getColumnCount(); c++) {
                inverseMatrix.setValue(r, c, adjointMatrix.getValue(r, c) / determinant);
                inverseMatrix.display();
            }
        }

        return inverseMatrix;
    }

    // getDeterminant helper method.
    // This method takes in a square matrix and returns the determinant.
    // This is a private helper method because the method that is using this will use an instance of Matrix 
    // and will have no parameters.

    // If you don't pass in a square matrix, it will result in an error.
    // If you pass in null, it will result in an error.
    private static double getDeterminantOperation(double[][] matrixValues) {

        int rowCount = matrixValues.length; 
        int colCount = rowCount; // validated in ctor of this class

        if (rowCount == 1) {
            return matrixValues[0][0];
        }
        
        if(rowCount == 2) {
            return getDeterminantOperation2x2(matrixValues);
        }

        double[][] newMatrixValues = new double[rowCount - 1][colCount - 1];
        int sum = 0;
        
        // 1, 2, 3
        // 4, 5, 6
        // 7, 8, 9

        // 1 * | 5, 6 | - 2 * | 4, 6 | + 3 * | 4, 5 |
        //     | 8, 9 |       | 7, 9 |       | 7, 8 |

        for (int a = 0; a < colCount; a++) {
            for (int b = 0; b < rowCount - 1; b++) {
                int d = 0;
                for (int c = 0; c < colCount; c++) {
                    if (c != a) {
                        newMatrixValues[b][d] = matrixValues[b + 1][c];
                        d++;
                    }
                }
            }

            int multiplier = a % 2 == 0 ? 1 : -1;
            double subResult = matrixValues[0][a] * getDeterminantOperation(newMatrixValues);
            sum += multiplier * subResult;
        }
        
        return sum;
    }

    private static double getDeterminantOperation2x2(double[][] matrixValues) {
        double determinant = matrixValues[0][0] * matrixValues[1][1] - matrixValues[0][1] * matrixValues[1][0];
        return determinant;
    }

    private static SquareMatrix getCofactorMatrixOperation(double[][] matrixValues) {
        int rowCount = matrixValues.length; 
        int colCount = rowCount; // validated in ctor of this class

        if (rowCount == 1) {
            return new SquareMatrix(matrixValues);
        }

        double[][] newMatrixValues = new double[rowCount - 1][colCount - 1];
        double[][] result = new double[rowCount][colCount];

        for (int a = 0; a < rowCount; a++) {
            for (int b = 0; b < colCount; b++) {
                int x = 0;
                for (int c = 0; c < rowCount; c++) {
                    int y = 0;
                    if (c != a) {
                        for (int d = 0; d < colCount; d++) {
                            if (d != b) {
                                newMatrixValues[x][y] = matrixValues[c][d];
                                y++;
                            }
                        }
                        x++;
                    }
                }

                result[a][b] = Math.pow(-1, a + b) * getDeterminantOperation(newMatrixValues);
            }
        }

        SquareMatrix cofactorMatrix = new SquareMatrix(result);
        return cofactorMatrix;
    }
}
