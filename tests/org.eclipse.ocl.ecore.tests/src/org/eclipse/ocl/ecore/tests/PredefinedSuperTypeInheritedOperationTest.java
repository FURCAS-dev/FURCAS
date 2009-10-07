/**
 * <copyright>
 * 
 * Copyright (c) 2008 Borland Software Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Borland - Initial API and implementation
 *   Zeligsoft - Added suite() and more test cases
 * 
 * </copyright>
 *
 * $Id: PredefinedSuperTypeInheritedOperationTest.java,v 1.2 2009/10/07 20:39:27 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.helper.OCLHelper;

/**
 * Tests the inheritance of additional operations defined on supertypes of
 * an OCL pre-defined type.
 */
@SuppressWarnings("nls")
public class PredefinedSuperTypeInheritedOperationTest extends AbstractTestSuite {

	public void testInheritedOperation() throws ParserException {
		OCLHelper<EClassifier, ?, ?, ?> helper = ocl.createOCLHelper();
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		try {
			helper.createQuery("(1).additionalOnReal() + (1.5).additionalOnReal()");
		} catch (ParserException e) {
			fail("Additional operation should come from super type");
		}
	}

	public void testInheritedAttribute() throws ParserException {
		OCLHelper<EClassifier, ?, ?, ?> helper = ocl.createOCLHelper();
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		try {
			helper.createQuery("(1).digitalRoot + (1.5).digitalRoot");
		} catch (ParserException e) {
			fail("Additional attribute should come from super type");
		}
	}

	public void testOperationInheritedFromOclAny() throws ParserException {
		OCLHelper<EClassifier, ?, ?, ?> helper = ocl.createOCLHelper();
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		try {
			helper.createQuery("self.hashString()");
		} catch (ParserException e) {
			fail("Additional ENamedElement operation should come from OclAny");
		}
		try {
			helper.createQuery("(1).hashString().concat((1.5).hashString())");
		} catch (ParserException e) {
			fail("Additional Real/Integer operation should come from OclAny");
		}
	}

	public void testAttributeInheritedFromOclAny() throws ParserException {
		OCLHelper<EClassifier, ?, ?, ?> helper = ocl.createOCLHelper();
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		try {
			helper.createQuery("self.stringValue");
		} catch (ParserException e) {
			fail("Additional ENamedElement attribute should come from OclAny");
		}
		try {
			helper.createQuery("(1).stringValue.concat((1.5).stringValue)");
		} catch (ParserException e) {
			fail("Additional Real/Integer attribute should come from OclAny");
		}
	}
	
	//
	// Test framework
	//
	
	@Override
	protected void setUp() {
		super.setUp();
		EcoreEnvironment env = (EcoreEnvironment) ocl.getEnvironment();
		env.addHelperOperation(env.getOCLStandardLibrary().getReal(),
			createAdditionalRealOperation());
		env.addHelperProperty(env.getOCLStandardLibrary().getReal(),
			createAdditionalRealAttribute());
		env.addHelperOperation(env.getOCLStandardLibrary().getOclAny(),
			createAdditionalOclAnyOperation());
		env.addHelperProperty(env.getOCLStandardLibrary().getOclAny(),
			createAdditionalOclAnyAttribute());
	}

	private EOperation createAdditionalRealOperation() {
		EOperation operation = EcoreFactory.eINSTANCE.createEOperation();
		operation.setName("additionalOnReal");
		operation.setEType(ocl.getEnvironment().getOCLStandardLibrary().getInteger());
		return operation;
	}

	private EAttribute createAdditionalRealAttribute() {
		EAttribute result = EcoreFactory.eINSTANCE.createEAttribute();
		result.setName("digitalRoot");
		result.setEType(ocl.getEnvironment().getOCLStandardLibrary().getInteger());
		return result;
	}

	private EOperation createAdditionalOclAnyOperation() {
		EOperation result = EcoreFactory.eINSTANCE.createEOperation();
		result.setName("hashString");
		result.setEType(ocl.getEnvironment().getOCLStandardLibrary().getString());
		return result;
	}

	private EAttribute createAdditionalOclAnyAttribute() {
		EAttribute result = EcoreFactory.eINSTANCE.createEAttribute();
		result.setName("stringValue");
		result.setEType(ocl.getEnvironment().getOCLStandardLibrary().getString());
		return result;
	}
}
