package com.sap.ide.cts.editor.contentassist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTextPosition {

	@Test
	public void testEquals() {
		TextPosition a = new TextPosition(0, 0);
		TextPosition b = new TextPosition(0, 0);
		TextPosition c = new TextPosition(0, 1);
		TextPosition d = new TextPosition(2, 1);

		assertEquals(true, a.equals(b));
		assertEquals(true, b.equals(a));
		assertEquals(false, a.equals(c));
		assertEquals(false, c.equals(d));
	}

	@Test
	public void testToString() {
		TextPosition a = new TextPosition(13, 2);

		assertEquals("[13, 2]", a.toString());
	}
}
