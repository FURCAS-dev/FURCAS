/**
 * 
 */
package com.sap.mi.textual.parsing.textblocks;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecore.EEnum;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.parsergenerator.textblocks.model.ShortPrettyPrinter;

/**
 * 
 */
public class TestChangeUtil extends UtilFixtureBase {

	@Test
	public void testCleanUp() {
		TextBlock mainCurrent = modelFactory.createTextBlock();
		mainCurrent.setVersion(EEnum.CURRENT);
		mainCurrent.getOtherVersions().add(main);
		main.getOtherVersions().add(mainCurrent);
		TextBlock middleCurrent = modelFactory.createTextBlock();
		middleCurrent.setVersion(EEnum.CURRENT);
		Bostoken bosCurrent = modelFactory.createBostoken();
		bosCurrent.setVersion(EEnum.CURRENT);
		Eostoken eosCurrent = modelFactory.createEostoken();
		eosCurrent.setVersion(EEnum.CURRENT);
		LexedToken lexedPrevious = modelFactory.createLexedToken();
		lexedPrevious.setVersion(EEnum.CURRENT);

		mainCurrent.getSubBlocks().add(middleCurrent);
		middleCurrent.getTokens().add(bosCurrent);
		middleCurrent.getTokens().add(lexedPrevious);
		middleCurrent.getTokens().add(eosCurrent);

		assertEquals(mainCurrent, TbChangeUtil.cleanUp(main));
		assertEquals(EEnum.REFERENCE, mainCurrent.getVersion());
		assertEquals(0, mainCurrent.getOtherVersions().size());

		assertEquals(EEnum.REFERENCE, middleCurrent.getVersion());
		assertEquals(EEnum.REFERENCE, bosCurrent.getVersion());
		assertEquals(EEnum.REFERENCE, lexedPrevious.getVersion());
		assertEquals(EEnum.REFERENCE, eosCurrent.getVersion());
	}

	@Test
	public void testMakeReferenceVersion() {
		main.setVersion(EEnum.CURRENT);
		left.setVersion(EEnum.PREVIOUS);
		leftLeft.setVersion(EEnum.CURRENT);
		lexed1.setVersion(EEnum.PREVIOUS);
		middle.setVersion(EEnum.CURRENT);
		eos.setVersion(EEnum.PREVIOUS);

		main.setRelexingNeeded(true);
		left.setRelexingNeeded(true);
		leftLeft.setRelexingNeeded(true);
		lexed1.setRelexingNeeded(true);
		middle.setRelexingNeeded(true);
		eos.setRelexingNeeded(true);

		TbChangeUtil.makeReferenceVersion(main);

		assertEquals(EEnum.REFERENCE, main.getVersion());
		assertEquals(EEnum.REFERENCE, left.getVersion());
		assertEquals(EEnum.REFERENCE, leftLeft.getVersion());
		assertEquals(EEnum.REFERENCE, lexed1.getVersion());
		assertEquals(EEnum.REFERENCE, middle.getVersion());
		assertEquals(EEnum.REFERENCE, eos.getVersion());

		main.setRelexingNeeded(false);
		left.setRelexingNeeded(false);
		leftLeft.setRelexingNeeded(false);
		lexed1.setRelexingNeeded(false);
		middle.setRelexingNeeded(false);
		eos.setRelexingNeeded(false);
	}

	@Test
	public void testMakeVersion() {
		main.setVersion(EEnum.CURRENT);
		left.setVersion(EEnum.PREVIOUS);
		leftLeft.setVersion(EEnum.CURRENT);
		lexed1.setVersion(EEnum.PREVIOUS);
		middle.setVersion(EEnum.CURRENT);
		eos.setVersion(EEnum.PREVIOUS);

		TbChangeUtil.makeVersion(main, EEnum.REFERENCE);

		assertEquals(EEnum.REFERENCE, main.getVersion());
		assertEquals(EEnum.REFERENCE, left.getVersion());
		assertEquals(EEnum.REFERENCE, leftLeft.getVersion());
		assertEquals(EEnum.REFERENCE, lexed1.getVersion());
		assertEquals(EEnum.REFERENCE, middle.getVersion());
		assertEquals(EEnum.REFERENCE, eos.getVersion());

		TbChangeUtil.makeVersion(main, EEnum.CURRENT);

		assertEquals(EEnum.CURRENT, main.getVersion());
		assertEquals(EEnum.CURRENT, left.getVersion());
		assertEquals(EEnum.CURRENT, leftLeft.getVersion());
		assertEquals(EEnum.CURRENT, lexed1.getVersion());
		assertEquals(EEnum.CURRENT, middle.getVersion());
		assertEquals(EEnum.CURRENT, eos.getVersion());
	}

