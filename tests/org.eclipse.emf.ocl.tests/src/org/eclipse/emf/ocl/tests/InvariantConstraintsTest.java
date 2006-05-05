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

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.TypeExp;


/**
 * Tests support for operation constraints (pre/post/body).
 *
 * @author Christian W. Damus (cdamus)
 */
public class InvariantConstraintsTest extends AbstractTestSuite {

	public InvariantConstraintsTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(InvariantConstraintsTest.class,
			"Invariant Constraints"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a very simple invariant, with a package and classifier context
	 * not using any "self" variable.
	 */
	public void test_simpleInvariant() {
		parseConstraint(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: color <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a very simple invariant, with a package and classifier context
	 * using the "self" variable.
	 */
	public void test_simpleInvariantWithSelf() {
		parseConstraint(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: self.color <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Test a let expression.
	 */
	public void test_simpleInvariantWithLet() {
		parseConstraint(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: let myColor : Color = self.color in myColor <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that local variables correctly hide attributes of the context
	 * classifier. 
	 */
	public void test_variablesHidingAttributes() {
		parseConstraint(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: let color : Boolean = (not self.color.oclIsUndefined()) in " + //$NON-NLS-1$
			"  color implies self.color <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that when a property name coincides with a type name, we correctly
	 * distinguish references to the type from references to the property.
	 */
	public void test_propertyNameCoincidesWithTypeName_140347() {
		EReference myFruit = EcoreFactory.eINSTANCE.createEReference();
		myFruit.setName("Fruit"); //$NON-NLS-1$
		myFruit.setEType(fruit);
		apple.getEStructuralFeatures().add(myFruit);
		
		try {
			OCLExpression expr = parseConstraint(
				"package ocltest context Apple " + //$NON-NLS-1$
				"inv: self.Fruit <> self implies self.Fruit.oclIsKindOf(Fruit) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
			
			int propertyCalls = 0;
			int typeCalls = 0;
			for (Iterator iter = EcoreUtil.getAllContents(Collections.singleton(expr)); iter.hasNext();) {
				Object next = iter.next();
				if (next instanceof PropertyCallExp) {
					if ("Fruit".equals(((PropertyCallExp) next).getReferredProperty().getName())) { //$NON-NLS-1$
						propertyCalls++;
					}
				} else if (next instanceof TypeExp) {
					if ("Fruit".equals(((TypeExp) next).getReferredType().getName())) { //$NON-NLS-1$
						typeCalls++;
					}
				}
			}
			
			assertEquals("property calls", 2, propertyCalls); //$NON-NLS-1$
			assertEquals("type calls", 1, typeCalls); //$NON-NLS-1$
		} finally {
			apple.getEStructuralFeatures().remove(myFruit);
		}
	}
}
