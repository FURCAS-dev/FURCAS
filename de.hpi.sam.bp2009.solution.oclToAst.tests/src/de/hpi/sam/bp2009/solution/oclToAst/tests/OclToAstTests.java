package de.hpi.sam.bp2009.solution.oclToAst.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * A test suite for the '<em><b>oclToAst</b></em>' package.
 */
public class OclToAstTests extends TestSuite {

	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	public static Test suite() {
		TestSuite suite = new OclToAstTests("oclToAst Tests");
		suite.addTestSuite(EAnnotationOCLParserTest.class);
		suite.addTestSuite(TestEcoreHelper.class);
		return suite;
	}

	public OclToAstTests(String name) {
		super(name);
	}

} //OclToAstTests
