
import main.Calculator;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
public class CalculatorTests {
    // Tests for the calculateExpression method
    @Test
    public void calculateExpression_StringToDouble_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String acutal = calc.calculateExpression("3");

        // Assert
        assertEquals("3.0", acutal);
    }

    @Test
    public void calculateExpression_SingleAddition_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3+4");

        // Assert
        assertEquals("7.0",actual);
    }

    @Test
    public void calculateExpression_MultiAddition_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3+4+3");

        // Assert
        assertEquals("10.0", actual);
    }

    @Test
    public void calculateExpression_SingleSubtraction_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4-2");

        // Assert
        assertEquals("2.0", actual);
    }

    @Test
    public void calculateExpression_MultiSubtraction_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("6-2-2");

        // Assert
        assertEquals("2.0", actual);
    }

    @Test
    public void calculateExpression_SingleMultiplication_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("2*2");

        // Assert
        assertEquals("4.0", actual);
    }

    @Test
    public void calculateExpression_MultiMultiplication_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4*3*2");

        // Assert
        assertEquals("24.0", actual);
    }

    @Test
    public void calculateExpression_SingleDivision_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4/2");

        // Assert
        assertEquals("2.0", actual);
    }

    @Ignore
    @Test
    public void calculateExpression_MultiDivision_Test() {
        fail("8/4/2");
    }

    @Ignore
    @Test
    public void calculateExpression_SingleModulus_Test() {
        fail("9%2");
    }

    @Ignore
    @Test
    public void calculateExpression_MultiModulus_Test() {
        fail("15%2%2");
    }

    @Ignore
    @Test
    public void calculateExpression_AdditionSubtraction_Test() {
        fail("4+3-1");
    }

    @Ignore
    @Test
    public void calculateExpression_MultiplicationAddition_Test() {
        fail("4*3+3");
    }

    @Ignore
    @Test
    public void calculateExpression_AdditionMultiplication_Test() {
        // Remember Multiplication goes first!
        fail("3+4*3");
    }

    @Ignore
    @Test
    public void calculateExpression_MultiplicationSubtraction_Test() {
        fail("4*3-2");
    }

    @Ignore
    @Test
    public void calculateExpression_SubtractionMultiplication_Test() {
        // Remember Multiplication goes first!
        fail("2-4*3");
    }

    @Ignore
    @Test
    public void calculateExpression_DivisionAddition_Test() {
        fail("4/2+3");
    }

    @Ignore
    @Test
    public void calculateExpression_AdditionDivision_Test() {
        // Remember division calculates first!
        fail("3+4/2");
    }

    @Ignore
    @Test
    public void calculateExpression_MultiplicationDivision_Test() {
        fail("3*4/2");
    }

    @Ignore
    @Test
    public void calculateExpression_DivisionMultiplication_Test() {
        fail("4/2*3");
    }

    @Ignore
    @Test
    public void calculateExpression_AdditionParenthesis_Test() {
        fail("3+(3+4)");
    }

    @Ignore
    @Test
    public void calculateExpression_SubtractionParenthesis_Test() {
        fail("4-(2+1)");
    }

    @Ignore
    @Test
    public void calculateExpression_DivisionParenthesis_Test() {
        fail("6/(4-2");
    }

    @Ignore
    @Test
    public void calculateExpression_MultiplicationParenthesis_Test() {
        fail("2*(3-1)");
    }

    @Ignore
    @Test
    public void calculateExpression_numberParenthesis_Test() {
        fail("2(3-1)");
    }

    @Ignore
    @Test
    public void calculateExpression_ParenthesisParenthesis_Test() {
        fail("(4-3)(5+10)");
    }

    @Ignore
    @Test
    public void calculateExpression_LongCalculation_Test() {
        fail("3+4(4/2)/2");
    }

    @Ignore
    @Test
    public void calculateExpression_InfiniteResult_Test() {
        fail("10/3");
    }


    // Tests for the separate math-methods
    @Test
    public void additionTest() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.addition(3.0,4.0);

        // Assert
        assertEquals(7d,actual,0.111);
    }

    @Test
    public void subtractionTest() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.subtraction(4.0, 3.0);

        // Assert
        assertEquals(1d, actual, 0.111);
    }

    @Test
    public void multiplicationTest() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.multiplication(4.0, 3.0);

        // Assert
        assertEquals(12d, actual, 0.111);
    }

    @Test
    public void divisionTest() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.division(4.0, 2.0);

        // Assert
        assertEquals(2d, actual, 0.111);
    }

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
