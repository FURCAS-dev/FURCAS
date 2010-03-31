package com.sap.mi.fwk.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.mi.fwk.test.service.TestUtil;

/**
 * Test suite for MOIN in Eclipse fwk. Includes the smoke tests.
 * 
 * @author d031150
 */
public class MiFwkTestsCentral {

	public static Test suite() {
		TestSuite suite = new ActiveSWTTestSuite(MiFwkTestsCentral.class.getName()) {
			@Override
			protected void suiteSetUp() throws Exception {
				super.suiteSetUp();
				requestScreenShotFor(this);
			}

			@Override
			protected void suiteTearDown() throws Exception {
				try {
					TestUtil.disposeTests(this);
				} finally {
					super.suiteTearDown();
				}
			}
		};

		suite.addTest(MiFwkTests.suite());
		suite.addTest(MiFwkUnitTest.suite());
		return suite;
	}

}
