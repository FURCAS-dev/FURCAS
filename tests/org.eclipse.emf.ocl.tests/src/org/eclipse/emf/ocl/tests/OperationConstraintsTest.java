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

package org.eclipse.emf.ocl.tests;

import java.util.Collections;
import java.util.Iterator;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.VariableExp;


/**
 * Tests support for operation constraints (pre/post/body).
 *
 * @author Christian W. Damus (cdamus)
 */
public class OperationConstraintsTest extends AbstractTestSuite {

	public OperationConstraintsTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(OperationConstraintsTest.class,
			"Operation Constraints"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a very simple precondition, with a package and operation context.
	 */
	public void test_simplePrecondition() {
		parseConstraint(
			"package ocltest context Fruit::ripen(color : Color) : Boolean " + //$NON-NLS-1$
			"pre: color <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a very simple postcondition, with a package and operation context
	 * and using the "self" variable to disambiguate the name "color".
	 */
	public void test_simplePostcondition() {
		parseConstraint(
			"package ocltest context Fruit::ripen(color : Color) : Boolean " + //$NON-NLS-1$
			"post: self.color = color " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a postcondition containing the "@pre" construct.
	 */
	public void test_postcondition_atPre() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"post: color <> color@pre implies color = c " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a postcondition containing the "@pre" construct on an operation call.
	 */
	public void test_postcondition_atPre_operation() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"post: preferredColor() <> preferredColor@pre() implies color = c " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests availability of the special "result" variable in postconditions.
	 */
	public void test_postcondition_result() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"post: result implies color <> color@pre " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that in case of multiple constraints, each defines its own namespace
	 * for local variables (we don't get errors on multiple declarations).
	 */
	public void test_namespaces() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"pre notBlack: let ok : Boolean = c <> Color::black in " + //$NON-NLS-1$
			"  ok " + //$NON-NLS-1$
			"pre different: let ok : Boolean = c <> color in " + //$NON-NLS-1$
			"  ok " + //$NON-NLS-1$
			"body: let b : Boolean = c <> color in " + //$NON-NLS-1$
			"  result = b implies color <> Color::black " + //$NON-NLS-1$
			"post worked: result implies color <> color@pre " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Checks that we correctly reject illegal use of "@pre" in precondition
	 * constraints.
	 */
	public void test_illegalUseOfAtPre_precondition() {
		AssertionFailedError err = null;
		
		try {
			parseConstraint(
				"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
				"pre: c <> color@pre " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have succeeded in validating illegal @pre", err); //$NON-NLS-1$
	}
	
	/**
	 * Checks that we correctly reject illegal use of "@pre" in invariant
	 * constraints.
	 */
	public void test_illegalUseOfAtPre_invariant() {
		AssertionFailedError err = null;
		
		try {
			parseConstraint(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: color@pre <> Color::black " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have succeeded in validating illegal @pre", err); //$NON-NLS-1$
	}
	
	/**
	 * Checks that we correctly reject illegal use of "@pre" in postcondition
	 * constraints (where the "@pre" is not used on a model property expression).
	 */
	public void test_illegalUseOfAtPre_postcondition() {
		AssertionFailedError err = null;
		
		try {
			parseConstraint(
				"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
				"post: let oldColor : Color = color in c <> oldColor@pre " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have succeeded in validating illegal @pre", err); //$NON-NLS-1$
	}
	
	/**
	 * Tests that local variables correctly hide attributes of the context
	 * classifier. 
	 */
	public void test_variablesHidingAttributes() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"pre: let color : Boolean = (c = self.color) in " + //$NON-NLS-1$
			"  color implies c <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that parameters are in the same scope as local variables (cannot
	 * use same names). 
	 */
	public void test_parametersAreLocalVariables() {
		AssertionFailedError err = null;
		
		try {
			parseConstraint(
				"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
				"pre: color : Boolean = (c = self.color) in " + //$NON-NLS-1$
				"  color implies c <> Color::black " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(err);
	}
	
	/**
	 * Tests that body conditions are correctly checked for conformance to the
	 * operation type. 
	 */
	public void test_bodyConditionConformance() {
		AssertionFailedError err = null;
		
		try {
			// try a scenario with no common supertype
			parseConstraint(
				"package ocltest context Fruit::preferredColor() : Color " + //$NON-NLS-1$
				"body: result = (if true then 'red' else 'brown' endif) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(err);
		err = null;
		
		try {
			// try a scenario with a common supertype
			parseConstraint(
				"package ocltest context Apple::newApple() : Apple " + //$NON-NLS-1$
				"body: result = self.newFruit() " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(err);
		err = null;
		
		try {
			// this scenario is OK
			parseConstraint(
				"package ocltest context Apple::newFruit() : Fruit " + //$NON-NLS-1$
				"body: result = self.newApple() " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.err.println("Got unexpected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNull(err);
	}
	
	/**
	 * Tests that body conditions are not allowed for void operations. 
	 */
	public void test_bodyConditionVoidOperation() {
		AssertionFailedError err = null;
		
		try {
			parseConstraint(
				"package ocltest context Apple::label(newLabel : String) : " + //$NON-NLS-1$
				"body: result = (if true then 'Spy' else 'Spartan' endif) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(err);
	}
	
	/**
	 * Tests that when a parameter name (or any other local variable, for that
	 * matter) coincides with an attribute name, we correctly distinguish
	 * references to the variable from references to the attribute.
	 */
	public void test_parameterNameCoincidesWithAttributeName_140008() {
		EOperation foo = EcoreFactory.eINSTANCE.createEOperation();
		foo.setName("foo"); //$NON-NLS-1$
		EParameter parm = EcoreFactory.eINSTANCE.createEParameter();
		parm.setName("str"); //$NON-NLS-1$
		parm.setEType(EcorePackage.Literals.ESTRING);
		foo.getEParameters().add(parm);
		foo.setEType(EcorePackage.Literals.ESTRING);
		apple.getEOperations().add(foo);
		EAttribute myStr = EcoreFactory.eINSTANCE.createEAttribute();
		myStr.setName("str"); //$NON-NLS-1$
		myStr.setEType(EcorePackage.Literals.ESTRING);
		apple.getEStructuralFeatures().add(myStr);
		
		try {
			OCLExpression expr = parseConstraint(
				"package ocltest context Apple::foo(str : String) : String " + //$NON-NLS-1$
				"body: result = (if str = self.str then '' else str endif) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
			
			int propertyCalls = 0;
			int variableCalls = 0;
			for (Iterator iter = EcoreUtil.getAllContents(Collections.singleton(expr)); iter.hasNext();) {
				Object next = iter.next();
				if (next instanceof PropertyCallExp) {
					if ("str".equals(((PropertyCallExp) next).getReferredProperty().getName())) { //$NON-NLS-1$
						propertyCalls++;
					}
				} else if (next instanceof VariableExp) {
					if ("str".equals(((VariableExp) next).getReferredVariable().getName())) { //$NON-NLS-1$
						variableCalls++;
					}
				}
			}
			
			assertEquals("property calls", 1, propertyCalls); //$NON-NLS-1$
			assertEquals("variable calls", 2, variableCalls); //$NON-NLS-1$
		} finally {
			apple.getEOperations().remove(foo);
			apple.getEStructuralFeatures().remove(myStr);
		}
	}
}
