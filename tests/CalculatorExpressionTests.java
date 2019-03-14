
import main.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;
public class CalculatorExpressionTests {
    // Tests for the calculateExpression method
    @Test
    public void inputWithDecimals_ReturnsMathResult() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3,4+2,8");

        // Assert
        assertEquals("6.2", actual);
    }
    @Test
    public void inputSingleNumber_ReturnsDoubleString() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3");

        // Assert
        assertEquals("3.0", actual);
    }

    @Test
    public void inputSingleAddition_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("10+4");

        // Assert
        assertEquals("14.0",actual);
    }

    @Test
    public void inputMultipleAdditions_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3+4+3");

        // Assert
        assertEquals("10.0", actual);
    }

    @Test
    public void inputSingleSubtraction_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4-2");

        // Assert
        assertEquals("2.0", actual);
    }

    @Test
    public void inputMultipleSubtractions_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("6-2-2");

        // Assert
        assertEquals("2.0", actual);
    }

    @Test
    public void inputSingleMultiplication_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("50*2");

        // Assert
        assertEquals("100.0", actual);
    }

    @Test
    public void inputMultipleMultiplication_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4*3*2");

        // Assert
        assertEquals("24.0", actual);
    }

    @Test
    public void inputSingleDivision_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4/2");

        // Assert
        assertEquals("2.0", actual);
    }

    @Test
    public void inputMultipleDivision_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("8/4/2");

        // Assert
        assertEquals("1.0", actual);
    }

    @Test
    public void inputSingleModulus_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("9%2");

        // Assert
        assertEquals("1.0", actual);
    }

    @Test
    public void inputMultipleModulus_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("27%20%1");

        // Assert
        assertEquals("0.0", actual);
    }

    @Test
    public void inputAdditionAndSubtraction_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4+3-1");

        // Assert
        assertEquals("6.0", actual);
    }

    @Test
    public void inputMultiplicationAndAddition_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4*3+3");

        // Assert
        assertEquals("15.0", actual);
    }

    @Test
    public void inputAdditionAndMultiplication_ReturnsStringWithDoubleAnswer() {
        // Remember Multiplication goes first!
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3+4*3");

        // Assert
        assertEquals("15.0", actual);
    }

    @Test
    public void inputMultiplicationAndSubtraction_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4*3-2");

        // Assert
        assertEquals("10.0", actual);
    }

    @Test
    public void inputSubtractionAndMultiplication_ReturnsStringWithDoubleAnswer() {
        // Remember Multiplication goes first!
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("2-4*3");

        // Assert
        assertEquals("-10.0", actual);
    }

    @Test
    public void inputDivisionAndAddition_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4/2+3");

        // Assert
        assertEquals("5.0", actual);
    }

    @Test
    public void inputAdditionAndDivision_ReturnsStringWithDoubleAnswer() {
        // Remember division calculates first!
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3+4/2");

        // Assert
        assertEquals("5.0", actual);
    }

    @Test
    public void inputMultiplicationAndDivision_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3*4/2");

        // Assert
        assertEquals("6.0", actual);
    }

    @Test
    public void inputDivisionAndMultiplication_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4/2*3");

        // Assert
        assertEquals("6.0", actual);
    }

    @Test
    public void inputAdditionAndModulus_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4+2%3");

        // Assert
        assertEquals("6.0", actual);
    }

    @Test
    public void inputAdditionAndParenthesis_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("3+(3+4)");

        // Assert
        assertEquals("10.0", actual);
    }

    @Test
    public void inputSubtractionAndParenthesis_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("4-(2+1)");

        // Assert
        assertEquals("1.0", actual);
    }

    @Test
    public void inputDivisionAndParenthesis_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("6/(4-2)");

        // Assert
        assertEquals("3.0", actual);
    }

    @Test
    public void inputMultiplicationAndParenthesis_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("2*(3-1)");

        // Assert
        assertEquals("4.0", actual);
    }

    @Test
    public void inputNumberAndParenthesis_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("2(3-1)");

        // Assert
        assertEquals("4.0", actual);
    }

    @Test
    public void inputParenthesisAndParenthesis_ReturnsStringWithDoubleAnswer() {
        // Arrange
        Calculator  calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("(4-3)(5+10)");

        // Assert
        assertEquals("15.0", actual);
    }

    @Test
    public void inputDoubleSubtractions_ReturnsStringWithDoubleAnswerAfterConvertedToAddition() {
        // Assert
        Calculator calc = new Calculator();

        // Act
        String actual = calc.calculateExpression("5--5");

        // Assert
        assertEquals("10.0", actual);
    }



}
