package Tests.model;

import model.Binary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTest {

    /**
     * Test if empty constructor is functioning correctly
     */
    @Test
    void testEmptyConstructor() {
        Binary b = new Binary();
        String expected = b.getNumber();
        String actual = "000000000000000000000000";
        assertEquals(expected, actual);
    }

    /**
     * Test if compare method works.
     */
    @Test
    void testCompare() {
        Binary b1 = new Binary("10");
        Binary b2 = new Binary("11");
        int actual = b1.compare(b2);
        assertEquals(actual, -1);
    }

    /**
     * Test if two Binary objects are equal to each other.
     * (Case: different Binary objects)
     */
    @Test
    void testEquals() {
        Binary b1 = new Binary("10");
        Binary b2 = new Binary("11");
        boolean actual = b1.equals(b2);
        assertEquals(actual, false);
    }

    /**
     * Test if two Binary objects are equal to each other.
     * (Case: different objects)
     */
    @Test
    void testEquals2() {
        Binary b1 = new Binary("10");
        String b2 = "11";
        boolean actual = b1.equals(b2);
        assertEquals(actual, false);
    }

    /**
     * Test if two Binary objects are equal to each other.
     * (Case: Same Binary objects)
     */
    @Test
    void testEquals3() {
        Binary b1 = new Binary("10");
        Binary b2 = b1;
        boolean actual = b1.equals(b2);
        assertEquals(actual, true);
    }

    /**
     * Test if setter method works
     */
    @Test
    void testSetNumber() {
        Binary b = new Binary("10");
        b.setNumber("11");
        String actual = b.getNumber();
        assertEquals(actual, "11");
    }
}