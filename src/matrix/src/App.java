public class App {
    public static void main(String[] args) throws Exception {
        
        Matrix matrix1 = new Matrix(new int[][] { { 1, 3 }, { 4, 2 } });
        Matrix matrix2 = new Matrix(new int[][] { { 3, -1 }, { 4, 8 } });

        matrix1.display();
        matrix2.display();
    }
}

class Matrix {
    int[][] values;
    
    public Matrix(int[][] matrixValues) {
        this.values = matrixValues;
    }

    public int[][] getValues() {
        return values;
    }

    public void display() {

        for (int x = 0; x < values.length; x ++) {
            for (int y = 0; y < values[x].length; y ++){
                System.out.print(values[x][y] + " ");
            }

            System.out.println("");
        }
    }
}