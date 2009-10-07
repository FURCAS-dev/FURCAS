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
 * $Id: AbstractTestSuite.java,v 1.3 2009/10/07 20:38:54 ewillink Exp $
 */

package org.eclipse.ocl.ecore.helper.tests;


/**
 * Tests for the OCL engine plug-in.
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractTestSuite
	extends org.eclipse.ocl.ecore.tests.AbstractTestSuite {

	public static CheckedTestSuite suite() {
		CheckedTestSuite result = new CheckedTestSuite("OCL Helper Tests"); //$NON-NLS-1$
		
		result.createTestSuite(OCLHelperTest.class, "Basic Tests"); //$NON-NLS-1$
		result.createTestSuite(ParsingTest.class, "Constraint Parsing Tests"); //$NON-NLS-1$
		result.createTestSuite(SyntaxHelpTest.class, "Syntax Help Tests"); //$NON-NLS-1$
		result.createTestSuite(EvaluationTest.class, "Constraint Evaluation Tests"); //$NON-NLS-1$
		result.createTestSuite(RegressionTest.class, "Regression Tests"); //$NON-NLS-1$
		
		return result;
	}
}
