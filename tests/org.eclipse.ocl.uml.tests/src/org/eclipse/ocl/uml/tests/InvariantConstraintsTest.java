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
 * $Id: InvariantConstraintsTest.java,v 1.5 2009/11/28 18:09:33 ewillink Exp $
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
		Property myFruit = apple.createOwnedAttribute(
				"Fruit", fruit);
		
		try {
			OCLExpression<Classifier> expr = parseConstraint(
				"package ocltest context Apple " +
				"inv: self.Fruit <> self implies self.Fruit.oclIsKindOf(Fruit) " +
				"endpackage");
			
			int propertyCalls = 0;
			int typeCalls = 0;
			for (Iterator<?> iter = EcoreUtil.getAllContents(Collections.singleton(expr)); iter.hasNext();) {
				Object next = iter.next();
				if (next instanceof PropertyCallExp<?, ?>) {
					@SuppressWarnings("unchecked")
					PropertyCallExp<Classifier, Property> pc =
						(PropertyCallExp<Classifier, Property>) next;
					
					if ("Fruit".equals(pc.getReferredProperty().getName())) {
						propertyCalls++;
					}
				} else if (next instanceof TypeExp<?>) {
					@SuppressWarnings("unchecked")
					TypeExp<Classifier> te = (TypeExp<Classifier>) next;
					
					if ("Fruit".equals(te.getReferredType().getName())) {
						typeCalls++;
					}
				}
			}
			
			assertEquals("property calls", 2, propertyCalls);
			assertEquals("type calls", 1, typeCalls);
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
			"package ocltest context Fruit " +
			"inv only_tasty_fruit: self.oclAsType(Edible).isTasty implies " +
			"  Edible.allInstances()->excluding(self)->forAll(e | not e.isTasty) " +
			"endpackage");
	}
    
    /**
     * Tests resolution of qualified classifier names for nested classifiers.
     */
    public void test_nestedClassifiers() {
        expectModified = true;
        Class seed = (Class) apple.createNestedClassifier("Seed", uml.getClass_());
        seed.createOwnedAttribute("fruit", apple);
        
        try {
            // try different usages of the qualified class name
            parseConstraint(
                "package ocltest context Fruit" +
                " inv: Apple::Seed.allInstances()->forAll(fruit.color <> Color::black)" +
                " endpackage");
            
            parseConstraint(
                "package ocltest context Apple::Seed" +
                " inv: not fruit.oclIsUndefined()" +
                " endpackage");
            
            parseConstraint(
                "context ocltest::Apple::Seed" +
                " inv: fruit.color <> Color::black");
            
            parseDef(
                "package ocltest context Apple::Seed" +
                " def: getColor() : Color = fruit.color" +
                " endpackage");
            
            parseConstraint(
                "package ocltest context Apple::Seed::getColor() : Color" +
                " pre: not fruit.oclIsUndefined()" +
                " endpackage");
        } finally {
            seed.destroy();
        }
    }
}
