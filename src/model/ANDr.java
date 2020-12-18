package model;

import utils.Converter;

public class ANDr extends Instruction {
    public ANDr(String opCode, String operand) {
        super(opCode, operand);
    }

    public ANDr(String opCode, String registerSpec, String operand) {
        super(opCode, registerSpec, operand);
    }

    public ANDr(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) throws InterruptedException {
        String finalORValue;
        String ARStringValue = Converter.decimalToBinary(controlUnit.getAR());
        if (super.getAddressingMode().equals("001")) { // AND with immediate
            int operandInt = Converter.binToDecimal(super.getOperand());
            String memoryValue = controlUnit.getMemoryDump().getMemory(operandInt);
            finalORValue = bitwiseAND(memoryValue, ARStringValue);


        } else { // AND with memory
            finalORValue = bitwiseAND(super.getOperand(), ARStringValue);
        }

        controlUnit.setAR(Converter.binToDecimal(finalORValue));
        controlUnit.setMyNFlag(getNFlagFromBinary(finalORValue));
        controlUnit.setMyZFlag(getZFlagFromBinary(finalORValue));
    }

    private String bitwiseAND(final String theInput1, final String theInput2) {
        String output = "";
        if (theInput1.length() != theInput2.length()) {
            throw new IllegalArgumentException();
        }
        for (int index = 0; index < theInput1.length(); index++) {
            if (theInput1.charAt(index) == '1' && theInput2.charAt(index) == '1') {
                output = output.concat("1");
            } else { // if the matching index locations are not both 1, the ANDer sets the bit to 0.
                output = output.concat("0");
            }
        }
        return output;
    }

    private int getNFlagFromBinary(final String theBinary) {
        return Integer.parseInt(theBinary.substring(0, 1));
    }

    private int getZFlagFromBinary(final String theBinary) {
        int output = 0;
        if (!theBinary.contains("1")) { // There are no 1's in the binary string.
            output = 1;
        }
        return output;
    }
}
