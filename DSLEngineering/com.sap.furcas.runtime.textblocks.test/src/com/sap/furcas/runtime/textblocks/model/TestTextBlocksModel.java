package com.sap.furcas.runtime.textblocks.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;
import com.sap.furcas.runtime.textblocks.testutils.FixtureProvidingTextBlockTest;
import com.sap.furcas.runtime.textblocks.testutils.TextblocksTestHelper;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;

public class TestTextBlocksModel extends FixtureProvidingTextBlockTest {

    private TextBlocksModel tbModel;
    private String completeFixtureText;

    @Before
    public void setupTbModel() {
	tbModel = new TextBlocksModel(main, null);

	// has to match the fixture model
	completeFixtureText = "aaaaa*bbbbcccc+ddddd";
    }

    /**
     * Check that all offsets return the correct char.
     * 
     */
    @Test
    public void testGetChar() {
	for (int i = 0; i < completeFixtureText.length(); i++) {
	    assertEquals("char at offset " + i, completeFixtureText.charAt(i), tbModel.get(i));
	}
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCharOffsetNegative() {
	tbModel.get(completeFixtureText.length() + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCharOffsetTooLarge() {
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
	for (int length = 0; length <= completeFixtureText.length(); length++) {
	    for (int offset = 0; offset <= completeFixtureText.length() - length; offset++) {
		assertEquals("region at offset " + offset + " of length " + length,
			completeFixtureText.substring(offset, offset + length), tbModel.get(offset, length));
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
	// completeFixtureText = "aaaaa*bbbbcccc+ddddd";
	assertEquals(lexed1, tbModel.getFloorTokenInRoot(0));
	assertEquals(lexed1, tbModel.getFloorTokenInRoot(1));
	assertEquals(lexed1, tbModel.getFloorTokenInRoot(4));
	assertEquals(lexed2, tbModel.getFloorTokenInRoot(5));
	assertEquals(lexed3, tbModel.getFloorTokenInRoot(6));
	assertEquals(lexed3, tbModel.getFloorTokenInRoot(8));
	assertEquals(lexed3, tbModel.getFloorTokenInRoot(13));
	assertEquals(subToken, tbModel.getFloorTokenInRoot(14));
	assertEquals(lexed4, tbModel.getFloorTokenInRoot(15));
	assertEquals(lexed4, tbModel.getFloorTokenInRoot(16));
	assertEquals(lexed4, tbModel.getFloorTokenInRoot(19));
	assertEquals(lexed4, tbModel.getFloorTokenInRoot(20));

	main.getSubNodes().clear();
	main.getSubNodes().add(bos);
	main.getSubNodes().add(eos);

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

	resource.getContents().add(a);
	a.getSubNodes().add(b1);
	a.getSubNodes().add(b2);
	b1.getSubNodes().add(c);
	c.getSubNodes().add(d);
	d.getSubNodes().add(e);

	// should only remove b2
	assertEquals(true, a.getTokens().contains(b2));
	assertEquals(false, TextblocksTestHelper.isDeleted(b1));
	assertEquals(false, TextblocksTestHelper.isDeleted(a));

	TbChangeUtil.removeNode(b2);

	assertEquals(true, TextblocksTestHelper.isDeleted(b2));
	assertEquals(false, TextblocksTestHelper.isDeleted(a));

	// should now remove e, d, c, b1 and a (as b2 was already deleted)
	assertEquals(true, d.getTokens().contains(e));
	assertEquals(true, c.getSubBlocks().contains(d));
	assertEquals(true, b1.getSubBlocks().contains(c));
	assertEquals(true, a.getSubBlocks().contains(b1));
	assertEquals(false, TextblocksTestHelper.isDeleted(e));
	assertEquals(false, TextblocksTestHelper.isDeleted(d));
	assertEquals(false, TextblocksTestHelper.isDeleted(c));
	assertEquals(false, TextblocksTestHelper.isDeleted(b1));
	assertEquals(false, TextblocksTestHelper.isDeleted(a));

	TbChangeUtil.removeNode(e);

	assertEquals(true, TextblocksTestHelper.isDeleted(e));
	assertEquals(true, TextblocksTestHelper.isDeleted(d));
	assertEquals(true, TextblocksTestHelper.isDeleted(c));
	assertEquals(true, TextblocksTestHelper.isDeleted(b1));
	assertEquals(true, TextblocksTestHelper.isDeleted(a));

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

	resource.getContents().add(a);
	a.getSubNodes().add(b1);
	a.getSubNodes().add(b2);
	b1.getSubNodes().add(c);
	c.getSubNodes().add(d);

	// should not remove b1
	assertEquals(true, a.getSubBlocks().contains(b1));
	assertEquals(false, TextblocksTestHelper.isDeleted(b1));

	TbChangeUtil.removeTextBlockIfEmpty(b1);

	assertEquals(false, TextblocksTestHelper.isDeleted(b1));
	assertEquals(true, a.getSubBlocks().contains(b1));

	// should remove d, c and b1
	assertEquals(true, c.getSubBlocks().contains(d));
	assertEquals(true, b1.getSubBlocks().contains(c));
	assertEquals(true, a.getSubBlocks().contains(b1));
	assertEquals(false, TextblocksTestHelper.isDeleted(d));
	assertEquals(false, TextblocksTestHelper.isDeleted(c));
	assertEquals(false, TextblocksTestHelper.isDeleted(b1));

	TbChangeUtil.removeTextBlockIfEmpty(d);

	assertEquals(true, TextblocksTestHelper.isDeleted(d));
	assertEquals(true, TextblocksTestHelper.isDeleted(c));
	assertEquals(true, TextblocksTestHelper.isDeleted(b1));

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
	TbChangeUtil.makeVersion(main, Version.PREVIOUS);

	// should change
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(middle));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, main.isChildrenChanged());
	assertEquals(20, main.getLength());
	assertEquals(20, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
	assertEquals(false, bos.isChildrenChanged());
	assertEquals(false, eos.isChildrenChanged());

	tbModel.replace(0, completeFixtureText.length(), "");
	assertReplace(0, completeFixtureText.length(), "");

	// should change
	assertEquals(true, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(true, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(true, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(true, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(true, TextblocksTestHelper.isDeleted(middle));
	assertEquals(true, TextblocksTestHelper.isDeleted(right));
	assertEquals(true, main.isChildrenChanged());
	assertEquals(0, main.getLength());
	assertEquals(0, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
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
	TbChangeUtil.makeVersion(main, Version.PREVIOUS);

	// should change
	assertEquals("aaaaa", lexed1.getValue());
	assertEquals(false, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(middle));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, main.isChildrenChanged());
	assertEquals(false, left.isChildrenChanged());
	assertEquals(false, leftLeft.isChildrenChanged());
	assertEquals(20, main.getLength());
	assertEquals(20, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
	assertEquals(false, bos.isChildrenChanged());
	assertEquals(false, eos.isChildrenChanged());

	tbModel.replace(0, completeFixtureText.length(), "x");
	assertReplace(0, completeFixtureText.length(), "x");

	// should change
	assertEquals("x", lexed1.getValue());
	assertEquals(true, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(true, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(true, TextblocksTestHelper.isDeleted(middle));
	assertEquals(true, TextblocksTestHelper.isDeleted(right));
	assertEquals(true, main.isChildrenChanged());
	assertEquals(true, left.isChildrenChanged());
	assertEquals(true, leftLeft.isChildrenChanged());
	assertEquals(1, main.getLength());
	assertEquals(1, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
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
	tbModel.replace(0, completeFixtureText.length(), "xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");
	assertReplace(0, completeFixtureText.length(), "xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");

	// re-replace original string
	tbModel.replace(0, tbModel.getLength(), completeFixtureText);
	assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
    }

    @Test
    public void testReplaceAllLongStringPreviousVersion() throws Exception {
	// make used fixture of version PREVIOUS to prevent getWorkingCopy
	// to create a different version and check deletions, values etc
	TbChangeUtil.makeVersion(main, Version.PREVIOUS);

	// should change
	assertEquals("aaaaa", lexed1.getValue());
	assertEquals(false, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(middle));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, main.isChildrenChanged());
	assertEquals(false, left.isChildrenChanged());
	assertEquals(false, leftLeft.isChildrenChanged());
	assertEquals(20, main.getLength());
	assertEquals(20, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
	assertEquals(false, bos.isChildrenChanged());
	assertEquals(false, eos.isChildrenChanged());

	tbModel.replace(0, completeFixtureText.length(), "xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");
	assertReplace(0, completeFixtureText.length(), "xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");

	// should change
	assertEquals("xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx", lexed1.getValue());
	assertEquals(true, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(true, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(true, TextblocksTestHelper.isDeleted(middle));
	assertEquals(true, TextblocksTestHelper.isDeleted(right));
	assertEquals(true, main.isChildrenChanged());
	assertEquals(true, left.isChildrenChanged());
	assertEquals(true, leftLeft.isChildrenChanged());
	assertEquals(37, main.getLength());
	assertEquals(37, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
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
	TbChangeUtil.makeVersion(main, Version.PREVIOUS);

	// should change
	assertEquals("+", subToken.getValue());
	assertEquals("ddddd", lexed4.getValue());
	assertEquals(false, TextblocksTestHelper.isDeleted(subBlock1));
	assertEquals(false, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(false, main.isChildrenChanged());
	assertEquals(false, middle.isChildrenChanged());
	assertEquals(false, right.isChildrenChanged());
	assertEquals(20, main.getLength());
	assertEquals(20, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed2));
	assertEquals(false, TextblocksTestHelper.isDeleted(middle));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed3));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
	assertEquals(false, bos.isChildrenChanged());
	assertEquals(false, eos.isChildrenChanged());

	tbModel.replace(14, 4, "");
	assertReplace(14, 4, "");

	// should change
	assertEquals("dd", lexed4.getValue());
	assertEquals(true, TextblocksTestHelper.isDeleted(subBlock1));
	assertEquals(true, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(true, main.isChildrenChanged());
	assertEquals(true, middle.isChildrenChanged());
	assertEquals(true, right.isChildrenChanged());
	assertEquals(16, main.getLength());
	assertEquals(16, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed2));
	assertEquals(false, TextblocksTestHelper.isDeleted(middle));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed3));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
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
	TbChangeUtil.makeVersion(main, Version.PREVIOUS);

	// should change
	assertEquals("bbbbcccc", lexed3.getValue());
	assertEquals("+", subToken.getValue());
	assertEquals("ddddd", lexed4.getValue());
	assertEquals(false, TextblocksTestHelper.isDeleted(subBlock1));
	assertEquals(false, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(false, main.isChildrenChanged());
	assertEquals(false, middle.isChildrenChanged());
	assertEquals(false, right.isChildrenChanged());
	assertEquals(20, main.getLength());
	assertEquals(20, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed2));
	assertEquals(false, TextblocksTestHelper.isDeleted(middle));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed3));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
	assertEquals(false, bos.isChildrenChanged());
	assertEquals(false, eos.isChildrenChanged());

	tbModel.replace(11, 7, "x");
	assertReplace(11, 7, "x");

	// should change
	assertEquals("bbbbcx", lexed3.getValue());
	assertEquals("dd", lexed4.getValue());
	assertEquals(true, TextblocksTestHelper.isDeleted(subBlock1));
	assertEquals(true, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(true, main.isChildrenChanged());
	assertEquals(true, middle.isChildrenChanged());
	assertEquals(true, right.isChildrenChanged());
	assertEquals(14, main.getLength());
	assertEquals(14, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed2));
	assertEquals(false, TextblocksTestHelper.isDeleted(middle));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed3));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
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
	TbChangeUtil.makeVersion(main, Version.PREVIOUS);

	// should change
	assertEquals("aaaaa", lexed1.getValue());
	assertEquals("ddddd", lexed4.getValue());
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed2));
	assertEquals(false, TextblocksTestHelper.isDeleted(middle));
	assertEquals(false, TextblocksTestHelper.isDeleted(subBlock1));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed3));
	assertEquals(false, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(false, main.isChildrenChanged());
	assertEquals(false, left.isChildrenChanged());
	assertEquals(false, leftLeft.isChildrenChanged());
	assertEquals(false, right.isChildrenChanged());
	assertEquals(20, main.getLength());
	assertEquals(20, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
	assertEquals(false, bos.isChildrenChanged());
	assertEquals(false, eos.isChildrenChanged());

	tbModel.replace(4, 11, "xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");
	assertReplace(4, 11, "xxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx");

	// should change
	assertEquals("aaaaxxxxxyyyyxxxxyyyyxxxxyyyyxxxxyyyyxxxx", lexed1.getValue());
	assertEquals("ddddd", lexed4.getValue());
	assertEquals(true, TextblocksTestHelper.isDeleted(lexed2));
	assertEquals(true, TextblocksTestHelper.isDeleted(middle));
	assertEquals(true, TextblocksTestHelper.isDeleted(subBlock1));
	assertEquals(true, TextblocksTestHelper.isDeleted(lexed3));
	assertEquals(true, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(true, main.isChildrenChanged());
	assertEquals(true, left.isChildrenChanged());
	assertEquals(true, leftLeft.isChildrenChanged());
	assertEquals(true, right.isChildrenChanged());
	assertEquals(46, main.getLength());
	assertEquals(46, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
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
	TbChangeUtil.makeVersion(main, Version.PREVIOUS);

	// should change
	assertEquals("ddddd", lexed4.getValue());
	assertEquals(false, main.isChildrenChanged());
	assertEquals(false, right.isChildrenChanged());
	assertEquals(20, main.getLength());
	assertEquals(20, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed2));
	assertEquals(false, TextblocksTestHelper.isDeleted(middle));
	assertEquals(false, TextblocksTestHelper.isDeleted(subBlock1));
	assertEquals(false, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed3));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
	assertEquals(false, left.isChildrenChanged());
	assertEquals(false, leftLeft.isChildrenChanged());
	assertEquals(false, middle.isChildrenChanged());
	assertEquals(false, bos.isChildrenChanged());
	assertEquals(false, eos.isChildrenChanged());

	tbModel.replace(completeFixtureText.length(), 0, "xxxxx");
	assertReplace(completeFixtureText.length(), 0, "xxxxx");

	// should change
	assertEquals("dddddxxxxx", lexed4.getValue());
	assertEquals(true, main.isChildrenChanged());
	assertEquals(true, right.isChildrenChanged());
	assertEquals(25, main.getLength());
	assertEquals(25, eos.getOffset());

	// should not change
	assertEquals(false, TextblocksTestHelper.isDeleted(main));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed1));
	assertEquals(false, TextblocksTestHelper.isDeleted(left));
	assertEquals(false, TextblocksTestHelper.isDeleted(leftLeft));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed2));
	assertEquals(false, TextblocksTestHelper.isDeleted(middle));
	assertEquals(false, TextblocksTestHelper.isDeleted(subBlock1));
	assertEquals(false, TextblocksTestHelper.isDeleted(subToken));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed3));
	assertEquals(false, TextblocksTestHelper.isDeleted(right));
	assertEquals(false, TextblocksTestHelper.isDeleted(lexed4));
	assertEquals(false, TextblocksTestHelper.isDeleted(bos));
	assertEquals(false, TextblocksTestHelper.isDeleted(eos));
	assertEquals(false, left.isChildrenChanged());
	assertEquals(false, leftLeft.isChildrenChanged());
	assertEquals(false, middle.isChildrenChanged());
	assertEquals(false, bos.isChildrenChanged());
	assertEquals(false, eos.isChildrenChanged());

