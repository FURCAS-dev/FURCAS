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
 * $Id: AbstractTestSuite.java,v 1.2 2007/02/14 14:45:48 cdamus Exp $
 */

package org.eclipse.ocl.ecore.helper.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Tests for the OCL engine plug-in.
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractTestSuite
	extends org.eclipse.ocl.ecore.tests.AbstractTestSuite {

	/**
	 * Initializes me with my name.
	 * 
	 * @param name my name
	 */
	public AbstractTestSuite(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite result = new TestSuite("OCL Helper Tests"); //$NON-NLS-1$
		
		result.addTest(OCLHelperTest.suite());
		result.addTest(ParsingTest.suite());
		result.addTest(SyntaxHelpTest.suite());
		result.addTest(EvaluationTest.suite());
		result.addTest(RegressionTest.suite());
		
		return result;
	}
}
