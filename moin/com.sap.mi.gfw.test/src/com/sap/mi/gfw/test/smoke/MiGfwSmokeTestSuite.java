package com.sap.mi.gfw.test.smoke;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.test.service.DisposingTestSuite;

public class MiGfwSmokeTestSuite {

	public static Test suite() {
		TestSuite suite = new DisposingTestSuite(MiGfwSmokeTestSuite.class.getName());

		suite.addTestSuite(SmokeTest.class);
		return suite;
	}

}
