import org.example.NumberComparator;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class NumberComparatorTest {
    @Test
    public void testFirstNumberGreater() {
        String result = NumberComparator.compare(10, 5);
        assertTrue(result.contains("больше"));
        assertFalse(result.contains("меньше"));
    }

    @Test
    public void testFirstNumberLess() {
        String result = NumberComparator.compare(3, 8);
        assertTrue(result.contains("меньше"));
        assertFalse(result.contains("больше"));
    }

    @Test
    public void testNumbersEqual() {
        String result = NumberComparator.compare(7, 7);
        assertTrue(result.contains("равно"));
        assertFalse(result.contains("больше"));
        assertFalse(result.contains("меньше"));
    }

    @Test
    public void testFindMax() {
        assertEquals(NumberComparator.findMax(10, 15), Integer.valueOf(15));
        assertEquals(NumberComparator.findMax(-10, -5), Integer.valueOf(-5));
        assertEquals(NumberComparator.findMax(3, 3), Integer.valueOf(3));
    }

    @Test
    public void testFindMin() {
        assertEquals(NumberComparator.findMin(10, 15), Integer.valueOf(10));
        assertEquals(NumberComparator.findMin(-10, -5), Integer.valueOf(-10));
        assertEquals(NumberComparator.findMin(3, 3), Integer.valueOf(3));
    }

    @DataProvider(name = "comparisonData")
    public Object[][] comparisonDataProvider() {
        return new Object[][] {
                {5, 3, "больше"},
                {2, 7, "меньше"},
                {4, 4, "равно"}
        };
    }

    @Test(dataProvider = "comparisonData")
    public void testCompareNumbers(int a, int b, String expectedRelation) {
        String result = NumberComparator.compare(a, b);
        assertTrue(result.contains(expectedRelation));
    }

    @Test(invocationCount = 3)
    public void testMultipleComparisons() {
        assertNotNull(NumberComparator.compare(5, 3));
    }

    @BeforeClass
    public void setUpClass() {
        System.out.println("Инициализация тестов сравнения чисел");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Завершение тестов сравнения чисел");
    }
}
