import org.example.ArithmeticOperations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTest {
    @Test
    @DisplayName("Тест сложения")
    void testAddition() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
        assertEquals(-1, ArithmeticOperations.add(-2, 1));
        assertEquals(10, ArithmeticOperations.add(0, 10));
    }

    @Test
    @DisplayName("Тест вычитания")
    void testSubtraction() {
        assertEquals(-1, ArithmeticOperations.subtract(2, 3));
        assertEquals(5, ArithmeticOperations.subtract(10, 5));
        assertEquals(0, ArithmeticOperations.subtract(7, 7));
    }

    @Test
    @DisplayName("Тест умножения")
    void testMultiplication() {
        assertEquals(15, ArithmeticOperations.multiply(3, 5));
        assertEquals(-12, ArithmeticOperations.multiply(-3, 4));
        assertEquals(0, ArithmeticOperations.multiply(0, 100));
    }

    @Test
    @DisplayName("Тест деления")
    void testDivision() {
        assertEquals(3.5, ArithmeticOperations.divide(7, 2), 0.0001);
        assertEquals(-2.5, ArithmeticOperations.divide(-5, 2), 0.0001);
        assertEquals(0.0, ArithmeticOperations.divide(0, 5), 0.0001);
    }

    @Test
    @DisplayName("Тест деления на ноль")
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class,
                () -> ArithmeticOperations.divide(10, 0));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "-5, 10, 5",
            "0, 0, 0"
    })
    @DisplayName("Параметризованный тест арифметических операций")
    void testArithmeticOperations(int a, int b, int expectedSum) {
        assertEquals(expectedSum, ArithmeticOperations.add(a, b));
        assertEquals(a - b, ArithmeticOperations.subtract(a, b));
        assertEquals(a * b, ArithmeticOperations.multiply(a, b));
    }
}
