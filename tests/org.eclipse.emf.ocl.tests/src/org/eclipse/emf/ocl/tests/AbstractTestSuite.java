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

import java.io.StringReader;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;

import antlr.ANTLRException;

import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.internal.impl.ValidationVisitorImpl;
import org.eclipse.emf.ocl.helper.Choice;
import org.eclipse.emf.ocl.helper.ChoiceType;
import org.eclipse.emf.ocl.internal.parser.OclLexer;
import org.eclipse.emf.ocl.internal.parser.OclParser;
import org.eclipse.emf.ocl.internal.utilities.Visitable;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.uml.Constraint;


/**
 * Mini-framework for the OCL tests.
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractTestSuite
	extends TestCase {

	protected static TypesPackage ocltypes = TypesPackage.eINSTANCE;
	protected static EClass oclBoolean = ocltypes.getPrimitiveBoolean();
	
	protected static EcorePackage ecore = EcorePackage.eINSTANCE;
	
	protected static EPackage fruitPackage;
	protected static EFactory fruitFactory;
	
	protected static EClass fruit;
	protected static EOperation fruit_ripen;
	protected static EOperation fruit_preferredColor;
	protected static EOperation fruit_newFruit;
	protected static EAttribute fruit_color;
	
	protected static EClass apple;
	protected static EAttribute apple_label;
	protected static EReference apple_stem;
	protected static EOperation apple_labelOper;
	protected static EOperation apple_newApple;
	
	protected static EClass stem;
	
	protected static EEnum color;
	protected static EEnumLiteral color_black;
	protected static EEnumLiteral color_red;
	protected static EEnumLiteral color_green;
	protected static EEnumLiteral color_yellow;
	protected static EEnumLiteral color_orange;
	protected static EEnumLiteral color_brown;
	protected static EEnumLiteral color_pink;
	
	protected static EClass util;
	protected static EReference util_orderedSet;
	protected static EReference util_set;
	protected static EReference util_bag;
	protected static EReference util_sequence;
	protected static EOperation util_processOrderedSet;
	protected static EOperation util_processSet;
	protected static EOperation util_processBag;
	protected static EOperation util_processSequence;
	
	public AbstractTestSuite(String name) {
		super(name);
	}

	/**
	 * Creates the test suite.
	 * 
	 * @return the suite
	 */
	public static Test suite() {
		TestSuite result = new TestSuite("OCL Parsing Tests"); //$NON-NLS-1$
		
		result.addTest(BasicOclTest.suite());
		result.addTest(InvariantConstraintsTest.suite());
		result.addTest(OperationConstraintsTest.suite());
		result.addTest(ExpressionsUtilTest.suite());
		result.addTest(LocationInformationTest.suite());
		result.addTest(AssociationTest.suite());
		result.addTest(org.eclipse.emf.ocl.helper.tests.AbstractTestSuite.suite());
		result.addTest(RegressionTest.suite());
		result.addTest(QueryFactoryTest.suite());
		result.addTest(EcoreEnvironmentTest.suite());
		
		return result;
	}
	
	//
	// Framework methods
	//
	
	protected void setUp()
		throws Exception {
		
		System.out.println("==> Start  " + getName()); //$NON-NLS-1$
		
		if (fruitPackage == null) {
			initFruitPackage();
		}
	}
	
	protected void tearDown()
		throws Exception {
		
		System.out.println("==> Finish " + getName()); //$NON-NLS-1$
	}
	
	/**
	 * Parses the specified <code>text</code>.
	 * 
	 * @param text the OCL text
	 * @return the OCL expression
	 */
	protected OclExpression parse(String text) {
		OclExpression result = parseUnvalidated(text);
		validate(result);
		return result;
	}
	
	/**
	 * Parses the specified <code>text</code> without validating it.
	 * 
	 * @param text the OCL text
	 * @return the OCL expression, invalidated
	 */
	protected OclExpression parseUnvalidated(String text) {
		OclLexer lexer = new OclLexer(new StringReader(text));
		OclParser parser = new OclParser(lexer);
		parser.setTraceFlag(true);
		
		EList constraints = new BasicEList();
		Constraint constraint = null;
		
		try {
			parser.packageDeclarationCS(constraints);
			constraint = (Constraint) constraints.get(0);
		} catch (ANTLRException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		OclExpression result = null;
		result = constraint.getBody();
		
		assertNotNull(result);
		
		return result;
	}
	
	/**
	 * Validates an OCL expression, asserting that it is valid.
	 * 
	 * @param expr the OCL expression to validate
	 */
	protected void validate(OclExpression expr) {
		try {
			Visitable v;
			
			if (expr.eContainer() instanceof Constraint) {
				// start validation from the constraint, for good measure
				v = (Constraint) expr.eContainer();
			} else {
				v = expr;
			}
			
			v.accept(ValidationVisitorImpl.getInstance());
		} catch (IllegalArgumentException e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression
	 */
	protected OclExpression parseConstraint(String text) {
		OclExpression result = parse(text);
		
		assertTrue("Not a boolean-valued constraint", oclBoolean.isInstance(result.getType())); //$NON-NLS-1$
		
		return result;
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint, without
	 * validating it.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression, unvalidated
	 */
	protected OclExpression parseConstraintUnvalidated(String text) {
		OclExpression result = parseUnvalidated(text);
		
		assertTrue("Not a boolean-valued constraint", oclBoolean.isInstance(result.getType())); //$NON-NLS-1$
		
		return result;
	}
	
	protected Object evaluate(OclExpression expr) {
		Object result = null;
		
		try {
			result = QueryFactory.eINSTANCE.createQuery(expr).evaluate();
		} catch (RuntimeException e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected Object evaluate(OclExpression expr, Object self) {
		Object result = null;
		
		try {
			result = QueryFactory.eINSTANCE.createQuery(expr).evaluate(self);
		} catch (RuntimeException e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected boolean check(OclExpression expr, Object self) {
		boolean result = false;
		
		try {
			result = QueryFactory.eINSTANCE.createQuery(expr).check(self);
		} catch (RuntimeException e) {
			fail("Validation failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	protected Choice findChoice(Collection choices, ChoiceType kind, String name) {
		Choice result = null;
		
		for (Iterator i = choices.iterator(); i.hasNext();) {
			Choice c = (Choice) i.next();
			
			if (c.getKind() == kind && name.equals(c.getName())) {
				result = c;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Asserts that the specified choice is to be found in the collection of
	 * <code>choices</code>.
	 * 
	 * @param choices a collection of {@link OclChoice}s
	 * @param kind the kind of choice to find
	 * @param name the name of the choice to find
	 */
	protected void assertChoice(Collection choices, ChoiceType kind, String name) {
		assertNotNull("Choice not found: " + name + ", " + kind, //$NON-NLS-1$ //$NON-NLS-2$
			findChoice(choices, kind, name));
	}
	
	/**
	 * Asserts that the specified choice is <em>not</em> to be found in the
	 * collection of <code>choices</code>.
	 * 
	 * @param choices a collection of {@link OclChoice}s
	 * @param kind the kind of choice not to find
	 * @param name the name of the choice not to find
	 */
	protected void assertNotChoice(Collection choices, ChoiceType kind, String name) {
		assertNull("Choice found: " + name + ", " + kind, //$NON-NLS-1$ //$NON-NLS-2$
			findChoice(choices, kind, name));
	}
	
	private static void initFruitPackage() {
		Bundle bundle = Platform.getBundle("org.eclipse.emf.ocl.tests"); //$NON-NLS-1$
		URL url = bundle.getEntry("/model/OclTest.ecore"); //$NON-NLS-1$
		
		ResourceSet rset = new ResourceSetImpl();
		Resource res = rset.getResource(URI.createURI(url.toString()), true);
		
		fruitPackage = (EPackage) res.getContents().get(0);
		EPackage.Registry.INSTANCE.put(fruitPackage.getNsURI(), fruitPackage);
		
		fruitFactory = fruitPackage.getEFactoryInstance();
		
		fruit = (EClass) fruitPackage.getEClassifier("Fruit"); //$NON-NLS-1$
		fruit_ripen = (EOperation) fruit.getEOperations().get(0);
		fruit_preferredColor = (EOperation) fruit.getEOperations().get(1);
		fruit_newFruit = (EOperation) fruit.getEOperations().get(2);
		fruit_color = (EAttribute) fruit.getEStructuralFeature("color"); //$NON-NLS-1$
		
		apple = (EClass) fruitPackage.getEClassifier("Apple"); //$NON-NLS-1$
		apple_label = (EAttribute) apple.getEStructuralFeature("label"); //$NON-NLS-1$
		apple_stem = (EReference) apple.getEStructuralFeature("stem"); //$NON-NLS-1$
		apple_labelOper = (EOperation) apple.getEOperations().get(0);
		apple_newApple = (EOperation) apple.getEOperations().get(1);
		
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
		util_processOrderedSet = (EOperation) util.getEOperations().get(0);
		util_processSet = (EOperation) util.getEOperations().get(1);
		util_processBag = (EOperation) util.getEOperations().get(2);
		util_processSequence = (EOperation) util.getEOperations().get(3);
	}
}
