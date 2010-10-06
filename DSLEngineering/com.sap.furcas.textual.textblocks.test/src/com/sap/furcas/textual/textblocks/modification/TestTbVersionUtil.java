/**
 * 
 */
package com.sap.furcas.textual.textblocks.modification;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.Version;
import com.sap.furcas.textual.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.textual.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.textual.textblocks.testutils.FixtureProvidingTextBlockTest;

/**
 * 
 */
public class TestTbVersionUtil extends FixtureProvidingTextBlockTest {

    @Test
    public void testSetVersion() {
	// main
	assertEquals(Version.REFERENCE, main.getVersion());
	TbVersionUtil.setVersion(main, Version.CURRENT);
	assertEquals(Version.CURRENT, main.getVersion());
	TbVersionUtil.setVersion(main, Version.PREVIOUS);
	assertEquals(Version.PREVIOUS, main.getVersion());

	// left
	assertEquals(Version.REFERENCE, left.getVersion());
	TbVersionUtil.setVersion(left, Version.CURRENT);
	assertEquals(Version.CURRENT, left.getVersion());

	// lexed3
	assertEquals(Version.REFERENCE, lexed3.getVersion());
	TbVersionUtil.setVersion(lexed3, Version.CURRENT);
	assertEquals(Version.CURRENT, lexed3.getVersion());
    }

    @Test
    public void testMarkAscending() {
	// should change
	assertEquals(false, main.isChildrenChanged());
	assertEquals(false, middle.isChildrenChanged());
	assertEquals(false, subBlock1.isChildrenChanged());
	assertEquals(false, subBlock2.isChildrenChanged());
	assertEquals(false, subBlock3.isChildrenChanged());

	// should not change
	assertEquals(false, subBlock4.isChildrenChanged());
	assertEquals(false, left.isChildrenChanged());
	assertEquals(false, leftLeft.isChildrenChanged());
	assertEquals(false, right.isChildrenChanged());

	TbChangeUtil.markAscending(subBlock3);

	// should change
	assertEquals(true, main.isChildrenChanged());
	assertEquals(true, middle.isChildrenChanged());
	assertEquals(true, subBlock1.isChildrenChanged());
	assertEquals(true, subBlock2.isChildrenChanged());
	assertEquals(true, subBlock3.isChildrenChanged());

	// should not change
	assertEquals(false, subBlock4.isChildrenChanged());
	assertEquals(false, left.isChildrenChanged());
	assertEquals(false, leftLeft.isChildrenChanged());
	assertEquals(false, right.isChildrenChanged());

	TbChangeUtil.markAscending(subBlock4);

	assertEquals(true, subBlock4.isChildrenChanged());
    }

    @Test
    public void testGetOtherVersion() {
	assertEquals(Version.REFERENCE, main.getVersion());
	assertEquals(0, main.getOtherVersions().size());

	// only REFERENCE version exists
	assertEquals(main, TbVersionUtil.getOtherVersion(main, Version.REFERENCE));
	assertEquals(null, TbVersionUtil.getOtherVersion(main, Version.PREVIOUS));
	assertEquals(null, TbVersionUtil.getOtherVersion(main, Version.CURRENT));

	TextBlock mainPrevious = modelFactory.createTextBlock();
	mainPrevious.setVersion(Version.PREVIOUS);

	main.getOtherVersions().add(mainPrevious);
	mainPrevious.getOtherVersions().add(main);

	assertEquals(1, main.getOtherVersions().size());
	assertEquals(1, mainPrevious.getOtherVersions().size());

	// only REFERENCE and PREVIOUS versions exists
	assertEquals(main, TbVersionUtil.getOtherVersion(main, Version.REFERENCE));
	assertEquals(mainPrevious, TbVersionUtil.getOtherVersion(main, Version.PREVIOUS));
	assertEquals(null, TbVersionUtil.getOtherVersion(main, Version.CURRENT));

	TextBlock mainCurrent = modelFactory.createTextBlock();
	mainCurrent.setVersion(Version.CURRENT);

	main.getOtherVersions().add(mainCurrent);
	mainCurrent.getOtherVersions().add(main);
	mainCurrent.getOtherVersions().add(mainPrevious);
	mainPrevious.getOtherVersions().add(mainCurrent);

	assertEquals(2, main.getOtherVersions().size());
	assertEquals(2, mainCurrent.getOtherVersions().size());
	assertEquals(2, mainPrevious.getOtherVersions().size());

	// all versions exist
	assertEquals(main, TbVersionUtil.getOtherVersion(main, Version.REFERENCE));
	assertEquals(mainPrevious, TbVersionUtil.getOtherVersion(main, Version.PREVIOUS));
	assertEquals(mainCurrent, TbVersionUtil.getOtherVersion(main, Version.CURRENT));
    }

    /**
     * TODO: write test when clear if function should be based on
     * isChildrenChanged or on sub nodes size
     * 
     */
    @Test
    public void testHasChildChanges() {

    }
}
