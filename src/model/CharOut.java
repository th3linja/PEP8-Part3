package model;

public class CharOut extends Instruction {
    public CharOut(String opCode, String operand) {
        super(opCode, operand);
    }

    public CharOut(String opCode, String registerSpec, String operand) {
        super(opCode, registerSpec, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) {

    }
}
