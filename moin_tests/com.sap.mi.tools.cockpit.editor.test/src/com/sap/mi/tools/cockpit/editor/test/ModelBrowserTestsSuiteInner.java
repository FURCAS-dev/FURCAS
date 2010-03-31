package com.sap.mi.tools.cockpit.editor.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.test.service.DisposingTestSuite;

/**
 * This nesting of suites is necessary, because the outermost suite must be a
 * {@link ActiveSWTTestSuite} and the inner suite must be a
 * {@link DisposingTestSuite}.
 * 
 * @author d003456
 * 
 */
public class ModelBrowserTestsSuiteInner {

	public static Test suite() {

		TestSuite suite = new DisposingTestSuite(
				ModelBrowserTestsSuiteInner.class.getName()) {
			/*
			 * (non-Javadoc)
			 * 
			 * @see com.sap.ide.junit.extensions.PDETestSuite#suiteSetUp()
			 */
			@Override
			protected void suiteSetUp() throws Exception {
				super.suiteSetUp();

			}
			/*
			 * (non-Javadoc)
			 * 
			 * @see com.sap.mi.fwk.test.service.DisposingTestSuite#suiteTearDown()
			 */
			@Override
			protected void suiteTearDown() throws Exception {
				super.suiteTearDown();
			}
		};
		suite.addTestSuite(ModelBrowserUITest.class);
		suite.addTestSuite(ModelBrowserUITest2.class);
		return suite;
	} 
}
