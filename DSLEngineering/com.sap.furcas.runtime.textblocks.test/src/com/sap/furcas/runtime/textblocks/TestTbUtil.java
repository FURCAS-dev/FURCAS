/**
 * 
 */
package com.sap.furcas.runtime.textblocks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.textblocks.testbase.FixtureProvidingTextBlockTest;

/**
 * 
 */
public class TestTbUtil extends FixtureProvidingTextBlockTest {

    @Test
    public void testIsAncestorTrue() throws Exception {
	TextBlock block1 = modelFactory.createTextBlock();
	TextBlock block2 = modelFactory.createTextBlock();
	TextBlock block3 = modelFactory.createTextBlock();
	block1.setParent(block2);
	block2.setParent(block3);

	assertTrue(TbUtil.isAncestorOf(block3, block1));
    }

    @Test
    public void testIsAncestorFalse() throws Exception {
	TextBlock block1 = modelFactory.createTextBlock();
	TextBlock block2 = modelFactory.createTextBlock();
	TextBlock block3 = modelFactory.createTextBlock();
	block1.setParent(block2);
	block3.setParent(block2);

	assertFalse(TbUtil.isAncestorOf(block3, block1));
    }

    @Test
    public void testIsAncestorNull() throws Exception {
	assertFalse(TbUtil.isAncestorOf(null, null));
    }

    /**
     * Only tests with all offsets relative.
     * 
     */
    @Test
    public void testGetAbsoluteOffset() {
	assertEquals(0, TbUtil.getAbsoluteOffset(main));
	assertEquals(0, TbUtil.getAbsoluteOffset(left));
	assertEquals(0, TbUtil.getAbsoluteOffset(leftLeft));
	assertEquals(0, TbUtil.getAbsoluteOffset(bos));
	assertEquals(0, TbUtil.getAbsoluteOffset(lexed1));
	assertEquals(5, TbUtil.getAbsoluteOffset(lexed2));
	assertEquals(6, TbUtil.getAbsoluteOffset(middle));
	assertEquals(6, TbUtil.getAbsoluteOffset(lexed3));
	assertEquals(14, TbUtil.getAbsoluteOffset(subBlock1));
	assertEquals(14, TbUtil.getAbsoluteOffset(subBlock2));
	assertEquals(14, TbUtil.getAbsoluteOffset(subBlock3));
	assertEquals(14, TbUtil.getAbsoluteOffset(subBlock4));
	assertEquals(14, TbUtil.getAbsoluteOffset(subToken));
	assertEquals(15, TbUtil.getAbsoluteOffset(right));
	assertEquals(15, TbUtil.getAbsoluteOffset(lexed4));
	assertEquals(20, TbUtil.getAbsoluteOffset(eos));
    }

    @Test
    public void testGetNewestVersion() {
	assertEquals(Version.REFERENCE, main.getVersion());
	assertEquals(0, main.getOtherVersions().size());

	// REFERENCE is newest Version
	assertEquals(main, TbUtil.getNewestVersion(main));

	TextBlock mainPrevious = modelFactory.createTextBlock();
	mainPrevious.setVersion(Version.PREVIOUS);

	main.getOtherVersions().add(mainPrevious);
	mainPrevious.getOtherVersions().add(main);

	assertEquals(1, main.getOtherVersions().size());
	assertEquals(1, mainPrevious.getOtherVersions().size());

	// PREVIOUS is newest Version
	assertEquals(mainPrevious, TbUtil.getNewestVersion(main));
	assertEquals(mainPrevious, TbUtil.getNewestVersion(mainPrevious));

	TextBlock mainCurrent = modelFactory.createTextBlock();
	mainCurrent.setVersion(Version.CURRENT);

	main.getOtherVersions().add(mainCurrent);
	mainCurrent.getOtherVersions().add(main);
	mainCurrent.getOtherVersions().add(mainPrevious);
	mainPrevious.getOtherVersions().add(mainCurrent);

	assertEquals(2, main.getOtherVersions().size());
	assertEquals(2, mainCurrent.getOtherVersions().size());
	assertEquals(2, mainPrevious.getOtherVersions().size());

	// CURRENT is newest Version
	assertEquals(mainCurrent, TbUtil.getNewestVersion(mainCurrent));
    }

