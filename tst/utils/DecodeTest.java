package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.SourceDecode;
import org.junit.jupiter.api.Test;

public class DecodeTest {
	SourceDecode dec = new SourceDecode();

	@Test
	public void testStop() {
		String[] ins = new String[] { "STOP" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("00", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testBR() {
		String[] ins = new String[] { "BR	0x000D", "BR	0x000D,i" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("05000D04000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testBRLE() {
		String[] ins = new String[] { "BRLE	0x000D", "BRLE	0x000D,i" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("07000D06000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testBRLT() {
		String[] ins = new String[] { "BRLT	0x000D", "BRLT	0x000D,i" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("09000D08000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testBREQ() {
		String[] ins = new String[] { "BREQ	0x000D", "BREQ	0x000D,i" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("0B000D0A000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testBRNE() {
		String[] ins = new String[] { "BRNE	0x000D", "BRNE	0x000D,i" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("0D000D0C000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testBRGE() {
		String[] ins = new String[] { "BRGE	0x000D", "BRGE	0x000D,i" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("0F000D0E000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testBRGT() {
		String[] ins = new String[] { "BRGT	0x000D", "BRGT	0x000D,i" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("11000D10000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testBRV() {
		String[] ins = new String[] { "BRV	0x000D", "BRV	0x000D,i" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("13000D12000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testBRC() {
		String[] ins = new String[] { "BRC	0x000D", "BRC	0x000D,i" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("15000D14000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testNOTA() {
		String[] ins = new String[] { "NOTA" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("18", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testNEGA() {
		String[] ins = new String[] { "NEGA" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("1A", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testASLA() {
		String[] ins = new String[] { "ASLA" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("1C", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testASRA() {
		String[] ins = new String[] { "ASRA" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("1E", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testROLA() {
		String[] ins = new String[] { "ROLA" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("20", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testRORA() {
		String[] ins = new String[] { "RORA" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("22", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testCHARI() {
		String[] ins = new String[] { "CHARI	0x000D,i", "CHARI	0x000D,d", "CHARI	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("48000D49000D4A000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testCHARO() {
		String[] ins = new String[] { "CHARO	0x000D,i", "CHARO	0x000D,d", "CHARO	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("50000D51000D52000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testADDA() {
		String[] ins = new String[] { "ADDA	0x000D,i", "ADDA	0x000D,d", "ADDA	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("70000D71000D72000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testSUBA() {
		String[] ins = new String[] { "SUBA	0x000D,i", "SUBA	0x000D,d", "SUBA	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("80000D81000D82000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testANDA() {
		String[] ins = new String[] { "ANDA	0x000D,i", "ANDA	0x000D,d", "ANDA	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("90000D91000D92000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testORA() {
		String[] ins = new String[] { "ORA	0x000D,i", "ORA	0x000D,d", "ORA	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("A0000DA1000DA2000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testCPA() {
		String[] ins = new String[] { "CPA	0x000D,i", "CPA	0x000D,d", "CPA	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("B0000DB1000DB2000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testLDA() {
		String[] ins = new String[] { "LDA	0x000D,i", "LDA	0x000D,d", "LDA	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("C0000DC1000DC2000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testLDBYTEA() {
		String[] ins = new String[] { "LDBYTEA	0x000D,i", "LDBYTEA	0x000D,d", "LDBYTEA	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("D0000DD1000DD2000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testSTA() {
		String[] ins = new String[] { "STA	0x000D,i", "STA	0x000D,d", "STA	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("E0000DE1000DE2000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testSTBYTEA() {
		String[] ins = new String[] { "STBYTEA	0x000D,i", "STBYTEA	0x000D,d", "STBYTEA	0x000D,n" };
		String ans;
		try {
			ans = dec.assemblyToHex(ins);
			assertEquals("F0000DF1000DF2000D", ans);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testStopFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "STOP 0x000D, i" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("00", ans);
		});
	}

	@Test
	public void testBRFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "BR" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("05000D04000D", ans);
		});
	}

	@Test
	public void testBRLEFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "BRLE" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("07000D06000D", ans);
		});
	}

	@Test
	public void testBRLTFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "BRLT" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("09000D08000D", ans);
		});
	}

	@Test
	public void testBREQFail() throws Exception {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "BREQ" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("0B000D0A000D", ans);
		});
	}

	@Test
	public void testBRNEFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "BRNE" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("0D000D0C000D", ans);
		});
	}

	@Test
	public void testBRGEFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "BRGE" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("0F000D0E000D", ans);
		});
	}

	@Test
	public void testBRGTFail() throws Exception {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "BRGT" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("11000D10000D", ans);
		});
	}

	@Test
	public void testBRVFail() throws Exception {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "BRV" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("13000D12000D", ans);
		});
	}

	@Test
	public void testBRCFail() throws Exception {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "BRC" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("15000D14000D", ans);
		});
	}

	@Test
	public void testNOTAFail() throws Exception {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "NOTA	0x000D, i" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("18", ans);
		});
	}

	@Test
	public void testNEGAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "NEGA	0x000D, i" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("1A", ans);
		});
	}

	@Test
	public void testASLAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "ASLA 0x000D, i" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("1C", ans);
		});
	}

	@Test
	public void testASRAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "ASRA	0x000D, i" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("1E", ans);
		});
	}

	@Test
	public void testROLAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "ROLA	0x000D, i" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("20", ans);
		});
	}

	@Test
	public void testRORAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "RORA 0x000D, i" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("22", ans);
		});
	}

	@Test
	public void testCHARIFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "CHARI" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("48000D49000D4A000D", ans);
		});
	}

	@Test
	public void testCHAROFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "CHARO" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("50000D51000D52000D", ans);
		});
	}

	@Test
	public void testADDAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "ADDA" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("70000D71000D72000D", ans);
		});
	}

	@Test
	public void testSUBAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "SUBA" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("80000D81000D82000D", ans);
		});
	}

	@Test
	public void testANDAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "ANDA" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("90000D91000D92000D", ans);
		});
	}

	@Test
	public void testORAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "ORA" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("A0000DA1000DA2000D", ans);
		});
	}

	@Test
	public void testCPAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "CPA" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("B0000DB1000DB2000D", ans);
		});
	}

	@Test
	public void testLDAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "LDA" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("C0000DC1000DC2000D", ans);
		});
	}

	@Test
	public void testLDBYTEAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "LDBYTEA" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("D0000DD1000DD2000D", ans);
		});
	}

	@Test
	public void testSTAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "STA" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("E0000DE1000DE2000D", ans);
		});
	}

	@Test
	public void testSTBYTEAFail() {
		assertThrows(Exception.class, () -> {
			String[] ins = new String[] { "STBYTEA" };
			String ans;
			ans = dec.assemblyToHex(ins);
			assertEquals("F0000DF1000DF2000D", ans);
		});
	}
}
