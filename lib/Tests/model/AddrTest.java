package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddrTest {

    @Test
    void testVBit() throws InterruptedException {
        ControlUnit controlUnit = new ControlUnit();
        controlUnit.setAR(1);
        Instruction add = new Addr("0111","0","000","0111111111111111");
        add.execute(controlUnit);
        assertEquals(1,controlUnit.getMyVFlag());
    }
}