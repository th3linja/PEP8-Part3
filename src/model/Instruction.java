package model;

public abstract class Instruction {
    private String myRegisterSpecifier = "";

    private String myOperand = "";

    private String myAddressingMode = "";

    private String myOpcode = "";

    public Instruction(String opCode, String operand) {
        this.myOpcode = opCode;
        this.myOperand = operand;
    }

    public Instruction(String opCode, String registerSpec, String operand) {
        this.myOpcode = opCode;
        this.myRegisterSpecifier = registerSpec;
        this.myOperand = operand;
    }

    public Instruction(String opCode, String registerSpec, String addressingMode, String operand) {
        this.myOpcode = opCode;
        this.myRegisterSpecifier = registerSpec;
        this.myOperand = operand;
        this.myAddressingMode = addressingMode;
    }

    public abstract void execute(ControlUnit controlUnit);

    @Override
    public String toString() {
        return this.myOpcode + this.myRegisterSpecifier + this.myAddressingMode + this.myOperand;
    }

    public String getAddressingMode() {
        return (myAddressingMode == null)? "": myAddressingMode;
    }

    public String getOpcode() {
        return (myOpcode == null)? "": myOpcode;
    }
    public String getOperand() {
        return (myOperand == null)? "": myOperand;
    }
    public String getRegisterSpecifier() {
        return (myRegisterSpecifier == null)? "": myRegisterSpecifier;
    }

    public int NFlag(final String theBinary) {
        return Integer.parseInt(theBinary.substring(0,1));
    }

    public int ZFlag(final String theBinary) {
        int output = 0;
        if (theBinary.indexOf("1") == -1) { // There are no 1's in the binary string.
            output = 1;
        }
        return output;
    }

    public int VFlag(int ARegisterValue, int operand,int result) {
        if((ARegisterValue > 0 && operand > 0 && result < 0) || (ARegisterValue < 0 && operand < 0 && result > 0)){
            return 1;
        }
        return 0;
    }

    public int CFlag(String ARegisterValue,String operand,String result){
        int AMSB = Integer.parseInt(ARegisterValue.substring(0,1));
        int operandMSB = Integer.parseInt(operand.substring(0,1));
        int resultMSB = Integer.parseInt(result.substring(0,1));
        if((AMSB == 1 && operandMSB == 1&& resultMSB == 0)||(AMSB == 0 && operandMSB == 0 && resultMSB == 1)){
            return 1;
        }
        return 0;
    }
}
