/**
 * <copyright>
 * 
 * Copyright (c) 2008 Stefan Schulze, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Stefan Schulze - Initial API and implementation
 *   Zeligsoft - Formatting and MDT OCL code conventions
 * 
 * </copyright>
 *
 * $Id: FeatureRedefinitionTest.java,v 1.2 2009/10/07 20:39:27 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * Tests access to redefined features.
 * 
 * @author Stefan Schulze
 */
@SuppressWarnings("nls")
public class FeatureRedefinitionTest
		extends AbstractTestSuite {

	EClass c3;
	EOperation op3;
	EAttribute attr3;
	EClass c2;
	EAttribute attr2;
	EOperation op2;
	EClass c1;
	EAttribute attr1;
	EOperation op1;

	public void testCallOverridingMethod()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<EClassifier> expr = helper.createQuery("self.foo()");
		OperationCallExp callExpr = (OperationCallExp) expr;
		EOperation eop = callExpr.getReferredOperation();

		// C3::foo() should accessed
		assertSame(op3, eop);
	}

	public void testCallOverriddenMethod1()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<EClassifier> expr = helper
			.createQuery("self.oclAsType(C2).foo()");
		OperationCallExp callExpr = (OperationCallExp) expr;
		EOperation eop = callExpr.getReferredOperation();

		// C2::foo() should accessed
		assertSame(op2, eop);
	}

	public void testCallOverriddenMethod2()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<EClassifier> expr = helper
			.createQuery("self.oclAsType(C1).foo()");
		OperationCallExp callExpr = (OperationCallExp) expr;
		EOperation eop = callExpr.getReferredOperation();

		// C1::foo() should accessed
		assertSame(op1, eop);
	}

	public void testAccessOverridingProperty()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<EClassifier> expr = helper.createQuery("self.a");
		PropertyCallExp callExpr = (PropertyCallExp) expr;
		EStructuralFeature esf = callExpr.getReferredProperty();

		// C3::a should accessed
		assertSame(attr3, esf);
	}

	public void testAccessOverriddenProperty1()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<EClassifier> expr = helper
			.createQuery("self.oclAsType(C2).a");
		PropertyCallExp callExpr = (PropertyCallExp) expr;
		EStructuralFeature esf = callExpr.getReferredProperty();

		// C2::a should accessed
		assertSame(attr2, esf);
	}

	public void testAccessOverriddenProperty2()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<EClassifier> expr = helper
			.createQuery("self.oclAsType(C1).a");
		PropertyCallExp callExpr = (PropertyCallExp) expr;
		EStructuralFeature esf = callExpr.getReferredProperty();

		// C1::a should accessed
		assertSame(attr1, esf);
	}

	//
	// Test framework
	//

	@Override
	protected void setUp() {
		super.setUp();
		EcoreFactory f = EcoreFactory.eINSTANCE;
		EPackage p = f.createEPackage();

		p.setName("TestPackage");
		
		/* test model:
		 * 
		 * C1
		 *   - a : EInt
		 *   - foo() : EInt
		 * 
		 * C2 --|> C1
		 *   - a : EInt
		 *   - foo() : EInt
		 * 
		 * C3 --|> C2
		 *   - a : EInt
		 *   - foo() : EInt
		 */

		c1 = f.createEClass();
		p.getEClassifiers().add(c1);
		c1.setName("C1");
		attr1 = f.createEAttribute();
		attr1.setName("a");
		attr1.setEType(EcorePackage.Literals.EINT);
		c1.getEStructuralFeatures().add(attr1);

		op1 = f.createEOperation();
		c1.getEOperations().add(op1);
		op1.setName("foo");
		op1.setEType(EcorePackage.Literals.EINT);

		c2 = f.createEClass();
		p.getEClassifiers().add(c2);
		c2.setName("C2");
		c2.getESuperTypes().add(c1);

		attr2 = f.createEAttribute();
		attr2.setName("a");
		attr2.setEType(EcorePackage.Literals.EINT);
		c2.getEStructuralFeatures().add(attr2);

		op2 = f.createEOperation();
		c2.getEOperations().add(op2);
		op2.setName("foo");
		op2.setEType(EcorePackage.Literals.EINT);

		c3 = f.createEClass();
		p.getEClassifiers().add(c3);
		c3.setName("C3");
		c3.getESuperTypes().add(c2);

		attr3 = f.createEAttribute();
		attr3.setName("a");
		attr3.setEType(EcorePackage.Literals.EINT);
		c3.getEStructuralFeatures().add(attr3);

		op3 = f.createEOperation();
		c3.getEOperations().add(op3);
		op3.setName("foo");
		op3.setEType(EcorePackage.Literals.EINT);
	}
}
