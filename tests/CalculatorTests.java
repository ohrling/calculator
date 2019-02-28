
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

    @Test
    public void additionTest() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.addition(3.0,4.0);

        // Assert
        assertEquals(7d,actual,0.111);
    }
}
