/**
 * 
 */
package com.sap.furcas.textual.textblocks.modification;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.furcas.textual.textblocks.modifcation.TbMarkingUtil;
import com.sap.furcas.textual.textblocks.testutils.FixtureProvidingTextBlockTest;

/**
 * 
 */
public class TestMarkingUtil extends FixtureProvidingTextBlockTest {

    @Test
    public void testIsEOS() {
	assertEquals(true, TbMarkingUtil.isEOS(eos));
	assertEquals(false, TbMarkingUtil.isEOS(bos));
	assertEquals(false, TbMarkingUtil.isEOS(main));
	assertEquals(false, TbMarkingUtil.isEOS(left));
	assertEquals(false, TbMarkingUtil.isEOS(subToken));
    }

    @Test
    public void testIsBOS() {
	assertEquals(true, TbMarkingUtil.isBOS(bos));
	assertEquals(false, TbMarkingUtil.isBOS(eos));
	assertEquals(false, TbMarkingUtil.isBOS(main));
	assertEquals(false, TbMarkingUtil.isBOS(left));
	assertEquals(false, TbMarkingUtil.isBOS(subToken));
    }

    @Test
    public void testMark() {
	assertEquals(false, bos.isRelexingNeeded());
	TbMarkingUtil.mark(bos);
	assertEquals(false, bos.isRelexingNeeded());

	assertEquals(false, eos.isRelexingNeeded());
	TbMarkingUtil.mark(eos);
	assertEquals(false, eos.isRelexingNeeded());

	assertEquals(false, lexed2.isRelexingNeeded());
	TbMarkingUtil.mark(lexed2);
	assertEquals(true, lexed2.isRelexingNeeded());

	assertEquals(false, lexed3.isRelexingNeeded());
	TbMarkingUtil.mark(lexed3);
	assertEquals(true, lexed3.isRelexingNeeded());

	assertEquals(false, subToken.isRelexingNeeded());
	TbMarkingUtil.mark(subToken);
	assertEquals(true, subToken.isRelexingNeeded());
    }

    @Test
    public void testMarked() {
	// bos
	assertEquals(false, bos.isRelexingNeeded());
	assertEquals(false, TbMarkingUtil.marked(bos));

	bos.setRelexingNeeded(true);

	assertEquals(true, TbMarkingUtil.marked(bos));

	// lexed2
	assertEquals(false, lexed2.isRelexingNeeded());
	assertEquals(false, TbMarkingUtil.marked(lexed2));

	lexed2.setRelexingNeeded(true);

	assertEquals(true, TbMarkingUtil.marked(lexed2));
    }

    /**
     * * TODO: write test when clear what function does
     * 
     * @throws Exception
     */
    @Test
    public void testDeltaInChars() {

    }
}
