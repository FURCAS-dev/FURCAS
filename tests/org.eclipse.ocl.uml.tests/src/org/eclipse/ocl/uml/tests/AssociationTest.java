/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 251808
 *
 * </copyright>
 *
 * $Id: AssociationTest.java,v 1.9 2009/10/07 20:41:44 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Collection;
import java.util.List;

import junit.framework.AssertionFailedError;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.ocl.AmbiguousLookupException;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.options.ProblemOption;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.uml.options.UMLParsingOptions;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Tests for association navigation.
 *
 * @author Christian W. Damus (cdamus)
 */
public class AssociationTest
	extends AbstractTestSuite {

	Resource instanceResource;
	Package instancePackage;
	
	/**
	 * Tests support for association end qualifiers.
	 */
	public void test_qualifiers_associationEnd_RATLC00538077() {
		InstanceSpecification aForest = instantiate(instancePackage, forest);
		
		InstanceSpecification aTree = instantiate(instancePackage, tree);
		InstanceSpecification anotherTree = instantiate(instancePackage, tree);
		
		Collection<InstanceSpecification> trees =
			new java.util.HashSet<InstanceSpecification>();
		
		trees.add(aTree);
		trees.add(anotherTree);
		
		link(instancePackage,
				aForest, forest_trees,
				new Object[] {"foo", 3}, //$NON-NLS-1$
				aTree, a_forest_tree_forest,
				a_forest_tree);
		
		link(instancePackage,
				aForest, forest_trees,
				new Object[] {"bar", 2}, //$NON-NLS-1$
				anotherTree, a_forest_tree_forest,
				a_forest_tree);
		
		// allowed to specify no qualifiers
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Forest " + //$NON-NLS-1$
			"inv: self.trees->asSet()" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		Object result = evaluate(expr, aForest);
		
		assertEquals(trees, result);
		
		// allowed to specify both qualifiers
		expr = parse(
			"package ocltest context Forest " + //$NON-NLS-1$
			"inv: self.trees['bar', 2]" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		result = evaluate(expr, aForest);
		
		assertSame(anotherTree, result);
		
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
		InstanceSpecification aTree = instantiate(instancePackage, tree);
		
		InstanceSpecification anApple = instantiate(instancePackage, apple);
		setValue(anApple, fruit_color, color_red);
		
		InstanceSpecification anotherApple = instantiate(instancePackage, apple);
		setValue(anotherApple, fruit_color, color_green);
		
		InstanceSpecification aStem = link(instancePackage,
				aTree, tree_apples,
				anApple, apple_tree,
				stem);
		setValue(aStem, stem_length, 3);
		
		InstanceSpecification anotherStem = link(instancePackage,
				aTree, tree_apples,
				anotherApple, apple_tree,
				stem);
		setValue(anotherStem, stem_length, 2);
		
		// navigate the association end as usual
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.apples->forAll(a : Apple | a.color <> Color::black)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		assertTrue(check(expr, aTree));
		
		setValue(anotherApple, fruit_color, color_black);
		assertFalse(check(expr, aTree));
		
		// navigate to the association class, itself
		expr = parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.stem->forAll(s : Stem | s.length > 0)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		assertTrue(check(expr, aTree));
		
		setValue(anotherStem, stem_length, 0);
		assertFalse(check(expr, aTree));
	}
    
    /**
     * Tests support for association class navigation in a scalar (multiplicity
     * upper bound is 1) direction.
     */
    public void test_associationClass_scalar_182193() {
        InstanceSpecification aTree = instantiate(instancePackage, tree);
        setValue(aTree, tree_height, 30);
        
        InstanceSpecification anApple = instantiate(instancePackage, apple);
        setValue(anApple, fruit_color, color_red);
        
        InstanceSpecification anotherApple = instantiate(instancePackage, apple);
        setValue(anotherApple, fruit_color, color_green);
        
        InstanceSpecification aStem = link(instancePackage,
                aTree, tree_apples,
                anApple, apple_tree,
                stem);
        setValue(aStem, stem_length, 3);
        
        InstanceSpecification anotherStem = link(instancePackage,
                aTree, tree_apples,
                anotherApple, apple_tree,
                stem);
        setValue(anotherStem, stem_length, 2);
        
        // navigate the association end as usual
        OCLExpression<Classifier> expr = parse(
            "package ocltest context Apple " + //$NON-NLS-1$
            "inv: self.tree.height > 20" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$
        
        assertTrue(check(expr, anApple));
        
        setValue(aTree, tree_height, 20);
        assertFalse(check(expr, anApple));
        
        // navigate to the association class, itself
        expr = parse(
            "package ocltest context Apple " + //$NON-NLS-1$
            "inv: self.stem.length > 0" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$
        
        assertTrue(check(expr, anApple));
        
        setValue(anotherStem, stem_length, 0);
        assertFalse(check(expr, anotherApple));
    }
	
	/**
	 * Tests support for association class navigation qualifiers.
	 */
	public void test_associationClass_qualifiers_RATLC00538077() {
		InstanceSpecification aTree = instantiate(instancePackage, tree);
		
		InstanceSpecification anApple = instantiate(instancePackage, apple);
		setValue(anApple, fruit_color, color_red);
		
		InstanceSpecification anotherApple = instantiate(instancePackage, apple);
		setValue(anotherApple, fruit_color, color_green);
		
		InstanceSpecification aStem = link(instancePackage,
				aTree, tree_apples,
				anApple, apple_tree,
				stem);
		setValue(aStem, stem_length, 3);
		
		InstanceSpecification anotherStem = link(instancePackage,
				aTree, tree_apples,
				anotherApple, apple_tree,
				stem);
		setValue(anotherStem, stem_length, 2);
		
		// navigate to the association class using the optional qualifier
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.stem[apples]->forAll(s : Stem | s.length > 0)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		assertTrue(check(expr, aTree));
		
		AssertionFailedError err = null;
		
		try {
			// cannot use role name "tree" as a qualifier
			parse(
				"package ocltest context Tree " + //$NON-NLS-1$
				"inv: self.stem[tree]->forAll(s : Stem | s.length > 0)" + //$NON-NLS-1$
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
				"inv: self.stem[3]->forAll(s : Stem | s.length > 0)" + //$NON-NLS-1$
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
				"inv: self.stem[apples, apples]->forAll(s : Stem | s.length > 0)" + //$NON-NLS-1$
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
		expectModified = true;
		// set up a reflexive association class for this test case
		AssociationClass ac = (AssociationClass) fruitPackage.createOwnedType("AC", //$NON-NLS-1$
				uml.getAssociationClass());
		
		Property x = ac.createOwnedAttribute("x", //$NON-NLS-1$
				getUMLInteger());
		
		Property parent = tree.createOwnedAttribute("parent", //$NON-NLS-1$
				tree);
		parent.setLower(0);
		parent.setIsUnique(true);
		parent.setIsOrdered(false);
		
		Property children = tree.createOwnedAttribute("children", //$NON-NLS-1$
				tree);
		children.setLower(0);
		children.setUpper(LiteralUnlimitedNatural.UNLIMITED);
		children.setIsUnique(true);
		children.setIsOrdered(false);
		
		parent.setAssociation(ac);
		children.setAssociation(ac);
		
		// create some instances
		InstanceSpecification aTree = instantiate(instancePackage, tree);
		
		InstanceSpecification aChild = instantiate(instancePackage, tree);
		InstanceSpecification anotherChild = instantiate(instancePackage, tree);
		
		InstanceSpecification aLink = link(instancePackage,
				aTree, children,
				aChild, parent,
				ac);
		setValue(aLink, x, 3);
		
		InstanceSpecification anotherLink = link(instancePackage,
				aTree, children,
				anotherChild, parent,
				ac);
		setValue(anotherLink, x, 2);
		
		// navigate the association end as usual
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.children->forAll(t : Tree | t.apples->isEmpty())" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		assertTrue(check(expr, aTree));
		
		link(instancePackage,
				anotherChild, tree_apples,
				instantiate(instancePackage, apple), apple_tree,
				null);
		
		assertFalse(check(expr, aTree));
		
		// navigate to the association class, itself, using the role qualifier
		expr = parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.aC[children]->forAll(ac : AC | ac.x > 0)" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		assertTrue(check(expr, aTree));
		
		setValue(anotherLink, x, 0);
		assertFalse(check(expr, aTree));
		
		// this direction is a scalar reference
		expr = parse(
			"package ocltest context Tree " + //$NON-NLS-1$
			"inv: self.aC[parent].x > 0" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		assertTrue(check(expr, aChild));
		assertFalse(check(expr, anotherChild));
		
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
		InstanceSpecification aTree = instantiate(instancePackage, tree);
		setValue(aTree, tree_height, 20);
        
		InstanceSpecification anApple = instantiate(instancePackage, apple);
		setValue(anApple, fruit_color, color_red);
		
		InstanceSpecification anotherApple = instantiate(instancePackage, apple);
		setValue(anotherApple, fruit_color, color_black);
		
		InstanceSpecification aStem = link(instancePackage,
				aTree, tree_apples,
				anApple, apple_tree,
				stem);
		setValue(aStem, stem_length, 3);
		
		InstanceSpecification anotherStem = link(instancePackage,
				aTree, tree_apples,
				anotherApple, apple_tree,
				stem);
		setValue(anotherStem, stem_length, 0);
		
		// navigate the association end.  This end is multiplicity 1..1 by
		//    definition
		OCLExpression<Classifier> expr = parse(
			"package ocltest context Stem " + //$NON-NLS-1$
			"inv: self.apples.color <> Color::black" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		assertTrue(check(expr, aStem));
		assertFalse(check(expr, anotherStem));
		
		// this end, too, is 1..1
		expr = parse(
			"package ocltest context Stem " + //$NON-NLS-1$
			"inv: self.tree.height > 20" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		assertFalse(check(expr, aStem));
		assertFalse(check(expr, anotherStem));
		
		setValue(aTree, tree_height, 30);
		assertTrue(check(expr, aStem));
		assertTrue(check(expr, anotherStem));
		
		// I have my own attributes, too
		expr = parse(
			"package ocltest context Stem " + //$NON-NLS-1$
			"inv: self.length > 0" + //$NON-NLS-1$
			" endpackage"); //$NON-NLS-1$
		
		assertTrue(check(expr, aStem));
		assertFalse(check(expr, anotherStem));
	}
	
	/**
	 * Tests that content-assist suggests association class navigation.
	 */
	public void test_associationClass_contentAssist_RATLC00538077() {
		helper.setContext(tree);
		
		try {
			List<Choice> choices = helper.getSyntaxHelp(
					ConstraintKind.INVARIANT, "self."); //$NON-NLS-1$
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
		OCLExpression<Classifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<Classifier, Operation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		FeatureCallExp<Classifier> mpcExp = LocationInformationTest.asFeatureCall(
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
		OCLExpression<Classifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<Classifier, Operation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		FeatureCallExp<Classifier> mpcExp = LocationInformationTest.asFeatureCall(
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
		OCLExpression<Classifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<Classifier, Operation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		// the OCL is implicitly ->collect(stem[apples])->notEmpty()
		LoopExp<Classifier, Parameter> loopExp = LocationInformationTest.asLoop(
			notEmptyExp.getSource());
		
		FeatureCallExp<Classifier> mpcExp = LocationInformationTest.asFeatureCall(
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
		OCLExpression<Classifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<Classifier, Operation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		AssociationClassCallExp<Classifier, Property> accExp =
			LocationInformationTest.asAssociationClassCall(notEmptyExp.getSource());
		
		List<OCLExpression<Classifier>> qualifiers = accExp.getQualifier();
		assertEquals(1, qualifiers.size());
		
		OCLExpression<Classifier> qualifier = qualifiers.get(0);
		
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
		OCLExpression<Classifier> constraint = createQuery(tree, exprString);
		
		OperationCallExp<Classifier, Operation> notEmptyExp = LocationInformationTest.asOperationCall(
			constraint);
		
		// the OCL is implicitly ->collect(stem[apples])->notEmpty()
		LoopExp<Classifier, Parameter> loopExp = LocationInformationTest.asLoop(
			notEmptyExp.getSource());
		
		AssociationClassCallExp<Classifier, Property> accExp = LocationInformationTest.asAssociationClassCall(
			loopExp.getBody());
		
		List<OCLExpression<Classifier>> qualifiers = accExp.getQualifier();
		assertEquals(1, qualifiers.size());
		
		OCLExpression<Classifier> qualifier = qualifiers.get(0);
		
		LocationInformationTest.assertLocation(qualifier,
			exprString.indexOf("apples"), //$NON-NLS-1$
			exprString.indexOf("]->")); //$NON-NLS-1$
	}
	
	/**
	 * Tests that navigation through association ends does not throw NPE
	 * in case that at least one end in the navigation path
	 * (except for the last) is undefined.
	 */
	public void test_associationNullContext_bugzilla121614() {
		// Employee class
		Class employee = instancePackage.createOwnedClass("Employee", false); //$NON-NLS-1$
		
		// manager reference
		employee.createOwnedAttribute("manager", employee); //$NON-NLS-1$
				
		// create our test instance
		InstanceSpecification emp1 = instantiate(instancePackage, employee);

		// parse & evaluate expression
		OCLExpression<Classifier> expr = parse(
				"package instances context Employee " + //$NON-NLS-1$
				"inv: self.manager.manager" + //$NON-NLS-1$
				" endpackage"); //$NON-NLS-1$

		Object result = evaluate(expr, emp1);
		assertInvalid(result);
	}
	
	/**
	 * Tests that the result of qualifying an association navigation is a
	 * scalar value (not a collection).
	 */
	public void test_qualifiedAssociation_scalar_133435() {
		// unqualified navigation
		OCLExpression<Classifier> expr = parse(
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

    public void test_nonNavigableAttribute() {
        OCLExpression<Classifier> expr = parseConstraint("package ocltest context Tree " + //$NON-NLS-1$
            "inv: forest.trees->includes(self)" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        EPackage epackage = UMLUtil.convertToEcore(fruitPackage, null)
            .iterator().next();
        EFactory factory = epackage.getEFactoryInstance();

        // create a resource to provide the context of instance searches
        Resource res = new ResourceImpl(URI.createURI("test://foo")); //$NON-NLS-1$
        res.eAdapters().add(new ECrossReferenceAdapter());

        resourceSet.getPackageRegistry().put(epackage.getNsURI(), epackage);

        try {
            EClass eTree = (EClass) epackage.getEClassifier("Tree"); //$NON-NLS-1$
            EClass eForest = (EClass) epackage.getEClassifier("Forest"); //$NON-NLS-1$
            EStructuralFeature eTrees = eForest.getEStructuralFeature("trees"); //$NON-NLS-1$

            EObject aForest = factory.create(eForest);
            res.getContents().add(aForest);

            @SuppressWarnings("unchecked")
            EList<EObject> trees = (EList<EObject>) aForest.eGet(eTrees);
            EObject aTree = factory.create(eTree);
            res.getContents().add(aTree);
            trees.add(aTree);
            EObject anotherTree = factory.create(eTree);
            res.getContents().add(anotherTree);
            trees.add(anotherTree);
            aTree = factory.create(eTree);
            res.getContents().add(aTree);
            trees.add(aTree);

            assertTrue(check(expr, anotherTree));
        } finally {
            res.unload();
        }
    }

    public void test_nonNavigableAttribute_instanceSpecification() {
        OCLExpression<Classifier> expr = parseConstraint("package ocltest context Tree " + //$NON-NLS-1$
            "inv: forest.trees->includes(self)" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        InstanceSpecification aForest = instantiate(instancePackage, forest);

        InstanceSpecification aTree = instantiate(instancePackage, tree);
        addValue(aForest, forest_trees, aTree);
        InstanceSpecification anotherTree = instantiate(instancePackage, tree);
        addValue(aForest, forest_trees, anotherTree);
        aTree = instantiate(instancePackage, tree);
        addValue(aForest, forest_trees, aTree);

        assertTrue(check(expr, anotherTree));
    }

    public void test_unnamedAttribute_194245() {
        expectModified = true;
        Property tree_forest = forest_trees.getOtherEnd();
        assertNotNull(tree_forest);
        assertNotNull(tree_forest.getName());
        tree_forest.setName(null); // unnamed end
        
        // create a resource to provide the context of instance searches
        Resource res = new ResourceImpl(URI.createURI("test://foo")); //$NON-NLS-1$
        res.eAdapters().add(new ECrossReferenceAdapter());

        OCLExpression<Classifier> expr = parseConstraint("package ocltest context Tree " + //$NON-NLS-1$
            "inv: forest.trees->includes(self)" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        EPackage epackage = UMLUtil.convertToEcore(fruitPackage, null)
            .iterator().next();
        EFactory factory = epackage.getEFactoryInstance();

        resourceSet.getPackageRegistry().put(epackage.getNsURI(), epackage);

        EClass eTree = (EClass) epackage.getEClassifier("Tree"); //$NON-NLS-1$
        EClass eForest = (EClass) epackage.getEClassifier("Forest"); //$NON-NLS-1$
        EStructuralFeature eTrees = eForest.getEStructuralFeature("trees"); //$NON-NLS-1$

        EObject aForest = factory.create(eForest);
        res.getContents().add(aForest);

        @SuppressWarnings("unchecked")
        EList<EObject> trees = (EList<EObject>) aForest.eGet(eTrees);
        EObject aTree = factory.create(eTree);
        res.getContents().add(aTree);
        trees.add(aTree);
        EObject anotherTree = factory.create(eTree);
        res.getContents().add(anotherTree);
        trees.add(anotherTree);
        aTree = factory.create(eTree);
        res.getContents().add(aTree);
        trees.add(aTree);

        assertTrue(check(expr, anotherTree));
    }

    public void test_unnamedAttribute_instanceSpecification_194245() {
        expectModified = true;
        Property tree_forest = forest_trees.getOtherEnd();
        assertNotNull(tree_forest);
        assertNotNull(tree_forest.getName());
        tree_forest.setName(null); // unnamed end
        
        OCLExpression<Classifier> expr = parseConstraint("package ocltest context Tree " + //$NON-NLS-1$
            "inv: forest.trees->includes(self)" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        InstanceSpecification aForest = instantiate(instancePackage, forest);

        InstanceSpecification aTree = instantiate(instancePackage, tree);
        addValue(aForest, forest_trees, aTree);
        InstanceSpecification anotherTree = instantiate(instancePackage, tree);
        addValue(aForest, forest_trees, anotherTree);
        aTree = instantiate(instancePackage, tree);
        addValue(aForest, forest_trees, aTree);

        assertTrue(check(expr, anotherTree));
    }

    public void test_associationEndAmbiguity_nonNavigable_194245() {
        expectModified = true;
        // create a duplicate end
        forest.createAssociation(
            true, AggregationKind.SHARED_LITERAL, "someTrees", 0, -1, tree, //$NON-NLS-1$
            false, AggregationKind.SHARED_LITERAL, "forest", 0, 1); //$NON-NLS-1$
        
        BasicEnvironment benv = OCLUtil.getAdapter(ocl.getEnvironment(),
            BasicEnvironment.class);
        benv.setOption(ProblemOption.AMBIGUOUS_ASSOCIATION_ENDS,
            ProblemHandler.Severity.WARNING);
        
        parseConstraint("package ocltest context Tree " + //$NON-NLS-1$
            "inv: forest.trees->includes(self)" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        Diagnostic diag = ocl.getProblems();
        assertNotNull(diag);
        assertEquals(Diagnostic.WARNING, diag.getSeverity());
        System.out.println("Got expected warning: " + diag.getMessage()); //$NON-NLS-1$
    }

    public void test_associationEndAmbiguity_unnamed_194245() {
        expectModified = true;
        Property tree_forest = forest_trees.getOtherEnd();
        assertNotNull(tree_forest);
        assertNotNull(tree_forest.getName());
        tree_forest.setName(null); // unnamed end
        
        // create a duplicate end
        forest.createAssociation(
            true, AggregationKind.SHARED_LITERAL, "someTrees", 0, -1, tree, //$NON-NLS-1$
            false, AggregationKind.SHARED_LITERAL, null, 0, 1); // unnamed
        
        BasicEnvironment benv = OCLUtil.getAdapter(ocl.getEnvironment(),
            BasicEnvironment.class);
        benv.setOption(ProblemOption.AMBIGUOUS_ASSOCIATION_ENDS,
            ProblemHandler.Severity.WARNING);
        
        parseConstraint("package ocltest context Tree " + //$NON-NLS-1$
            "inv: forest.trees->includes(self)" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        Diagnostic diag = ocl.getProblems();
        assertNotNull(diag);
        assertEquals(Diagnostic.WARNING, diag.getSeverity());
        System.out.println("Got expected warning: " + diag.getMessage()); //$NON-NLS-1$
    }

    public void test_associationEndAmbiguity_errorSeverity_194245() {
        expectModified = true;
        // create a duplicate end
        forest.createAssociation(
            true, AggregationKind.SHARED_LITERAL, "someTrees", 0, -1, tree, //$NON-NLS-1$
            false, AggregationKind.SHARED_LITERAL, "forest", 0, 1); //$NON-NLS-1$
        
        try {
            ocl.parse(new OCLInput("package ocltest context Tree " + //$NON-NLS-1$
                "inv: forest.trees->includes(self)" + //$NON-NLS-1$
                " endpackage")); //$NON-NLS-1$
    
            fail("Should not have parsed"); //$NON-NLS-1$
        } catch (ParserException e) {
            // success
            System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_nonNavigableAttribute_inheritedAssociation_194245() {
        OCLExpression<Classifier> expr = parseConstraint(
            "package uml context LiteralNull " + //$NON-NLS-1$
            "inv: not owningProperty.type.oclIsUndefined()" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        Package pkg = UMLFactory.eINSTANCE.createPackage();
        pkg.setName("pkg"); //$NON-NLS-1$
        
        Class a = pkg.createOwnedClass("A", false); //$NON-NLS-1$
        Property foo = a.createOwnedAttribute("foo", null); //$NON-NLS-1$
        
        LiteralNull nullVal = (LiteralNull) foo.createDefaultValue(null, null,
            UMLPackage.Literals.LITERAL_NULL);

        assertFalse(check(expr, nullVal));
        
        foo.setType(a);
        
        assertTrue(check(expr, nullVal));
    }

    public void test_unnamedAttribute_inheritedAssociation_194245() {
        OCLExpression<Classifier> expr = parseConstraint(
            "package uml context Class " + //$NON-NLS-1$
            "inv: instanceSpecification.classifier->excluding(self)->isEmpty()" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        Package pkg = UMLFactory.eINSTANCE.createPackage();
        pkg.setName("pkg"); //$NON-NLS-1$
        
        Class a = pkg.createOwnedClass("A", false); //$NON-NLS-1$
        Class b = pkg.createOwnedClass("B", false); //$NON-NLS-1$

        InstanceSpecification instance = (InstanceSpecification) pkg.createPackagedElement(
            "anA", UMLPackage.Literals.INSTANCE_SPECIFICATION); //$NON-NLS-1$
        instance.getClassifiers().add(a);

        assertTrue(check(expr, a));
        
        instance = (InstanceSpecification) pkg.createPackagedElement(
            "anotherA", UMLPackage.Literals.INSTANCE_SPECIFICATION); //$NON-NLS-1$
        instance.getClassifiers().add(a);
        
        assertTrue(check(expr, a));
        
        instance.getClassifiers().add(b);  // violate the constraint
        assertFalse(check(expr, a));
    }
    
    /**
     * Tests support for navigation from association to its ends.
     */
    public void test_navigateFromAssociation() {
        // set the option to consider all Assocations as OCL association-classes
        ParsingOptions.setOption(ocl.getEnvironment(), UMLParsingOptions.ASSOCIATION_CLASS_TYPE,
            Association.class);
        
        InstanceSpecification aForest = instantiate(instancePackage, forest);
        setValue(aForest, forest_area, 1000);
        
        InstanceSpecification aTree = instantiate(instancePackage, tree);
        setValue(aTree, tree_height, 2);
        
        InstanceSpecification anotherTree = instantiate(instancePackage, tree);
        setValue(anotherTree, tree_height, 0);
        
        InstanceSpecification aLink = link(instancePackage,
                aForest, forest_trees,
                aTree, forest_trees.getOtherEnd(),
                forest_trees.getAssociation());
        
        InstanceSpecification anotherLink = link(instancePackage,
            aForest, forest_trees,
            anotherTree, forest_trees.getOtherEnd(),
            forest_trees.getAssociation());
        
        // navigate the association end.  This end is multiplicity 1..1 by
        //    definition
        OCLExpression<Classifier> expr = parse(
            "package ocltest context A_Forest_Tree " + //$NON-NLS-1$
            "inv: self.trees.height > 0" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$
        
        assertTrue(check(expr, aLink));
        assertFalse(check(expr, anotherLink));
        
        // this end, too, is 1..1
        expr = parse(
            "package ocltest context A_Forest_Tree " + //$NON-NLS-1$
            "inv: self.forest.area > 1000" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$
        
        assertFalse(check(expr, aLink));
        assertFalse(check(expr, anotherLink));
        
        setValue(aForest, forest_area, 1050);
        assertTrue(check(expr, aLink));
        assertTrue(check(expr, anotherLink));
    }

    /**
     * Tests that reference to uml::Class::general does not resolve to anything,
     * not the Classifier::general attribute (because it is redefined as
     * Class::superType) nor the bogus association end Generalization::general.
     */
	@SuppressWarnings("unchecked")
    public void test_classGeneralResolvesToNothing_251808() {
    	try {
    		assertNull(
				"Should not find redefined property Classifier::general", //$NON-NLS-1$
				OCLUtil.getAdapter(ocl.getEnvironment(),
					Environment.Lookup.class).tryLookupProperty(
					getMetaclass("Class"), "general")); //$NON-NLS-1$//$NON-NLS-2$
    	} catch (AmbiguousLookupException e) {
    		fail("Should not be an ambiguous look-up"); //$NON-NLS-1$
    	} catch (LookupException e) {
    		fail("Should not be a look-up exception"); //$NON-NLS-1$
    	}
    	
    	// this should parse OK, though
        parseConstraint("package uml context Class " + //$NON-NLS-1$
            "inv: self.oclAsType(Classifier).general->isEmpty()" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$
    }

	//
	// Fixture methods
	//
	
	@Override
	protected void setUp() {
		super.setUp();
		
		instanceResource = resourceSet.createResource(
				URI.createFileURI("/tmp/instances.uml")); //$NON-NLS-1$
		
		instancePackage = umlf.createPackage();
		instancePackage.setName("instances"); //$NON-NLS-1$
		instanceResource.getContents().add(instancePackage);
	}
}
