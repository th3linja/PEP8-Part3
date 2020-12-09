package model;

import utils.Converter;


public class Addr extends Instruction {

    public Addr(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    public Addr(String opCode, String operandSpecifier, String operand) {
        super(opCode, operandSpecifier, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) {

        int operand = Converter.binToDecimal(super.getOperand());
        int result;
        int ar = controlUnit.getAR();

        if (super.getRegisterSpecifier().equals("0")&&super.getAddressingMode().equals("000")) { // Immediate value,ac
            result = ar + operand;
            controlUnit.setAR(result);
        } else if (super.getRegisterSpecifier().equals("1")&&super.getAddressingMode().equals("000")) {  // Immediate value,index register
            result = ar + operand;
            controlUnit.setMyIndexRegister(result);
        } else { //memory,direct
            result = ar + Converter.binToDecimal(controlUnit.memoryDump.getMemory(operand));
            controlUnit.setAR(result);
        }
        controlUnit.setMyNFlag(NFlag(Converter.decimalToBinary(result)));
        controlUnit.setMyZFlag(ZFlag(Converter.decimalToBinary(result)));
        controlUnit.setMyVFlag(VFlag(ar,operand,result));
        controlUnit.setMyCFlag(CFlag(Converter.decimalToBinary(ar),Converter.decimalToBinary(operand),Converter.decimalToBinary(result)));
    }

    private int NFlag(final String theBinary) {
        return Integer.parseInt(theBinary.substring(0,1));
    }

    private int ZFlag(final String theBinary) {
        int output = 0;
        if (!theBinary.contains("1")) { // There are no 1's in the binary string.
            output = 1;
        }
        return output;
    }

    private int VFlag(int ARegisterValue, int operand,int result) {
        char ar1 = Converter.decimalToBinary(ARegisterValue).charAt(0);
        char operand1 = Converter.decimalToBinary(operand).charAt(0);
        char result1 = Converter.decimalToBinary(result).charAt(0);

        if((ar1 == '1' && operand1 == '1' && result1 == '0')||((ar1 == '0' && operand1 == '0' && result1 == '1'))){
            return 1;
        }

        return 0;

    }

    private int CFlag(String ARegisterValue,String operand,String result){
        int AMSB = Integer.parseInt(ARegisterValue.substring(0,1));
        int operandMSB = Integer.parseInt(operand.substring(0,1));
        int resultMSB = Integer.parseInt(result.substring(0,1));
        if((AMSB == 1 && operandMSB == 1&& resultMSB == 0)||(AMSB == 0 && operandMSB == 0 && resultMSB == 1)){
            return 1;
        }
        return 0;
    }
}