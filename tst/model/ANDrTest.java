package Tests.model;

import model.ANDr;
import model.ControlUnit;
import model.Instruction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ANDrTest {
    @Test
    void testAND() throws InterruptedException {
        ControlUnit controlUnit = new ControlUnit();
        controlUnit.setAR(3);
        Instruction and = new ANDr("0111", "0", "000", "0000000000000001");
        and.execute(controlUnit);
        assertEquals(1, controlUnit.getAR());
    }
}