
import main.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;
public class CalculatorExpressionTests {
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
        String actual = calc.calculateExpression("10+4");

        // Assert
        assertEquals("14.0",actual);
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
        String actual = calc.calculateExpression("50*2");

        // Assert
        assertEquals("100.0", actual);
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

    @Test
    public void calculateExpression_MultiDivision_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("8/4/2");

        // Assert
        assertEquals("1.0", actual);
    }

    @Test
    public void calculateExpression_SingleModulus_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("9%2");

        // Assert
        assertEquals("1.0", actual);
    }

    @Test
    public void calculateExpression_MultiModulus_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("27%20%1");

        // Assert
        assertEquals("0.0", actual);
    }

    @Test
    public void calculateExpression_AdditionSubtraction_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4+3-1");

        // Assert
        assertEquals("6.0", actual);
    }

    @Test
    public void calculateExpression_MultiplicationAddition_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4*3+3");

        // Assert
        assertEquals("15.0", actual);
    }

    @Test
    public void calculateExpression_AdditionMultiplication_Test() {
        // Remember Multiplication goes first!
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3+4*3");

        // Assert
        assertEquals("15.0", actual);
    }

    @Test
    public void calculateExpression_MultiplicationSubtraction_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4*3-2");

        // Assert
        assertEquals("10.0", actual);
    }

    @Test
    public void calculateExpression_SubtractionMultiplication_Test() {
        // Remember Multiplication goes first!
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("2-4*3");

        // Assert
        assertEquals("-10.0", actual);
    }

    @Test
    public void calculateExpression_DivisionAddition_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4/2+3");

        // Assert
        assertEquals("5.0", actual);
    }

    @Test
    public void calculateExpression_AdditionDivision_Test() {
        // Remember division calculates first!
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3+4/2");

        // Assert
        assertEquals("5.0", actual);
    }

    @Test
    public void calculateExpression_MultiplicationDivision_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3*4/2");

        // Assert
        assertEquals("6.0", actual);
    }

    @Test
    public void calculateExpression_DivisionMultiplication_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4/2*3");

        // Assert
        assertEquals("6.0", actual);
    }

    @Test
    public void calculateExpression_AdditionModulus_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4+2%3");

        // Assert
        assertEquals("6.0", actual);
    }

    @Test
    public void calculateExpression_AdditionParenthesis_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3+(3+4)");

        // Assert
        assertEquals("10.0", actual);
    }

    @Test
    public void calculateExpression_SubtractionParenthesis_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4-(2+1)");

        // Assert
        assertEquals("1.0", actual);
    }

    @Test
    public void calculateExpression_DivisionParenthesis_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("6/(4-2)");

        // Assert
        assertEquals("3.0", actual);
    }

    @Test
    public void calculateExpression_MultiplicationParenthesis_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("2*(3-1)");

        // Assert
        assertEquals("4.0", actual);
    }

    @Test
    public void calculateExpression_numberParenthesis_Test() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("2(3-1)");

        // Assert
        assertEquals("4.0", actual);
    }

    @Test
    public void calculateExpression_ParenthesisParenthesis_Test() {
        // Arrange
        Calculator  calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("(4-3)(5+10)");

        // Assert
        assertEquals("15.0", actual);
    }

    @Test
    public void calculateExpression_TwoSubtractions_Test() {
        // Assert
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("5--5");

        // Assert
        assertEquals("10.0", actual);
    }



}
