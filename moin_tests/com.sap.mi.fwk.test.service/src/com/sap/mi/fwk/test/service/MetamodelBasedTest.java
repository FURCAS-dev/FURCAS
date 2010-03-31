package com.sap.mi.fwk.test.service;

import junit.framework.TestCase;

import com.sap.ide.junit.extensions.ExtendedTestCase;

/**
 * Test that needs one or more metamodels for its test data. Can be used for
 * automatically checking whether the metamodel is available prior to the test
 * run.
 * 
 * @author d031150
 */
public abstract class MetamodelBasedTest extends ExtendedTestCase {

	/**
	 * Indicates no metamodels to be imported for the test
	 * 
	 * @see #getMetamodels()
	 */
	protected static final String[] NO_METAMODELS = new String[0];

	/**
	 * @see TestCase#TestCase()
	 */
	public MetamodelBasedTest() {
		super();
	}

	/**
	 * @see TestCase#TestCase(String)
	 */
	public MetamodelBasedTest(String name) {
		super(name);
	}

	/**
	 * @return the containerNames of the metamodels that this test needs
	 */
	protected abstract String[] getMetamodels();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		assertMetamodelsImported();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Checks whether the given
	 */
	protected void assertMetamodelsImported() {
		String[] metamodels = getMetamodels();
		if (metamodels == null || metamodels.length == 0)
			return;

		TestUtil.assertMetamodelsImported(metamodels);
	}

}
