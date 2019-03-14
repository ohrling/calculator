import main.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LimitTests {
    // Limit tests
    @Test(expected = RuntimeException.class)
    public void inputTooLargeNumber_ReturnsException() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double toLargeNumber = 1e308;
        calc.calculateExpression(String.valueOf(toLargeNumber * 10));
    }

    @Test
    public void inputLongCalculation_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3+4(4/2)/2");

        // Assert
        assertEquals("7.0", actual);
    }

    @Test
    public void inputDivisionResultsInInfiteAnswer_ReturnsTrimmedStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("10/3");

        // Assert
        assertEquals("3.33333333", actual);
    }
}
