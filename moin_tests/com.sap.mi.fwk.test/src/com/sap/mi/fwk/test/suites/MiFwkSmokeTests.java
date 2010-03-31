package com.sap.mi.fwk.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.test.MoinProjectTest;
import com.sap.mi.fwk.test.service.DisposingTestSuite;

/**
 * Test suite for smoke tests for MOIN in Eclipse fwk
 * 
 * @author d031150
 */
public class MiFwkSmokeTests {

	public static Test suite() {
		TestSuite suite = new DisposingTestSuite(MiFwkSmokeTests.class.getName());

		return addToSuite(suite);
	}

	/**
	 * Adds all tests to the given suite
	 * 
	 * @return the given suite for convenience
	 */
	static TestSuite addToSuite(TestSuite suite) {
		suite.addTestSuite(MoinProjectTest.class);
		return suite;
	}

}
