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
 * $Id: OCLHelperTest.java,v 1.3 2006/04/04 18:03:10 cdamus Exp $
 */

package org.eclipse.emf.ocl.helper.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;

/**
 * Tests the OCL Helper API.
 * 
 * @author Chris McGee (cmcgee)
 */
public class OCLHelperTest
	extends AbstractTestSuite {

	/**
	 * Initializes me with my name.
	 */
	public OCLHelperTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(OCLHelperTest.class, "Basic Tests"); //$NON-NLS-1$
	}
	
	public void testHelperCreation() {
		IOCLHelper helper1 = HelperUtil.createOCLHelper();
		assertNotNull(helper1);
		
		IOCLHelper helper2 = HelperUtil.createOCLHelper(EnvironmentFactory.ECORE_INSTANCE);
		assertNotNull(helper2);
		
		assertNotSame(helper1, helper2);
	}
}
