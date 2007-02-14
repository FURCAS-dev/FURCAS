/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ValidationTest.java,v 1.2 2007/02/14 14:46:16 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.uml2.uml.Classifier;


/**
 * Tests the validation of OCL expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ValidationTest extends AbstractTestSuite {

	public ValidationTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(ValidationTest.class,
			"Expression Validation Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that operation calls may only invoke query operations. 
	 */
	public void test_callNonQueryOperation_136778() {
		// newApple() is not a query operation
		OCLExpression<Classifier> expr = parseConstraintUnvalidated(
				"package ocltest context Apple " + //$NON-NLS-1$
				"inv: Apple.allInstances()->includes(self.newApple()) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		
		try {
			ocl.validate(expr);
			fail("Should not have successfully validated"); //$NON-NLS-1$
		} catch (SemanticException e) {
			// success
			System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	//
	// Fixture methods
	//
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		apple_newApple.setIsQuery(false);
	}
	
	@Override
	protected void tearDown() throws Exception {
		apple_newApple.setIsQuery(true);
		
		super.tearDown();
	}
}
