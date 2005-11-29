/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.core.runtime.IPlatformRunnable;

/**
 * Tests for the OCL engine plug-in.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class AllTests
	extends TestCase
	implements IPlatformRunnable {

	public AllTests() {
		super(""); //$NON-NLS-1$
	}

	public static Test suite() {
		return AbstractTestSuite.suite();
	}

	public Object run(Object args)
		throws Exception {

		TestRunner.run(suite());
		return Arrays
			.asList(new String[] {"Please see raw test suite output for details."}); //$NON-NLS-1$
	}
}