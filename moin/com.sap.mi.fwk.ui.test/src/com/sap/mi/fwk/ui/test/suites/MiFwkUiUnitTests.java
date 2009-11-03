package com.sap.mi.fwk.ui.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.ui.test.tree.TreeNodeDecoratorTest;
import com.sap.mi.fwk.ui.test.unit.databinding.BindingScopedMultiValidatorTest;
import com.sap.mi.fwk.ui.test.unit.databinding.RefObjectObservableListTest;
import com.sap.mi.fwk.ui.test.unit.databinding.RefObjectObservableSetTest;
import com.sap.mi.fwk.ui.test.unit.databinding.RefObjectObservableValueTest;
import com.sap.mi.fwk.ui.test.unit.databinding.RefObjectOservableMapTest;
import com.sap.mi.fwk.ui.test.unit.databinding.TracingSupportTest;
import com.sap.mi.fwk.ui.test.unit.tree.nodes.TreeNodeTest;

/**
 * Test suite containing unit tests for plugin com.sap.mi.fwk.ui
 * 
 * @author d022960
 * 
 */
public class MiFwkUiUnitTests extends TestSuite {
	public static Test suite() {
		TestSuite suite = new MiFwkUiUnitTests();

		suite.addTestSuite(TreeNodeTest.class);
		suite.addTestSuite(TreeNodeDecoratorTest.class);
		suite.addTestSuite(RefObjectObservableValueTest.class);
		suite.addTestSuite(RefObjectObservableListTest.class);
		suite.addTestSuite(RefObjectObservableSetTest.class);
		suite.addTestSuite(RefObjectOservableMapTest.class);
		suite.addTestSuite(TracingSupportTest.class);
		suite.addTestSuite(BindingScopedMultiValidatorTest.class);
		return suite;
	}
}