    @Test
    public void testCreateNewCopyMain() {
	assertEquals(Version.REFERENCE, main.getVersion());
	assertEquals(0, main.getOtherVersions().size());

	DocumentNode mainCurrentNode = TbUtil.createNewCopy(main, Version.CURRENT, false, null);
	assertEquals(true, mainCurrentNode instanceof TextBlock);
	TextBlock mainCurrent = (TextBlock) mainCurrentNode;

	// check versions and version references of root block
	assertEquals(Version.REFERENCE, main.getVersion());
	assertEquals(Version.CURRENT, mainCurrent.getVersion());
	assertEquals(1, main.getOtherVersions().size());
	assertEquals(1, mainCurrent.getOtherVersions().size());
	assertEquals(true, main.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainCurrent.getOtherVersions().contains(main));

	// check that the old model has a new other version reference
	// with the correct version and equal attributes and corresponding
	// references (a parallel structure with a new version)

	assertNewCopyResult(main);
	assertNewCopyResult(left);
	assertNewCopyResult(leftLeft);
	assertNewCopyResult(bos);
	assertNewCopyResult(lexed1);
	assertNewCopyResult(lexed2);
	assertNewCopyResult(middle);
	assertNewCopyResult(lexed3);
	assertNewCopyResult(subBlock1);
	assertNewCopyResult(subBlock2);
	assertNewCopyResult(subBlock3);
	assertNewCopyResult(subBlock4);
	assertNewCopyResult(subToken);
	assertNewCopyResult(lexed4);
	assertNewCopyResult(right);
	assertNewCopyResult(eos);
    }

    /**
     * Checks the existence of other version CURRENT with equal attributes and
     * corresponding references.
     * 
     * @param copyBase
     *            the node that was copied
     */
    private void assertNewCopyResult(DocumentNode oldVersion) {

	assertEquals(Version.REFERENCE, oldVersion.getVersion());
	assertEquals(1, oldVersion.getOtherVersions().size());

	DocumentNode newVersion = oldVersion.getOtherVersions().get(0);
	assertEquals(Version.CURRENT, newVersion.getVersion());
	assertEquals(1, newVersion.getOtherVersions().size());
	assertEquals(true, newVersion.getOtherVersions().contains(oldVersion));

	assertEquals(newVersion.getOffset(), oldVersion.getOffset());
	assertEquals(newVersion.getLength(), oldVersion.getLength());
	assertEquals(newVersion.isOffsetRelative(), oldVersion.isOffsetRelative());

	if (oldVersion instanceof TextBlock) {
	    assertNewCopyResultBlock((TextBlock) oldVersion, (TextBlock) newVersion);
	} else {
	    assertNewCopyResultToken((AbstractToken) oldVersion, (AbstractToken) newVersion);
	}
    }

    private void assertNewCopyResultBlock(TextBlock oldVersion, TextBlock newVersion) {
	if (oldVersion.getParent() != null) {
	    assertEquals(newVersion.getParent(), oldVersion.getParent().getOtherVersions().get(0));
	} else {
	    assertEquals(null, newVersion.getParent());
	}

	assertEquals(oldVersion.getSubBlocks().size(), newVersion.getSubBlocks().size());
	for (TextBlock oldSubBlock : oldVersion.getSubBlocks()) {
	    assertEquals(true, newVersion.getSubBlocks().contains(oldSubBlock.getOtherVersions().get(0)));
	}

	assertEquals(oldVersion.getTokens().size(), newVersion.getTokens().size());
	for (AbstractToken oldToken : oldVersion.getTokens()) {
	    assertEquals(true, newVersion.getTokens().contains(oldToken.getOtherVersions().get(0)));
	}
    }

    private void assertNewCopyResultToken(AbstractToken oldVersion, AbstractToken newVersion) {
	assertEquals(newVersion.getParent(), oldVersion.getParent().getOtherVersions().get(0));
    }

