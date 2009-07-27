/**
 * <copyright>
 * 
 * Copyright (c) 2002, 2007 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.tests;

import java.util.Arrays;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * Tests for the OCL engine plug-in.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class AllTests
	extends TestCase {

	public AllTests() {
		super(""); //$NON-NLS-1$
	}

	public static Test suite() {
		if (System.getProperty("standalone") != null) { //$NON-NLS-1$
			// running tests stand-alone:  must set up the environment registry
			Environment.Registry.INSTANCE.registerEnvironment(
					EcoreEnvironmentFactory.INSTANCE.createEnvironment());
		}
		
		return AbstractTestSuite.suite();
	}

	public Object run(Object args)
		throws Exception {

		TestRunner.run(suite());
		return Arrays
			.asList(new String[] {"Please see raw test suite output for details."}); //$NON-NLS-1$
	}
}
