package Tests.model;

import model.Decimal;
import model.DecimalCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalCalculatorTest {

    /**
     * Test the addition method (2 + 1 = 3)
     */
    @Test
    void testAdd() {
        Decimal b1 = new Decimal("2");
        Decimal b2 = new Decimal("1");
        Decimal actual = (Decimal) DecimalCalculator.add(b1, b2);
        Decimal expected = new Decimal("3");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the subtraction method (2 - 1 = 1)
     */
    @Test
    void testSubtract() {
        Decimal b1 = new Decimal("2");
        Decimal b2 = new Decimal("1");
        Decimal actual = (Decimal) DecimalCalculator.subtract(b1, b2);
        Decimal expected = new Decimal("1");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the multiply method (2 * 1 = 2)
     */
    @Test
    void testMultiply() {
        Decimal b1 = new Decimal("2");
        Decimal b2 = new Decimal("1");
        Decimal actual = (Decimal) DecimalCalculator.multiply(b1, b2);
        Decimal expected = new Decimal("2");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the divide method (2 / 1 = 2)
     */
    @Test
    void testDivide() {
        Decimal b1 = new Decimal("2");
        Decimal b2 = new Decimal("1");
        Decimal actual = (Decimal) DecimalCalculator.divide(b1, b2);
        Decimal expected = new Decimal("2");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the mod method (2 % 1 = 0)
     */
    @Test
    void testMod() {
        Decimal b1 = new Decimal("2");
        Decimal b2 = new Decimal("1");
        Decimal actual = (Decimal) DecimalCalculator.mod(b1, b2);
        Decimal expected = new Decimal("0");
        assertEquals(expected.getNumber(), actual.getNumber());
    }
}