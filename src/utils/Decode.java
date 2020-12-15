
package utils;

import model.*;
import model.Instruction;

/**
 * This class reads the input binary strings and assign them to correct
 * instruction obj
 */
public final class Decode {
	/**
	 * Decode the binary string and create the appropriate Instruction object.
	 *
	 * @throws IllegalArgumentException if value for immediate is out of bound.
	 */
	public static Instruction decodeInstruction(final String hex) throws IllegalArgumentException {
		String binaryString = Converter.hexToBinary(hex).replace(" ", "");

		if (binaryString.equals("00000000")) { // Stop instruction
			return new Stop("0000", "0000");
		}
		String operand = binaryString.substring(8, 24);
		for (int i = 7; i >= 0; i--) {
			String possibleOpcode = binaryString.substring(0, i);
			switch (possibleOpcode) {
			case "0000010":
			case "0000011":
			case "0000100":
			case "0000101":
			case "0000110":
			case "0000111":
			case "0001000":
			case "0001001":
			case "0001010":
				return new Branch(possibleOpcode, "", "" + binaryString.charAt(7), operand);
			case "0001100":
			case "0001101":
			case "0001110":
			case "0001111":
			case "0010000":
			case "0010001":
			case "00101":
			case "00110":
			case "00111":
			case "01000":
			case "01001":
				return new CharIn(possibleOpcode, binaryString.substring(5, 8), operand);
			case "01010":
				return new CharOut(possibleOpcode, binaryString.substring(5, 8), operand);
			case "01011":
			case "01100":
			case "01101":
			case "0111":
				return new Addr(possibleOpcode, "" + binaryString.charAt(4), binaryString.substring(5, 8), operand);
			case "1000":
				return new Subtract(possibleOpcode, "" + binaryString.charAt(4), binaryString.substring(5, 8), operand);
			case "1001":
			case "1010":
			case "1011":
			case "1100":
				return new Ldr(possibleOpcode, "" + binaryString.charAt(4), binaryString.substring(5, 8), operand);
			case "1101":
			case "1110":
				return new Str(possibleOpcode, "" + binaryString.charAt(4), binaryString.substring(5, 8), operand);
			case "1111":
			}

		}
		return null;
	}
}
