package Tests.model;

import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressingBitsTest {

    ControlUnit controlUnit = new ControlUnit(null);

    @Test
    void testZBit() throws InterruptedException {
        // Command will Load the A register with the value of 1. Then add a -1 to it. Should trigger the Z addressing bit.
        Instruction loadInstruction = new Ldr("1100","0","000", "0000000000000001");
        Instruction addInstruction = new Addr("0111", "0", "000", "1111111111111111");
        Instruction stopInstruction = new Stop("0000", "0000");
        controlUnit.executeSingleInstruction(loadInstruction);
        controlUnit.executeSingleInstruction(addInstruction);
        controlUnit.executeSingleInstruction(stopInstruction);
        assertEquals(1, controlUnit.getMyZFlag());
    }

    @Test
    void testNBit() throws InterruptedException {
        // Command will Load the the A register with the value of 1. Then subtract 2 to it. Should trigger the N bit.
        Instruction loadInstruction = new Ldr("1100","0","000", "0000000000000001");
        Instruction subtractInstruction = new Subtract("1000", "0", "000", "0000000000000010");
        Instruction stopInstruction = new Stop("0000", "0000");
        controlUnit.executeSingleInstruction(loadInstruction);
        controlUnit.executeSingleInstruction(subtractInstruction);
        controlUnit.executeSingleInstruction(stopInstruction);
        assertEquals(1, controlUnit.getMyNFlag());
    }

    @Test
    void testCBit() throws InterruptedException {
        // Command will Load the A register with the value of 32767(Largest 16 bit number). Then Add 1 to the A Register
        //    0111111111111111
        //    0000000000000001 +
        // = 01000000000000000
        Instruction loadInstruction = new Ldr("1100", "0", "000", "0111111111111111");
        Instruction addInstruction = new Addr("0111", "0", "000", "0000000000000001");
        Instruction stopInstruction = new Stop("0000", "0000");
        controlUnit.executeSingleInstruction(loadInstruction);
        controlUnit.executeSingleInstruction(addInstruction);
        controlUnit.executeSingleInstruction(stopInstruction);
        assertEquals(1, controlUnit.getMyCFlag());
    }

    @Test
    void testVBit() throws InterruptedException {
        // Command will Load the A register with the value of 32767(Largest 16 bit number). Then Add 1 to the A Register
        //    0111111111111111
        //    0000000000000001 +
        // =  1000000000000000
        Instruction loadInstruction = new Ldr("1100", "0", "000", "0111111111111111");
        Instruction addInstruction = new Addr("0111", "0", "000", "0000000000000001");
        Instruction stopInstruction = new Stop("0000", "0000");
        controlUnit.executeSingleInstruction(loadInstruction);
        controlUnit.executeSingleInstruction(addInstruction);
        controlUnit.executeSingleInstruction(stopInstruction);
        assertEquals(1, controlUnit.getMyVFlag());
    }
}
