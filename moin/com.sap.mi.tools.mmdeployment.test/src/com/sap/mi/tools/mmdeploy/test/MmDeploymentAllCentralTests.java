package com.sap.mi.tools.mmdeploy.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.ide.junit.utils.PDEUtil;

/**
 * Test suite collecting all Graphics framework tests that should be executed centrally.
 * 
 * @author d031150
 */
public class MmDeploymentAllCentralTests extends ActiveSWTTestSuite {

	public static Test suite() {
		TestSuite suite = new MmDeploymentAllCentralTests();
		
		suite.addTest(MmDeploymentTestSuite.suite());
		
		return suite;
	}
	
    public MmDeploymentAllCentralTests() {
		super(MmDeploymentAllCentralTests.class.getName());
	}

    @Override
	protected void suiteSetUp() throws Exception {
        super.suiteSetUp();
       	PDEUtil.prepareWorkbench();
    }

}
