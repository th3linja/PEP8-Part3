package model;

import utils.Converter;


public class Addr extends Instruction {

    public Addr(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) {

        int operand = Converter.binToDecimal(super.getOperand());
        int result;

        if (super.getRegisterSpecifier().equals("0")&&super.getAddressingMode().equals("000")) { // Immediate value,ac
            result = controlUnit.getAR() + operand;
            controlUnit.setAR(result);
        } else if (super.getRegisterSpecifier().equals("1")&&super.getAddressingMode().equals("000")) {  // Immediate value,index register
            result = controlUnit.getAR() + operand;
            controlUnit.setMyIndexRegister(result);
        } else { //memory,direct
            result = controlUnit.getAR() + Converter.binToDecimal(controlUnit.memoryDump.getMemory(operand));
            controlUnit.setAR(result);
        }
        controlUnit.setMyNFlag(NFlag(Converter.decimalToBinary(result)));
        controlUnit.setMyZFlag(ZFlag(Converter.decimalToBinary(result)));
        controlUnit.setMyVFlag(VFlag(controlUnit.getAR(),operand,result));
        controlUnit.setMyCFlag(CFlag(Converter.decimalToBinary(controlUnit.getAR()),Converter.decimalToBinary(operand),Converter.decimalToBinary(result)));

    }

    private int NFlag(final String theBinary) {
        return Integer.parseInt(theBinary.substring(0,1));
    }

    private int ZFlag(final String theBinary) {
        int output = 0;
        if (theBinary.indexOf("1") == -1) { // There are no 1's in the binary string.
            output = 1;
        }
        return output;
    }

    private int VFlag(int ARegisterValue, int operand,int result) {

        if((ARegisterValue > 0 && operand > 0 && result < 0)||(ARegisterValue < 0 && operand < 0 && result > 0)){
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