	@Test
	public void updateOffsets() {

		// should change
		assertEquals(15, right.getOffset());
		assertEquals(20, eos.getOffset());

		// should not change
		assertEquals(0, subToken.getOffset());
		assertEquals(0, subBlock4.getOffset());
		assertEquals(0, subBlock3.getOffset());
		assertEquals(0, subBlock2.getOffset());
		assertEquals(8, subBlock1.getOffset());
		assertEquals(6, middle.getOffset());
		assertEquals(0, main.getOffset());
		assertEquals(0, lexed4.getOffset());
		assertEquals(0, bos.getOffset());
		assertEquals(0, lexed1.getOffset());
		assertEquals(5, lexed2.getOffset());
		assertEquals(0, lexed3.getOffset());
		assertEquals(0, left.getOffset());

		TbChangeUtil.updateOffsets(subToken, 25);

		// should change
		assertEquals(40, right.getOffset());
		assertEquals(45, eos.getOffset());

		// should not change
		assertEquals(0, subToken.getOffset());
		assertEquals(0, subBlock4.getOffset());
		assertEquals(0, subBlock3.getOffset());
		assertEquals(0, subBlock2.getOffset());
		assertEquals(8, subBlock1.getOffset());
		assertEquals(6, middle.getOffset());
		assertEquals(0, main.getOffset());
		assertEquals(0, lexed4.getOffset());
		assertEquals(0, bos.getOffset());
		assertEquals(0, lexed1.getOffset());
		assertEquals(5, lexed2.getOffset());
		assertEquals(0, lexed3.getOffset());
		assertEquals(0, left.getOffset());

		TbChangeUtil.updateOffsets(subToken, -3);

		// should change
		assertEquals(37, right.getOffset());
		assertEquals(42, eos.getOffset());

		// should not change
		assertEquals(0, subToken.getOffset());
		assertEquals(0, subBlock4.getOffset());
		assertEquals(0, subBlock3.getOffset());
		assertEquals(0, subBlock2.getOffset());
		assertEquals(8, subBlock1.getOffset());
		assertEquals(6, middle.getOffset());
		assertEquals(0, main.getOffset());
		assertEquals(0, lexed4.getOffset());
		assertEquals(0, bos.getOffset());
		assertEquals(0, lexed1.getOffset());
		assertEquals(5, lexed2.getOffset());
		assertEquals(0, lexed3.getOffset());
		assertEquals(0, left.getOffset());
	}

	@Test(expected = NullPointerException.class)
	public void testUpdateOffsetsNull() {
		TbChangeUtil.updateOffsets(null, 1);
	}

	@Test
	public void updateLengthAscending() {

		// should change
		assertEquals(1, subToken.getLength());
		assertEquals(1, subBlock4.getLength());
		assertEquals(1, subBlock3.getLength());
		assertEquals(1, subBlock2.getLength());
		assertEquals(1, subBlock1.getLength());
		assertEquals(9, middle.getLength());
		assertEquals(20, main.getLength());

		// should not change
		assertEquals(5, lexed1.getLength());
		assertEquals(1, lexed2.getLength());
		assertEquals(8, lexed3.getLength());
		assertEquals(0, bos.getLength());
		assertEquals(0, eos.getLength());

		TbChangeUtil.updateLengthAscending(subToken, 19);

		// should change
		assertEquals(20, subToken.getLength());
		assertEquals(20, subBlock4.getLength());
		assertEquals(20, subBlock3.getLength());
		assertEquals(20, subBlock2.getLength());
		assertEquals(20, subBlock1.getLength());
		assertEquals(28, middle.getLength());
		assertEquals(39, main.getLength());

		// should not change
		assertEquals(5, lexed1.getLength());
		assertEquals(1, lexed2.getLength());
		assertEquals(8, lexed3.getLength());
		assertEquals(0, bos.getLength());
		assertEquals(0, eos.getLength());

		TbChangeUtil.updateLengthAscending(subToken, -10);

		// should change
		assertEquals(10, subToken.getLength());
		assertEquals(10, subBlock4.getLength());
		assertEquals(10, subBlock3.getLength());
		assertEquals(10, subBlock2.getLength());
		assertEquals(10, subBlock1.getLength());
		assertEquals(18, middle.getLength());
		assertEquals(29, main.getLength());

		// should not change
		assertEquals(5, lexed1.getLength());
		assertEquals(1, lexed2.getLength());
		assertEquals(8, lexed3.getLength());
		assertEquals(0, bos.getLength());
		assertEquals(0, eos.getLength());
	}

