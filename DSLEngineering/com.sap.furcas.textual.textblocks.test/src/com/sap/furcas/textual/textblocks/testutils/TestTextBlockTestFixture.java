package com.sap.furcas.textual.textblocks.testutils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Base class for TextBlock related test cases. Sets up a common fixture model
 * and makes all elements available through protected members.
 * 
 * @author D052602
 * 
 */
public class TestTextBlockTestFixture extends FixtureProvidingTextBlockTest {

    @Test
    public void testFixtureLengths() {
	TextblocksTestHelper.assertNodeLength(main);
	TextblocksTestHelper.assertNodeLength(bos);
	TextblocksTestHelper.assertNodeLength(left);
	TextblocksTestHelper.assertNodeLength(leftLeft);
	TextblocksTestHelper.assertNodeLength(lexed1);
	TextblocksTestHelper.assertNodeLength(lexed2);
	TextblocksTestHelper.assertNodeLength(middle);
	TextblocksTestHelper.assertNodeLength(lexed3);
	TextblocksTestHelper.assertNodeLength(subBlock1);
	TextblocksTestHelper.assertNodeLength(subBlock2);
	TextblocksTestHelper.assertNodeLength(subBlock3);
	TextblocksTestHelper.assertNodeLength(subBlock4);
	TextblocksTestHelper.assertNodeLength(subToken);
	TextblocksTestHelper.assertNodeLength(right);
	TextblocksTestHelper.assertNodeLength(lexed4);
	TextblocksTestHelper.assertNodeLength(eos);
    }

    @Test
    public void testFixtureOffsets() {
	TextblocksTestHelper.assertNodeOffset(main);
	TextblocksTestHelper.assertNodeOffset(bos);
	TextblocksTestHelper.assertNodeOffset(left);
	TextblocksTestHelper.assertNodeOffset(leftLeft);
	TextblocksTestHelper.assertNodeOffset(lexed1);
	TextblocksTestHelper.assertNodeOffset(lexed2);
	TextblocksTestHelper.assertNodeOffset(middle);
	TextblocksTestHelper.assertNodeOffset(lexed3);
	TextblocksTestHelper.assertNodeOffset(subBlock1);
	TextblocksTestHelper.assertNodeOffset(subBlock2);
	TextblocksTestHelper.assertNodeOffset(subBlock3);
	TextblocksTestHelper.assertNodeOffset(subBlock4);
	TextblocksTestHelper.assertNodeOffset(subToken);
	TextblocksTestHelper.assertNodeOffset(right);
	TextblocksTestHelper.assertNodeOffset(lexed4);
	TextblocksTestHelper.assertNodeOffset(eos);
    }

    /**
     * Double check all parent-child relationships
     */
    @Test
    public void testFixtureStructure() {
	assertEquals(true, main.getTokens().contains(bos));
	assertEquals(true, main.getSubBlocks().contains(left));
	assertEquals(true, main.getTokens().contains(lexed2));
	assertEquals(true, main.getSubBlocks().contains(middle));
	assertEquals(true, main.getTokens().contains(eos));
	assertEquals(true, left.getSubBlocks().contains(leftLeft));
	assertEquals(true, leftLeft.getTokens().contains(lexed1));
	assertEquals(true, middle.getTokens().contains(lexed3));
	assertEquals(true, middle.getSubBlocks().contains(subBlock1));
	assertEquals(true, subBlock1.getSubBlocks().contains(subBlock2));
	assertEquals(true, subBlock2.getSubBlocks().contains(subBlock3));
	assertEquals(true, subBlock3.getSubBlocks().contains(subBlock4));
	assertEquals(true, subBlock4.getTokens().contains(subToken));
	assertEquals(true, right.getTokens().contains(lexed4));

	assertEquals(main, left.getParent());
	assertEquals(left, leftLeft.getParent());
	assertEquals(main, bos.getParent());
	assertEquals(leftLeft, lexed1.getParent());
	assertEquals(main, lexed2.getParent());
	assertEquals(main, middle.getParent());
	assertEquals(middle, lexed3.getParent());
	assertEquals(middle, subBlock1.getParent());
	assertEquals(subBlock1, subBlock2.getParent());
	assertEquals(subBlock2, subBlock3.getParent());
	assertEquals(subBlock3, subBlock4.getParent());
	assertEquals(subBlock4, subToken.getParent());
	assertEquals(right, lexed4.getParent());
	assertEquals(main, right.getParent());
	assertEquals(main, eos.getParent());
    }

    @Test
    public void testFixtureValues() {
	TextblocksTestHelper.assertCachedString(main);
	TextblocksTestHelper.assertCachedString(left);
	TextblocksTestHelper.assertCachedString(leftLeft);
	TextblocksTestHelper.assertCachedString(middle);
	TextblocksTestHelper.assertCachedString(subBlock1);
	TextblocksTestHelper.assertCachedString(subBlock2);
	TextblocksTestHelper.assertCachedString(subBlock3);
	TextblocksTestHelper.assertCachedString(subBlock4);
	TextblocksTestHelper.assertCachedString(right);
    }
}
