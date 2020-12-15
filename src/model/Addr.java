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

		if (super.getRegisterSpecifier().equals("0") && super.getAddressingMode().equals("000")) { // Immediate value,ac
			result = ar + operand;
			controlUnit.setAR(result);
		} else if (super.getRegisterSpecifier().equals("1") && super.getAddressingMode().equals("000")) { // Immediate
																											// value,index
																											// register
			result = ar + operand;
			controlUnit.setMyIndexRegister(result);
		} else { // memory,direct
			result = ar + Converter.binToDecimal(controlUnit.memoryDump.getMemory(operand));
			controlUnit.setAR(result);
		}
		controlUnit.setMyNFlag(NFlag(Converter.decimalToBinary(result)));
		controlUnit.setMyZFlag(ZFlag(Converter.decimalToBinary(result)));
		controlUnit.setMyVFlag(VFlag(ar, operand, result));
		controlUnit.setMyCFlag(CFlag(Converter.decimalToBinary(ar), Converter.decimalToBinary(operand),
				Converter.decimalToBinary(result)));
	}
}