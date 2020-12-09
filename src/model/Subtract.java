package model;

public class Subtract extends Instruction{
    public Subtract(String opCode, String operand) {
        super(opCode, operand);
    }

    public Subtract(String opCode, String registerSpec, String operand) {
        super(opCode, registerSpec, operand);
    }

    public Subtract(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) {

    }
}
