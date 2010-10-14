package com.sap.runlet.interpreter.test;

import junit.framework.TestSuite;

import com.sap.runlet.operationaltransformation.test.OperationalTransformationTests;

public class ProxyForTransformationTests extends TestSuite {
    public ProxyForTransformationTests() {
	addTestSuite(OperationalTransformationTests.class);
    }
    
    public static TestSuite suite() {
	TestSuite result = new ProxyForTransformationTests();
	return result;
    }
}
