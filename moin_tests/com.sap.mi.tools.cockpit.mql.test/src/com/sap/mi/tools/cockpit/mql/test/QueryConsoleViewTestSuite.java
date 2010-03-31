package com.sap.mi.tools.cockpit.mql.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.ide.junit.utils.PDEUtil;

/**
 * @author d003456
 * 
 */
public class QueryConsoleViewTestSuite {

	private static boolean autoBuild;

	public static Test suite() {

		final TestSuite suite = new ActiveSWTTestSuite(QueryConsoleViewTestSuite.class.getName()) {
			/*
			 * (non-Javadoc)
			 * 
			 * @see com.sap.ide.junit.extensions.ActiveSWTTestSuite#suiteSetUp()
			 */
			@Override
			protected void suiteSetUp() throws Exception {

				super.suiteSetUp();
				QueryConsoleViewTestSuite.autoBuild = PDEUtil.setAutoBuilding(false);
				PDEUtil.maximizeWorkbenchAndRequestFocus();
				PDEUtil.assertDisplayIsActiveWindow();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.sap.ide.junit.extensions.ActiveSWTTestSuite#suiteTearDown()
			 */
			@Override
			protected void suiteTearDown() throws Exception {

				super.suiteTearDown();
				PDEUtil.setAutoBuilding(QueryConsoleViewTestSuite.autoBuild);
			}

		};

		suite.addTest(QueryConsoleTestSuiteInner.suite());

		return suite;
	}
}
