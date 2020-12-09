package model;

public class Stop extends Instruction{

    public Stop(String opCode, String operand) {
        super(opCode, operand);
    }

    public Stop(String opCode, String registerSpec, String operand) {
        super(opCode, registerSpec, operand);
    }

    public Stop(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) {

    }
}
