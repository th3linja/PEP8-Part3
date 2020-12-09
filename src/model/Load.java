package model;

public class Load extends Instruction{

    public Load(String opCode, String operand) {
        super(opCode, operand);
    }

    public Load(String opCode, String registerSpec, String operand) {
        super(opCode, registerSpec, operand);
    }

    public Load(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) {

    }
}
