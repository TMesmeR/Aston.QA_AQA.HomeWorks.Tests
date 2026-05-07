import org.example.TriangleAreaCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaCalculatorTest {
    @Test
    @DisplayName("Тест площади прямоугольного треугольника")
    void testRightTriangle() {
        double area = TriangleAreaCalculator.calculateArea(3, 4, 5);
        assertEquals(6.0, area, 0.0001);
    }

    @Test
    @DisplayName("Тест площади равностороннего треугольника")
    void testEquilateralTriangle() {
        double area = TriangleAreaCalculator.calculateArea(4, 4, 4);
        double expectedArea = 6.928203230275509;
        assertEquals(expectedArea, area, 0.0001);
    }

    @Test
    @DisplayName("Тест с некорректными сторонами - отрицательные значения")
    void testInvalidTriangleNegativeSides() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(-1, 2, 3));
    }

    @Test
    @DisplayName("Тест с некорректными сторонами - несуществующий треугольник")
    void testNonExistentTriangle() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(1, 1, 10));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, 6.0",
            "5, 5, 6, 12.0",
            "6, 8, 10, 24.0"
    })
    @DisplayName("Параметризованный тест площади треугольника")
    void testMultipleTriangles(double a, double b, double c, double expectedArea) {
        assertEquals(expectedArea, TriangleAreaCalculator.calculateArea(a, b, c), 0.0001);
    }
}
