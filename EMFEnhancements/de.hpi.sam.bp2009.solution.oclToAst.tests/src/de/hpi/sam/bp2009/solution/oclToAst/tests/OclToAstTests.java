/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
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
	        //$JUnit-BEGIN$
		suite.addTestSuite(EAnnotationOCLParserTest.class);
		suite.addTestSuite(TestEcoreHelper.class);
	        //$JUnit-END$
		return suite;
	}

	public OclToAstTests(String name) {
		super(name);
	}

} //OclToAstTests
