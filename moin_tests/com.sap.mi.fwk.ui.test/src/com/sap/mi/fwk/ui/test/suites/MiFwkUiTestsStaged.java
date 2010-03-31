package com.sap.mi.fwk.ui.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;

/**
 * Suite for UI-related tests which are not part of central test
 * 
 * @author d024127
 */
public class MiFwkUiTestsStaged {

	/**
	 * @return
	 */
	public static Test suite() {
		TestSuite suite = new ActiveSWTTestSuite() {
			@Override
			protected void suiteSetUp() throws Exception {
				super.suiteSetUp();
				requestScreenShotFor(this);
			}
		};

		return suite;
	}
}
