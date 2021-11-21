package net.alenzen.intelHex;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HexFileLineTest {
	@Test
	public void testParse() throws InvalidFormatException {
		String hexLine = ":080018001234567812345678B8";
		HexFileLine l = HexFileLine.parse(0, hexLine, null);
		assertEquals(0x08, l.getLength());
		assertEquals(0x18, l.getAddress());
		assertEquals((byte) 0xB8, l.getChecksum());
		assertEquals(RecordType.DATA, l.getType());
		assertArrayEquals(new byte[] { 0x12, 0x34, 0x56, 0x78, 0x12, 0x34, 0x56, 0x78 }, l.getData());
	}

	@Test
	public void testParse_2() throws InvalidFormatException {
		String hexLineFromWiki = ":0300300002337A1E";
		HexFileLine l = HexFileLine.parse(0, hexLineFromWiki, null);
		assertEquals(0x03, l.getLength());
		assertEquals(0x0030, l.getAddress());
		assertEquals((byte) 0x1E, l.getChecksum());
		assertEquals(RecordType.DATA, l.getType());
		assertArrayEquals(new byte[] { 0x02, 0x33, 0x7A }, l.getData());
	}
	
	@Test
	public void testToString() throws InvalidFormatException {
		String hexLineFromWiki = ":0300300002337A1E";
		HexFileLine l = HexFileLine.parse(0, hexLineFromWiki, null);
		assertEquals(hexLineFromWiki, l.toString());
	}
}
