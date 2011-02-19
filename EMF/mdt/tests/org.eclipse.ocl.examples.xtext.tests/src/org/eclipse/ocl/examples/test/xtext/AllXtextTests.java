/**
 * <copyright>
 * 
 * Copyright (c) 2002,2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 298634
 *
 * </copyright>
 *
 * $Id: AllXtextTests.java,v 1.3 2011/02/19 12:04:36 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.xtext;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.ocl.examples.pivot.tests.EvaluateBooleanOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateCollectionOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateNumericOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateOclAnyOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateStringOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.IteratorsTest;

/**
 * Tests for the Xtext editor support.
 */
@SuppressWarnings("nls")
public class AllXtextTests
	extends TestCase {

	public AllXtextTests() {
		super("");
	}

	public static Test suite() {
//		if (System.getProperty("standalone") != null) {
			// running tests stand-alone:  must set up the environment registry
//			Environment.Registry.INSTANCE.registerEnvironment(
//					EcoreEnvironmentFactory.INSTANCE.createEnvironment());
//		}

		TestSuite result = new TestSuite("Xtext Editor Support");			
		result.addTestSuite(MonikerTests.class);
		result.addTestSuite(PivotTests.class);
		result.addTestSuite(OCLstdlibTests.class);
		result.addTestSuite(EvaluateBooleanOperationsTest.class);
		result.addTestSuite(EvaluateCollectionOperationsTest.class);
		result.addTestSuite(EvaluateNumericOperationsTest.class);
		result.addTestSuite(EvaluateOclAnyOperationsTest.class);
		result.addTestSuite(EvaluateStringOperationsTest.class);
		result.addTestSuite(IteratorsTest.class);
//		result.addTestSuite(LoadTests.class);
//		result.addTestSuite(SerializeTests.class);
		result.addTestSuite(RoundTripTests.class);
		return result;
	}

	public Object run(Object args)
		throws Exception {

		TestRunner.run(suite());
		return Arrays
			.asList(new String[] {"Please see raw test suite output for details."});
	}
}
