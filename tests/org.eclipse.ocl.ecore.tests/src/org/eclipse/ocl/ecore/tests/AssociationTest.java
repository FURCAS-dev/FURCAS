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
 * $Id: AssociationTest.java,v 1.2 2007/02/14 14:45:48 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collections;
import java.util.List;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.utilities.UMLReflection;


/**
 * Tests for association navigation.
 *
 * @author Christian W. Damus (cdamus)
 */
public class AssociationTest
	extends AbstractTestSuite {

	private EReference stem_apple;
	private EReference stem_tree;
	private EAttribute stem_thickness;
	
	private EReference apple_tree;
	
	private EClass tree;
	private EReference tree_apples;
	
	private EClass forest;
	private EReference forest_trees;
	
	private EStructuralFeature q1;
	private EStructuralFeature q2;
	
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
		EClass ac = EcoreFactory.eINSTANCE.createEClass();
		ac.setName("AC"); //$NON-NLS-1$
		fruitPackage.getEClassifiers().add(ac);
		
		EAttribute x = EcoreFactory.eINSTANCE.createEAttribute();
		x.setName("x"); //$NON-NLS-1$
		x.setEType(EcorePackage.eINSTANCE.getEInt());
		ac.getEStructuralFeatures().add(x);
		
		EReference parent = EcoreFactory.eINSTANCE.createEReference();
		parent.setName("parent"); //$NON-NLS-1$
		parent.setEType(tree);
		tree.getEStructuralFeatures().add(parent);
		
		EReference children = EcoreFactory.eINSTANCE.createEReference();
		children.setName("children"); //$NON-NLS-1$
		children.setEType(tree);
		children.setUpperBound(-1);
		tree.getEStructuralFeatures().add(children);
		
		EReference parentTree = EcoreFactory.eINSTANCE.createEReference();
		parentTree.setName("parentTree"); //$NON-NLS-1$
		parentTree.setEType(tree);
		parentTree.setEOpposite(parent);
		ac.getEStructuralFeatures().add(parentTree);
		
		EReference childTree = EcoreFactory.eINSTANCE.createEReference();
		childTree.setName("childTree"); //$NON-NLS-1$
		childTree.setEType(tree);
		childTree.setEOpposite(children);
		ac.getEStructuralFeatures().add(childTree);
		
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
		helper.setContext(tree);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "this."); //$NON-NLS-1$
			assertNotNull(choices);
			
			// regular reference feature
			assertChoice(choices, ChoiceKind.PROPERTY, "apples"); //$NON-NLS-1$
			
			// association class navigation
			assertChoice(choices, ChoiceKind.ASSOCIATION_CLASS, "stem"); //$NON-NLS-1$
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
		OCLExpression<EClassifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<EClassifier, EOperation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		FeatureCallExp<EClassifier> mpcExp = LocationInformationTest.asFeatureCall(
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
		OCLExpression<EClassifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<EClassifier, EOperation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		FeatureCallExp<EClassifier> mpcExp = LocationInformationTest.asFeatureCall(
				notEmptyExp.getSource());
		
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
		OCLExpression<EClassifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<EClassifier, EOperation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		// the OCL is implicitly ->collect(stem[apples])->notEmpty()
		LoopExp<EClassifier, EParameter> loopExp = LocationInformationTest.asLoop(
			notEmptyExp.getSource());
		
		FeatureCallExp<EClassifier> mpcExp = LocationInformationTest.asFeatureCall(
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
		OCLExpression<EClassifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<EClassifier, EOperation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		AssociationClassCallExp<EClassifier, EStructuralFeature> accExp = LocationInformationTest.asAssociationClassCall(
				notEmptyExp.getSource());
		
		List<OCLExpression<EClassifier>> qualifiers = accExp.getQualifier();
		assertEquals(1, qualifiers.size());
		
		OCLExpression<EClassifier> qualifier = qualifiers.get(0);
		
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
		OCLExpression<EClassifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<EClassifier, EOperation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		// the OCL is implicitly ->collect(stem[apples])->notEmpty()
		LoopExp<EClassifier, EParameter> loopExp = LocationInformationTest.asLoop(
			notEmptyExp.getSource());
		
		AssociationClassCallExp<EClassifier, EStructuralFeature> accExp = LocationInformationTest.asAssociationClassCall(
			loopExp.getBody());
		
		List<OCLExpression<EClassifier>> qualifiers = accExp.getQualifier();
		assertEquals(1, qualifiers.size());
		
		OCLExpression<EClassifier> qualifier = qualifiers.get(0);
		
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
			OCLExpression<EClassifier> expr = parse(
					"package mypkg context Employee " + //$NON-NLS-1$
					"inv: self.manager.manager" + //$NON-NLS-1$
					" endpackage"); //$NON-NLS-1$

			Object result = evaluate(expr, emp1);
			assertInvalid(result);
		} finally {
			EPackage.Registry.INSTANCE.remove(epackage.getNsURI());
		}
	}
	
	/**
	 * Tests that the result of qualifying an association navigation is a
	 * scalar value (not a collection).
	 */
	public void test_qualifiedAssociation_scalar_133435() {
		// unqualified navigation
		OCLExpression<EClassifier> expr = parse(
				"package ocltest context Forest " + //$NON-NLS-1$
				"inv: self.trees" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$
			
		assertTrue(expr.getType() instanceof CollectionType);
		CollectionType collType = (CollectionType) expr.getType();
		assertSame(tree, collType.getElementType());
		
		// qualified navigation
		expr = parse(
			"package ocltest context Forest " + //$NON-NLS-1$
			"inv: self.trees['foo', 3]" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		assertSame(tree, expr.getType());
	}

	//
	// Fixture methods
	//
	
	/**
	 * Sets up a common fixture for the association class tests.
	 */
	public void setUp() throws Exception {
		super.setUp();
		
		initFruitExtensions();
	}
	
	private void initFruitExtensions() {
		if (q1 != null) {
			// already inited
			return;
		}
		
		fruitPackage.getEClassifiers().remove(stem);
		
		// "stem" is more appropriately modeled as an association class
		stem = EcoreFactory.eINSTANCE.createEClass();
		stem.setName("Stem"); //$NON-NLS-1$
		
		tree = EcoreFactory.eINSTANCE.createEClass();
		tree.setName("Tree"); //$NON-NLS-1$
		
		fruitPackage.getEClassifiers().add(stem);
		fruitPackage.getEClassifiers().add(tree);
		
		apple.getEStructuralFeatures().remove(apple_stem);
		apple_stem = null;
		
		apple_tree = EcoreFactory.eINSTANCE.createEReference();
		apple_tree.setName("tree"); //$NON-NLS-1$
		apple_tree.setEType(tree);
		apple.getEStructuralFeatures().add(apple_tree);
		
		tree_apples = EcoreFactory.eINSTANCE.createEReference();
		tree_apples.setName("apples"); //$NON-NLS-1$
		tree_apples.setEType(apple);
		tree_apples.setUpperBound(-1);
		tree.getEStructuralFeatures().add(tree_apples);
		
		stem_thickness = EcoreFactory.eINSTANCE.createEAttribute();
		stem_thickness.setName("thickness"); //$NON-NLS-1$
		stem_thickness.setEType(EcorePackage.eINSTANCE.getEInt());
		stem.getEStructuralFeatures().add(stem_thickness);
		
		stem_apple = EcoreFactory.eINSTANCE.createEReference();
		stem_apple.setName("apple"); //$NON-NLS-1$
		stem_apple.setEType(apple);
		stem.getEStructuralFeatures().add(stem_apple);
		
		stem_tree = EcoreFactory.eINSTANCE.createEReference();
		stem_tree.setName("tree"); //$NON-NLS-1$
		stem_tree.setEType(tree);
		stem.getEStructuralFeatures().add(stem_tree);
		
		// add a Forest::trees association with qualifiers
		forest = EcoreFactory.eINSTANCE.createEClass();
		forest.setName("Forest"); //$NON-NLS-1$
		fruitPackage.getEClassifiers().add(forest);
		
		forest_trees = EcoreFactory.eINSTANCE.createEReference();
		forest_trees.setName("trees"); //$NON-NLS-1$
		forest_trees.setEType(tree);
		forest_trees.setUpperBound(-1);
		forest.getEStructuralFeatures().add(forest_trees);
		
		q1 = EcoreFactory.eINSTANCE.createEAttribute();
		q1.setName("q1"); //$NON-NLS-1$
		q1.setEType(EcorePackage.eINSTANCE.getEString());
		q2 = EcoreFactory.eINSTANCE.createEAttribute();
		q2.setName("q2"); //$NON-NLS-1$
		q2.setEType(EcorePackage.eINSTANCE.getEInt());
	}
	
	@Override
	protected OCL createOCL() {
		return OCL.newInstance(new AssocClassFruitEnvironmentFactory());
	}
	
	protected void tearDown()
		throws Exception {
		
		super.tearDown();
		
		// delete customizations, to re-initialize schema for subsequent tests
		fruitPackage = null;
	}
	
	private class AssocClassFruitEnvironmentFactory extends EcoreEnvironmentFactory {

		public EcoreEnvironment createEnvironment() {
			return new AssocClassFruitEnvironment(this);
		}

		public EcoreEnvironment createEnvironment(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			return new AssocClassFruitEnvironment(this, parent);
		}
	}
	
	private class AssocClassFruitEnvironment extends EcoreEnvironment {
		private List<EStructuralFeature> stemEnds =
			new java.util.ArrayList<EStructuralFeature>(2);
		
		private List<EStructuralFeature> qualifiers =
			new java.util.ArrayList<EStructuralFeature>(2);
		
		public AssocClassFruitEnvironment(AssocClassFruitEnvironmentFactory factory) {
			super(EPackage.Registry.INSTANCE);
			
			setFactory(factory);
			setContextPackage(fruitPackage);
			
			init();
		}
		
		public AssocClassFruitEnvironment(
				AssocClassFruitEnvironmentFactory factory,
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			super(parent);
			
			setFactory(factory);
			
			init();
		}

		private void init() {
			initFruitExtensions();
			
			stemEnds.add(stem_tree);
			stemEnds.add(stem_apple);
			
			qualifiers.add(q1);
			qualifiers.add(q2);
		}
		
        @Override
        public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
            return new UMLReflectionImpl() {
        		@Override
        		public boolean isAssociationClass(EClassifier eclass) {
        			return eclass == stem || eclass.getName().equals("AC"); //$NON-NLS-1$
        		}
        		
        		@Override
        		public EClass getAssociationClass(EStructuralFeature reference) {
        			if (reference == tree_apples || reference == apple_tree) {
        				return stem;
        			} else if (reference.getName().equals("parent") //$NON-NLS-1$
        					|| reference.getName().equals("children")) { //$NON-NLS-1$
        				return (EClass) fruitPackage.getEClassifier("AC"); //$NON-NLS-1$
        			}
        			
        			return null;
        		}
        		
        		@Override
        		public List<EStructuralFeature> getMemberEnds(
        				EClassifier associationClass) {
        			
        			if (associationClass == stem) {
        				return stemEnds;
        			} else if (associationClass.getName().equals("AC")) { //$NON-NLS-1$
        				EClass ac = (EClass) associationClass;
        				
        				List<EStructuralFeature> result = new java.util.ArrayList<EStructuralFeature>(2);
        				result.add(ac.getEStructuralFeature("parentTree")); //$NON-NLS-1$
        				result.add(ac.getEStructuralFeature("childTree")); //$NON-NLS-1$
        				
        				return result;
        			}
        			
        			return Collections.emptyList();
        		}
        		
        		@Override
        		public List<EStructuralFeature> getQualifiers(EStructuralFeature property) {
        			if (property == forest_trees) {
        				return qualifiers;
        			}
        			
        			return Collections.emptyList();
        		}};
        }
	}

}
