import main.Calculator;
import org.junit.BeforeClass;
import org.junit.ComparisonFailure;
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

    // Varför ger denna fel emellanåt?
    @Test
    public void specificationThree_MultiplicationAndDivision_ReturnsStringConvertedDoubleOf21() {
        // Act
        String actual = calc.calculateExpression("7*6/2");

        // Assert
        assertEquals("21.0", actual);
    }

    @Test
    public void specificationFour_AdditionDivisionAndMultiplication_ReturnsStringConvertedDoubleOf11() {
        // Act
        String actual = calc.calculateExpression("5+6/2*2");

        // Assert
        assertEquals("11.0", actual);
    }

    @Test (expected = NumberFormatException.class)
    public void specificationFive_WrongInputsDoubleTermAndLetter_ReturnsException() {
        // Act
        String actual = calc.calculateExpression("5++p");

        // Assert
        assertEquals("11.0", actual);
    }

    @Test (expected = NumberFormatException.class)
    public void specificationSix_WrongInputsDoubleTerm_ReturnsException() {
        // Act
        String actual = calc.calculateExpression("5++4");
    }

    @Test (expected = NumberFormatException.class)
    public void specificationSeven_WrongInputsDoubleSpace_ReturnsException() {
        // Act
        String actual = calc.calculateExpression("3  4");
    }

    @Test (expected = NumberFormatException.class)
    public void specificationEight_WrongInputsLetters_ReturnsException() {
        // Act
        String actual = calc.calculateExpression("sdf");
    }

    @Test (expected = NumberFormatException.class)
    public void specificationNine_WrongInputsStartsWithTerm_ReturnsException() {
        // Act
        String actual = calc.calculateExpression("*3");

        // Assert
        assertEquals("0.0", actual);
    }

    @Test (expected = NumberFormatException.class)
    public void specificationTen_WrongInputsDoubleSlash_ReturnsException() {
        // Act
        String actual = calc.calculateExpression("0+0//");

        // Assert
        assertEquals("0.0", actual);
    }
}
