package com.sap.ide.cts.editor.contentassist;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestTextPositionComparator {

	private TextPositionComparator comparator;

	@Before
	public void createComparator() {
		comparator = new TextPositionComparator();
	}

	@Test
	public void testCompareSmallerLine() {
		TextPosition a = new TextPosition(0, 0);
		TextPosition b = new TextPosition(1, 0);

		assertTrue(comparator.compare(a, b) < 0);

	}

	@Test
	public void testCompareSmallerLineButGreaterInPosition() {
		TextPosition a = new TextPosition(0, 14);
		TextPosition b = new TextPosition(1, 0);

		assertTrue(comparator.compare(a, b) < 0);

	}

	@Test
	public void testCompareGreaterLine() {
		TextPosition a = new TextPosition(5, 0);
		TextPosition b = new TextPosition(4, 0);

		assertTrue(comparator.compare(a, b) > 0);

	}

	@Test
	public void testCompareSmallerInLine() {
		TextPosition a = new TextPosition(3, 0);
		TextPosition b = new TextPosition(3, 1);

		assertTrue(comparator.compare(a, b) < 0);

	}

	@Test
	public void testCompareGreaterInLine() {
		TextPosition a = new TextPosition(4, 4);
		TextPosition b = new TextPosition(4, 3);

		assertTrue(comparator.compare(a, b) > 0);

	}

	@Test
	public void testCompareEqual() {
		TextPosition a = new TextPosition(13, 7);
		TextPosition b = new TextPosition(13, 7);

		assertTrue(comparator.compare(a, b) == 0);

	}

}
