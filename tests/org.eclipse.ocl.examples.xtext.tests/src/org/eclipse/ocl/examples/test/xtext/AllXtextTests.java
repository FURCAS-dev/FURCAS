/**
 * <copyright>
 * 
 * Copyright (c) 2002, 2009 IBM Corporation and others.
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
 * $Id: AllXtextTests.java,v 1.1 2010/05/03 20:01:59 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.xtext;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

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
		result.addTestSuite(LoadTests.class);
		result.addTestSuite(SerializeTests.class);
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
