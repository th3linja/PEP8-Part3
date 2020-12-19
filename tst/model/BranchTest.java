package model;

import model.Branch;
import model.ControlUnit;
import model.Instruction;
import model.Ldr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BranchTest {

    String BROpcode = "0000010";
    String BRLEOpcode = "0000011";
    String BRLTOpcode = "0000100";
    String BREQOpcode = "0000101";
    String BRNEOpcode = "0000110";
    String BRGEOpcode = "0000111";
    String BRGTOpcode = "0001000";
    String BRVOpcode = "0001001";
    String BRCOpcode = "0001010";

    ControlUnit controlUnit = new ControlUnit(null);

    //BR, BRLE, BRLT, BREQ, BRNE, BRGE, BRGT
    @Test
    void testBR() throws InterruptedException {
        Branch BRInstruction = new Branch(BROpcode, "", "0", "0000000000000100");
        controlUnit.executeSingleInstruction(BRInstruction);
        assertEquals(4, controlUnit.getPC());
    }

    @Test
    void testBRLE() throws InterruptedException {
        //Load AR with 1. Since AR <= BRLE opcode. Then set PC to BRLE opcode.
        Instruction loadInstruction = new Ldr("1100", "0", "000", "0000000000000001");
        Branch BRLE = new Branch(BRLEOpcode, "", "0", "0000000000000100");
        controlUnit.executeSingleInstruction(loadInstruction);
        controlUnit.executeSingleInstruction(BRLE);
        assertEquals(4, controlUnit.getPC());
    }

    @Test
    void testBRLT() throws InterruptedException {
        //Load AR with 1. Since AR < BRLT opcode. Then set PC to BRLE opcode.
        Instruction loadInstruction = new Ldr("1100", "0", "000", "0000000000000001");
        Branch BRLT = new Branch(BRLTOpcode, "", "0", "0000000000000100");
        controlUnit.executeSingleInstruction(loadInstruction);
        controlUnit.executeSingleInstruction(BRLT);
        assertEquals(4, controlUnit.getPC());
    }

    @Test
    void testBREQ() throws InterruptedException {
        //Load AR with 4. Since AR = BR opcode. Then set PC to BRLE opcode.
        Instruction loadInstruction = new Ldr("1100", "0", "000", "0000000000000100");
        Branch BREQ = new Branch(BREQOpcode, "", "0", "0000000000000100");
        controlUnit.executeSingleInstruction(loadInstruction);
        controlUnit.executeSingleInstruction(BREQ);
        assertEquals(4, controlUnit.getPC());
    }

    @Test
    void testBRNE() throws InterruptedException {
        //Load AR with 0. Since AR != BR opcode. Then set PC to BRLE opcode.
        Instruction loadInstruction = new Ldr("1100", "0", "000", "0000000000000000");
        Branch BRNE = new Branch(BRNEOpcode, "", "0", "0000000000000100");
        controlUnit.executeSingleInstruction(loadInstruction);
        controlUnit.executeSingleInstruction(BRNE);
        assertEquals(4, controlUnit.getPC());
    }

    @Test
    void testBRGE() throws InterruptedException {
        //Load AR with 5. Since AR >= BR opcode. Then set PC to BRLE opcode.
        Instruction loadInstruction = new Ldr("1100", "0", "000", "0000000000000101");
        Branch BRGE = new Branch(BRGEOpcode, "", "0", "0000000000000100");
        controlUnit.executeSingleInstruction(loadInstruction);
        controlUnit.executeSingleInstruction(BRGE);
        assertEquals(4, controlUnit.getPC());
    }

    @Test
    void testBRGT() throws InterruptedException {
        //Load AR with 5. Since AR > BR opcode. Then set PC to BRLE opcode.
        Instruction loadInstruction = new Ldr("1100", "0", "000", "0000000000000101");
        Branch BRGT = new Branch(BRGTOpcode, "", "0", "0000000000000100");
        controlUnit.executeSingleInstruction(loadInstruction);
        controlUnit.executeSingleInstruction(BRGT);
        assertEquals(4, controlUnit.getPC());
    }

    @Test
    void testBRV() throws InterruptedException {
        controlUnit.setMyVFlag(1);
        Branch BRV = new Branch(BRVOpcode, "", "0", "0000000000000111");
        controlUnit.executeSingleInstruction(BRV);
        assertEquals(7, controlUnit.getPC());
    }

    @Test
    void testBRC() throws InterruptedException {
        controlUnit.setMyCFlag(1);
        Branch BRC = new Branch(BRCOpcode, "", "0", "0000000000000111");
        controlUnit.executeSingleInstruction(BRC);
        assertEquals(7, controlUnit.getPC());
    }
}
