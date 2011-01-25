/**
 * <copyright>
 * 
 * Copyright (c) 2009 E.D.Willink and others.
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
 * $Id: AllTestsBacktracking.java,v 1.3 2010/04/25 06:50:15 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.tests.GenericTestSuite.CheckedTestSuite;

/**
 * Tests for the OCL engine plug-in using the backtracking parser.
 */
@SuppressWarnings("nls")
public class AllTestsBacktracking
	extends TestCase {

	public AllTestsBacktracking() {
		super("");
	}

	public static Test suite() {
		if (System.getProperty("standalone") != null) {
			// running tests stand-alone:  must set up the environment registry
			Environment.Registry.INSTANCE.registerEnvironment(
					EcoreEnvironmentFactory.INSTANCE.createEnvironment());
		}
		System.setProperty(EcoreTestReflection.PLUGIN_ID + ".repairs", "100");
		CheckedTestSuite result = new CheckedTestSuite("OCL Tests for Ecore Metamodel");			
		AbstractTestSuite.suite(result);
		AbstractTestSuite.suiteBacktracking(result);
		return result;
	}

	public Object run(Object args)
		throws Exception {

		TestRunner.run(suite());
		return Arrays
			.asList(new String[] {"Please see raw test suite output for details."});
	}
}
