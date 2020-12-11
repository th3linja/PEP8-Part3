package model;

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

    }
}
