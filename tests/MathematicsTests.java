import main.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathematicsTests {
    // Tests for the separate math-methods
    @Test
    public void additionTest_ReturnsDouble() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.addition(3.3,4.7);

        // Assert
        assertEquals(8d,actual,0.111);
    }

    @Test
    public void subtractionTest_ReturnsDouble() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.subtraction(4.1, 3.1);

        // Assert
        assertEquals(1d, actual, 0.111);
    }

    @Test
    public void multiplicationTest_ReturnsDouble() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.multiplication(99.7, 3.6);

        // Assert
        assertEquals(358.92d, actual, 0.111);
    }

    @Test
    public void divisionTest_ReturnsDouble() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.division(46.2, 6.3);

        // Assert
        assertEquals(7.3333333333d, actual, 0.111);
    }

    @Test
    public void modulusTest_ReturnsDouble() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        double actual = calc.modulus(9.0, 2.0);

        // Assert
        assertEquals(1d, actual, 0.111);
    }
}
