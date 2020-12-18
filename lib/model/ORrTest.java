package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ORrTest {
    @Test
    void testOr() throws InterruptedException {
        ControlUnit controlUnit = new ControlUnit();
        controlUnit.setAR(0);
        Instruction Or = new ORr("1010", "0", "000", "0000000000000001");
        Or.execute(controlUnit);
        assertEquals(1, controlUnit.getAR());
    }
}