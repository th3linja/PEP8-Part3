package model;

import utils.Converter;

public class Subtract extends Instruction {

	public Subtract(String opCode, String registerSpec, String operand) {
		super(opCode, registerSpec, operand);
	}

	public Subtract(String opCode, String registerSpec, String addressingMode, String operand) {
		super(opCode, registerSpec, addressingMode, operand);
	}

	@Override
	public void execute(ControlUnit controlUnit) {
		int operand = Converter.binToDecimal(super.getOperand());
		int result;

		if (super.getRegisterSpecifier().equals("0") && super.getAddressingMode().equals("000")) { // Immediate value,ac
			result = controlUnit.getAR() - operand;
			controlUnit.setAR(result);
		} else if (super.getRegisterSpecifier().equals("1") && super.getAddressingMode().equals("000")) { // Immediate
																											// value,index
																											// register
			result = controlUnit.getAR() - operand;
			controlUnit.setMyIndexRegister(result);
		} else { // memory,direct
			result = controlUnit.getAR() - Converter.binToDecimal(controlUnit.memoryDump.getMemory(operand));
			controlUnit.setAR(result);
		}
		controlUnit.setMyNFlag(NFlag(Converter.decimalToBinary(result)));
		controlUnit.setMyZFlag(ZFlag(Converter.decimalToBinary(result)));
		controlUnit.setMyVFlag(VFlag(controlUnit.getAR(), operand, result));
		controlUnit.setMyCFlag(CFlag(Converter.decimalToBinary(controlUnit.getAR()), Converter.decimalToBinary(operand),
				Converter.decimalToBinary(result)));
	}
}
