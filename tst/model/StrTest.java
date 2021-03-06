package model;

import model.ControlUnit;
import model.Instruction;
import model.Str;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrTest {

    @Test
    void testStr() throws InterruptedException {
        ControlUnit controlUnit = new ControlUnit();
        controlUnit.setAR(10);
        Instruction str = new Str("1110", "0", "001", "0000000000000001");
        str.execute(controlUnit);
        assertEquals("0A", controlUnit.memoryDump.getMemory(1));
    }
}