	@Ignore //code that throws this exception is currently commented out
	@Test(expected = IllegalArgumentException.class)
	public void updateLenghtAscendingInvalid() {
		assertEquals(1, subToken.getLength());

		TbChangeUtil.updateLengthAscending(subToken, -2);
	}

	@Test
	public void testreplaceTokenContentsAndUpdateParentsHasValue() {
		// should change
		assertEquals("bbbbcccc", lexed3.getValue());
		assertEquals(8, lexed3.getLength());
		assertEquals(9, middle.getLength());
		assertEquals(20, main.getLength());

		assertEquals(8, subBlock1.getOffset());
		assertEquals(15, right.getOffset());
		assertEquals(20, eos.getOffset());

		// should not change
		assertEquals(5, lexed4.getLength());
		assertEquals(5, right.getLength());
		assertEquals(5, left.getLength());
		assertEquals(1, subBlock1.getLength());

		assertEquals(6, middle.getOffset());
		assertEquals(0, main.getOffset());
		assertEquals(0, bos.getOffset());
		assertEquals(0, lexed1.getOffset());
		assertEquals(5, lexed2.getOffset());
		assertEquals(0, lexed3.getOffset());
		assertEquals(0, lexed4.getOffset());
		assertEquals(0, left.getOffset());

		TbChangeUtil.replaceTokenContentsAndUpdateParents(lexed3, "aaaadddd", 4, 4, new ShortPrettyPrinter(null));

		// should change
		assertEquals("bbbbaaaadddd", lexed3.getValue());
		assertEquals(12, lexed3.getLength());
		assertEquals(13, middle.getLength());
		assertEquals(24, main.getLength());

		assertEquals(12, subBlock1.getOffset());
		assertEquals(19, right.getOffset());
		assertEquals(24, eos.getOffset());

		// should not change
		assertEquals(5, lexed4.getLength());
		assertEquals(5, right.getLength());
		assertEquals(5, left.getLength());
		assertEquals(1, subBlock1.getLength());

		assertEquals(6, middle.getOffset());
		assertEquals(0, main.getOffset());
		assertEquals(0, bos.getOffset());
		assertEquals(0, lexed1.getOffset());
		assertEquals(5, lexed2.getOffset());
		assertEquals(0, lexed3.getOffset());
		assertEquals(0, lexed4.getOffset());
		assertEquals(0, left.getOffset());
	}

	@Test
	public void testreplaceTokenContentsAndUpdateParentsMakeEmpty() {
		// should change
		assertEquals("bbbbcccc", lexed3.getValue());
		assertEquals(8, lexed3.getLength());
		assertEquals(9, middle.getLength());
		assertEquals(20, main.getLength());

		assertEquals(8, subBlock1.getOffset());
		assertEquals(15, right.getOffset());
		assertEquals(20, eos.getOffset());

		// should not change
		assertEquals(5, lexed4.getLength());
		assertEquals(5, right.getLength());
		assertEquals(5, left.getLength());
		assertEquals(1, subBlock1.getLength());

		assertEquals(6, middle.getOffset());
		assertEquals(0, main.getOffset());
		assertEquals(0, bos.getOffset());
		assertEquals(0, lexed1.getOffset());
		assertEquals(5, lexed2.getOffset());
		assertEquals(0, lexed3.getOffset());
		assertEquals(0, lexed4.getOffset());
		assertEquals(0, left.getOffset());

		TbChangeUtil.replaceTokenContentsAndUpdateParents(lexed3, "", 0, 8, new ShortPrettyPrinter(null));

		// should change
		assertEquals("", lexed3.getValue());
		assertEquals(0, lexed3.getLength());
		assertEquals(1, middle.getLength());
		assertEquals(12, main.getLength());

		assertEquals(0, subBlock1.getOffset());
		assertEquals(7, right.getOffset());
		assertEquals(12, eos.getOffset());

		// should not change
		assertEquals(5, lexed4.getLength());
		assertEquals(5, right.getLength());
		assertEquals(5, left.getLength());
		assertEquals(1, subBlock1.getLength());

		assertEquals(6, middle.getOffset());
		assertEquals(0, main.getOffset());
		assertEquals(0, bos.getOffset());
		assertEquals(0, lexed1.getOffset());
		assertEquals(5, lexed2.getOffset());
		assertEquals(0, lexed3.getOffset());
		assertEquals(0, lexed4.getOffset());
		assertEquals(0, left.getOffset());

	}

