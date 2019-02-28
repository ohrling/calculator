
import main.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;
public class CalculatorTests {
    @Test
    public void calculateExpressionString_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String acutal = calc.calculateExpression("3+4");

        // Assert
        assertEquals("3+4", acutal);
    }
}
