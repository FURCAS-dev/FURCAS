package com.sap.mi.tools.metamodelbuilder.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.test.service.DisposingTestSuite;

public class MetamodelbuilderTestSuite {

	public static Test suite() {
		TestSuite suite = new DisposingTestSuite(MetamodelbuilderTestSuite.class.getName());
		suite.addTestSuite(MetamodelBuilderTest.class);
		suite.addTestSuite(JaproParserTest.class);
		return suite;
	}
}