	// re-replace original string
	tbModel.replace(0, tbModel.getLength(), completeFixtureText);
	assertEquals(completeFixtureText, tbModel.get(0, tbModel.getLength()));
    }

    @Test
    public void testGetNodesBetweenAsRootSetSameBlock() {
	// add newLexed to middle, so that we have two tokens and the block in
	// between
	LexedToken newLexed = modelFactory.createLexedToken();
	middle.getSubNodes().add(newLexed);
	newLexed.setOffset(9);
	newLexed.setOffsetRelative(true);
	TbChangeUtil.replaceTokenContentsAndUpdateParents(newLexed, "test", 0, 0, new ShortPrettyPrinter(null));
	TbValidationUtil.assertTextBlockConsistency(middle);

	List<DocumentNode> expectedNodes = new ArrayList<DocumentNode>();

	expectedNodes.add(lexed3); // token starts at 6, length 8
	expectedNodes.add(subBlock1); // length 1
	expectedNodes.add(newLexed);
	List<DocumentNode> resultNodes = tbModel.getNodesBetweenAsRootSet(main, 6, 15);
	assertEquals(expectedNodes.size(), resultNodes.size());
	assertEquals(expectedNodes, resultNodes);
    }

    @Test
    public void testGetNodesBetweenAsRootSetSameLevel() {
	// add newLexed to the end of right, to check if descend gathers all
	// left siblings of
	// the right floor token and its parents
	LexedToken newLexed = modelFactory.createLexedToken();
	right.getSubNodes().add(newLexed);
	newLexed.setOffset(5);
	TbChangeUtil.replaceTokenContentsAndUpdateParents(newLexed, "test", 0, 0, new ShortPrettyPrinter(null));

	List<DocumentNode> expectedNodes = new ArrayList<DocumentNode>();

	expectedNodes.add(lexed3); // token starts at 6, length 8
	expectedNodes.add(subBlock1); // length 1
	expectedNodes.add(lexed4);
	expectedNodes.add(newLexed);
	List<DocumentNode> resultNodes = tbModel.getNodesBetweenAsRootSet(main, 6, 20);

	assertEquals(expectedNodes.size(), resultNodes.size());
	assertEquals(expectedNodes, resultNodes);
    }

    @Test
    public void testGetNodesBetweenAsRootSetLeftLowerLevel() {
	// add a level 1 token, so that lexed1 (level 3) have a level difference
	// of at least 2
	LexedToken newLexed = modelFactory.createLexedToken();
	main.getSubNodes().remove(eos);
	main.getSubNodes().add(newLexed);
	newLexed.setOffset(20);
	TbChangeUtil.replaceTokenContentsAndUpdateParents(newLexed, "test", 0, 0, new ShortPrettyPrinter(null));
	main.getSubNodes().add(eos);
	eos.setOffset(24);

	List<DocumentNode> expectedNodes = new ArrayList<DocumentNode>();

	expectedNodes.add(lexed1);
	expectedNodes.add(lexed2);
	expectedNodes.add(middle);
	expectedNodes.add(right);
	expectedNodes.add(newLexed);
	List<DocumentNode> resultNodes = tbModel.getNodesBetweenAsRootSet(main, 0, 20);

	assertEquals(expectedNodes.size(), resultNodes.size());
	assertEquals(expectedNodes, resultNodes);
    }

    @Test
    public void testGetNodesBetweenAsRootSetLeftHigherLevel() {
	// add some more nodes, as standard fixture is rather sparse
	// also, add more depth, so make the level difference of the floor
	// tokens
	// at least 2
	TextBlock newBlock = modelFactory.createTextBlock();
	LexedToken newLexed = modelFactory.createLexedToken();
	newLexed.setOffsetRelative(true);
	LexedToken newLexed2 = modelFactory.createLexedToken();
	right.getSubNodes().add(newBlock);
	newBlock.setOffset(5);
	newBlock.setOffsetRelative(true);
	newBlock.getSubNodes().add(newLexed);
	TbChangeUtil.replaceTokenContentsAndUpdateParents(newLexed, "test", 0, 0, new ShortPrettyPrinter(null));
	newBlock.getSubNodes().add(newLexed2);
	newLexed2.setOffset(4);
	newLexed2.setOffsetRelative(true);
	TbChangeUtil.replaceTokenContentsAndUpdateParents(newLexed2, "other", 0, 0, new ShortPrettyPrinter(null));

	List<DocumentNode> expectedNodes = new ArrayList<DocumentNode>();

	expectedNodes.add(lexed2);
	expectedNodes.add(middle);
	expectedNodes.add(lexed4);
	expectedNodes.add(newLexed);
	expectedNodes.add(newLexed2);
	List<DocumentNode> resultNodes = tbModel.getNodesBetweenAsRootSet(main, 5, 24);

	assertEquals(expectedNodes.size(), resultNodes.size());
	assertEquals(expectedNodes, resultNodes);
    }

    @Test
    public void testGetNodesBetweenAsRootSetLeftMuchHigherLevel() {
	// test with a high level difference
	// add some more tokens, as the standard fixture is rather sparse
	TextBlock newBlock = modelFactory.createTextBlock();
	LexedToken newLexed = modelFactory.createLexedToken();
	newLexed.setOffsetRelative(true);
	LexedToken newLexed2 = modelFactory.createLexedToken();
	subBlock4.getSubNodes().add(newBlock);
	newBlock.setOffset(1);
	newBlock.setOffsetRelative(true);
	newBlock.getSubNodes().add(newLexed);
	TbChangeUtil.replaceTokenContentsAndUpdateParents(newLexed, "test", 0, 0, new ShortPrettyPrinter(null));
	newBlock.getSubNodes().add(newLexed2);
	newLexed2.setOffset(4);
	newLexed2.setOffsetRelative(true);
	TbChangeUtil.replaceTokenContentsAndUpdateParents(newLexed2, "other", 0, 0, new ShortPrettyPrinter(null));

	List<DocumentNode> expectedNodes = new ArrayList<DocumentNode>();

	expectedNodes.add(lexed2);
	expectedNodes.add(lexed3);
	expectedNodes.add(subToken);
	expectedNodes.add(newLexed);
	expectedNodes.add(newLexed2);
	List<DocumentNode> resultNodes = tbModel.getNodesBetweenAsRootSet(main, 5, 19);

	assertEquals(expectedNodes.size(), resultNodes.size());
	assertEquals(expectedNodes, resultNodes);
    }

    @Test
    public void testGetNodesBetweenAsRootSetSameToken() {
	List<DocumentNode> expectedNodes = new ArrayList<DocumentNode>();

	expectedNodes.add(lexed3); // token starts at 6, length 8
	List<DocumentNode> resultNodes = tbModel.getNodesBetweenAsRootSet(main, 6, 13);
	assertEquals(expectedNodes.size(), resultNodes.size());
	assertEquals(expectedNodes, resultNodes);
    }

    @Test
    public void testGetNodesBetweenAsRootSetSameOffset() {
	List<DocumentNode> expectedNodes = new ArrayList<DocumentNode>();

	expectedNodes.add(lexed3); // token starts at 6, length 8
	List<DocumentNode> resultNodes = tbModel.getNodesBetweenAsRootSet(main, 6, 6);
	assertEquals(expectedNodes.size(), resultNodes.size());
	assertEquals(expectedNodes, resultNodes);
    }

    @Test
    public void testAddRightSiblingsBeforeEndNode() {
	TextBlock top = modelFactory.createTextBlock();
	LexedToken t1 = modelFactory.createLexedToken();
	LexedToken t2 = modelFactory.createLexedToken();
	TextBlock t3 = modelFactory.createTextBlock();
	LexedToken t4 = modelFactory.createLexedToken();
	LexedToken t5 = modelFactory.createLexedToken();
	LexedToken x = modelFactory.createLexedToken();
	top.getSubNodes().add(t1);
	top.getSubNodes().add(t2);
	top.getSubNodes().add(t3);
	top.getSubNodes().add(t4);
	top.getSubNodes().add(t5);

	t1.setOffset(0);
	t2.setOffset(2);
	t3.setOffset(3);
	t4.setOffset(8);
	t5.setOffset(10);

	List<DocumentNode> expectedNodes = new ArrayList<DocumentNode>();
	List<DocumentNode> resultNodes = new ArrayList<DocumentNode>();

	tbModel.addRightSiblingsBeforeEndNode(resultNodes, t1, t1);
	assertEquals(expectedNodes, resultNodes);

	resultNodes.clear();
	tbModel.addRightSiblingsBeforeEndNode(resultNodes, t1, t2);
	assertEquals(expectedNodes, resultNodes);

	expectedNodes.add(t2);
	resultNodes.clear();
	tbModel.addRightSiblingsBeforeEndNode(resultNodes, t1, t3);
	assertEquals(expectedNodes, resultNodes);

	expectedNodes.add(t3);
	resultNodes.clear();
	tbModel.addRightSiblingsBeforeEndNode(resultNodes, t1, t4);
	assertEquals(expectedNodes, resultNodes);

	expectedNodes.add(t4);
	resultNodes.clear();
	tbModel.addRightSiblingsBeforeEndNode(resultNodes, t1, t5);
	assertEquals(expectedNodes, resultNodes);

	expectedNodes.add(t5);
	resultNodes.clear();
	tbModel.addRightSiblingsBeforeEndNode(resultNodes, t1, null);
	assertEquals(expectedNodes, resultNodes);

	resultNodes.clear();
	tbModel.addRightSiblingsBeforeEndNode(resultNodes, t1, x);
	assertEquals(expectedNodes, resultNodes);
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
    private void assertReplace(int offset, int length, String newText) throws Exception {
	String beforeReplace = completeFixtureText.substring(0, offset);
	String afterReplace = completeFixtureText.substring(offset + length, completeFixtureText.length());
	String expectedCompleteText = beforeReplace + newText + afterReplace;
	assertEquals(expectedCompleteText, tbModel.get(0, tbModel.getLength()));
    }
}
