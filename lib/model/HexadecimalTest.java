package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HexadecimalTest {

    /**
     * Test if compare method works.
     */
    @Test
    void testCompare() {
        Hexadecimal h1 = new Hexadecimal("1B");
        Hexadecimal h2 = new Hexadecimal("1A");
        int actual = h1.compare(h2);
        assertEquals(actual, 1);
    }

    /**
     * Test if two Hexadecimal objects are equal to each other.
     * (Case: different Hexadecimal objects)
     */
    @Test
    void testEquals() {
        Hexadecimal h1 = new Hexadecimal("1B");
        Hexadecimal h2 = new Hexadecimal("1A");
        boolean actual = h1.equals(h2);
        assertEquals(actual, false);
    }

    /**
     * Test if two Hexadecimal objects are equal to each other.
     * (Case: different Hexadecimal objects)
     */
    @Test
    void testEquals2() {
        Hexadecimal h1 = new Hexadecimal("1B");
        String h2 = "1A";
        boolean actual = h1.equals(h2);
        assertEquals(actual, false);
    }

    /**
     * Test if two Hexadecimal objects are equal to each other.
     * (Case: same Hexadecimal objects)
     */
    @Test
    void testEquals3() {
        Hexadecimal h1 = new Hexadecimal("1B");
        Hexadecimal h2 = h1;
        boolean actual = h1.equals(h2);
        assertEquals(actual, true);
    }

    /**
     * Test if setter method works
     */
    @Test
    void testSetNumber() {
        Hexadecimal b = new Hexadecimal("0");
        b.setNumber("1A");
        String actual = b.getNumber();
        assertEquals(actual, "1A");
    }

}