package model;

import java.util.Observable;
import java.util.Observer;

import utils.Converter;
import utils.Decode;
import view.SimulatorWindow;

public class ControlUnit implements Observer {
    /**
     * Negative Flag
     * Holds a 1 if the previous instruction generated a negative value, and holds a 0 otherwise.
     */
    private int myNFlag;

    /**
     * Zero Flag
     * Holds a 1 if the previous instruction generated a zero as a value, and holds a 0 otherwise.
     */
    private int myZFlag;

    /**
     * Overflow Flag
     * Holds a 1 if the previous instruction caused a signed overflow, and holds a 0 otherwise.
     * <p>
     * An overflow can look like a positiveNum + positiveNum = negativeNum,
     * negativeNum + negativeNum = positiveNum,
     * positiveNum - negativeNum = negativeNum,
     * or negativeNum - positiveNum = positiveNum
     */
    private int myVFlag;

    /**
     * Holds a 1 if the previous instruction produced a carry value (like borrowing on subtraction),
     * and holds a 0 otherwise.
     */
    private int myCFlag;

    private int myIndexRegister;

    private int PC = 0x0000;
    private int AR = 0x0000;
    private int IR = 0x000000;
    SimulatorWindow window;

    private Decode decode = new Decode();
    public MemoryDump memoryDump = new MemoryDump();

    public ControlUnit(SimulatorWindow window) {
        this.window = window;
    }

    public ControlUnit() {

    }

    public void executeNextInstruction() {
        Instruction nextInstruction = getNextInstruction();
        nextInstruction.execute(this);
        checkCharOutput(nextInstruction);
        incrementPC();
        updateCPU();
    }

    public void startCycle() {
        boolean stop = false;
        Instruction nextInstruction = getNextInstruction();
        nextInstruction.execute(this);
        checkCharOutput(nextInstruction);
        incrementPC();
        updateCPU();

        if (!stop) {
            startCycle();
        }
    }

    private void checkCharOutput(Instruction nextInstruction) {
        if (nextInstruction instanceof CharOut) {
            CharOut charOutInstruction = (CharOut) nextInstruction;
            window.setOutArea(charOutInstruction.getOutput());
        }
    }

    private void updateCPU() {
        Instruction currentInstruction = getNextInstruction();
        window.irText.setText(String.format("0x%06X", this.IR));
        window.arText.setText(String.format("0x%06X", this.AR));
        window.pcText.setText(String.format("0x%04X", this.PC));
        window.isText.setText(String.format("0x%02X", Converter.binToDecimal(currentInstruction.getOpcode())));
        window.osText.setText(String.format("0x%04X", Converter.binToDecimal(currentInstruction.getOperand())));
        System.out.println(currentInstruction.getOpcode() + currentInstruction.getRegisterSpecifier() + " " + currentInstruction.getOperand());
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        if (window.charEntered.length() == 1) {
            synchronized (ControlUnit.this) {
                ControlUnit.this.notify();
            }
        }
        if (window.res == true) {
            this.PC = 0x0000;
        }
    }

    private void incrementPC() {
        this.PC += 0x0001;
    }

    public Instruction getNextInstruction() {
        int instructionStoredInPC = getNextInstructionFromMemory();
        this.IR = instructionStoredInPC;
        Instruction nextInstruction = Decode.decodeInstruction(String.format("%06X", this.IR));
        return nextInstruction;
    }
    public int getNextInstructionFromMemory() {
        return Integer.parseInt(memoryDump.fetch(this.PC), 16);
    }

    public void setMyIndexRegister(int myIndexRegister) {
        this.myIndexRegister = myIndexRegister;
    }

    public void setMyNFlag(int myNFlag) {
        this.myNFlag = myNFlag;
    }

    public void setMyZFlag(int myZFlag) {
        this.myZFlag = myZFlag;
    }

    public void setMyVFlag(int myVFlag) {
        this.myVFlag = myVFlag;
    }

    public void setMyCFlag(int myCFlag) {
        this.myCFlag = myCFlag;
    }

    public int getMyNFlag() {
        return myNFlag;
    }

    public int getMyVFlag() {
        return myVFlag;
    }

    public int getMyZFlag() {
        return myZFlag;
    }

    public int getMyCFlag() {
        return myCFlag;
    }

    public int getAR() {
        return AR;
    }

    public void setAR(int AR) {
        this.AR = AR;
    }
}

class myRunnable implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
