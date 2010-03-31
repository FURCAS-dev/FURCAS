package com.sap.mi.tools.cockpit.mql.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.mi.fwk.test.service.DisposingTestSuite;
import com.sap.mi.tools.cockpit.mql.internal.QueryConsoleViewUITest;

/**
 * This nesting of suites is necessary, because the outermost suite must be a {@link ActiveSWTTestSuite} and the inner suite must be a
 * {@link DisposingTestSuite}.
 * 
 * @author d003456
 * 
 */
public class QueryConsoleTestSuiteInner {

	public static Test suite() {

		final TestSuite suite = new DisposingTestSuite(QueryConsoleTestSuiteInner.class.getName()) {
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
		suite.addTestSuite(QueryConsoleViewUITest.class);
		return suite;
	}
}
