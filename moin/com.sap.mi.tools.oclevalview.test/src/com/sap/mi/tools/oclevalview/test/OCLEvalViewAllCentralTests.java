package com.sap.mi.tools.oclevalview.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.ide.junit.utils.PDEUtil;

/**
 * Test suite collecting all Graphics framework tests that should be executed centrally.
 * 
 * @author d024127
 */
public class OCLEvalViewAllCentralTests extends ActiveSWTTestSuite {

	public static Test suite() {
		TestSuite suite = new OCLEvalViewAllCentralTests();
		
		suite.addTest(OCLEvalViewTestSuite.suite());
		
		return suite;
	}
	
    public OCLEvalViewAllCentralTests() {
		super(OCLEvalViewAllCentralTests.class.getName());
	}

    @Override
	protected void suiteSetUp() throws Exception {
        super.suiteSetUp();
        
        PDEUtil.prepareWorkbench();
    }

}
