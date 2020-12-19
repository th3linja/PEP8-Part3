package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TransformerTests {
	Transformer transformer = new Transformer();

	@Test
    void testBinaryToDecimalSuccess(){
        int binary = 10101010;
        int decimalConversion = -86;
        assertEquals(decimalConversion, Transformer.transformBinaryToDecimal(binary));
    }

	@Test
    void testBinaryToDecimalFail() {
        int binary = 10101010;

        int decimalConversion = -85;
        assertNotEquals(decimalConversion + 1, Transformer.transformBinaryToDecimal(binary));
    }

	@Test
	void testDecimalToBinarySuccess() {
		int decimal = 65;
		int binaryConversion = 1000001;
		assertEquals(binaryConversion, Transformer.transformDecimalToBinary(decimal));
	}

	@Test
	void testDecimalToBinaryFail() {
		int decimal = 65;
		int binaryConversion = 1000001;
		assertNotEquals(binaryConversion + 1, Transformer.transformDecimalToBinary(decimal));
	}
}
