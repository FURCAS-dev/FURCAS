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

import java.util.List;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.ModelPropertyCallExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.helper.ChoiceType;
import org.eclipse.emf.ocl.helper.ConstraintType;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.uml.AssociationClass;
import org.eclipse.emf.ocl.uml.AssociationClassEnd;
import org.eclipse.emf.ocl.uml.AssociationEnd;
import org.eclipse.emf.ocl.uml.Qualifier;
import org.eclipse.emf.ocl.uml.UMLFactory;


/**
 * Tests for association navigation (especially with qualifiers) and
 * association class navigation.
 *
 * @author Christian W. Damus (cdamus)
 */
public class AssociationTest
	extends AbstractTestSuite {

	private EReference stem_apple;
	private EReference stem_tree;
	private EAttribute stem_thickness;
	
	private AssociationClassEnd apple_tree;
	
	private EClass tree;
	private AssociationClassEnd tree_apples;
	
	private EClass forest;
	private AssociationEnd forest_trees;
	
	public AssociationTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(AssociationTest.class, "Association Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests support for association end qualifiers.
	 */
	public void test_qualifiers_associationEnd_RATLC00538077() {
		// allowed to specify no qualifiers
		parse(
			"package ocltest context Forest " + //$NON-NLS-1$
			"inv: self.trees->forAll(t : Tree | not t.apples->isEmpty())" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// allowed to specify both qualifiers
		parse(
			"package ocltest context Forest " + //$NON-NLS-1$
			"inv: not self.trees['foo', 3].apples->isEmpty()" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		AssertionFailedError err = null;
		
		try {
			// must specify both qualifiers or none
			parse(
				"package ocltest context Forest " + //$NON-NLS-1$
				"inv: not self.trees['foo'].apples->isEmpty()" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
		
		try {
			// qualifiers must conform
			parse(
				"package ocltest context Forest " + //$NON-NLS-1$
				"inv: not self.trees[3, 'foo'].apples->isEmpty()" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
		
		try {
			// too many qualifiers
			parse(
				"package ocltest context Forest " + //$NON-NLS-1$
				"inv: not self.trees['foo', 3, 'bar'].apples->isEmpty()" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
	}
	
	/**
	 * Tests support for association class navigation.
	 */
	public void test_associationClass_RATLC00538077() {
		// navigate the association end as usual
		parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.apples->forAll(a : Apple | a.color <> Color::black)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// navigate to the association class, itself
		parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.stem->forAll(s : Stem | s.thickness > 0)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests support for association class navigation qualifiers.
	 */
	public void test_associationClass_qualifiers_RATLC00538077() {
		// navigate to the association class using the optional qualifier
		parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.stem[apples]->forAll(s : Stem | s.thickness > 0)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		AssertionFailedError err = null;
		
		try {
			// cannot use role name "tree" as a qualifier
			parse(
				"package ocltest context Tree " + //$NON-NLS-1$
				"inv: self.stem[tree]->forAll(s : Stem | s.thickness > 0)" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
			
		try {
			// cannot use other expressions as qualifiers
			parse(
				"package ocltest context Tree " + //$NON-NLS-1$
				"inv: self.stem[3]->forAll(s : Stem | s.thickness > 0)" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
		
		try {
			// only one qualifier is allowed
			parse(
				"package ocltest context Tree " + //$NON-NLS-1$
				"inv: self.stem[apples, apples]->forAll(s : Stem | s.thickness > 0)" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
	}
	
	/**
	 * Tests support for association class navigation in the case of a
	 * reflexive association.
	 */
	public void test_associationClass_reflexive_RATLC00538077() {
		// set up a reflexive association class for this test case
		AssociationClass ac = UMLFactory.eINSTANCE.createAssociationClass();
		ac.setName("AC"); //$NON-NLS-1$
		fruitPackage.getEClassifiers().add(ac);
		
		EAttribute x = EcoreFactory.eINSTANCE.createEAttribute();
		x.setName("x"); //$NON-NLS-1$
		x.setEType(EcorePackage.eINSTANCE.getEInt());
		ac.getEStructuralFeatures().add(x);
		
		AssociationClassEnd parent = UMLFactory.eINSTANCE.createAssociationClassEnd();
		parent.setName("parent"); //$NON-NLS-1$
		parent.setEType(tree);
		parent.setAssociationClass(ac);
		tree.getEStructuralFeatures().add(parent);
		
		AssociationClassEnd children = UMLFactory.eINSTANCE.createAssociationClassEnd();
		children.setName("children"); //$NON-NLS-1$
		children.setEType(tree);
		children.setUpperBound(-1);
		children.setAssociationClass(ac);
		tree.getEStructuralFeatures().add(children);
		
		EReference parentTree = EcoreFactory.eINSTANCE.createEReference();
		parentTree.setName("parentTree"); //$NON-NLS-1$
		parentTree.setEType(tree);
		parentTree.setEOpposite(parent);
		ac.getEStructuralFeatures().add(parentTree);
		ac.getMemberEnds().add(parentTree);
		
		EReference childTree = EcoreFactory.eINSTANCE.createEReference();
		childTree.setName("childTree"); //$NON-NLS-1$
		childTree.setEType(tree);
		childTree.setEOpposite(children);
		ac.getEStructuralFeatures().add(childTree);
		ac.getMemberEnds().add(childTree);
		
		// navigate the association end as usual
		parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.children->forAll(t : Tree | not t.apples->isEmpty())" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// navigate to the association class, itself, using the role qualifier
		parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.aC[children]->forAll(ac : AC | ac.x > 0)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// this direction is a scalar reference
		parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.aC[parent].x > 0" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		AssertionFailedError err = null;
		
		try {
			// ambiguous navigation to association class
			parse(
				"package ocltest context Tree " + //$NON-NLS-1$
				"inv: self.aC->forAll(ac : AC | ac.x > 0)" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		assertNotNull("Parse should have failed", err); //$NON-NLS-1$
	}
	
	/**
	 * Tests support for navigation from association class to its ends.
	 */
	public void test_navigateFromAssociationClass_RATLC00538077() {
		// navigate the association end.  This end is multiplicity 1..1 by
		//    definition
		parse(
			"package ocltest context Stem " + //$NON-NLS-1$
			"inv: self.apple.color <> Color::black" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// this end, too, is 1..1
		parse(
			"package ocltest context Stem " + //$NON-NLS-1$
			"inv: self.tree.apples->forAll(a : Apple | a.color <> Color::black)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		// I have my own attributes, too
		parse(
			"package ocltest context Stem " + //$NON-NLS-1$
			"inv: self.thickness > 0" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that content-assist suggests association class navigation.
	 */
	public void test_associationClass_contextAssist_RATLC00538077() {
		IOCLHelper helper = HelperUtil.createOclHelper();

		helper.setContext(tree);
		
		try {
			List choices = helper.getSyntaxHelp(ConstraintType.INVARIANT, "this."); //$NON-NLS-1$
			assertNotNull(choices);
			
			// regular reference feature
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "apples"); //$NON-NLS-1$
			
			// association class navigation
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "stem"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by association end call expressions for association classes.
	 */
	public void test_propertyPositions_associationClassEndCall() {
		final String exprString =
			"self.apples->notEmpty()"; //$NON-NLS-1$
		OCLExpression constraint = LocationInformationTest.createInvariant(
			tree, exprString);
		
		OperationCallExp notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		ModelPropertyCallExp mpcExp = LocationInformationTest.asModelPropertyCall(
			notEmptyExp.getSource());
		
		LocationInformationTest.assertPropertyLocation(mpcExp,
			exprString.indexOf("apples"), //$NON-NLS-1$
			exprString.indexOf("->")); //$NON-NLS-1$
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by association class call expressions.
	 */
	public void test_propertyPositions_associationClassCall() {
		final String exprString =
			"self.stem[apples]->notEmpty()"; //$NON-NLS-1$
		OCLExpression constraint = LocationInformationTest.createInvariant(
			tree, exprString);
		
		OperationCallExp notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		// the OCL is implicitly Set{self.stem}->notEmpty()
		CollectionLiteralExp setExp = LocationInformationTest.asCollectionLiteral(
			notEmptyExp.getSource());
		
		ModelPropertyCallExp mpcExp = LocationInformationTest.asModelPropertyCall(
			((CollectionItem) setExp.getParts().get(0)).getItem());
		
		LocationInformationTest.assertPropertyLocation(mpcExp,
			exprString.indexOf("stem"), //$NON-NLS-1$
			exprString.indexOf("[")); //$NON-NLS-1$
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by association class call expressions, where the source is a collection
	 * (so that there is an implicit collect node).
	 */
	public void test_propertyPositions_associationClassCall_implicitCollect() {
		final String exprString =
			"Tree.allInstances().stem[apples]->notEmpty()"; //$NON-NLS-1$
		OCLExpression constraint = LocationInformationTest.createInvariant(
			tree, exprString);
		
		OperationCallExp notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		// the OCL is implicitly ->collect(stem[apples])->notEmpty()
		LoopExp loopExp = LocationInformationTest.asLoop(
			notEmptyExp.getSource());
		
		ModelPropertyCallExp mpcExp = LocationInformationTest.asModelPropertyCall(
			loopExp.getBody());
		
		LocationInformationTest.assertPropertyLocation(mpcExp,
			exprString.indexOf("stem"), //$NON-NLS-1$
			exprString.indexOf("[")); //$NON-NLS-1$
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * as qualifiers of association class call expressions.
	 */
	public void test_propertyPositions_associationClassQualified() {
		final String exprString =
			"self.stem[apples]->notEmpty()"; //$NON-NLS-1$
		OCLExpression constraint = LocationInformationTest.createInvariant(
			tree, exprString);
		
		OperationCallExp notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		// the OCL is implicitly Set{self.stem}->notEmpty()
		CollectionLiteralExp setExp = LocationInformationTest.asCollectionLiteral(
			notEmptyExp.getSource());
		
		AssociationClassCallExp accExp = LocationInformationTest.asAssociationClassCall(
			((CollectionItem) setExp.getParts().get(0)).getItem());
		
		List qualifiers = accExp.getQualifiers();
		assertEquals(1, qualifiers.size());
		
		OCLExpression qualifier = (OCLExpression) qualifiers.get(0);
		
		LocationInformationTest.assertLocation(qualifier,
			exprString.indexOf("apples"), //$NON-NLS-1$
			exprString.indexOf("]->")); //$NON-NLS-1$
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * as qualifiers of association class call expressions, where the source
	 * is a collection (so that there is an implicit collect node).
	 */
	public void test_propertyPositions_associationClassQualified_implicitCollect() {
		final String exprString =
			"Tree.allInstances().stem[apples]->notEmpty()"; //$NON-NLS-1$
		OCLExpression constraint = LocationInformationTest.createInvariant(
			tree, exprString);
		
		OperationCallExp notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		// the OCL is implicitly ->collect(stem[apples])->notEmpty()
		LoopExp loopExp = LocationInformationTest.asLoop(
			notEmptyExp.getSource());
		
		AssociationClassCallExp accExp = LocationInformationTest.asAssociationClassCall(
			loopExp.getBody());
		
		List qualifiers = accExp.getQualifiers();
		assertEquals(1, qualifiers.size());
		
		OCLExpression qualifier = (OCLExpression) qualifiers.get(0);
		
		LocationInformationTest.assertLocation(qualifier,
			exprString.indexOf("apples"), //$NON-NLS-1$
			exprString.indexOf("]->")); //$NON-NLS-1$
	}
	
	/**
	 * Tests that navigation through association ends does not throws NPE
	 * in case that at least one end in the navigation path
	 * (except for the last) is undefined.
	 */
	public void test_associationNullContext_bugzilla121614() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage"); //$NON-NLS-1$
		epackage.setNsPrefix("mypkg"); //$NON-NLS-1$
		epackage.setNsURI("http:///mypkg.ecore"); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
		
		// Employee class
		EClass employee = EcoreFactory.eINSTANCE.createEClass();
		employee.setName("Employee"); //$NON-NLS-1$
		epackage.getEClassifiers().add(employee);

		// manager reference
		EReference manager = EcoreFactory.eINSTANCE.createEReference();
		manager.setName("manager"); //$NON-NLS-1$
		manager.setEType(employee);

		employee.getEStructuralFeatures().add(manager);

		EFactory efactory = epackage.getEFactoryInstance();
		
		// create our test instance
		EObject emp1 = efactory.create(employee);

		// parse & evaluate expression
		try {
			OCLExpression expr = parse(
					"package mypkg context Employee " + //$NON-NLS-1$
					"inv: self.manager.manager" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$

			Object result = evaluate(expr, emp1);
			assertNull(result);
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}

	//
	// Fixture methods
	//
	
	/**
	 * Sets up a common fixture for the association class tests.
	 */
	public void setUp() throws Exception {
		super.setUp();
		
		fruitPackage.getEClassifiers().remove(stem);
		
		// "stem" is more appropriately modeled as an association class
		stem = UMLFactory.eINSTANCE.createAssociationClass();
		stem.setName("Stem"); //$NON-NLS-1$
		
		tree = EcoreFactory.eINSTANCE.createEClass();
		tree.setName("Tree"); //$NON-NLS-1$
		
		fruitPackage.getEClassifiers().add(stem);
		fruitPackage.getEClassifiers().add(tree);
		
		apple.getEStructuralFeatures().remove(apple_stem);
		apple_stem = null;
		
		apple_tree = UMLFactory.eINSTANCE.createAssociationClassEnd();
		apple_tree.setName("tree"); //$NON-NLS-1$
		apple_tree.setEType(tree);
		apple_tree.setAssociationClass(stem);
		apple.getEStructuralFeatures().add(apple_tree);
		
		tree_apples = UMLFactory.eINSTANCE.createAssociationClassEnd();
		tree_apples.setName("apples"); //$NON-NLS-1$
		tree_apples.setEType(apple);
		tree_apples.setUpperBound(-1);
		tree_apples.setAssociationClass(stem);
		tree.getEStructuralFeatures().add(tree_apples);
		
		stem_thickness = EcoreFactory.eINSTANCE.createEAttribute();
		stem_thickness.setName("thickness"); //$NON-NLS-1$
		stem_thickness.setEType(EcorePackage.eINSTANCE.getEInt());
		stem.getEStructuralFeatures().add(stem_thickness);
		
		stem_apple = EcoreFactory.eINSTANCE.createEReference();
		stem_apple.setName("apple"); //$NON-NLS-1$
		stem_apple.setEType(apple);
		stem.getEStructuralFeatures().add(stem_apple);
		((AssociationClass) stem).getMemberEnds().add(stem_apple);
		
		stem_tree = EcoreFactory.eINSTANCE.createEReference();
		stem_tree.setName("tree"); //$NON-NLS-1$
		stem_tree.setEType(tree);
		stem.getEStructuralFeatures().add(stem_tree);
		((AssociationClass) stem).getMemberEnds().add(stem_tree);
		
		// add a Forest::trees association with qualifiers
		forest = EcoreFactory.eINSTANCE.createEClass();
		forest.setName("Forest"); //$NON-NLS-1$
		fruitPackage.getEClassifiers().add(forest);
		
		forest_trees = UMLFactory.eINSTANCE.createAssociationEnd();
		forest_trees.setName("trees"); //$NON-NLS-1$
		forest_trees.setEType(tree);
		forest_trees.setUpperBound(-1);
		forest.getEStructuralFeatures().add(forest_trees);
		
		Qualifier q = UMLFactory.eINSTANCE.createQualifier();
		q.setName("q1"); //$NON-NLS-1$
		q.setEType(EcorePackage.eINSTANCE.getEString());
		forest_trees.getQualifiers().add(q);
		q = UMLFactory.eINSTANCE.createQualifier();
		q.setName("q2"); //$NON-NLS-1$
		q.setEType(EcorePackage.eINSTANCE.getEInt());
		forest_trees.getQualifiers().add(q);
	}
	
	protected void tearDown()
		throws Exception {
		
		super.tearDown();
		
		// delete customizations, to re-initialize schema for subsequent tests
		fruitPackage = null;
	}

}
