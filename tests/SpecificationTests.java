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
    public void specificationOne_LongExpression_ReturnsStringConvertedDoubleOf21() {
        // Act
        String actual = calc.calculateExpression("5*4+7-3*0+4-10");

        // Assert
        assertEquals("21.0", actual);
    }

    @Test
    public void specificationTwo_ShortExpression_ReturnsStringConvertedDoubleOf32dot5() {
        // Act
        String actual = calc.calculateExpression("7*4+6-3/2");

        // Assert
        assertEquals("32.5", actual);
    }

    @Test
    public void specificationThree_MultiplicationAndDivision_ReturnsStringConvertedDoubleOf21() {
        // Act
        fail();
    }
}
