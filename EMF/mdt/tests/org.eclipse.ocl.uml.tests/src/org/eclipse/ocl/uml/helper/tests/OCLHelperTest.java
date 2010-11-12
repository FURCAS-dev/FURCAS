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
 * $Id: OCLHelperTest.java,v 1.3 2009/10/07 20:42:16 ewillink Exp $
 */

package org.eclipse.ocl.uml.helper.tests;

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
