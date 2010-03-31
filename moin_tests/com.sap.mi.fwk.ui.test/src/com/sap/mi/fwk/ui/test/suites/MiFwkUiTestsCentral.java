package com.sap.mi.fwk.ui.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;

/**
 * Test suite collecting all MiE BI UI tests that should be executed centrally.
 * 
 * @author d031150
 */
public final class MiFwkUiTestsCentral {

	public static Test suite() {
		TestSuite suite = new ActiveSWTTestSuite() {
			@Override
			protected void suiteSetUp() throws Exception {
				super.suiteSetUp();
				requestScreenShotFor(this);
			}
		};

		suite.addTest(MiFwkUiTests.suite());
		
		return suite;
	}
    
}
