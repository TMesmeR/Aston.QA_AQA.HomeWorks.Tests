package org.example;

public class TriangleAreaCalculator {
    public static double calculateArea(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными числами");
        }

        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }

        double semiPerimeter = (sideA + sideB + sideC) / 2;
        double area = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) *
                (semiPerimeter - sideB) * (semiPerimeter - sideC));
        return area;
    }
}
