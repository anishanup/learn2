# Matrix Library

A modular Java-based matrix library for performing a variety of matrix operations, including comparisons, transformations, and algebraic manipulations. Designed with object-oriented principles and extensibility in mind, this library provides a clean foundation for both educational and practical use cases.

---

## Features

### General Matrix Operations (`Matrix.java`)
- Matrix creation using 2D arrays
- Matrix addition, subtraction
- Matrix multiplication
- Transpose of a matrix
- Pretty-printed matrix display
- Dimension validation and error handling

### Square Matrix Enhancements (`SquareMatrix.java`)
- Determinant calculation
- Cofactor Matrix
- Adjoint Matrix
- Specialized operations for square matrices only

### Matrix Construction Factory (`MatrixFactory.java`)
- Factory methods for:
  - Zero matrices
  - Identity matrices
- Safe instantiation of both general and square matrices
- Abstracts internal implementation details

### Matrix Comparison Logic (`MatrixComparator.java`)
- Compare matrices by:
  - Size
  - Number of non-zero elements
  - Lexicographical order of flattened entries
- Custom comparator to assist in sorting or validation scenarios

---

## Project Structure

```
learn2/
├── src/
│   └── matrix/
│       ├── Matrix.java             # Core matrix operations
│       ├── SquareMatrix.java       # Extensions for square matrix logic
│       ├── MatrixFactory.java      # Utility for generating common matrices
│       ├── MatrixComparator.java   # Logic for comparing matrix objects
│       └── Main.java               # Demo CLI to test features
```

---

## Example Usage

```java
Matrix a = MatrixFactory.zeroMatrix(3, 2);
Matrix b = MatrixFactory.identityMatrix(2);

Matrix result = a.multiply(b);
System.out.println(result);

SquareMatrix square = new SquareMatrix(new double[][] 
{
    { 1, 2, 3 },
    { 4, 5, 6 },
    { 7, 8, 9 }
});

System.out.println(square.getDeterminant()); // 0
```

---

## Running the Application

### Prerequisites

- Java JDK 8 or higher

### Steps

```bash
git clone https://github.com/anishanup/learn2.git
cd learn2/src
javac matrix/*.java
java matrix.Main
```

---

## Educational Value

This project demonstrates:
- Inheritance and method overriding (`SquareMatrix` extends `Matrix`)
- Static factory methods (`MatrixFactory`)
- Java interfaces and comparators (`MatrixComparator`)
- Clean separation of concerns
- Recurssion

---

## License

Open-source. Free to use and extend for personal or academic purposes.

