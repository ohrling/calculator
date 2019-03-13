import main.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExceptionTests {
    // Exception tests
    @Test(expected = ArithmeticException.class)
    public void divisionZeroTest() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.division(4.0,0.0);

        // Assert
        assertEquals(3d,actual, 0.111);
    }

    // Test for converting
    @Test(expected = NullPointerException.class)
    public void convertStringToDouble_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        Double actual = calc.convertStringToDouble("h");

        // Assert
        assertEquals(3d, actual, 0.111);
    }
}
