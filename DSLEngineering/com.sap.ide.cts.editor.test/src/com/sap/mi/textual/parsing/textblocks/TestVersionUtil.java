/**
 * 
 */
package com.sap.mi.textual.parsing.textblocks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import textblocks.TextBlock;
import textblocks.VersionEnum;

/**
 * 
 */
public class TestVersionUtil extends UtilFixtureBase {

	@Test
	public void testSetVersion() {
		// main
		assertEquals(VersionEnum.REFERENCE, main.getVersion());
		TbVersionUtil.setVersion(main, VersionEnum.CURRENT);
		assertEquals(VersionEnum.CURRENT, main.getVersion());
		TbVersionUtil.setVersion(main, VersionEnum.PREVIOUS);
		assertEquals(VersionEnum.PREVIOUS, main.getVersion());

		// left
		assertEquals(VersionEnum.REFERENCE, left.getVersion());
		TbVersionUtil.setVersion(left, VersionEnum.CURRENT);
		assertEquals(VersionEnum.CURRENT, left.getVersion());

		// lexed3
		assertEquals(VersionEnum.REFERENCE, lexed3.getVersion());
		TbVersionUtil.setVersion(lexed3, VersionEnum.CURRENT);
		assertEquals(VersionEnum.CURRENT, lexed3.getVersion());
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
		assertEquals(VersionEnum.REFERENCE, main.getVersion());
		assertEquals(0, main.getOtherVersions().size());

		// only REFERENCE version exists
		assertEquals(main, TbVersionUtil.getOtherVersion(main,
				VersionEnum.REFERENCE));
		assertEquals(null, TbVersionUtil.getOtherVersion(main,
				VersionEnum.PREVIOUS));
		assertEquals(null, TbVersionUtil.getOtherVersion(main,
				VersionEnum.CURRENT));

		TextBlock mainPrevious = modelFactory.createTextBlock();
		mainPrevious.setVersion(VersionEnum.PREVIOUS);

		main.getOtherVersions().add(mainPrevious);
		mainPrevious.getOtherVersions().add(main);

		assertEquals(1, main.getOtherVersions().size());
		assertEquals(1, mainPrevious.getOtherVersions().size());

		// only REFERENCE and PREVIOUS versions exists
		assertEquals(main, TbVersionUtil.getOtherVersion(main,
				VersionEnum.REFERENCE));
		assertEquals(mainPrevious, TbVersionUtil.getOtherVersion(main,
				VersionEnum.PREVIOUS));
		assertEquals(null, TbVersionUtil.getOtherVersion(main,
				VersionEnum.CURRENT));

		TextBlock mainCurrent = modelFactory.createTextBlock();
		mainCurrent.setVersion(VersionEnum.CURRENT);

		main.getOtherVersions().add(mainCurrent);
		mainCurrent.getOtherVersions().add(main);
		mainCurrent.getOtherVersions().add(mainPrevious);
		mainPrevious.getOtherVersions().add(mainCurrent);

		assertEquals(2, main.getOtherVersions().size());
		assertEquals(2, mainCurrent.getOtherVersions().size());
		assertEquals(2, mainPrevious.getOtherVersions().size());

		// all versions exist
		assertEquals(main, TbVersionUtil.getOtherVersion(main,
				VersionEnum.REFERENCE));
		assertEquals(mainPrevious, TbVersionUtil.getOtherVersion(main,
				VersionEnum.PREVIOUS));
		assertEquals(mainCurrent, TbVersionUtil.getOtherVersion(main,
				VersionEnum.CURRENT));
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
