package Tests.model;

import model.Binary;
import model.BinaryCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryCalculatorTest {

    /**
     * Test the addition method (3 + 2 = 5 in Binary)
     */
    @Test
    void testAdd() {
        Binary b1 = new Binary("11");
        Binary b2 = new Binary("10");
        Binary actual = (Binary) BinaryCalculator.add(b1, b2);
        Binary expected = new Binary("101");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the subtraction method (3 - 2 = 1 in Binary)
     */
    @Test
    void testSubtract() {
        Binary b1 = new Binary("11");
        Binary b2 = new Binary("10");
        Binary actual = (Binary) BinaryCalculator.subtract(b1, b2);
        Binary expected = new Binary("1");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the multiply method (3 * 2 = 6 in Binary)
     */
    @Test
    void testMultiply() {
        Binary b1 = new Binary("11");
        Binary b2 = new Binary("10");
        Binary actual = (Binary) BinaryCalculator.multiply(b1, b2);
        Binary expected = new Binary("110");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the divide method (3 / 2 = 1 in Binary)
     */
    @Test
    void testDivide() {
        Binary b1 = new Binary("11");
        Binary b2 = new Binary("10");
        Binary actual = (Binary) BinaryCalculator.divide(b1, b2);
        Binary expected = new Binary("1");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the mod method (3 % 2 = 1 in Binary)
     */
    @Test
    void testMod() {
        Binary b1 = new Binary("11");
        Binary b2 = new Binary("10");
        Binary actual = (Binary) BinaryCalculator.mod(b1, b2);
        Binary expected = new Binary("1");
        assertEquals(expected.getNumber(), actual.getNumber());
    }
}