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
 *   Zeligsoft - Bugs 243079, 244948, 244886, 245619
 *   Ed Willink - Bug 254919
 *
 * </copyright>
 *
 * $Id: AbstractTestSuite.java,v 1.23 2009/11/26 20:45:48 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

import junit.framework.Test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.internal.OCLFactoryImpl;
import org.eclipse.ocl.tests.GenericFruitTestSuite;
import org.eclipse.ocl.utilities.OCLFactory;

/**
 * Extended test framework for tests using the Ecore binding and the Fruit meta-model.
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractTestSuite
	extends GenericFruitTestSuite<EObject, EPackage, EClassifier, EClassifier, EClass, EDataType, EClassifier, EEnum, EOperation, EParameter, EStructuralFeature,
	EAttribute, EReference, EEnumLiteral, EObject, CallOperationAction, SendSignalAction, Constraint> {

	protected static final org.eclipse.ocl.ecore.EcorePackage ocltypes =
        org.eclipse.ocl.ecore.EcorePackage.eINSTANCE;
	protected static final EcorePackage ecore = EcorePackage.eINSTANCE;
	
	protected EFactory fruitFactory;
	
	protected EClass fruit;
	protected EOperation fruit_ripen;
	protected EOperation fruit_preferredColor;
	protected EOperation fruit_newFruit;
	protected EOperation fruit_setColor;
	protected EAttribute fruit_color;
	
	protected EClass apple;
	protected EAttribute apple_label;
	protected EReference apple_stem;
	protected EOperation apple_labelOper;
	protected EOperation apple_newApple;
	
	protected EClass stem;
	
	protected EEnum color;
	protected EEnumLiteral color_black;
	protected EEnumLiteral color_red;
	protected EEnumLiteral color_green;
	protected EEnumLiteral color_yellow;
	protected EEnumLiteral color_orange;
	protected EEnumLiteral color_brown;
	protected EEnumLiteral color_pink;
	
	protected EClass util;
	protected EReference util_orderedSet;
	protected EReference util_set;
	protected EReference util_bag;
	protected EReference util_sequence;
	protected EOperation util_processOrderedSet;
	protected EOperation util_processSet;
	protected EOperation util_processBag;
	protected EOperation util_processSequence;
	
	protected final OCLFactory oclFactory = OCLFactoryImpl.INSTANCE;

	/**
	 * Creates the test suite.
	 * 
	 * @return the suite
	 */
	public static Test suite() {
		CheckedTestSuite result = new CheckedTestSuite("OCL Tests for Ecore Metamodel"); //$NON-NLS-1$
		
		result.createTestSuite(BasicOCLTest.class, "Basic Tests"); //$NON-NLS-1$
		result.createTestSuite(KeywordsTest.class, "OCL Keyword Tests"); //$NON-NLS-1$
		result.createTestSuite(ComparisonTest.class, "Comparison/Ordering Tests"); //$NON-NLS-1$
        result.createTestSuite(PrimitiveTypesTest.class, "Primitive Type Tests"); //$NON-NLS-1$
        result.createTestSuite(PredefinedSuperTypeInheritedOperationTest.class,
        	"Inheritance of additional operations"); //$NON-NLS-1$
		result.createTestSuite(CollectionsTest.class, "Collection Type Tests"); //$NON-NLS-1$
		result.createTestSuite(IteratorsTest.class, "Iterator Tests"); //$NON-NLS-1$
		result.createTestSuite(TuplesTest.class, "Tuple Tests"); //$NON-NLS-1$
		result.createTestSuite(AssociationTest.class, "Association Tests"); //$NON-NLS-1$
		result.createTestSuite(StatesTest.class, "State Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(MessagesTest.class, "Message Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(InvariantConstraintsTest.class, "Invariant Constraints"); //$NON-NLS-1$
		result.createTestSuite(OperationConstraintsTest.class, "Operation Constraints"); //$NON-NLS-1$
		result.createTestSuite(LocationInformationTest.class, "Location Information Tests"); //$NON-NLS-1$
		result.createTestSuite(DefExpressionTest.class, "Def Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(OCLOperationCollisionTest.class,
			"Collision with OCL Standard Operation"); //$NON-NLS-1$
		result.createTestSuite(FeatureRedefinitionTest.class, "Feature redefinition tests"); //$NON-NLS-1$
		result.createTestSuite(InitOrDerExpressionTest.class, "Initial and Derivation Expression Tests"); //$NON-NLS-1$
		result.createTestSuite(OCLDocumentTest.class, "OCL Document Parsing Tests"); //$NON-NLS-1$
		result.createTestSuite(AbstractVisitorTest.class, "AbstractVisitor Tests"); //$NON-NLS-1$
		result.createTestSuite(TypeConformanceTests.class, "Primitive Type Conformance Tests"); //$NON-NLS-1$
		result.addTestSuite(org.eclipse.ocl.ecore.helper.tests.AbstractTestSuite.suite());
		result.createTestSuite(RegressionTest.class, "Regression Tests"); //$NON-NLS-1$
		result.createTestSuite(EcoreEnvironmentTest.class, "Ecore Environment Tests"); //$NON-NLS-1$
        result.createTestSuite(ExtensibilityTest.class, "Extensibility Tests"); //$NON-NLS-1$
		result.createTestSuite(ValidationTest.class, "Expression Validation Tests"); //$NON-NLS-1$
		result.createTestSuite(ProblemOptionTest.class, "Problem Option Tests"); //$NON-NLS-1$
		result.createTestSuite(ParsingOptionsTest.class, "Parsing Options Tests"); //$NON-NLS-1$
		result.createTestSuite(TypesValidatorTest.class, "Types Validator Tests"); //$NON-NLS-1$
		result.createTestSuite(ExpressionsValidatorTest.class, "Expressions Validator Tests"); //$NON-NLS-1$
		result.createTestSuite(SerializationTest.class, "Serialization Tests"); //$NON-NLS-1$
		result.createTestSuite(EvaluationHaltedTest.class, "Ecore Halted Evaluation Tests"); //$NON-NLS-1$
		
		String repairs = System.getProperty("org.eclipse.ocl.ecore.tests.repairs"); //$NON-NLS-1$
		if (repairs != null) {
			result.createTestSuite(ParserBacktrackingTest.class, "Parser Backtracking Tests"); //$NON-NLS-1$
		}
		
		return result;
	}
	
	//
	// Framework methods
	//

	@Override
	public EcoreTestReflection getStaticReflection() {
		return EcoreTestReflection.INSTANCE;
	}

	@Override
	protected void tearDownField(Field field) throws IllegalAccessException {
		field.set(this, null);
	}

	@Override
	protected final void tearDownStatic(java.lang.Class<?> aClass, Field field) {
		if (aClass != AbstractTestSuite.class) {
			super.tearDownStatic(aClass, field);
		}
	}

	@Override
	protected void tearDownUsing(Method method)
			throws IllegalAccessException, InvocationTargetException {
		method.invoke(this);
	}
	
	@Override
	protected void initFruitPackage() {
		URI uri = getTestModelURI("/model/OCLTest.ecore"); //$NON-NLS-1$
		Resource res = resourceSet.getResource(uri, true);
		
		fruitPackage = (EPackage) res.getContents().get(0);
		resourceSet.getPackageRegistry().put(fruitPackage.getNsURI(), fruitPackage);
		
		fruitFactory = fruitPackage.getEFactoryInstance();
		
		fruit = (EClass) fruitPackage.getEClassifier("Fruit"); //$NON-NLS-1$
		fruit_ripen = fruit.getEOperations().get(0);
		fruit_preferredColor = fruit.getEOperations().get(1);
		fruit_newFruit = fruit.getEOperations().get(2);
		fruit_setColor = fruit.getEOperations().get(3);
		fruit_color = (EAttribute) fruit.getEStructuralFeature("color"); //$NON-NLS-1$
		
		apple = (EClass) fruitPackage.getEClassifier("Apple"); //$NON-NLS-1$
		apple_label = (EAttribute) apple.getEStructuralFeature("label"); //$NON-NLS-1$
		apple_stem = (EReference) apple.getEStructuralFeature("stem"); //$NON-NLS-1$
		apple_labelOper = apple.getEOperations().get(0);
		apple_newApple = apple.getEOperations().get(1);
		
		stem = (EClass) fruitPackage.getEClassifier("Stem"); //$NON-NLS-1$
		
		color = (EEnum) fruitPackage.getEClassifier("Color"); //$NON-NLS-1$
		color_black = color.getEEnumLiteral("black"); //$NON-NLS-1$
		color_red = color.getEEnumLiteral("red"); //$NON-NLS-1$
		color_green = color.getEEnumLiteral("green"); //$NON-NLS-1$
		color_yellow = color.getEEnumLiteral("yellow"); //$NON-NLS-1$
		color_orange = color.getEEnumLiteral("orange"); //$NON-NLS-1$
		color_brown = color.getEEnumLiteral("brown"); //$NON-NLS-1$
		color_pink = color.getEEnumLiteral("pink"); //$NON-NLS-1$
		
		util = (EClass) fruitPackage.getEClassifier("FruitUtil"); //$NON-NLS-1$
		util_orderedSet = (EReference) util.getEStructuralFeature("orderedSet"); //$NON-NLS-1$
		util_set = (EReference) util.getEStructuralFeature("set"); //$NON-NLS-1$
		util_bag = (EReference) util.getEStructuralFeature("bag"); //$NON-NLS-1$
		util_sequence = (EReference) util.getEStructuralFeature("sequence"); //$NON-NLS-1$
		util_processOrderedSet = util.getEOperations().get(0);
		util_processSet = util.getEOperations().get(1);
		util_processBag = util.getEOperations().get(2);
		util_processSequence = util.getEOperations().get(3);
		res.setTrackingModification(true);
		
		assertSame(
			fruitPackage,
			resourceSet.getPackageRegistry().getEPackage(fruitPackage.getNsURI()));
		assertSame(
			fruitPackage,
			EcoreEnvironment.findPackage(Collections.singletonList(fruitPackage.getName()), resourceSet.getPackageRegistry()));
	}
}
