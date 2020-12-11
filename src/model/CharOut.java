package model;

import utils.Converter;

public class CharOut extends Instruction {


    private String output = "";

    public CharOut(String opCode, String operand) {
        super(opCode, operand);
    }

    public CharOut(String opCode, String registerSpec, String operand) {
        super(opCode, registerSpec, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) {
        String operand = controlUnit.getNextInstruction().getOperand();
        char character = (char) Converter.binToDecimal(operand);
        output += character;
    }

    public String getOutput() {
        return output;
    }
}
