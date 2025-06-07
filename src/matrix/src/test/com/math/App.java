package test.com.math;

import main.com.math.SquareMatrix;
import main.com.math.Matrix;

public class App {
    public static void main(String[] args) {
        SquareMatrix squareMatrix = new SquareMatrix(new double[][] {{5}});
        SquareMatrix inverse = squareMatrix.getInverseMatrix();
        Matrix result = squareMatrix.multiply(inverse);
        result.display();
    }
}
