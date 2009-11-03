package com.sap.mi.gfw.test.smoke;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.ide.junit.utils.PDEUtil;

/**
 * Test suite collecting all Graphics framework tests that should be executed centrally.
 * 
 * @author d031150
 */
public class GfwSmokeTests extends ActiveSWTTestSuite {

	public static Test suite() {
		TestSuite suite = new GfwSmokeTests();

		suite.addTest(MiGfwSmokeTestSuite.suite());

		return suite;
	}

	public GfwSmokeTests() {
		super(GfwSmokeTests.class.getName());
	}

	@Override
	protected void suiteSetUp() throws Exception {
		super.suiteSetUp();

		PDEUtil.prepareWorkbench();
	}

}
