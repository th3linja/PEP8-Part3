package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ORrTest {
    @Test
    void testOr() throws InterruptedException {
        ControlUnit controlUnit = new ControlUnit();
        controlUnit.setAR(0);
        Instruction add = new Addr("1010","0","000","000000000000001");
        add.execute(controlUnit);
        assertEquals(1,controlUnit.getAR());
    }

}