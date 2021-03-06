package utils;

import static java.lang.Integer.toBinaryString;

/**
 * this class contains methods convert between hex <---> binary binary <--->
 * decimal hex ---> decimal
 */
public class Converter {

	/**
	 * binary---> hexDecimal
	 *
	 * @param binary
	 * @return hexDecimal
	 */
	public static String binToHex(String binary) {
		StringBuilder hex = new StringBuilder();
		int count = 1;
		if (binary.length() < 1) {
			return hex.toString();
		}
		if (binary.replace(" ", "").length() % 2 != 0) {
			return "Invalid binary string.";
		}
		for (int i = 0; i < binary.replace(" ", "").length(); i += 4) {
			String binString = binary.replace(" ", "").substring(i, i + 4);
			hex.append(Integer.toString(binToDecimal(binString), 16).toUpperCase());
			if (count % 2 == 0) {
				hex.append(" ");
			}
			count++;
		}
		return hex.toString();
	}

	/**
	 * hexDecimal ---> decimal
	 *
	 * @param hex
	 * @return Decimal
	 */
	public static int hexToDecimal(String hex) {
		return Integer.parseInt(hex, 16);
	}

	/**
	 * Twos compliment binary string ---> Decimal
	 *
	 * @param bin
	 * @return Decimal
	 */
	public static int binToDecimal(String bin) {
		return (int)Long.parseLong(bin, 2);
	}

	/**
	 * hexDecimal ---> Binary
	 *
	 * @param hex
	 * @return binary
	 */
	public static String hexToBinary(String hex) {
		StringBuilder binary = new StringBuilder();
		if (hex.length() < 1) {
			return binary.toString();
		}
		if (hex.replace(" ", "").length() % 2 != 0) {
			return "Invalid hex string.";
		}
		String[] hexCode = hex.replace(" ", "").split("");
		for (int i = 0; i < hexCode.length; i++) {
			int binVal = hexToDecimal(hexCode[i]);
			binary.append(String.format("%4s", toBinaryString(binVal)).replace(" ", "0"));
			binary.append(" ");
		}
		return binary.toString();
	}

	/**
	 * decimal ---> binary
	 *
	 * @param decimal
	 * @return binary
	 */
	public static String decimalToBinary(int decimal) {
		String binaryOutput = "";
		// If theReturnLength is valid:
		binaryOutput = toBinaryString(decimal);
		int binStartLength = binaryOutput.length();
		/*
		 * If the length of the generated binary is too small (which is the case with
		 * positive values only), extend leading 0's to the desired return length.
		 */
		if (binStartLength < 16) {
			for (int i = 0; i < 16 - binStartLength; i++) {
				binaryOutput = "0" + binaryOutput;
			}
		}
		return binaryOutput;
	}
}
