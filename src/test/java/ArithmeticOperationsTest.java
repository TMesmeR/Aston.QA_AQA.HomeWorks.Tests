import org.example.ArithmeticOperations;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class ArithmeticOperationsTest {
    @Test(groups = {"arithmetic"})
    public void testAddition() {
        assertEquals(ArithmeticOperations.add(2, 3), 5);
        assertEquals(ArithmeticOperations.add(-2, 1), -1);
        assertEquals(ArithmeticOperations.add(0, 10), 10);
    }

    @Test
    public void testSubtraction() {
        assertEquals(ArithmeticOperations.subtract(2, 3), -1);
        assertEquals(ArithmeticOperations.subtract(10, 5), 5);
        assertEquals(ArithmeticOperations.subtract(7, 7), 0);
    }

    @Test
    public void testMultiplication() {
        assertEquals(ArithmeticOperations.multiply(3, 5), 15);
        assertEquals(ArithmeticOperations.multiply(-3, 4), -12);
        assertEquals(ArithmeticOperations.multiply(0, 100), 0);
    }

    @Test
    public void testDivision() {
        assertEquals(ArithmeticOperations.divide(7, 2), 3.5, 0.0001);
        assertEquals(ArithmeticOperations.divide(-5, 2), -2.5, 0.0001);
        assertEquals(ArithmeticOperations.divide(0, 5), 0.0, 0.0001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations.divide(10, 0);
    }

    @DataProvider(name = "arithmeticData")
    public Object[][] arithmeticDataProvider() {
        return new Object[][] {
                {2, 3, 5, -1, 6, 0.6667},
                {10, 5, 15, 5, 50, 2.0},
                {0, 0, 0, 0, 0, Double.NaN}
        };
    }

    @Test(dataProvider = "arithmeticData")
    public void testAllOperations(int a, int b, int expectedSum, int expectedDiff,
                                  int expectedProduct, double expectedQuotient) {
        assertEquals(ArithmeticOperations.add(a, b), expectedSum);
        assertEquals(ArithmeticOperations.subtract(a, b), expectedDiff);
        assertEquals(ArithmeticOperations.multiply(a, b), expectedProduct);
        if (b != 0) {
            assertEquals(ArithmeticOperations.divide(a, b), expectedQuotient, 0.0001);
        }
    }
}
