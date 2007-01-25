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
 * $Id: OCLHelperTest.java,v 1.1 2007/01/25 18:32:32 cdamus Exp $
 */

package org.eclipse.ocl.ecore.helper.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.helper.OCLHelper;

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
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper1 =
			OCL.newInstance().createOCLHelper();
		assertNotNull(helper1);
		
		
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper2 =
			OCL.newInstance(EcoreEnvironmentFactory.INSTANCE).createOCLHelper();
		assertNotNull(helper2);
		
		assertNotSame(helper1, helper2);
	}
}
