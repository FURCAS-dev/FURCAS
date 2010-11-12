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
 *   Zeligsoft - Adapted for the UML metamodel
 * 
 * </copyright>
 *
 * $Id: FeatureRedefinitionTest.java,v 1.2 2009/10/07 20:41:45 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.uml.OperationCallExp;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;


/**
 * Tests access to redefined features.
 * 
 * @author Stefan Schulze
 */
@SuppressWarnings("nls")
public class FeatureRedefinitionTest
		extends AbstractTestSuite {

	Class c3;
	Operation op3;
	Property attr3;
	Class c2;
	Property attr2;
	Operation op2;
	Class c1;
	Property attr1;
	Operation op1;

	public void testCallOverridingMethod()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<Classifier> expr = helper.createQuery("self.foo()");
		OperationCallExp callExpr = (OperationCallExp) expr;
		Operation eop = callExpr.getReferredOperation();

		// C3::foo() should accessed
		assertSame(op3, eop);
	}

	public void testCallOverriddenMethod1()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<Classifier> expr = helper
			.createQuery("self.oclAsType(C2).foo()");
		OperationCallExp callExpr = (OperationCallExp) expr;
		Operation eop = callExpr.getReferredOperation();

		// C2::foo() should accessed
		assertSame(op2, eop);
	}

	public void testCallOverriddenMethod2()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<Classifier> expr = helper
			.createQuery("self.oclAsType(C1).foo()");
		OperationCallExp callExpr = (OperationCallExp) expr;
		Operation eop = callExpr.getReferredOperation();

		// C1::foo() should accessed
		assertSame(op1, eop);
	}

	public void testAccessOverridingProperty()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<Classifier> expr = helper.createQuery("self.a");
		PropertyCallExp callExpr = (PropertyCallExp) expr;
		Property esf = callExpr.getReferredProperty();

		// C3::a should accessed
		assertSame(attr3, esf);
	}

	public void testAccessOverriddenProperty1()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<Classifier> expr = helper
			.createQuery("self.oclAsType(C2).a");
		PropertyCallExp callExpr = (PropertyCallExp) expr;
		Property esf = callExpr.getReferredProperty();

		// C2::a should accessed
		assertSame(attr2, esf);
	}

	public void testAccessOverriddenProperty2()
			throws Exception {

		helper.setContext(c3);

		OCLExpression<Classifier> expr = helper
			.createQuery("self.oclAsType(C1).a");
		PropertyCallExp callExpr = (PropertyCallExp) expr;
		Property esf = callExpr.getReferredProperty();

		// C1::a should accessed
		assertSame(attr1, esf);
	}

	//
	// Test framework
	//

	@Override
	protected void setUp() {
		super.setUp();
		UMLFactory f = UMLFactory.eINSTANCE;

		
		Classifier integer = ocl.getEnvironment().getOCLStandardLibrary()
			.getInteger();
	
		Package p = f.createPackage();
		p.setName("TestPackage");
		
		resourceSet.createResource(URI.createURI("http:///test.uml")).getContents()
			.add(p);
		
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

		// UML defines redefinition semantics that Ecore does not
		
		c1 = p.createOwnedClass("C1", false);
		attr1 = c1.createOwnedAttribute("a", integer);
		op1 = c1.createOwnedOperation("foo", null, null, integer);
		op1.setIsQuery(true);

		c2 = p.createOwnedClass("C2", false);
		c2.createGeneralization(c1);
		attr2 = c2.createOwnedAttribute("a", integer);
		attr2.getRedefinedProperties().add(attr1);
		op2 = c2.createOwnedOperation("foo", null, null, integer);
		op2.setIsQuery(true);
		op2.getRedefinedOperations().add(op1);

		c3 = p.createOwnedClass("C3", false);
		c3.createGeneralization(c2);
		attr3 = c3.createOwnedAttribute("a", integer);
		attr3.getRedefinedProperties().add(attr1);
		attr3.getRedefinedProperties().add(attr2);
		op3 = c3.createOwnedOperation("foo", null, null, integer);
		op3.setIsQuery(true);
		op3.getRedefinedOperations().add(op1);
		op3.getRedefinedOperations().add(op2);
	}
}