    @Test
    public void testReferenceVersions() {
	assertEquals(Version.REFERENCE, main.getVersion());
	assertEquals(0, main.getOtherVersions().size());

	TextBlock mainPrevious = modelFactory.createTextBlock();
	mainPrevious.setVersion(Version.PREVIOUS);
	TextBlock mainCurrent = modelFactory.createTextBlock();
	mainCurrent.setVersion(Version.CURRENT);

	TbUtil.referenceVersions(main, mainPrevious);

	assertEquals(1, main.getOtherVersions().size());
	assertEquals(1, mainPrevious.getOtherVersions().size());
	assertEquals(true, main.getOtherVersions().contains(mainPrevious));
	assertEquals(true, mainPrevious.getOtherVersions().contains(main));

	TbUtil.referenceVersions(mainCurrent, mainPrevious);

	assertEquals(2, main.getOtherVersions().size());
	assertEquals(2, mainPrevious.getOtherVersions().size());
	assertEquals(2, mainCurrent.getOtherVersions().size());
	assertEquals(true, main.getOtherVersions().contains(mainPrevious));
	assertEquals(true, main.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainPrevious.getOtherVersions().contains(main));
	assertEquals(true, mainPrevious.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainCurrent.getOtherVersions().contains(main));
	assertEquals(true, mainCurrent.getOtherVersions().contains(mainPrevious));

	// should not add more, already existing
	TbUtil.referenceVersions(main, mainCurrent);
	TbUtil.referenceVersions(mainCurrent, main);

	assertEquals(2, main.getOtherVersions().size());
	assertEquals(2, mainPrevious.getOtherVersions().size());
	assertEquals(2, mainCurrent.getOtherVersions().size());
	assertEquals(true, main.getOtherVersions().contains(mainPrevious));
	assertEquals(true, main.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainPrevious.getOtherVersions().contains(main));
	assertEquals(true, mainPrevious.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainCurrent.getOtherVersions().contains(main));
	assertEquals(true, mainCurrent.getOtherVersions().contains(mainPrevious));

	// should not add more, not reflexive
	TbUtil.referenceVersions(main, main);

	assertEquals(2, main.getOtherVersions().size());
	assertEquals(2, mainPrevious.getOtherVersions().size());
	assertEquals(2, mainCurrent.getOtherVersions().size());
	assertEquals(true, main.getOtherVersions().contains(mainPrevious));
	assertEquals(true, main.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainPrevious.getOtherVersions().contains(main));
	assertEquals(true, mainPrevious.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainCurrent.getOtherVersions().contains(main));
	assertEquals(true, mainCurrent.getOtherVersions().contains(mainPrevious));
    }

    /**
     * Almost same test as testReferenceVersions, only with the parameters
     * swapped.
     * 
     */
    @Test
    public void testReferenceVersionsSwappedParameters() {

	TextBlock mainPrevious = modelFactory.createTextBlock();
	mainPrevious.setVersion(Version.PREVIOUS);
	TextBlock mainCurrent = modelFactory.createTextBlock();
	mainCurrent.setVersion(Version.CURRENT);

	TbUtil.referenceVersions(mainPrevious, main);

	assertEquals(1, main.getOtherVersions().size());
	assertEquals(1, mainPrevious.getOtherVersions().size());
	assertEquals(true, main.getOtherVersions().contains(mainPrevious));
	assertEquals(true, mainPrevious.getOtherVersions().contains(main));

	TbUtil.referenceVersions(mainPrevious, mainCurrent);

	assertEquals(2, main.getOtherVersions().size());
	assertEquals(2, mainPrevious.getOtherVersions().size());
	assertEquals(2, mainCurrent.getOtherVersions().size());
	assertEquals(true, main.getOtherVersions().contains(mainPrevious));
	assertEquals(true, main.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainPrevious.getOtherVersions().contains(main));
	assertEquals(true, mainPrevious.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainCurrent.getOtherVersions().contains(main));
	assertEquals(true, mainCurrent.getOtherVersions().contains(mainPrevious));

	// should not add more, already existing
	TbUtil.referenceVersions(mainCurrent, main);
	TbUtil.referenceVersions(main, mainCurrent);

	assertEquals(2, main.getOtherVersions().size());
	assertEquals(2, mainPrevious.getOtherVersions().size());
	assertEquals(2, mainCurrent.getOtherVersions().size());
	assertEquals(true, main.getOtherVersions().contains(mainPrevious));
	assertEquals(true, main.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainPrevious.getOtherVersions().contains(main));
	assertEquals(true, mainPrevious.getOtherVersions().contains(mainCurrent));
	assertEquals(true, mainCurrent.getOtherVersions().contains(main));
	assertEquals(true, mainCurrent.getOtherVersions().contains(mainPrevious));
    }

    @Test
    public void testGetRelativeOffsetFromToken() {
	// at start offset
	assertEquals(0, TbUtil.getRelativeOffsetFromNode(6, lexed3));

	// before start offset
	assertEquals(-2, TbUtil.getRelativeOffsetFromNode(4, lexed3));

	// after start offset
	assertEquals(2, TbUtil.getRelativeOffsetFromNode(8, lexed3));
    }

    @Test
    public void testFillNodeLevelMap() {
	Map<Integer, DocumentNode> nodeLevelMap = TbUtil.createNodeLevelMap(subToken, TbNavigationUtil.getLevel(subToken));

	assertEquals(main, nodeLevelMap.get(0));
	assertEquals(middle, nodeLevelMap.get(1));
	assertEquals(subBlock1, nodeLevelMap.get(2));
	assertEquals(subBlock2, nodeLevelMap.get(3));
	assertEquals(subBlock3, nodeLevelMap.get(4));
	assertEquals(subBlock4, nodeLevelMap.get(5));

    }
}
