import org.example.NumberComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberComparatorTest {
    @Test
    @DisplayName("Тест сравнения чисел - первое больше")
    void testFirstNumberGreater() {
        String result = NumberComparator.compare(10, 5);
        assertTrue(result.contains("больше"));
        assertFalse(result.contains("меньше"));
    }

    @Test
    @DisplayName("Тест сравнения чисел - первое меньше")
    void testFirstNumberLess() {
        String result = NumberComparator.compare(3, 8);
        assertTrue(result.contains("меньше"));
        assertFalse(result.contains("больше"));
    }

    @Test
    @DisplayName("Тест сравнения чисел - равны")
    void testNumbersEqual() {
        String result = NumberComparator.compare(7, 7);
        assertTrue(result.contains("равно"));
        assertFalse(result.contains("больше"));
        assertFalse(result.contains("меньше"));
    }

    @Test
    @DisplayName("Тест поиска максимального числа")
    void testFindMax() {
        assertEquals(15, NumberComparator.findMax(10, 15));
        assertEquals(-5, NumberComparator.findMax(-10, -5));
        assertEquals(3, NumberComparator.findMax(3, 3));
    }

    @Test
    @DisplayName("Тест поиска минимального числа")
    void testFindMin() {
        assertEquals(10, NumberComparator.findMin(10, 15));
        assertEquals(-10, NumberComparator.findMin(-10, -5));
        assertEquals(3, NumberComparator.findMin(3, 3));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, больше",
            "2, 7, меньше",
            "4, 4, равно"
    })
    @DisplayName("Параметризованный тест сравнения чисел")
    void testCompareNumbers(int a, int b, String expectedRelation) {
        String result = NumberComparator.compare(a, b);
        assertTrue(result.contains(expectedRelation));
    }
}
