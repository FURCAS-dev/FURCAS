/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: OCLHelperTest.java,v 1.2 2007/02/14 14:46:17 cdamus Exp $
 */

package org.eclipse.ocl.uml.helper.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

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
		OCLHelper<Classifier, Operation, Property, Constraint> helper1 =
			OCL.newInstance().createOCLHelper();
		assertNotNull(helper1);
		
		
		OCLHelper<Classifier, Operation, Property, Constraint> helper2 =
			OCL.newInstance(new UMLEnvironmentFactory()).createOCLHelper();
		assertNotNull(helper2);
		
		assertNotSame(helper1, helper2);
	}
}
