package model;

import utils.Converter;

public class Store extends Instruction {

    public Store(String opCode, String operand) {
        super(opCode, operand);
    }

    public Store(String opCode, String registerSpec, String operand) {
        super(opCode, registerSpec, operand);
    }

    public Store(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) {
        String hexAddress = Converter.binToHex(super.getOperand());

        if (super.getRegisterSpecifier().equals("0")) {
            controlUnit.memoryDump.setMemory(hexAddress, controlUnit.getAR());
        } else {
            controlUnit.memoryDump.setMemory(hexAddress, controlUnit.getMyIndexRegister());
        }

    }
}
