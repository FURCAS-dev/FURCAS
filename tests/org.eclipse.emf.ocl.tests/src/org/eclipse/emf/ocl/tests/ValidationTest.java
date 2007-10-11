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
 * $Id: ValidationTest.java,v 1.4 2007/10/11 23:05:09 cdamus Exp $
 */

package org.eclipse.emf.ocl.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.NavigationCallExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.impl.ValidationVisitorImpl;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.util.UMLTypeUtil;


/**
 * Tests the validation of OCL expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ValidationTest extends AbstractTestSuite {

	private EReference stem_apple;
	private EReference stem_tree;
	private EAttribute stem_thickness;
	
	private EReference apple_tree;
	
	private EClass tree;
	private EReference tree_apples;
	
	private EClass forest;
	private EReference forest_trees;

	public ValidationTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(ValidationTest.class,
			"Expression Validation Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that operation calls may only invoke query operations. 
	 */
	public void test_callNonQueryOperation_136778() {
		Environment[] env = new Environment[1];
		
		// newApple() is not a query operation
		UMLTypeUtil.setQuery(apple_newApple, false);
		
		OCLExpression expr = parseConstraintUnvalidated(
				"package ocltest context Apple " + //$NON-NLS-1$
				"inv: Apple.allInstances()->includes(self.newApple()) " + //$NON-NLS-1$
				"endpackage", //$NON-NLS-1$
				env);
		
		try {
			expr.accept(ValidationVisitorImpl.getInstance(env[0]));
			fail("Should not have successfully validated"); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			// success
			System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that association qualifiers must conform to the expected qualifier
	 * types.
	 */
	public void test_qualifiersMatchExpectedTypes_136778() {
		Environment[] env = new Environment[1];
		
		OCLExpression expr = parseUnvalidated(
			"package ocltest context Forest " + //$NON-NLS-1$
			"inv: self.trees['foo', 3]" + //$NON-NLS-1$
			" endpackage", //$NON-NLS-1$
			env);

		// now, replace the first qualifier with another integer value
		IntegerLiteralExp literal = ExpressionsFactory.eINSTANCE.createIntegerLiteralExp();
		literal.setIntegerSymbol(new Integer(1));
		literal.setType(Types.OCL_INTEGER);
		NavigationCallExp nav = (NavigationCallExp) expr;
		EList qualifiers = nav.getQualifier();
		qualifiers.set(0, literal);
		
		try {
			expr.accept(ValidationVisitorImpl.getInstance(env[0]));
			fail("Should not have successfully validated"); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			// success
			System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that the association class navigation source must be a member end
	 * of the association class.
	 */
	public void test_associationClass_qualifiers_RATLC00538077() {
		Environment[] env = new Environment[1];
		
		OCLExpression expr = parseUnvalidated(
				"package ocltest context Tree " + //$NON-NLS-1$
				"inv: self.stem[apples]" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		
		// now, replace the navigation source with another property that is not
		//   an end of the association class
		NavigationCallExp nav = (NavigationCallExp) expr;
		nav.setNavigationSource(forest_trees);
		
		try {
			expr.accept(ValidationVisitorImpl.getInstance(env[0]));
			fail("Should not have successfully validated"); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			// success
			System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
			
		// try again with yet another property that is an end of the association
		//   class, but which end is not at the source type
		nav.setNavigationSource(apple_tree);
		
		try {
			expr.accept(ValidationVisitorImpl.getInstance(env[0]));
			fail("Should not have successfully validated"); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			// success
			System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	//
	// Fixture methods
	//
	
	/**
	 * Sets up a common fixture for the association class tests.
	 */
	@Override
    public void setUp() throws Exception {
		super.setUp();
		
		fruitPackage.getEClassifiers().remove(stem);
		
		// "stem" is more appropriately modeled as an association class
		stem = EcoreFactory.eINSTANCE.createEClass();
		stem.setName("Stem"); //$NON-NLS-1$
		UMLTypeUtil.setAssociationClass(stem, true);
		
		tree = EcoreFactory.eINSTANCE.createEClass();
		tree.setName("Tree"); //$NON-NLS-1$
		
		fruitPackage.getEClassifiers().add(stem);
		fruitPackage.getEClassifiers().add(tree);
		
		apple.getEStructuralFeatures().remove(apple_stem);
		apple_stem = null;
		
		apple_tree = EcoreFactory.eINSTANCE.createEReference();
		apple_tree.setName("tree"); //$NON-NLS-1$
		apple_tree.setEType(tree);
		UMLTypeUtil.setAssociationClass(apple_tree, stem);
		apple.getEStructuralFeatures().add(apple_tree);
		
		tree_apples = EcoreFactory.eINSTANCE.createEReference();
		tree_apples.setName("apples"); //$NON-NLS-1$
		tree_apples.setEType(apple);
		tree_apples.setUpperBound(-1);
		UMLTypeUtil.setAssociationClass(tree_apples, stem);
		tree.getEStructuralFeatures().add(tree_apples);
		
		stem_thickness = EcoreFactory.eINSTANCE.createEAttribute();
		stem_thickness.setName("thickness"); //$NON-NLS-1$
		stem_thickness.setEType(EcorePackage.eINSTANCE.getEInt());
		stem.getEStructuralFeatures().add(stem_thickness);
		
		stem_apple = EcoreFactory.eINSTANCE.createEReference();
		stem_apple.setName("apple"); //$NON-NLS-1$
		stem_apple.setEType(apple);
		stem.getEStructuralFeatures().add(stem_apple);
		UMLTypeUtil.addMemberEnd(stem, stem_apple);
		
		stem_tree = EcoreFactory.eINSTANCE.createEReference();
		stem_tree.setName("tree"); //$NON-NLS-1$
		stem_tree.setEType(tree);
		stem.getEStructuralFeatures().add(stem_tree);
		UMLTypeUtil.addMemberEnd(stem, stem_tree);
		
		// add a Forest::trees association with qualifiers
		forest = EcoreFactory.eINSTANCE.createEClass();
		forest.setName("Forest"); //$NON-NLS-1$
		fruitPackage.getEClassifiers().add(forest);
		
		forest_trees = EcoreFactory.eINSTANCE.createEReference();
		forest_trees.setName("trees"); //$NON-NLS-1$
		forest_trees.setEType(tree);
		forest_trees.setUpperBound(-1);
		forest.getEStructuralFeatures().add(forest_trees);
		
		EStructuralFeature q = EcoreFactory.eINSTANCE.createEAttribute();
		q.setName("q1"); //$NON-NLS-1$
		q.setEType(EcorePackage.eINSTANCE.getEString());
		UMLTypeUtil.addQualifier(forest_trees, q);
		q = EcoreFactory.eINSTANCE.createEAttribute();
		q.setName("q2"); //$NON-NLS-1$
		q.setEType(EcorePackage.eINSTANCE.getEInt());
		UMLTypeUtil.addQualifier(forest_trees, q);
	}
	
	@Override
    protected void tearDown()
		throws Exception {
		
		super.tearDown();
		
		// delete customizations, to re-initialize schema for subsequent tests
		fruitPackage = null;
	}
}
