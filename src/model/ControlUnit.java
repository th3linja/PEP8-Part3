package model;

import java.util.Observable;
import java.util.Observer;

import utils.Converter;
import utils.Decode;
import view.SimulatorWindow;

public class ControlUnit implements Observer {

	private int PC = 0x0000;
	private int AR = 0x0000;
	private int IR = 0x000000;
	private myRunnable runnable = new myRunnable();
	SimulatorWindow window;

	private Decode decode = new Decode();
	private ArithmeticLogicUnit ALU = new ArithmeticLogicUnit();
	public MemoryDump memoryDump = new MemoryDump();
	private Instruction currentInstruction;

	public ControlUnit(SimulatorWindow window) {
		this.window = window;
	}

	public void startCycle() throws InterruptedException {
		this.IR = Integer.parseInt(memoryDump.fetch(this.PC), 16);
		
		boolean stop = false;

		currentInstruction = decode.decodeInstruction(String.format("%06X", this.IR));
		
		
		switch (currentInstruction.getOpcode()) {

		case ("01110"):// add
			executeAdd(currentInstruction);
			updateCPU();
			break;

		case ("01001"):// char in
			executeCharIn(currentInstruction);
			updateCPU();
			break;

		case ("01010"):// char out
			executeCharOut(currentInstruction);
			updateCPU();
			break;

		case ("11000"):// load
			executeLW(currentInstruction);
			updateCPU();
			break;

		case ("00000"):// stop
			stop = true;
			break;

		case ("10000"):// sub
			executeSub(currentInstruction);
			updateCPU();
			break;

		case ("11100"):// sw
			executeSW(currentInstruction);
			updateCPU();
			break;
		}

		// Get data if needed.

		// Execute the instruction.

		// PC must be updated to hold the address of the next instruction to be executed

		if (!stop) {
			startCycle();
		}
	}

	private void executeAdd(Instruction instruction) {
		this.AR += Integer.valueOf(Converter.binToHex(instruction.getOperand()).replace(" ", ""));
	}

	private void executeCharIn(Instruction instruction) throws InterruptedException {
		// Wait for a character to be pressed in the terminal window
		synchronized(this){
			while(window.charEntered.length() != 1) {
				try {
					window.inArea.setEditable(true);
					this.wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		int i = Integer.valueOf(window.charEntered.charAt(0));
		//String hex = Converter.binToHex(String.format("%8s", Converter.decimalToBinary(i)).replace(' ', '0')).strip();
    	memoryDump.setMemory(Converter.binToHex(instruction.getOperand()), i);   	
        window.appendOutArea("Entered : '" + window.charEntered + "' at " + Converter.binToHex(instruction.getOperand()) + " in memory.\n");
        window.charEntered = "";
	}
	

	private void executeCharOut(Instruction instruction) {
		if (instruction.getAddressingMode().contentEquals("000")) { // immediate
			String operand = instruction.getOperand();
			char character = (char) Converter.binToDecimal(operand);
			window.appendOutArea(String.valueOf(character));
		} else if (instruction.getAddressingMode().contentEquals("001")) { // direct
			int operand = Converter.binToDecimal(instruction.getOperand());
			char character = (char) Converter.hexToDecimal(memoryDump.getMemory(operand));
			window.appendOutArea(String.valueOf(character));
		}
	}

	private void executeLW(Instruction instruction) {
		if (instruction.getAddressingMode().contentEquals("000")) { // immediate
			this.AR =  Converter.binToDecimal(instruction.getOperand());
		} else if (instruction.getAddressingMode().contentEquals("001")) { // direct
			int address = Converter.binToDecimal(instruction.getOperand());
			this.AR = Converter.hexToDecimal(memoryDump.getMemory(address));
		}
	}

	private void executeSub(Instruction instruction) {
		if (instruction.getAddressingMode().contentEquals("000")) { // immediate
			AR -= Integer.parseInt(Converter.binToHex(instruction.getOperand()), 16);
		} else if (instruction.getAddressingMode().contentEquals("001")) { // direct
			int hexVal = Integer.parseInt(Converter.binToHex(instruction.getOperand()), 16);
			AR -= Converter.hexToDecimal(memoryDump.getMemory(hexVal));
		}
	}

	private void executeSW(Instruction instruction) {
		String hexAddress = Converter.binToHex(instruction.getOperand());
		memoryDump.setMemory(hexAddress, this.AR);
	}

	private void updateCPU() {
		this.PC += 0x0003;
		window.irText.setText(String.format("0x%06X", this.IR));
		window.arText.setText(String.format("0x%06X", this.AR));
		window.pcText.setText(String.format("0x%04X", this.PC));
		window.isText.setText(String.format("0x%02X", Converter.binToDecimal(currentInstruction.getOpcode())));
		window.osText.setText(String.format("0x%04X", Converter.binToDecimal(currentInstruction.getOperand())));
		System.out.println(currentInstruction.toString());
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(window.charEntered.length()==1) {
			synchronized(ControlUnit.this) {
				ControlUnit.this.notify();
			}
		}
		if(window.res == true) {
			this.PC = 0x0000;
		}
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
