import main.Calculator;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpecificationTests {
    // Arrange
    static Calculator calc;

    @BeforeClass
    public static void initiateCalculator() {
        calc = new Calculator();
    }

    @Test
    public void LongCalculation() {
        // Act
        String actual = calc.calculateExpression("5*4+7-3*0+4-10");

        // Assert
        assertEquals("21.0", actual);
    }
}
