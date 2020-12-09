package model;

public class CharIn extends Instruction{

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

    }
}
