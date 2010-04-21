/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * A test suite for the '<em><b>OstToAst</b></em>' model.
 */
public class OstToAstAllTests extends TestSuite {

	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	public static Test suite() {
		TestSuite suite = new OstToAstAllTests("OstToAst Tests");
		suite.addTest(OclToAstTests.suite());
		return suite;
	}

	public OstToAstAllTests(String name) {
		super(name);
	}

} //OstToAstAllTests
