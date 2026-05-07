import org.example.FactorialCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {
    @Test
    @DisplayName("Тест факториала нуля")
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    @DisplayName("Тест факториала единицы")
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
    }

    @Test
    @DisplayName("Тест факториала положительного числа")
    void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
        assertEquals(720, FactorialCalculator.calculateFactorial(6));
        assertEquals(3628800, FactorialCalculator.calculateFactorial(10));
    }

    @Test
    @DisplayName("Тест факториала отрицательного числа")
    void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.calculateFactorial(-5));
    }

    @Test
    @DisplayName("Тест факториала большого числа")
    void testFactorialOfLargeNumber() {
        assertDoesNotThrow(() -> FactorialCalculator.calculateFactorial(20));
    }
}
