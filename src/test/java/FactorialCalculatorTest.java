import org.example.FactorialCalculator;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class FactorialCalculatorTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator.calculateFactorial(1), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(FactorialCalculator.calculateFactorial(5), 120);
        assertEquals(FactorialCalculator.calculateFactorial(6), 720);
        assertEquals(FactorialCalculator.calculateFactorial(10), 3628800L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.calculateFactorial(-5);
    }

    @Test(timeOut = 1000)
    public void testFactorialPerformance() {
        FactorialCalculator.calculateFactorial(20);
    }

    @DataProvider(name = "factorialData")
    public Object[][] factorialDataProvider() {
        return new Object[][] {
                {0, 1},
                {1, 1},
                {5, 120},
                {7, 5040}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorialWithDataProvider(int input, long expected) {
        assertEquals(FactorialCalculator.calculateFactorial(input), expected);
    }
}
