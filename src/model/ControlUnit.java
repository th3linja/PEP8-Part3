package model;

import java.util.Observable;
import java.util.Observer;

import utils.Converter;
import utils.Decode;
import view.SimulatorWindow;

public class ControlUnit implements Observer {
	/**
	 * Negative Flag Holds a 1 if the previous instruction generated a negative
	 * value, and holds a 0 otherwise.
	 */
	private int myNFlag;

	/**
	 * Zero Flag Holds a 1 if the previous instruction generated a zero as a value,
	 * and holds a 0 otherwise.
	 */
	private int myZFlag;

	/**
	 * Overflow Flag Holds a 1 if the previous instruction caused a signed overflow,
	 * and holds a 0 otherwise.
	 * <p>
	 * An overflow can look like a positiveNum + positiveNum = negativeNum,
	 * negativeNum + negativeNum = positiveNum, positiveNum - negativeNum =
	 * negativeNum, or negativeNum - positiveNum = positiveNum
	 */
	private int myVFlag;

	/**
	 * Holds a 1 if the previous instruction produced a carry value (like borrowing
	 * on subtraction), and holds a 0 otherwise.
	 */
	private int myCFlag;

	private int myIndexRegister;
	private boolean stop = false;

	private int PC = 0x0000;
	private int AR = 0x0000;
	private int IR = 0x000000;
	SimulatorWindow window;

	public MemoryDump memoryDump = new MemoryDump();

	public ControlUnit(SimulatorWindow window) {
		this.window = window;
	}

	public ControlUnit() {

	}

	public void executeNextInstruction() throws InterruptedException {
		Instruction nextInstruction = getNextInstruction();
		nextInstruction.execute(this);
		checkCharOutput(nextInstruction);
		incrementPC();
		updateCPU();
	}

	public void executeSingleInstruction(Instruction instr) throws InterruptedException {
		instr.execute(this);
	}

	public void startCycle() throws InterruptedException {
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
			window.setOutArea(window.getOutArea() + charOutInstruction.getOutput());
		}
	}

	public void executeCharIn(Instruction instruction) throws InterruptedException {
		// Wait for a character to be pressed in the terminal window
		synchronized (this) {
			while (window.charEntered.length() != 1) {
				try {
					window.inArea.setEditable(true);
					this.wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		int i = Integer.valueOf(window.charEntered.charAt(0));
		// String hex = Converter.binToHex(String.format("%8s",
		// Converter.decimalToBinary(i)).replace(' ', '0')).strip();
		memoryDump.setMemory(Converter.binToHex(instruction.getOperand()), i);
		window.appendOutArea("Entered : '" + window.charEntered + "' at " + Converter.binToHex(instruction.getOperand())
				+ " in memory.\n");
		window.charEntered = "";
	}

	private void updateCPU() {
		Instruction currentInstruction = getNextInstruction();
		window.irText.setText(String.format("0x%06X", this.IR));
		window.arText.setText(String.format("0x%06X", this.AR));
		window.pcText.setText(String.format("0x%04X", this.PC));
		window.isText.setText(String.format("0x%02X", Converter.binToDecimal(currentInstruction.getOpcode())));
		window.osText.setText(String.format("0x%04X", Converter.binToDecimal(currentInstruction.getOperand())));
	}

	@Override
	public void update(Observable o, Object arg) {
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
		this.PC += 0x0003;
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

	public int getMyIndexRegister() {
		return myIndexRegister;
	}

	public int getAR() {
		return AR;
	}

	public void setPC(int newPC) {
		this.PC = newPC;
	}

	public int getPC() {
		return this.PC;
	}

	public void setAR(int AR) {
		this.AR = AR;
	}

	public void setTrue() {
		this.stop = true;
	}

	public SimulatorWindow getWindow() {
		return window;
	}

	public MemoryDump getMemoryDump() {
		return memoryDump;
	}
}