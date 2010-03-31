package com.sap.mi.tools.cockpit.editor.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.test.service.DisposingTestSuite;

/**
 * @author d003456
 * 
 */
public class ModelBrowserTestsSuiteStandalone {

	private static boolean autoBuild;
	/**
	 * Do not add this suite to other suites! Use it to run this test locally.
	 * 
	 * @return an {@link ActiveSWTTestSuite} containing a
	 *         {@link DisposingTestSuite}
	 */
	public static Test suite() {
		
		TestSuite suite = new ActiveSWTTestSuite(
				ModelBrowserTestsSuiteStandalone.class.getName()) {
			/*
			 * (non-Javadoc)
			 * 
			 * @see com.sap.ide.junit.extensions.ActiveSWTTestSuite#suiteSetUp()
			 */
			@Override
			protected void suiteSetUp() throws Exception {
				super.suiteSetUp();
				autoBuild = PDEUtil.setAutoBuilding(false);
				PDEUtil.maximizeWorkbenchAndRequestFocus();
				PDEUtil.assertDisplayIsActiveWindow();
			}

			/* (non-Javadoc)
			 * @see com.sap.ide.junit.extensions.ActiveSWTTestSuite#suiteTearDown()
			 */
			@Override
			protected void suiteTearDown() throws Exception {
				super.suiteTearDown();
				PDEUtil.setAutoBuilding(autoBuild);
			}
			
		
		};
		
		suite.addTest(ModelBrowserTestsSuiteInner.suite());

		return suite;
	}
}
