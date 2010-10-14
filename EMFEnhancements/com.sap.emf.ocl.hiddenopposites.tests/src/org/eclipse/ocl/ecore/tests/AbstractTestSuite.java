/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 243079, 244948, 244886, 245619
 *   E.D.Willink - Bugs 191689, 254919, 298634
 *
 * </copyright>
 *
 * $Id: AbstractTestSuite.java,v 1.27 2010/05/03 09:38:46 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collections;

import junit.framework.TestCase;

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
import org.eclipse.ocl.tests.GenericFruitTestSuite;
import org.eclipse.ocl.utilities.OCLFactory;

import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;

/**
 * Extended test framework for tests using the Ecore binding and the Fruit meta-model.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class AbstractTestSuite
	extends GenericFruitTestSuite<EObject, EPackage, EClassifier, EClassifier, EClass, EDataType, EClassifier, EEnum, EOperation, EParameter, EStructuralFeature,
	EAttribute, EReference, EEnumLiteral, EObject, CallOperationAction, SendSignalAction, Constraint> {

	@Override
	public URI getTestModelURI(String localFileName) {
		String testPlugInId = staticReflection.getTestPlugInId();
		try {
			java.lang.Class<?> platformClass = java.lang.Class.forName("org.eclipse.core.runtime.Platform");
			Method getBundle = platformClass.getDeclaredMethod("getBundle", new java.lang.Class[] {String.class});
			Object bundle = getBundle.invoke(null, new Object[] {testPlugInId});
			
			if (bundle != null) {
				Method getEntry = bundle.getClass().getMethod("getEntry", new java.lang.Class[] {String.class});
				URL url = (URL) getEntry.invoke(bundle, new Object[] {localFileName});
				return URI.createURI(url.toString());
			}
		} catch (Exception e) {
			// not running in Eclipse
		}
		String urlString = System.getProperty(testPlugInId);
		if (urlString == null)
			TestCase.fail("'" + testPlugInId + "' property not defined; use the launch configuration to define it"); //$NON-NLS-2$
		return URI.createFileURI(urlString + "/" + localFileName);
	}

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
	
	protected EClass tree;
	protected EAttribute tree_name;
	protected EReference tree_fruits;
	protected EReference tree_fruitsDroppedUnder;
	
	protected final OCLFactory oclFactory = new EcoreEnvironmentFactoryWithHiddenOpposites().createEnvironment().getOCLFactory();

	/**
	 * Adds parser-style independent tests to the test suite.
	 * 
	 * @param result the suite
	 */
	public static void suite(CheckedTestSuite result) {
		result.createTestSuite(AllInstancesTest.class, "AllInstances Tests");
		result.createTestSuite(BasicOCLTest.class, "Basic Tests");
		result.createTestSuite(KeywordsTest.class, "OCL Keyword Tests");
		result.createTestSuite(ComparisonTest.class, "Comparison/Ordering Tests");
        	result.createTestSuite(PrimitiveTypesTest.class, "Primitive Type Tests");
        	result.createTestSuite(PredefinedSuperTypeInheritedOperationTest.class,
        	"Inheritance of additional operations");
		result.createTestSuite(CollectionsTest.class, "Collection Type Tests");
		result.createTestSuite(IteratorsTest.class, "Iterator Tests");
		result.createTestSuite(TuplesTest.class, "Tuple Tests");
		result.createTestSuite(AssociationTest.class, "Association Tests");
		result.createTestSuite(StatesTest.class, "State Expression Tests");
		result.createTestSuite(MessagesTest.class, "Message Expression Tests");
		result.createTestSuite(InvariantConstraintsTest.class, "Invariant Constraints");
		result.createTestSuite(OperationConstraintsTest.class, "Operation Constraints");
		result.createTestSuite(LocationInformationTest.class, "Location Information Tests");
		result.createTestSuite(DefExpressionTest.class, "Def Expression Tests");
		result.createTestSuite(OCLOperationCollisionTest.class,
			"Collision with OCL Standard Operation");
		result.createTestSuite(FeatureRedefinitionTest.class, "Feature redefinition tests");
		result.createTestSuite(InitOrDerExpressionTest.class, "Initial and Derivation Expression Tests");
		result.createTestSuite(OCLDocumentTest.class, "OCL Document Parsing Tests");
		result.createTestSuite(AbstractVisitorTest.class, "AbstractVisitor Tests");
		result.createTestSuite(TypeConformanceTests.class, "Primitive Type Conformance Tests");
		result.addTestSuite(org.eclipse.ocl.ecore.helper.tests.AbstractTestSuite.suite());
		result.createTestSuite(RegressionTest.class, "Regression Tests");
		result.createTestSuite(EcoreEnvironmentTest.class, "Ecore Environment Tests");
        	result.createTestSuite(ExtensibilityTest.class, "Extensibility Tests");
		result.createTestSuite(ValidationTest.class, "Expression Validation Tests");
		result.createTestSuite(ProblemOptionTest.class, "Problem Option Tests");
		result.createTestSuite(ParsingOptionsTest.class, "Parsing Options Tests");
		result.createTestSuite(TypesValidatorTest.class, "Types Validator Tests");
		result.createTestSuite(ExpressionsValidatorTest.class, "Expressions Validator Tests");
		result.createTestSuite(SerializationTest.class, "Serialization Tests");
		result.createTestSuite(EvaluationHaltedTest.class, "Ecore Halted Evaluation Tests");
		result.createTestSuite(DelegatesTest.class, "Delegate Tests");
		result.createTestSuite(OppositePropertyCallExpTest.class, "Opposite Property Call Expression Tests");
		result.createTestSuite(AllInstancesContentAdapterTest.class, "allInstances Content Adapter Tests");
	}
	
	/**
	 * Adds backtracking tests to the test suite.
	 * 
	 * @param result the suite
	 */
	public static void suiteBacktracking(CheckedTestSuite result) {
		result.createTestSuite(ParserBacktrackingTest.class, "Parser Backtracking Tests");
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
		URI uri = getTestModelURI("/model/OCLTest.ecore");
		Resource res = resourceSet.getResource(uri, true);
		
		fruitPackage = (EPackage) res.getContents().get(0);
		resourceSet.getPackageRegistry().put(fruitPackage.getNsURI(), fruitPackage);
		
		fruitFactory = fruitPackage.getEFactoryInstance();
		
		fruit = (EClass) fruitPackage.getEClassifier("Fruit");
		fruit_ripen = fruit.getEOperations().get(0);
		fruit_preferredColor = fruit.getEOperations().get(1);
		fruit_newFruit = fruit.getEOperations().get(2);
		fruit_setColor = fruit.getEOperations().get(3);
		fruit_color = (EAttribute) fruit.getEStructuralFeature("color");
		
		apple = (EClass) fruitPackage.getEClassifier("Apple");
		apple_label = (EAttribute) apple.getEStructuralFeature("label");
		apple_stem = (EReference) apple.getEStructuralFeature("stem");
		apple_labelOper = apple.getEOperations().get(0);
		apple_newApple = apple.getEOperations().get(1);
		
		stem = (EClass) fruitPackage.getEClassifier("Stem");
		
		tree = (EClass) fruitPackage.getEClassifier("Tree");
		tree_name = (EAttribute) tree.getEStructuralFeature("name");
		tree_fruits = (EReference) tree.getEStructuralFeature("fruits");
		tree_fruitsDroppedUnder = (EReference) tree.getEStructuralFeature("fruitsDroppedUnder");
		
		color = (EEnum) fruitPackage.getEClassifier("Color");
		color_black = color.getEEnumLiteral("black");
		color_red = color.getEEnumLiteral("red");
		color_green = color.getEEnumLiteral("green");
		color_yellow = color.getEEnumLiteral("yellow");
		color_orange = color.getEEnumLiteral("orange");
		color_brown = color.getEEnumLiteral("brown");
		color_pink = color.getEEnumLiteral("pink");
		
		util = (EClass) fruitPackage.getEClassifier("FruitUtil");
		util_orderedSet = (EReference) util.getEStructuralFeature("orderedSet");
		util_set = (EReference) util.getEStructuralFeature("set");
		util_bag = (EReference) util.getEStructuralFeature("bag");
		util_sequence = (EReference) util.getEStructuralFeature("sequence");
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
