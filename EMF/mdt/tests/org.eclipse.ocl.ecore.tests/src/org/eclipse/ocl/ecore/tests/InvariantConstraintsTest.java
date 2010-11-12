/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: InvariantConstraintsTest.java,v 1.4 2009/11/28 17:46:56 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.TypeExp;


/**
 * Tests support for operation constraints (pre/post/body).
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class InvariantConstraintsTest extends AbstractTestSuite {
	
	/**
	 * Tests a very simple invariant, with a package and classifier context
	 * not using any "self" variable.
	 */
	public void test_simpleInvariant() {
		parseConstraint(
			"package ocltest context Fruit " +
			"inv: color <> Color::black " +
			"endpackage");
	}
	
	/**
	 * Tests a very simple invariant, with a package and classifier context
	 * using the "self" variable.
	 */
	public void test_simpleInvariantWithSelf() {
		parseConstraint(
			"package ocltest context Fruit " +
			"inv: self.color <> Color::black " +
			"endpackage");
	}
	
	/**
	 * Test a let expression.
	 */
	public void test_simpleInvariantWithLet() {
		parseConstraint(
			"package ocltest context Fruit " +
			"inv: let myColor : Color = self.color in myColor <> Color::black " +
			"endpackage");
	}
	
	/**
	 * Tests that local variables correctly hide attributes of the context
	 * classifier. 
	 */
	public void test_variablesHidingAttributes() {
		parseConstraint(
			"package ocltest context Fruit " +
			"inv: let color : Boolean = (not self.color.oclIsUndefined()) in " +
			"  color implies self.color <> Color::black " +
			"endpackage");
	}
	
	/**
	 * Tests that when a property name coincides with a type name, we correctly
	 * distinguish references to the type from references to the property.
	 */
	public void test_propertyNameCoincidesWithTypeName_140347() {
		expectModified = true;
		EReference myFruit = EcoreFactory.eINSTANCE.createEReference();
		myFruit.setName("Fruit");
		myFruit.setEType(fruit);
		apple.getEStructuralFeatures().add(myFruit);
		
		try {
			OCLExpression<EClassifier> expr = parseConstraint(
				"package ocltest context Apple " +
				"inv: self.Fruit <> self implies self.Fruit.oclIsKindOf(Fruit) " +
				"endpackage");
			
			int propertyCalls = 0;
			int typeCalls = 0;
			for (Iterator<?> iter = EcoreUtil.getAllContents(Collections.singleton(expr)); iter.hasNext();) {
				Object next = iter.next();
				if (next instanceof PropertyCallExp<?, ?>) {
					@SuppressWarnings("unchecked")
					PropertyCallExp<EClassifier, EStructuralFeature> pc =
						(PropertyCallExp<EClassifier, EStructuralFeature>) next;
					
					if ("Fruit".equals(pc.getReferredProperty().getName())) {
						propertyCalls++;
					}
				} else if (next instanceof TypeExp<?>) {
					@SuppressWarnings("unchecked")
					TypeExp<EClassifier> te = (TypeExp<EClassifier>) next;
					
					if ("Fruit".equals(te.getReferredType().getName())) {
						typeCalls++;
					}
				}
			}
			
			assertEquals("property calls", 2, propertyCalls);
			assertEquals("type calls", 1, typeCalls);
		} finally {
			apple.getEStructuralFeatures().remove(myFruit);
		}
	}
}
