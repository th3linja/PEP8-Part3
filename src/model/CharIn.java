package model;

import utils.Converter;

import java.util.Observable;
import java.util.Observer;

public class CharIn extends Instruction implements Observer {

    public CharIn(String opCode, String operand) {
        super(opCode, operand);
    }

    public CharIn(String opCode, String registerSpec, String operand) {
        super(opCode, registerSpec, operand);
    }

    public CharIn(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) {
        // Wait for a character to be pressed in the terminal window
        synchronized(this){
            while(controlUnit.getWindow().charEntered.length() != 1) {
                try {
                    controlUnit.getWindow().inArea.setEditable(true);
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        int i = Integer.valueOf(controlUnit.getWindow().charEntered.charAt(0));
        //String hex = Converter.binToHex(String.format("%8s", Converter.decimalToBinary(i)).replace(' ', '0')).strip();
        controlUnit.getMemoryDump().setMemory(Converter.binToHex(getOperand()), i);
        controlUnit.getWindow().appendOutArea("Entered : '" + controlUnit.getWindow().charEntered + "' at " + Converter.binToHex(getOperand()) + " in memory.\n");
        controlUnit.getWindow().charEntered = "";
    }

    @Override
    public void update(Observable o, Object arg) {
        ControlUnit controlUnit = (ControlUnit) arg;
        if (controlUnit.getWindow().charEntered.length() == 1) {
            synchronized (this) {
                this.notify();
            }
        }
        if (controlUnit.getWindow().res == true) {
            controlUnit.setPC(0x0000);
        }
    }
}
