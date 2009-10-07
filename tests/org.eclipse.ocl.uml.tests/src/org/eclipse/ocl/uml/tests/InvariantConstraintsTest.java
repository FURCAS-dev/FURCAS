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
 * $Id: InvariantConstraintsTest.java,v 1.4 2009/10/07 20:41:45 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;


/**
 * Tests support for operation constraints (pre/post/body).
 *
 * @author Christian W. Damus (cdamus)
 */
public class InvariantConstraintsTest extends AbstractTestSuite {
	
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
        expectModified = true;
		Property myFruit = apple.createOwnedAttribute(
				"Fruit", fruit); //$NON-NLS-1$
		
		try {
			OCLExpression<Classifier> expr = parseConstraint(
				"package ocltest context Apple " + //$NON-NLS-1$
				"inv: self.Fruit <> self implies self.Fruit.oclIsKindOf(Fruit) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
			
			int propertyCalls = 0;
			int typeCalls = 0;
			for (Iterator<?> iter = EcoreUtil.getAllContents(Collections.singleton(expr)); iter.hasNext();) {
				Object next = iter.next();
				if (next instanceof PropertyCallExp<?, ?>) {
					@SuppressWarnings("unchecked")
					PropertyCallExp<Classifier, Property> pc =
						(PropertyCallExp<Classifier, Property>) next;
					
					if ("Fruit".equals(pc.getReferredProperty().getName())) { //$NON-NLS-1$
						propertyCalls++;
					}
				} else if (next instanceof TypeExp<?>) {
					@SuppressWarnings("unchecked")
					TypeExp<Classifier> te = (TypeExp<Classifier>) next;
					
					if ("Fruit".equals(te.getReferredType().getName())) { //$NON-NLS-1$
						typeCalls++;
					}
				}
			}
			
			assertEquals("property calls", 2, propertyCalls); //$NON-NLS-1$
			assertEquals("type calls", 1, typeCalls); //$NON-NLS-1$
		} finally {
			apple.getOwnedAttributes().remove(myFruit);
		}
	}
	
	/**
	 * Tests that type conformance accounts for interface realizations.
	 */
	public void test_interfaceRealization() {
		// this constraint tests the Environment.getRelationship() method
		//    for conformance of classifiers with implemented interfaces.
		//    Note that it is necessary to cast in order to
		//    access features of the interface because they are not inherited
		//    in UML
		parseConstraint(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv only_tasty_fruit: self.oclAsType(Edible).isTasty implies " + //$NON-NLS-1$
			"  Edible.allInstances()->excluding(self)->forAll(e | not e.isTasty) " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
    
    /**
     * Tests resolution of qualified classifier names for nested classifiers.
     */
    public void test_nestedClassifiers() {
        expectModified = true;
        Class seed = (Class) apple.createNestedClassifier("Seed", uml.getClass_()); //$NON-NLS-1$
        seed.createOwnedAttribute("fruit", apple); //$NON-NLS-1$
        
        try {
            // try different usages of the qualified class name
            parseConstraint(
                "package ocltest context Fruit" + //$NON-NLS-1$
                " inv: Apple::Seed.allInstances()->forAll(fruit.color <> Color::black)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
            
            parseConstraint(
                "package ocltest context Apple::Seed" + //$NON-NLS-1$
                " inv: not fruit.oclIsUndefined()" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
            
            parseConstraint(
                "context ocltest::Apple::Seed" + //$NON-NLS-1$
                " inv: fruit.color <> Color::black"); //$NON-NLS-1$
            
            parseDef(
                "package ocltest context Apple::Seed" + //$NON-NLS-1$
                " def: getColor() : Color = fruit.color" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
            
            parseConstraint(
                "package ocltest context Apple::Seed::getColor() : Color" + //$NON-NLS-1$
                " pre: not fruit.oclIsUndefined()" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
        } finally {
            seed.destroy();
        }
    }
}
