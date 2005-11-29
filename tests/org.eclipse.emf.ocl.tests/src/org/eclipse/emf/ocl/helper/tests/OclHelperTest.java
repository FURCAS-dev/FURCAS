/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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

package org.eclipse.emf.ocl.helper.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOclHelper;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;

/**
 * Tests the OCL Helper API.
 * 
 * @author Chris McGee (cmcgee)
 */
public class OclHelperTest
	extends AbstractTestSuite {

	/**
	 * Initializes me with my name.
	 */
	public OclHelperTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(OclHelperTest.class, "Basic Tests"); //$NON-NLS-1$
	}
	
	public void testHelperCreation() {
		IOclHelper helper1 = HelperUtil.createOclHelper();
		assertNotNull(helper1);
		
		IOclHelper helper2 = HelperUtil.createOclHelper(EnvironmentFactory.ECORE_INSTANCE);
		assertNotNull(helper2);
		
		assertNotSame(helper1, helper2);
	}
}
