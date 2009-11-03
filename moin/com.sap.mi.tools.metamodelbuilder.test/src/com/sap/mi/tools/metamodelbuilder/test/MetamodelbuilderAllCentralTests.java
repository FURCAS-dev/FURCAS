package com.sap.mi.tools.metamodelbuilder.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.ide.junit.utils.PDEUtil;

/**
 * Test suite collecting all Graphics framework tests that should be executed centrally.
 * 
 * @author d031150
 */
public class MetamodelbuilderAllCentralTests extends ActiveSWTTestSuite {

	public static Test suite() {
		TestSuite suite = new MetamodelbuilderAllCentralTests();
		
		suite.addTest(MetamodelbuilderTestSuite.suite());
		
		return suite;
	}
	
    public MetamodelbuilderAllCentralTests() {
		super(MetamodelbuilderAllCentralTests.class.getName());
	}

    @Override
	protected void suiteSetUp() throws Exception {
        super.suiteSetUp();
       	PDEUtil.prepareWorkbench();
    }

}
