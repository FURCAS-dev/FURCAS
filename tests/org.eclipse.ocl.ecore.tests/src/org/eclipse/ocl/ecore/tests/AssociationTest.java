/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2009 IBM Corporation and others.
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
 * $Id: AssociationTest.java,v 1.7 2009/11/28 17:40:10 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collections;
import java.util.List;

import junit.framework.AssertionFailedError;

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
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
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
@SuppressWarnings("nls")
public class AssociationTest
	extends AbstractTestSuite {

	EReference stem_apple;
	EReference stem_tree;
	EAttribute stem_thickness;	
	EReference apple_tree;	
	EClass tree;
	EReference tree_apples;	
	EClass forest;
	EReference forest_trees;	
	EStructuralFeature q1;
	EStructuralFeature q2;
	
	/**
	 * Tests support for association end qualifiers.
	 */
	public void test_qualifiers_associationEnd_RATLC00538077() {
		// allowed to specify no qualifiers
		parse(
			"package ocltest context Forest " +
			"inv: self.trees->forAll(t : Tree | not t.apples->isEmpty())" +
			" endpackage");
		
		// allowed to specify both qualifiers
		parse(
			"package ocltest context Forest " +
			"inv: not self.trees['foo', 3].apples->isEmpty()" +
			" endpackage");
		
		AssertionFailedError err = null;
		
		try {
			// must specify both qualifiers or none
			parse(
				"package ocltest context Forest " +
				"inv: not self.trees['foo'].apples->isEmpty()" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
		
		try {
			// qualifiers must conform
			parse(
				"package ocltest context Forest " +
				"inv: not self.trees[3, 'foo'].apples->isEmpty()" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
		
		try {
			// too many qualifiers
			parse(
				"package ocltest context Forest " +
				"inv: not self.trees['foo', 3, 'bar'].apples->isEmpty()" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
	}
	
	/**
	 * Tests support for association class navigation.
	 */
	public void test_associationClass_RATLC00538077() {
		// navigate the association end as usual
		parse(
			"package ocltest context Tree " +
			"inv: self.apples->forAll(a : Apple | a.color <> Color::black)" +
			" endpackage");
		
		// navigate to the association class, itself
		parse(
			"package ocltest context Tree " +
			"inv: self.stem->forAll(s : Stem | s.thickness > 0)" +
			" endpackage");
	}
	
	/**
	 * Tests support for association class navigation qualifiers.
	 */
	public void test_associationClass_qualifiers_RATLC00538077() {
		// navigate to the association class using the optional qualifier
		parse(
			"package ocltest context Tree " +
			"inv: self.stem[apples]->forAll(s : Stem | s.thickness > 0)" +
			" endpackage");
		
		AssertionFailedError err = null;
		
		try {
			// cannot use role name "tree" as a qualifier
			parse(
				"package ocltest context Tree " +
				"inv: self.stem[tree]->forAll(s : Stem | s.thickness > 0)" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
			
		try {
			// cannot use other expressions as qualifiers
			parse(
				"package ocltest context Tree " +
				"inv: self.stem[3]->forAll(s : Stem | s.thickness > 0)" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
		
		try {
			// only one qualifier is allowed
			parse(
				"package ocltest context Tree " +
				"inv: self.stem[apples, apples]->forAll(s : Stem | s.thickness > 0)" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
	}
	
	/**
	 * Tests support for association class navigation in the case of a
	 * reflexive association.
	 */
	public void test_associationClass_reflexive_RATLC00538077() {
		// set up a reflexive association class for this test case
		EClass ac = EcoreFactory.eINSTANCE.createEClass();
		ac.setName("AC");
		fruitPackage.getEClassifiers().add(ac);
		
		EAttribute x = EcoreFactory.eINSTANCE.createEAttribute();
		x.setName("x");
		x.setEType(EcorePackage.eINSTANCE.getEInt());
		ac.getEStructuralFeatures().add(x);
		
		EReference parent = EcoreFactory.eINSTANCE.createEReference();
		parent.setName("parent");
		parent.setEType(tree);
		tree.getEStructuralFeatures().add(parent);
		
		EReference children = EcoreFactory.eINSTANCE.createEReference();
		children.setName("children");
		children.setEType(tree);
		children.setUpperBound(-1);
		tree.getEStructuralFeatures().add(children);
		
		EReference parentTree = EcoreFactory.eINSTANCE.createEReference();
		parentTree.setName("parentTree");
		parentTree.setEType(tree);
		parentTree.setEOpposite(parent);
		ac.getEStructuralFeatures().add(parentTree);
		
		EReference childTree = EcoreFactory.eINSTANCE.createEReference();
		childTree.setName("childTree");
		childTree.setEType(tree);
		childTree.setEOpposite(children);
		ac.getEStructuralFeatures().add(childTree);
		
		// navigate the association end as usual
		parse(
			"package ocltest context Tree " +
			"inv: self.children->forAll(t : Tree | not t.apples->isEmpty())" +
			" endpackage");
		
		// navigate to the association class, itself, using the role qualifier
		parse(
			"package ocltest context Tree " +
			"inv: self.aC[children]->forAll(ac : AC | ac.x > 0)" +
			" endpackage");
		
		// this direction is a scalar reference
		parse(
			"package ocltest context Tree " +
			"inv: self.aC[parent].x > 0" +
			" endpackage");
		
		AssertionFailedError err = null;
		
		try {
			// ambiguous navigation to association class
			parse(
				"package ocltest context Tree " +
				"inv: self.aC->forAll(ac : AC | ac.x > 0)" +
				" endpackage");
		} catch (AssertionFailedError e) {
			// this is expected (success case)
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage());
		}
		assertNotNull("Parse should have failed", err);
	}
	
	/**
	 * Tests support for navigation from association class to its ends.
	 */
	public void test_navigateFromAssociationClass_RATLC00538077() {
		// navigate the association end.  This end is multiplicity 1..1 by
		//    definition
		parse(
			"package ocltest context Stem " +
			"inv: self.apple.color <> Color::black" +
			" endpackage");
		
		// this end, too, is 1..1
		parse(
			"package ocltest context Stem " +
			"inv: self.tree.apples->forAll(a : Apple | a.color <> Color::black)" +
			" endpackage");
		
		// I have my own attributes, too
		parse(
			"package ocltest context Stem " +
			"inv: self.thickness > 0" +
			" endpackage");
	}
	
	/**
	 * Tests that content-assist suggests association class navigation.
	 */
	public void test_associationClass_contextAssist_RATLC00538077() {
		helper.setContext(tree);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self.");
			assertNotNull(choices);
			
			// regular reference feature
			assertChoice(choices, ChoiceKind.PROPERTY, "apples");
			
			// association class navigation
			assertChoice(choices, ChoiceKind.ASSOCIATION_CLASS, "stem");
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		}
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by association end call expressions for association classes.
	 */
	public void test_propertyPositions_associationClassEndCall() {
		final String exprString =
			"self.apples->notEmpty()";
		OCLExpression<EClassifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<EClassifier, EOperation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		FeatureCallExp<EClassifier> mpcExp = LocationInformationTest.asFeatureCall(
			notEmptyExp.getSource());
		
		LocationInformationTest.assertPropertyLocation(mpcExp,
			exprString.indexOf("apples"),
			exprString.indexOf("->"));
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by association class call expressions.
	 */
	public void test_propertyPositions_associationClassCall() {
		final String exprString =
			"self.stem[apples]->notEmpty()";
		OCLExpression<EClassifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<EClassifier, EOperation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		FeatureCallExp<EClassifier> mpcExp = LocationInformationTest.asFeatureCall(
				notEmptyExp.getSource());
		
		LocationInformationTest.assertPropertyLocation(mpcExp,
			exprString.indexOf("stem"),
			exprString.indexOf("["));
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by association class call expressions, where the source is a collection
	 * (so that there is an implicit collect node).
	 */
	public void test_propertyPositions_associationClassCall_implicitCollect() {
		final String exprString =
			"Tree.allInstances().stem[apples]->notEmpty()";
		OCLExpression<EClassifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<EClassifier, EOperation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		// the OCL is implicitly ->collect(stem[apples])->notEmpty()
		LoopExp<EClassifier, EParameter> loopExp = LocationInformationTest.asLoop(
			notEmptyExp.getSource());
		
		FeatureCallExp<EClassifier> mpcExp = LocationInformationTest.asFeatureCall(
			loopExp.getBody());
		
		LocationInformationTest.assertPropertyLocation(mpcExp,
			exprString.indexOf("stem"),
			exprString.indexOf("["));
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * as qualifiers of association class call expressions.
	 */
	public void test_propertyPositions_associationClassQualified() {
		final String exprString =
			"self.stem[apples]->notEmpty()";
		OCLExpression<EClassifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<EClassifier, EOperation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		AssociationClassCallExp<EClassifier, EStructuralFeature> accExp = LocationInformationTest.asAssociationClassCall(
				notEmptyExp.getSource());
		
		List<OCLExpression<EClassifier>> qualifiers = accExp.getQualifier();
		assertEquals(1, qualifiers.size());
		
		OCLExpression<EClassifier> qualifier = qualifiers.get(0);
		
		LocationInformationTest.assertLocation(qualifier,
			exprString.indexOf("apples"),
			exprString.indexOf("]->"));
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * as qualifiers of association class call expressions, where the source
	 * is a collection (so that there is an implicit collect node).
	 */
	public void test_propertyPositions_associationClassQualified_implicitCollect() {
		final String exprString =
			"Tree.allInstances().stem[apples]->notEmpty()";
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
			exprString.indexOf("apples"),
			exprString.indexOf("]->"));
	}
	
	/**
	 * Tests that navigation through association ends does not throws NPE
	 * in case that at least one end in the navigation path
	 * (except for the last) is undefined.
	 */
	public void test_associationNullContext_bugzilla121614() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("MyPackage");
		epackage.setNsPrefix("mypkg");
		epackage.setNsURI("http:///mypkg.ecore");
		resourceSet.getPackageRegistry().put(epackage.getNsURI(), epackage);
		
		// Employee class
		EClass employee = EcoreFactory.eINSTANCE.createEClass();
		employee.setName("Employee");
		epackage.getEClassifiers().add(employee);

		// manager reference
		EReference manager = EcoreFactory.eINSTANCE.createEReference();
		manager.setName("manager");
		manager.setEType(employee);

		employee.getEStructuralFeatures().add(manager);

		EFactory efactory = epackage.getEFactoryInstance();
		
		// create our test instance
		EObject emp1 = efactory.create(employee);

		// parse & evaluate expression
		OCLExpression<EClassifier> expr = parse(
				"package mypkg context Employee " +
				"inv: self.manager.manager" +
				" endpackage");

		Object result = evaluate(expr, emp1);
		assertInvalid(result);
	}
	
	/**
	 * Tests that the result of qualifying an association navigation is a
	 * scalar value (not a collection).
	 */
	public void test_qualifiedAssociation_scalar_133435() {
		// unqualified navigation
		OCLExpression<EClassifier> expr = parse(
				"package ocltest context Forest " +
				"inv: self.trees" +
				" endpackage");
			
		assertTrue(expr.getType() instanceof CollectionType);
		CollectionType collType = (CollectionType) expr.getType();
		assertSame(tree, collType.getElementType());
		
		// qualified navigation
		expr = parse(
			"package ocltest context Forest " +
			"inv: self.trees['foo', 3]" +
			" endpackage");
		
		assertSame(tree, expr.getType());
	}

	//
	// Fixture methods
	//
	
	/**
	 * Sets up a common fixture for the association class tests.
	 */
	@Override
    public void setUp() {
		super.setUp();
		expectModified = true;
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
		stem.setName("Stem");
		
		tree = EcoreFactory.eINSTANCE.createEClass();
		tree.setName("Tree");
		
		fruitPackage.getEClassifiers().add(stem);
		fruitPackage.getEClassifiers().add(tree);
		
		apple.getEStructuralFeatures().remove(apple_stem);
		apple_stem = null;
		
		apple_tree = EcoreFactory.eINSTANCE.createEReference();
		apple_tree.setName("tree");
		apple_tree.setEType(tree);
		apple.getEStructuralFeatures().add(apple_tree);
		
		tree_apples = EcoreFactory.eINSTANCE.createEReference();
		tree_apples.setName("apples");
		tree_apples.setEType(apple);
		tree_apples.setUpperBound(-1);
		tree.getEStructuralFeatures().add(tree_apples);
		
		stem_thickness = EcoreFactory.eINSTANCE.createEAttribute();
		stem_thickness.setName("thickness");
		stem_thickness.setEType(EcorePackage.eINSTANCE.getEInt());
		stem.getEStructuralFeatures().add(stem_thickness);
		
		stem_apple = EcoreFactory.eINSTANCE.createEReference();
		stem_apple.setName("apple");
		stem_apple.setEType(apple);
		stem.getEStructuralFeatures().add(stem_apple);
		
		stem_tree = EcoreFactory.eINSTANCE.createEReference();
		stem_tree.setName("tree");
		stem_tree.setEType(tree);
		stem.getEStructuralFeatures().add(stem_tree);
		
		// add a Forest::trees association with qualifiers
		forest = EcoreFactory.eINSTANCE.createEClass();
		forest.setName("Forest");
		fruitPackage.getEClassifiers().add(forest);
		
		forest_trees = EcoreFactory.eINSTANCE.createEReference();
		forest_trees.setName("trees");
		forest_trees.setEType(tree);
		forest_trees.setUpperBound(-1);
		forest.getEStructuralFeatures().add(forest_trees);
		
		q1 = EcoreFactory.eINSTANCE.createEAttribute();
		q1.setName("q1");
		q1.setEType(EcorePackage.eINSTANCE.getEString());
		q2 = EcoreFactory.eINSTANCE.createEAttribute();
		q2.setName("q2");
		q2.setEType(EcorePackage.eINSTANCE.getEInt());
	}
	
	@Override
	protected OCL createOCL() {
		return OCL.newInstance(new AssocClassFruitEnvironmentFactory());
	}
	
	@Override
    protected void tearDown()
		throws Exception {
		
		super.tearDown();
		
		// delete customizations, to re-initialize schema for subsequent tests
		fruitPackage = null;
	}
	
	private class AssocClassFruitEnvironmentFactory extends EcoreEnvironmentFactory {

		public AssocClassFruitEnvironmentFactory() {
			super(resourceSet.getPackageRegistry());
		}
		
		@Override
        public EcoreEnvironment createEnvironment() {
			return new AssocClassFruitEnvironment(this);
		}

		@Override
        public EcoreEnvironment createEnvironment(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			return new AssocClassFruitEnvironment(parent);
		}
	}
	
	private class AssocClassFruitEnvironment extends EcoreEnvironment implements InitEnvironment {
		private List<EStructuralFeature> stemEnds =
			new java.util.ArrayList<EStructuralFeature>(2);
		
		private List<EStructuralFeature> qualifiers =
			new java.util.ArrayList<EStructuralFeature>(2);
		
		public AssocClassFruitEnvironment(AssocClassFruitEnvironmentFactory factory) {
			super(factory, null);
			setContextPackage(fruitPackage);
			
	//		init();
		}
		
		public AssocClassFruitEnvironment(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			super(parent);
			
	//		init();
		}

		public void init() {
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
        			return eclass == stem || eclass.getName().equals("AC");
        		}
        		
        		@Override
        		public EClass getAssociationClass(EStructuralFeature reference) {
        			if (reference == tree_apples || reference == apple_tree) {
        				return stem;
        			} else if (reference.getName().equals("parent")
        					|| reference.getName().equals("children")) {
        				return (EClass) fruitPackage.getEClassifier("AC");
        			}
        			
        			return null;
        		}
        		
        		@Override
        		public List<EStructuralFeature> getMemberEnds(
        				EClassifier associationClass) {
        			
        			if (associationClass == stem) {
        				return stemEnds;
        			} else if (associationClass.getName().equals("AC")) {
        				EClass ac = (EClass) associationClass;
        				
        				List<EStructuralFeature> result = new java.util.ArrayList<EStructuralFeature>(2);
        				result.add(ac.getEStructuralFeature("parentTree"));
        				result.add(ac.getEStructuralFeature("childTree"));
        				
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
