package com.sap.mi.textual.textblocks.model;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecore.EEnum;
import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.parsergenerator.parsing.textblocks.TbChangeUtil;
import com.sap.furcas.parsergenerator.parsing.textblocks.TbNavigationUtil;
import com.sap.furcas.parsergenerator.parsing.textblocks.TbUtil;
import com.sap.mi.textual.parsing.textblocks.UtilFixtureBaseWithGaps;

public class TestTextBlocksModelWithGaps extends UtilFixtureBaseWithGaps {

	private TextBlocksModel tbModel;
	private String completeFixtureText;

	@Before
	public void setupTbModel() {
		tbModel = new TextBlocksModel(main, null);

		// has to match the fixture model
		completeFixtureText = "   aaaaa   * bbbbcccc     +     ddddd   ";
	}

	/**
	 * Check that all offsets return the correct char.
	 * 
	 */
	@Test
	public void testGetChar() {
		for (int i = 0; i < completeFixtureText.length(); i++) {
			assertEquals("char at offset " + i, completeFixtureText.charAt(i),
					tbModel.get(i));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetCharOffsetTooLarge() {
		tbModel.get(completeFixtureText.length() + 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetCharOffsetNegative() {
		tbModel.get(-1);
	}

	/**
	 * Check that all offsets and lengths return the correct region.
	 * 
	 * Take each possible valid length between 0 and the length of the fixture
	 * text and start at each possible offset.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetRegion() throws Exception {
	    String result;
	    for (int length = 0; length <= completeFixtureText.length(); length++) {
			for (int offset = 0; offset <= completeFixtureText.length()
					- length; offset++) {
				result = tbModel.get(offset, length);
                assertEquals("region at offset " + offset + " of length "
						+ length, completeFixtureText.substring(offset, offset
						+ length), result);
			}
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetRegionLengthNegative() throws Exception {
		tbModel.get(0, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetRegionOffsetNegative() throws Exception {
		tbModel.get(-1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetRegionOffsetTooLarge() throws Exception {
		tbModel.get(completeFixtureText.length() + 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetRegionLengthTooLarge() throws Exception {
		tbModel.get(completeFixtureText.length() - 1, 2);
	}

	@Test
	public void testGetFloorToken() {
		//completeFixtureText = "   aaaaa   * bbbbcccc     +     ddddd   ";
	    assertEquals(null, tbModel.getFloorTokenInRoot(0));
	    assertEquals(null, tbModel.getFloorTokenInRoot(1));
	    assertEquals(null, tbModel.getFloorTokenInRoot(2));
		assertEquals(lexed1, tbModel.getFloorTokenInRoot(3));
		assertEquals(lexed1, tbModel.getFloorTokenInRoot(4));
		assertEquals(lexed1, tbModel.getFloorTokenInRoot(5));
		assertEquals(lexed1, tbModel.getFloorTokenInRoot(6));
		assertEquals(lexed1, tbModel.getFloorTokenInRoot(7));
		assertEquals(lexed1, tbModel.getFloorTokenInRoot(8));
		assertEquals(lexed1, tbModel.getFloorTokenInRoot(9));
		assertEquals(lexed1, tbModel.getFloorTokenInRoot(10));
		assertEquals(lexed2, tbModel.getFloorTokenInRoot(11));
		assertEquals(lexed2, tbModel.getFloorTokenInRoot(12));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(13));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(14));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(15));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(16));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(17));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(18));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(19));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(20));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(21));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(22));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(23));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(24));
		assertEquals(lexed3, tbModel.getFloorTokenInRoot(25));
		assertEquals(subToken, tbModel.getFloorTokenInRoot(26));
		assertEquals(subToken, tbModel.getFloorTokenInRoot(27));
		assertEquals(subToken, tbModel.getFloorTokenInRoot(28));
		assertEquals(subToken, tbModel.getFloorTokenInRoot(29));
		assertEquals(subToken, tbModel.getFloorTokenInRoot(30));
		assertEquals(subToken, tbModel.getFloorTokenInRoot(31));
		assertEquals(lexed4, tbModel.getFloorTokenInRoot(32));
		assertEquals(lexed4, tbModel.getFloorTokenInRoot(40));

		main.getSubBlocks().clear();
		main.getTokens().clear();
		main.getTokens().add(bos);
		main.getTokens().add(eos);

		assertEquals(null, tbModel.getFloorTokenInRoot(0));
	}

	@Test
	public void testGetLength() {
		assertEquals(completeFixtureText.length(), tbModel.getLength());
	}

	@Test
	public void testRemoveNode() {
		// TODO: check calls to locationMap by mocking

		// a
		// - b1
		// - - c
		// - - - d
		// - - - - e
		// - b2

		TextBlock a = modelFactory.createTextBlock();
		TextBlock b1 = modelFactory.createTextBlock();
		LexedToken b2 = modelFactory.createLexedToken();
		TextBlock c = modelFactory.createTextBlock();
		TextBlock d = modelFactory.createTextBlock();
		LexedToken e = modelFactory.createLexedToken();

		b2.setLength(12);
		b2.setOffset(20);
		e.setLength(20);

		a.getSubBlocks().add(b1);
		a.getTokens().add(b2);
		b1.getSubBlocks().add(c);
		c.getSubBlocks().add(d);
		d.getTokens().add(e);

		// should only remove b2
		assertEquals(true, a.getTokens().contains(b2));
		assertEquals(false, TbUtil.isDeleted(b1));
		assertEquals(false, TbUtil.isDeleted(a));

		TbChangeUtil.removeNode(b2);

		assertEquals(true, TbUtil.isDeleted(b2));
		assertEquals(false, TbUtil.isDeleted(a));

		// should now remove e, d, c, b1 and a (as b2 was already deleted)
		assertEquals(true, d.getTokens().contains(e));
		assertEquals(true, c.getSubBlocks().contains(d));
		assertEquals(true, b1.getSubBlocks().contains(c));
		assertEquals(true, a.getSubBlocks().contains(b1));
		assertEquals(false, TbUtil.isDeleted(e));
		assertEquals(false, TbUtil.isDeleted(d));
		assertEquals(false, TbUtil.isDeleted(c));
		assertEquals(false, TbUtil.isDeleted(b1));
		assertEquals(false, TbUtil.isDeleted(a));

		TbChangeUtil.removeNode(e);

		assertEquals(true, TbUtil.isDeleted(e));
		assertEquals(true, TbUtil.isDeleted(d));
		assertEquals(true, TbUtil.isDeleted(c));
		assertEquals(true, TbUtil.isDeleted(b1));
		assertEquals(true, TbUtil.isDeleted(a));

		// should not throw an exception
		TbChangeUtil.removeNode(null);
	}

	@Test
	public void removeTextBlockIfEmpty() {
		// TODO: check calls to locationMap by mocking

		// a
		// - b1
		// - - c
		// - - - d (empty)
		// - b2

		TextBlock a = modelFactory.createTextBlock();
		TextBlock b1 = modelFactory.createTextBlock();
		LexedToken b2 = modelFactory.createLexedToken();
		TextBlock c = modelFactory.createTextBlock();
		TextBlock d = modelFactory.createTextBlock();

		b2.setLength(12);

		a.getSubBlocks().add(b1);
		a.getTokens().add(b2);
		b1.getSubBlocks().add(c);
		c.getSubBlocks().add(d);

		// should not remove b1
		assertEquals(true, a.getSubBlocks().contains(b1));
		assertEquals(false, TbUtil.isDeleted(b1));

		TbChangeUtil.removeTextBlockIfEmpty(b1);

		assertEquals(false, TbUtil.isDeleted(b1));
		assertEquals(true, a.getSubBlocks().contains(b1));

		// should remove d, c and b1
		assertEquals(true, c.getSubBlocks().contains(d));
		assertEquals(true, b1.getSubBlocks().contains(c));
		assertEquals(true, a.getSubBlocks().contains(b1));
		assertEquals(false, TbUtil.isDeleted(d));
		assertEquals(false, TbUtil.isDeleted(c));
		assertEquals(false, TbUtil.isDeleted(b1));

		TbChangeUtil.removeTextBlockIfEmpty(d);

		assertEquals(true, TbUtil.isDeleted(d));
		assertEquals(true, TbUtil.isDeleted(c));
		assertEquals(true, TbUtil.isDeleted(b1));

		// should not throw an exception
		TbChangeUtil.removeTextBlockIfEmpty(null);
	}

	@Test
	public void testReplaceAllEmpty() throws Exception {
		tbModel.replace(0, completeFixtureText.length(), "");
		assertReplace(0, completeFixtureText.length(), "");

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}
	
	@Test
    public void testReplaceFromEmptyTwice() throws Exception {
	    tbModel.replace(0, completeFixtureText.length(), "");
        assertReplace(0, completeFixtureText.length(), "");

        // replace like typing keystrokes twice
        tbModel.replace(0, 0, "a");
        tbModel.replace(1, 0, "b");
        assertEquals("ab", tbModel.get(0, 2));
    }

	@Test
	public void testReplaceAllEmptyPreviousVersion() throws Exception {
		// TODO: check calls to locationMap by mocking

		// make used fixture of version PREVIOUS to prevent getWorkingCopy
		// to create a different version and check deletions, values etc
		TbChangeUtil.makeVersion(main, EEnum.PREVIOUS);

		// should change
		assertEquals(false, TbUtil.isDeleted(lexed1));
		assertEquals(false, TbUtil.isDeleted(subToken));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(middle));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, main.isChildrenChanged());
		assertEquals(40, main.getLength());
		assertEquals(40, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		tbModel.replace(0, completeFixtureText.length(), "");
		assertReplace(0, completeFixtureText.length(), "");

		// should change
		assertEquals(true, TbUtil.isDeleted(lexed1));
		assertEquals(true, TbUtil.isDeleted(subToken));
		assertEquals(true, TbUtil.isDeleted(lexed4));
		assertEquals(true, TbUtil.isDeleted(leftLeft));
		assertEquals(true, TbUtil.isDeleted(middle));
		assertEquals(true, TbUtil.isDeleted(right));
		assertEquals(true, main.isChildrenChanged());
		assertEquals(0, main.getLength());
		assertEquals(0, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
		assertEquals(3, main.getTokens().size());
		assertEquals(0, main.getSubBlocks().size());
		assertEquals(completeFixtureText, main.getTokens().get(1).getValue());
		assertEquals(bos, TbNavigationUtil.getSubNodeAt(main, 0));
		assertEquals(eos, TbNavigationUtil.getSubNodeAt(main, 2));
	}

	@Test
	public void testReplaceAllShortString() throws Exception {
		tbModel.replace(0, completeFixtureText.length(), "x");
		assertReplace(0, completeFixtureText.length(), "x");

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	@Test
	public void testReplaceAllShortStringPreviousVersion() throws Exception {
		// make used fixture of version PREVIOUS to prevent getWorkingCopy
		// to create a different version and check deletions, values etc
		TbChangeUtil.makeVersion(main, EEnum.PREVIOUS);

		// should change
		assertEquals("aaaaa", lexed1.getValue());
		assertEquals(false, TbUtil.isDeleted(subToken));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(middle));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, main.isChildrenChanged());
		assertEquals(false, left.isChildrenChanged());
		assertEquals(false, leftLeft.isChildrenChanged());
		assertEquals(40, main.getLength());
		assertEquals(40, eos.getOffset());
        assertEquals(false, TbUtil.isDeleted(left));
        assertEquals(false, TbUtil.isDeleted(leftLeft));
        assertEquals(false, TbUtil.isDeleted(lexed1));
		
		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		tbModel.replace(0, completeFixtureText.length(), "x");
		assertReplace(0, completeFixtureText.length(), "x");

		// should change
		assertEquals("x", lexed1.getValue());
		
		assertEquals(true, TbUtil.isDeleted(subToken));
		assertEquals(true, TbUtil.isDeleted(lexed4));
		assertEquals(true, TbUtil.isDeleted(middle));
		assertEquals(true, TbUtil.isDeleted(right));
		assertEquals(true, main.isChildrenChanged());
		
		assertEquals(1, main.getLength());
		assertEquals(1, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(left));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
		assertEquals(bos, TbNavigationUtil.getSubNodeAt(main, 0));
		assertEquals(eos, TbNavigationUtil.getSubNodeAt(main, 2));
	}

	@Test
	public void testReplaceAllLongString() throws Exception {
		tbModel.replace(0, completeFixtureText.length(),
				"xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");
		assertReplace(0, completeFixtureText.length(),
				"xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	@Test
	public void testReplaceAllLongStringPreviousVersion() throws Exception {
		// make used fixture of version PREVIOUS to prevent getWorkingCopy
		// to create a different version and check deletions, values etc
		TbChangeUtil.makeVersion(main, EEnum.PREVIOUS);

		// should change
		assertEquals("aaaaa", lexed1.getValue());
		assertEquals(false, TbUtil.isDeleted(subToken));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(middle));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, main.isChildrenChanged());
		assertEquals(false, left.isChildrenChanged());
		assertEquals(false, leftLeft.isChildrenChanged());
		assertEquals(false, TbUtil.isDeleted(left));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(lexed1));
		assertEquals(40, main.getLength());
		assertEquals(40, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		tbModel.replace(0, completeFixtureText.length(),
				"xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");
		assertReplace(0, completeFixtureText.length(),
				"xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");

		// should change
		assertEquals("xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx", lexed1.getValue());
		assertEquals(true, TbUtil.isDeleted(subToken));
		assertEquals(true, TbUtil.isDeleted(lexed4));
		assertEquals(true, TbUtil.isDeleted(middle));
		assertEquals(true, TbUtil.isDeleted(right));
		assertEquals(true, main.isChildrenChanged());
		assertEquals(37, main.getLength());
		assertEquals(37, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(left));
        assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	@Test
	public void testReplaceMiddleEmpty() throws Exception {
		tbModel.replace(14, 4, "");
		assertReplace(14, 4, "");

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	@Test
	public void testReplaceMiddleEmptyPreviousVersion() throws Exception {
		// make used fixture of version PREVIOUS to prevent getWorkingCopy
		// to create a different version and check deletions, values etc
		TbChangeUtil.makeVersion(main, EEnum.PREVIOUS);

		// should change
		assertEquals("+", subToken.getValue());
		assertEquals("ddddd", lexed4.getValue());
		assertEquals(false, TbUtil.isDeleted(subBlock1));
		assertEquals(false, TbUtil.isDeleted(subToken));
		assertEquals(false, main.isChildrenChanged());
		assertEquals(false, middle.isChildrenChanged());
		assertEquals(false, right.isChildrenChanged());
		assertEquals(40, main.getLength());
		assertEquals(40, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(left));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(lexed1));
		assertEquals(false, TbUtil.isDeleted(lexed2));
		assertEquals(false, TbUtil.isDeleted(middle));
		assertEquals(false, TbUtil.isDeleted(lexed3));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		tbModel.replace(21, 14, "");
		assertReplace(21, 14, "");

		// should change
		assertEquals("dd", lexed4.getValue());
		assertEquals(true, TbUtil.isDeleted(subBlock1));
		assertEquals(true, TbUtil.isDeleted(subToken));
		assertEquals(true, main.isChildrenChanged());
		assertEquals(true, middle.isChildrenChanged());
		assertEquals(true, right.isChildrenChanged());
		assertEquals(26, main.getLength());
		assertEquals(26, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(left));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(lexed1));
		assertEquals(false, TbUtil.isDeleted(lexed2));
		assertEquals(false, TbUtil.isDeleted(middle));
		assertEquals(false, TbUtil.isDeleted(lexed3));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	@Test
	public void testReplaceMiddleShortString() throws Exception {
		tbModel.replace(11, 7, "x");
		assertReplace(11, 7, "x");

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	@Test
	public void testReplaceMiddleShortStringPreviousVersion() throws Exception {
		// make used fixture of version PREVIOUS to prevent getWorkingCopy
		// to create a different version and check deletions, values etc
		TbChangeUtil.makeVersion(main, EEnum.PREVIOUS);

		// should change
		assertEquals("bbbbcccc", lexed3.getValue());
		assertEquals("+", subToken.getValue());
		assertEquals("ddddd", lexed4.getValue());
		assertEquals(false, TbUtil.isDeleted(subBlock1));
		assertEquals(false, TbUtil.isDeleted(subToken));
		assertEquals(false, main.isChildrenChanged());
		assertEquals(false, middle.isChildrenChanged());
		assertEquals(false, right.isChildrenChanged());
		assertEquals(40, main.getLength());
		assertEquals(40, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(left));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(lexed1));
		assertEquals(false, TbUtil.isDeleted(lexed2));
		assertEquals(false, TbUtil.isDeleted(middle));
		assertEquals(false, TbUtil.isDeleted(lexed3));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		tbModel.replace(18, 17, "x");
		assertReplace(18, 17, "x");

		// should change
		assertEquals("bbbbcx", lexed3.getValue());
		assertEquals("dd", lexed4.getValue());
		assertEquals(true, TbUtil.isDeleted(subBlock1));
		assertEquals(true, TbUtil.isDeleted(subToken));
		assertEquals(true, main.isChildrenChanged());
		assertEquals(true, middle.isChildrenChanged());
		assertEquals(true, right.isChildrenChanged());
		assertEquals(24, main.getLength());
		assertEquals(24, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(left));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(lexed1));
		assertEquals(false, TbUtil.isDeleted(lexed2));
		assertEquals(false, TbUtil.isDeleted(middle));
		assertEquals(false, TbUtil.isDeleted(lexed3));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	@Test
	public void testReplaceMiddleLongString() throws Exception {
		tbModel.replace(4, 11, "xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");
		assertReplace(4, 11, "xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	@Test
	public void testReplaceMiddleLongStringPreviousVersion() throws Exception {
		// make used fixture of version PREVIOUS to prevent getWorkingCopy
		// to create a different version and check deletions, values etc
		TbChangeUtil.makeVersion(main, EEnum.PREVIOUS);

		// should change
		assertEquals("aaaaa", lexed1.getValue());
		assertEquals("ddddd", lexed4.getValue());
		assertEquals(false, TbUtil.isDeleted(lexed2));
		assertEquals(false, TbUtil.isDeleted(middle));
		assertEquals(false, TbUtil.isDeleted(subBlock1));
		assertEquals(false, TbUtil.isDeleted(lexed3));
		assertEquals(false, TbUtil.isDeleted(subToken));
		assertEquals(false, main.isChildrenChanged());
		assertEquals(false, left.isChildrenChanged());
		assertEquals(false, leftLeft.isChildrenChanged());
		assertEquals(false, right.isChildrenChanged());
		assertEquals(40, main.getLength());
		assertEquals(40, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(left));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(lexed1));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		tbModel.replace(4, 28, "xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");
		assertReplace(4, 28, "xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");

		// should change
		assertEquals("axxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx", lexed1
				.getValue());
		assertEquals("ddddd", lexed4.getValue());
		assertEquals(true, TbUtil.isDeleted(lexed2));
		assertEquals(true, TbUtil.isDeleted(middle));
		assertEquals(true, TbUtil.isDeleted(subBlock1));
		assertEquals(true, TbUtil.isDeleted(lexed3));
		assertEquals(true, TbUtil.isDeleted(subToken));
		assertEquals(true, main.isChildrenChanged());
		assertEquals(true, left.isChildrenChanged());
		assertEquals(true, leftLeft.isChildrenChanged());
		assertEquals(true, right.isChildrenChanged());
		assertEquals(49, main.getLength());
		assertEquals(49, eos.getOffset());

		// should not change
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(left));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(lexed1));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	@Test
	public void testReplaceAddToEnd() throws Exception {
		tbModel.replace(completeFixtureText.length(), 0, "xxxxx");
		assertReplace(completeFixtureText.length(), 0, "xxxxx");

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	@Test
	public void testReplaceAddToEndPreviousVersion() throws Exception {
		// make used fixture of version PREVIOUS to prevent getWorkingCopy
		// to create a different version and check deletions, values etc
		TbChangeUtil.makeVersion(main, EEnum.PREVIOUS);

		// should change
		assertEquals(false, main.isChildrenChanged());
		assertEquals(false, right.isChildrenChanged());
		assertEquals(40, main.getLength());
		assertEquals(40, eos.getOffset());

		// should not change
		assertEquals("ddddd", lexed4.getValue());
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(lexed1));
		assertEquals(false, TbUtil.isDeleted(left));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(lexed2));
		assertEquals(false, TbUtil.isDeleted(middle));
		assertEquals(false, TbUtil.isDeleted(subBlock1));
		assertEquals(false, TbUtil.isDeleted(subToken));
		assertEquals(false, TbUtil.isDeleted(lexed3));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, left.isChildrenChanged());
		assertEquals(false, leftLeft.isChildrenChanged());
		assertEquals(false, middle.isChildrenChanged());
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		tbModel.replace(completeFixtureText.length(), 0, "xxxxx");
		assertReplace(completeFixtureText.length(), 0, "xxxxx");

		// should change
		
		assertEquals(true, main.isChildrenChanged());
		assertEquals(true, right.isChildrenChanged());
		assertEquals(45, main.getLength());
		assertEquals(45, eos.getOffset());

		// should not change
		assertEquals("ddddd   xxxxx", lexed4.getValue());
		assertEquals(false, TbUtil.isDeleted(main));
		assertEquals(false, TbUtil.isDeleted(lexed1));
		assertEquals(false, TbUtil.isDeleted(left));
		assertEquals(false, TbUtil.isDeleted(leftLeft));
		assertEquals(false, TbUtil.isDeleted(lexed2));
		assertEquals(false, TbUtil.isDeleted(middle));
		assertEquals(false, TbUtil.isDeleted(subBlock1));
		assertEquals(false, TbUtil.isDeleted(subToken));
		assertEquals(false, TbUtil.isDeleted(lexed3));
		assertEquals(false, TbUtil.isDeleted(right));
		assertEquals(false, TbUtil.isDeleted(lexed4));
		assertEquals(false, TbUtil.isDeleted(bos));
		assertEquals(false, TbUtil.isDeleted(eos));
		assertEquals(false, left.isChildrenChanged());
		assertEquals(false, leftLeft.isChildrenChanged());
		assertEquals(false, middle.isChildrenChanged());
		assertEquals(false, bos.isChildrenChanged());
		assertEquals(false, eos.isChildrenChanged());

		// re-replace original string
		tbModel.replace(0, tbModel.getLength(), completeFixtureText);
		assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
	}

	/**
	 * Asserts, that the original value (assumed to be completeFixtureText) was
	 * replaced correctly, by checking, if get returns the right string for the
	 * whole document.
	 * 
	 * @param offset
	 *            offset replacement starts
	 * @param length
	 *            length of replacement
	 * @param newText
	 *            new text
	 * @throws Exception
	 */
	private void assertReplace(int offset, int length, String newText)
			throws Exception {
		String beforeReplace = completeFixtureText.substring(0, offset);
		String afterReplace = completeFixtureText.substring(offset + length,
				completeFixtureText.length());
		String expectedCompleteText = beforeReplace + newText + afterReplace;
		assertEquals(expectedCompleteText, tbModel.get(0, tbModel.getLength()));
	}
}
