package com.sap.mi.fwk.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.mi.fwk.test.service.TestUtil;

/**
 * Central smoke test suite for MOIN in Eclipse fwk. Wrapps the smoke test suite
 * into an {@link ActiveSWTTestSuite} to execute all contained test methods in a
 * non-UI thread (same behavior as in standard test suite, otherwise test
 * methods triggered in both test suites would have to distinguish).
 * 
 * @author d027044
 */
public class MiFwkSmokeTestsCentral {

	public static Test suite() {
		TestSuite suite = new ActiveSWTTestSuite(MiFwkSmokeTestsCentral.class.getName()) {
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
		suite.addTest(MiFwkSmokeTests.suite());
		return suite;
	}

}
