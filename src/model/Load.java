package model;

import utils.Converter;
import utils.Transformer;

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
        if (getRegisterSpecifier().contentEquals("0")) { //Accumulator
            if (getAddressingMode().contentEquals("000")) { //immediate
                controlUnit.setAR(Integer.parseInt(getOperand(), 2));
            }
            else if (getAddressingMode().contentEquals("001")) { //direct
                int address = Converter.binToDecimal(getOperand());
                String memBin = Integer.toBinaryString(
                        Converter.hexToDecimal(controlUnit.memoryDump.getMemory(address)));
                controlUnit.setAR(Integer.parseInt(memBin));
            }
        }else if (getRegisterSpecifier().contentEquals("1")) { //Index Reg
            if (getAddressingMode().contentEquals("000")) { //immediate
                controlUnit.setMyIndexRegister(Integer.parseInt(getOperand(), 2));
            }
            else if (getAddressingMode().contentEquals("001")) { //direct
                int address = Converter.binToDecimal(getOperand());
                String memBin = Integer.toBinaryString(
                        Converter.hexToDecimal(controlUnit.memoryDump.getMemory(address)));
                controlUnit.setMyIndexRegister(Integer.parseInt(memBin));
            }
        }
    }
}
