package model;

import utils.Converter;
import model.ControlUnit;


/**
 * This class is the add instruction
 */

public class Addr extends Instruction {

    public Addr(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    public void execute(ControlUnit theCon) {

        int operand = Converter.binToDecimal(super.getOperand()));
        int result;

        if (super.getRegisterSpecifier().equals("0")&&super.getAddressingMode().equals("000")) { // Immediate value,ac
            result = theCon.getAR() + operand;
            theCon.setAR(result);
        } else if (super.getRegisterSpecifier().equals("1")&&super.getAddressingMode().equals("000")) {  // Immediate value,index register
            result = theCon.getAR() + operand;
            theCon.setMyIndexRegister(result);
        } else { //memory,direct
            result = theCon.getAR() + Converter.binToDecimal(theCon.memoryDump.getMemory(operand)));
            theCon.setAR(result);
        }
        theCon.setMyNFlag(NFlag(Converter.decimalToBinary(result)));
        theCon.setMyZFlag(ZFlag(Converter.decimalToBinary(result)));
        theCon.setMyVFlag(VFlag(theCon.getAR(),operand,result));
        theCon.setMyCFlag(CFlag(Converter.decimalToBinary(theCon.getAR()),Converter.decimalToBinary(operand),Converter.decimalToBinary(result)));

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

    private int VFlag(int o1, int o2,int result) {

        if((o1>0&&o2>0&&result<0)||(o1<0&&o2<0&&result>0)){
            return 1;
        }

        return 0;

    }

    private int CFlag(String o1,String o2,String result){
        int o1b = Integer.parseInt(o1.substring(0,1));
        int o2b = Integer.parseInt(o1.substring(0,1));
        int resultb = Integer.parseInt(o1.substring(0,1));
        if((o1b==1&&o1b==1&&resultb==0)||(o1b==0&&o1b==0&&resultb==1)){
            return 1;
        }
        return 0;
    }

}