	@Test
	public void testreplaceTokenContentsAndUpdateParentsNoValue() {
		LexedToken newToken = modelFactory.createLexedToken();
		newToken.setOffset(1);
		newToken.setOffsetRelative(true);
		subBlock4.getTokens().add(newToken);

		// should change
		assertEquals(null, newToken.getValue());
		assertEquals(0, newToken.getLength());
		assertEquals(1, subBlock4.getLength());
		assertEquals(1, subBlock3.getLength());
		assertEquals(1, subBlock2.getLength());
		assertEquals(1, subBlock1.getLength());
		assertEquals(9, middle.getLength());
		assertEquals(20, main.getLength());

		assertEquals(15, right.getOffset());
		assertEquals(20, eos.getOffset());

		// should not change
		assertEquals(5, lexed4.getLength());
		assertEquals(5, right.getLength());
		assertEquals(5, left.getLength());

		assertEquals(8, subBlock1.getOffset());
		assertEquals(0, subBlock2.getOffset());
		assertEquals(0, subBlock3.getOffset());
		assertEquals(0, subBlock4.getOffset());
		assertEquals(0, subToken.getOffset());
		assertEquals(6, middle.getOffset());
		assertEquals(0, main.getOffset());
		assertEquals(0, bos.getOffset());
		assertEquals(0, lexed1.getOffset());
		assertEquals(5, lexed2.getOffset());
		assertEquals(0, lexed3.getOffset());
		assertEquals(0, lexed4.getOffset());
		assertEquals(0, left.getOffset());

		TbChangeUtil.replaceTokenContentsAndUpdateParents(newToken, "abcde", 0, 0, new ShortPrettyPrinter(null));

		// should change
		assertEquals("abcde", newToken.getValue());
		assertEquals(5, newToken.getLength());
		assertEquals(6, subBlock4.getLength());
		assertEquals(6, subBlock3.getLength());
		assertEquals(6, subBlock2.getLength());
		assertEquals(6, subBlock1.getLength());
		assertEquals(14, middle.getLength());
		assertEquals(25, main.getLength());

		assertEquals(20, right.getOffset());
		assertEquals(25, eos.getOffset());

		// should not change
		assertEquals(5, lexed4.getLength());
		assertEquals(5, right.getLength());
		assertEquals(5, left.getLength());

		assertEquals(8, subBlock1.getOffset());
		assertEquals(0, subBlock2.getOffset());
		assertEquals(0, subBlock3.getOffset());
		assertEquals(0, subBlock4.getOffset());
		assertEquals(0, subToken.getOffset());
		assertEquals(6, middle.getOffset());
		assertEquals(0, main.getOffset());
		assertEquals(0, bos.getOffset());
		assertEquals(0, lexed1.getOffset());
		assertEquals(5, lexed2.getOffset());
		assertEquals(0, lexed3.getOffset());
		assertEquals(0, lexed4.getOffset());
		assertEquals(0, left.getOffset());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testreplaceTokenContentsAndUpdateParentsStartOffsetNegative() {
		TbChangeUtil.replaceTokenContentsAndUpdateParents(subToken, "abc", -1, 0, new ShortPrettyPrinter(null));
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void testreplaceTokenContentsAndUpdateParentsStartOffsetNegativeFirst() {
        TbChangeUtil.replaceTokenContentsAndUpdateParents(lexed1, "abc", -1, 0, new ShortPrettyPrinter(null));
    }

	@Test(expected = IllegalArgumentException.class)
	public void testreplaceTokenContentsAndUpdateParentsReplacedRegionLengthNegative() {
		TbChangeUtil.replaceTokenContentsAndUpdateParents(subToken, "abc", 0, -1, new ShortPrettyPrinter(null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testreplaceTokenContentsAndUpdateParentsHasValueButInvalidRegion() {
		subToken.setValue("c");

		TbChangeUtil.replaceTokenContentsAndUpdateParents(subToken, "abc", 1, 1, new ShortPrettyPrinter(null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testreplaceTokenContentsAndUpdateParentsNoValueButInvalidRegion() {
		TbChangeUtil.replaceTokenContentsAndUpdateParents(subToken, "abc", 1, 1, new ShortPrettyPrinter(null));
	}
}
