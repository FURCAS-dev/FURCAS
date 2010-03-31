package com.sap.mi.tools.diagnostics.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;

/**
 * Test suite collecting all Graphics framework tests that should be executed centrally.
 * 
 * @author d031150
 */
public class DiagnosticsAllCentralTests extends ActiveSWTTestSuite {

	public static Test suite() {
		TestSuite suite = new DiagnosticsAllCentralTests();
		
		suite.addTest(DiagnosticsTestSuite.suite());
		
		return suite;
	}
	
    public DiagnosticsAllCentralTests() {
		super(DiagnosticsAllCentralTests.class.getName());
	}

    @Override
	protected void suiteSetUp() throws Exception {
        super.suiteSetUp();
    }

}
