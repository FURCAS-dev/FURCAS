package com.sap.river.expressionpad.tests;

import junit.framework.TestSuite;

import com.sap.ap.metamodel.test.MetamodelTests;
import com.sap.river.interpreter.test.ProxyForTransformationTests;
import com.sap.river.interpreter.test.RucolaTests;
import com.sap.river.interpreter.test.TestBasicExpressions;

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
