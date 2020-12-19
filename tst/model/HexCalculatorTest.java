package model;

import model.HexCalculator;
import model.Hexadecimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexCalculatorTest {

    /**
     * Test the addition method (27 + 1 = 28 in hex)
     */
    @Test
    void testAdd() {
        Hexadecimal b1 = new Hexadecimal("1b");
        Hexadecimal b2 = new Hexadecimal("1");
        Hexadecimal actual = (Hexadecimal) HexCalculator.add(b1, b2);
        Hexadecimal expected = new Hexadecimal("1c");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the subtraction method (27 - 1 = 26 in hex)
     */
    @Test
    void testSubtract() {
        Hexadecimal b1 = new Hexadecimal("1b");
        Hexadecimal b2 = new Hexadecimal("1");
        Hexadecimal actual = (Hexadecimal) HexCalculator.subtract(b1, b2);
        Hexadecimal expected = new Hexadecimal("1a");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the multiply method (27 * 1 = 21 in hex)
     */
    @Test
    void testMultiply() {
        Hexadecimal b1 = new Hexadecimal("1b");
        Hexadecimal b2 = new Hexadecimal("1");
        Hexadecimal actual = (Hexadecimal) HexCalculator.multiply(b1, b2);
        Hexadecimal expected = new Hexadecimal("1b");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the divide method (27 / 1 = 27 in hex)
     */
    @Test
    void testDivide() {
        Hexadecimal b1 = new Hexadecimal("1b");
        Hexadecimal b2 = new Hexadecimal("1");
        Hexadecimal actual = (Hexadecimal) HexCalculator.divide(b1, b2);
        Hexadecimal expected = new Hexadecimal("1b");
        assertEquals(expected.getNumber(), actual.getNumber());
    }

    /**
     * Test the mod method (27 % 2 = 1)
     */
    @Test
    void testMod() {
        Hexadecimal b1 = new Hexadecimal("1b");
        Hexadecimal b2 = new Hexadecimal("2");
        Hexadecimal actual = (Hexadecimal) HexCalculator.mod(b1, b2);
        Hexadecimal expected = new Hexadecimal("1");
        assertEquals(expected.getNumber(), actual.getNumber());
    }
}