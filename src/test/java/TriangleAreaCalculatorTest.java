import org.example.TriangleAreaCalculator;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class TriangleAreaCalculatorTest {
    @Test
    public void testRightTriangle() {
        double area = TriangleAreaCalculator.calculateArea(3, 4, 5);
        assertEquals(area, 6.0, 0.0001);
    }

    @Test
    public void testEquilateralTriangle() {
        double area = TriangleAreaCalculator.calculateArea(4, 4, 4);
        double expectedArea = 6.928203230275509;
        assertEquals(area, expectedArea, 0.0001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangleNegativeSides() {
        TriangleAreaCalculator.calculateArea(-1, 2, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNonExistentTriangle() {
        TriangleAreaCalculator.calculateArea(1, 1, 10);
    }

    @DataProvider(name = "triangleData")
    public Object[][] triangleDataProvider() {
        return new Object[][] {
                {3, 4, 5, 6.0},
                {5, 5, 6, 12.0},
                {6, 8, 10, 24.0}
        };
    }

    @Test(dataProvider = "triangleData")
    public void testMultipleTriangles(double a, double b, double c, double expectedArea) {
        assertEquals(TriangleAreaCalculator.calculateArea(a, b, c), expectedArea, 0.0001);
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Выполнение теста площади треугольника");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Тест площади треугольника завершен");
    }
}
