package com.sap.runlet.expressionpad.tests;

import junit.framework.TestSuite;

import com.sap.ap.metamodel.test.MetamodelTests;
import com.sap.runlet.interpreter.test.ProxyForTransformationTests;
import com.sap.runlet.interpreter.test.RucolaTests;
import com.sap.runlet.interpreter.test.TestBasicExpressions;

public class SuiteForTestProxies extends TestSuite {
    public static TestSuite suite() {
	TestSuite result = new SuiteForTestProxies();
	result.addTestSuite(TestBasicExpressions.class);
	result.addTestSuite(MetamodelTests.class);
	result.addTestSuite(RucolaTests.class);
	result.addTest(new ProxyForTransformationTests());
	return result;
    }
}
