package model;

import utils.Converter;

public class ORr extends Instruction {
    public ORr(String opCode, String operand) {
        super(opCode, operand);
    }

    public ORr(String opCode, String registerSpec, String operand) {
        super(opCode, registerSpec, operand);
    }

    public ORr(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) throws InterruptedException {
        String finalORValue;
        String ARStringValue = Converter.decimalToBinary(controlUnit.getAR());
        if (super.getAddressingMode().equals("001")) { // OR with immediate
            int operandInt = Converter.binToDecimal(super.getOperand());
            String memoryValue = controlUnit.getMemoryDump().getMemory(operandInt);
            finalORValue = bitwiseOR(memoryValue, ARStringValue);


        } else { // OR with memory
            finalORValue = bitwiseOR(super.getOperand(), ARStringValue);
        }

        controlUnit.setAR(Converter.binToDecimal(finalORValue));
        controlUnit.setMyNFlag(getNFlagFromBinary(finalORValue));
        controlUnit.setMyZFlag(getZFlagFromBinary(finalORValue));
    }

    private String bitwiseOR(final String theInput1, final String theInput2) {
        String output = "";
        if (theInput1.length() != theInput2.length()) {
            throw new IllegalArgumentException("Tried to OR binaries of mismatched length.");
        }
        for (int index = 0; index < theInput1.length(); index++) {
            if (theInput1.charAt(index) == '0' && theInput2.charAt(index) == '0') {
                output = output.concat("0");
            } else { // if the matching index locations are not both 0, the ORer sets the bit to 1.
                output = output.concat("1");
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
