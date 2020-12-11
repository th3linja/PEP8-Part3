package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DecimalTest {

    /**
     * Test if compare method works.
     */
    @Test
    void testCompare() {
        Decimal d1 = new Decimal("1");
        Decimal d2 = new Decimal("2");
        int actual = d1.compare(d2);
        assertEquals(actual, -1);
    }

    /**
     * Test if two Binary objects are equal to each other.
     * (Case: different Binary objects)
     */
    @Test
    void testEquals() {
        Decimal d1 = new Decimal("1");
        Decimal d2 = new Decimal("2");
        boolean actual = d1.equals(d2);
        assertEquals(actual, false);
    }

    /**
     * Test if two Binary objects are equal to each other.
     * (Case: different objects)
     */
    @Test
    void testEquals2() {
        Decimal d1 = new Decimal("1");
        String d2 = "2";
        boolean actual = d1.equals(d2);
        assertEquals(actual, false);
    }

    /**
     * Test if two Binary objects are equal to each other.
     * (Case: Same Binary objects)
     */
    @Test
    void testEquals3() {
        Decimal d1 = new Decimal("1");
        Decimal d2 = d1;
        boolean actual = d1.equals(d2);
        assertEquals(actual, true);
    }

    /**
     * Test if setter method works
     */
    @Test
    void testSetNumber() {
        Decimal d = new Decimal("1");
        d.setNumber("2");
        String actual = d.getNumber();
        assertEquals(actual, "2");
    }

}