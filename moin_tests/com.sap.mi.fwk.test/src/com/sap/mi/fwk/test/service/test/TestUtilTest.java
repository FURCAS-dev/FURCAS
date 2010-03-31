package com.sap.mi.fwk.test.service.test;

import junit.framework.TestCase;

import com.sap.mi.fwk.test.service.TestUtil;

/**
 * Unit tests for class {@link TestUtil}
 * 
 * @author d022960
 * 
 */
public class TestUtilTest extends TestCase {
	private static final String EXPECTED = "0 [TreeNode class] com.sap.demo.mi.library.editor.tree.librarynavigator.NodeLibraryNavigatorRootNode [Value class] org.eclipse.core.internal.resources.Project [Image +] [Text] Libraries\n1  [TreeNodeRefObject class] com.sap.demo.mi.library.editor.tree.librarynavigator.men.NodeLibrary [Value class] com.sap.demo.mi.library.Library [Image +] [Text] Public Library Exeter";
	private static final String ACTUAL = "0 [TreeNode class] com.sap.demo.mi.library.editor.tree.librarynavigator.NodeLibraryNavigatorRootNode [Value class] org.eclipse.core.internal.resources.Project [Image +] [Text] Libraries\n1  [TreeNodeRefObject class] com.sap.demo.mi.library.editor.tree.librarynavigator.men.NodeLibrary [Value class] com.sap.demo.mi.library.Library [Image -] [Text] Public Library Exeter";
	private static final String ERROR_MSG = "Causes an IllegalStateException  <... difference at <pos> (line: 2, column: 152 ), expected  [Value class] com.sap.demo.mi.library.Library [Image  <pos> +] [Text] Public Library Exeter ...>, but was <...  [Value class] com.sap.demo.mi.library.Library [Image  <pos> -] [Text] Public Library Exeter ...>";

	/**
	 * Tests functional correctness including regression avoidance of method
	 * {@link TestUtil#assertEqualsLongString(String, String, String)}
	 */
	public void testAssertEqualsLongString() {
		try {
			TestUtil.assertEqualsLongString("Causes an IllegalStateException ", EXPECTED, ACTUAL);
		} catch (IllegalStateException e) {
			assertTrue(
					"The method 'assertEqualsLongString' did not return the correct detail information for the string comparison failure.",
					e.getMessage().equals(ERROR_MSG));
			return;
		} catch (Exception e) {
			throw new IllegalStateException("The method 'assertEqualsLongString' threw wrong exception class "
					+ e.getClass().getName());
		}
		throw new IllegalStateException("The method 'assertEqualsLongString' did not cause an IllegalStateException");
	}
}
