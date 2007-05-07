/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: OCLDocumentTest.java,v 1.4 2007/05/07 12:28:46 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.UMLReflection;


/**
 * Tests support for parsing OCL documents.
 *
 * @author Christian W. Damus (cdamus)
 */
public class OCLDocumentTest extends AbstractTestSuite {

	private Map<String, Constraint> constraints;
	
	public OCLDocumentTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(OCLDocumentTest.class,
			"OCL Document Parsing Tests"); //$NON-NLS-1$
	}
	
	public void test_multipleInvariants() {
		Constraint notBlack = getConstraint("not_black"); //$NON-NLS-1$
		Constraint notFoo = getConstraint("not_foo"); //$NON-NLS-1$
		
		assertMatchingContextVariables(fruit, notBlack);
		assertMatchingContextVariables(fruit, notFoo);
		
		EObject anApple = fruitFactory.create(apple);
		anApple.eSet(fruit_color, color_black);
		anApple.eSet(apple_label, "Foo"); //$NON-NLS-1$
		
		// this constraint actually uses the derivation of the Fruit::name
		//    property, defined in the Apple context  :-)
		assertFalse(ocl.check(anApple, notFoo));
		assertFalse(ocl.check(anApple, notBlack));
		
		anApple.eSet(fruit_color, color_red);
		anApple.eSet(apple_label, "Bar"); //$NON-NLS-1$
		
		assertTrue(ocl.check(anApple, notFoo));
		assertTrue(ocl.check(anApple, notBlack));
	}
	
	public void test_multipleDefExpressions() {
		assertMatchingContextVariables(fruit, getConstraint("property_helper")); //$NON-NLS-1$
		assertMatchingContextVariables(fruit, getConstraint("operation_helper")); //$NON-NLS-1$
		
		EObject anApple = fruitFactory.create(apple);
		anApple.eSet(fruit_color, color_black);
		anApple.eSet(apple_label, "Foo"); //$NON-NLS-1$
		
		EObject anotherApple = fruitFactory.create(apple);
		anotherApple.eSet(fruit_color, color_red);
		anotherApple.eSet(apple_label, "Bar"); //$NON-NLS-1$
		
		Set<EObject> apples = new java.util.HashSet<EObject>();
		apples.add(anApple);
		apples.add(anotherApple);
		Map<EClass, Set<EObject>> extentMap = new java.util.HashMap<EClass, Set<EObject>>();
		extentMap.put(apple, apples);
		extentMap.put(fruit, apples);
		ocl.setExtentMap(extentMap);
		
		helper = ocl.createOCLHelper();
		helper.setContext(apple);
		
		try {
			// test the additional property
			Object value = evaluate(helper, anApple, "self.otherFruits"); //$NON-NLS-1$
			assertEquals(Collections.singleton(anotherApple), value);
			
			// test the additional operation
			value = evaluate(helper, anotherApple, "self.getOtherFruits(false)"); //$NON-NLS-1$
			assertEquals(Collections.singleton(anApple), value);
		} catch (ParserException e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_multipleInvariantsAndDefExpressions() {
		Constraint notBlack = getConstraint("not_black1"); //$NON-NLS-1$
		Constraint notFoo = getConstraint("not_foo1"); //$NON-NLS-1$
		
		assertMatchingContextVariables(fruit, notBlack);
		assertMatchingContextVariables(fruit, notFoo);
		assertMatchingContextVariables(fruit, getConstraint("property_helper")); //$NON-NLS-1$
		assertMatchingContextVariables(fruit, getConstraint("operation_helper")); //$NON-NLS-1$
		
		EObject anApple = fruitFactory.create(apple);
		anApple.eSet(fruit_color, color_black);
		anApple.eSet(apple_label, "Foo"); //$NON-NLS-1$
		
		// this constraint actually uses the derivation of the Fruit::name
		//    property, defined in the Apple context  :-)
		assertFalse(ocl.check(anApple, notFoo));
		assertFalse(ocl.check(anApple, notBlack));
		
		anApple.eSet(fruit_color, color_red);
		anApple.eSet(apple_label, "Bar"); //$NON-NLS-1$
		
		assertTrue(ocl.check(anApple, notFoo));
		assertTrue(ocl.check(anApple, notBlack));
		
		anApple.eSet(fruit_color, color_black);
		anApple.eSet(apple_label, "Foo"); //$NON-NLS-1$
		
		EObject anotherApple = fruitFactory.create(apple);
		anotherApple.eSet(fruit_color, color_red);
		anotherApple.eSet(apple_label, "Bar"); //$NON-NLS-1$
		
		Set<EObject> apples = new java.util.HashSet<EObject>();
		apples.add(anApple);
		apples.add(anotherApple);
		Map<EClass, Set<EObject>> extentMap = new java.util.HashMap<EClass, Set<EObject>>();
		extentMap.put(apple, apples);
		extentMap.put(fruit, apples);
		ocl.setExtentMap(extentMap);
		
		helper = ocl.createOCLHelper();
		helper.setContext(apple);
		
		try {
			// test the additional property
			Object value = evaluate(helper, anApple, "self.otherFruits1"); //$NON-NLS-1$
			assertEquals(Collections.singleton(anotherApple), value);
			
			// test the additional operation
			value = evaluate(helper, anotherApple, "self.getOtherFruits1(false)"); //$NON-NLS-1$
			assertEquals(Collections.singleton(anApple), value);
		} catch (ParserException e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	public void test_multipleMixedOperationConstraints() {
		Constraint textNotNull = getConstraint("text_not_null"); //$NON-NLS-1$
		Constraint textNotLabel = getConstraint("text_not_label"); //$NON-NLS-1$
		Constraint computeLabel = getConstraint("compute_label"); //$NON-NLS-1$
		Constraint labelIsChanged = getConstraint("label_is_changed"); //$NON-NLS-1$
		Constraint labelIsSet = getConstraint("label_is_set"); //$NON-NLS-1$
		
		assertEquals(1, textNotNull.getConstrainedElements().size());
		EOperation oper = (EOperation) textNotNull.getConstrainedElements().get(0);
		assertNotNull(oper);
		assertEquals(UMLReflection.PRECONDITION, textNotNull.getStereotype());
		assertNotNull(textNotNull.getSpecification().getBodyExpression());
		assertMatchingContextVariables(oper, textNotNull);
		
		assertEquals(1, textNotLabel.getConstrainedElements().size());
		assertSame(oper, textNotLabel.getConstrainedElements().get(0));
		assertEquals(UMLReflection.PRECONDITION, textNotLabel.getStereotype());
		assertNotNull(textNotLabel.getSpecification().getBodyExpression());
		assertMatchingContextVariables(oper, textNotLabel);
		
		assertEquals(1, computeLabel.getConstrainedElements().size());
		assertSame(oper, computeLabel.getConstrainedElements().get(0));
		assertEquals(UMLReflection.BODY, computeLabel.getStereotype());
		assertNotNull(computeLabel.getSpecification().getBodyExpression());
		assertMatchingContextVariables(oper, computeLabel);
		
		assertEquals(1, labelIsChanged.getConstrainedElements().size());
		assertSame(oper, labelIsChanged.getConstrainedElements().get(0));
		assertEquals(UMLReflection.POSTCONDITION, labelIsChanged.getStereotype());
		assertNotNull(labelIsChanged.getSpecification().getBodyExpression());
		assertMatchingContextVariables(oper, labelIsChanged);
		
		assertEquals(1, labelIsSet.getConstrainedElements().size());
		assertSame(oper, labelIsSet.getConstrainedElements().get(0));
		assertEquals(UMLReflection.POSTCONDITION, labelIsSet.getStereotype());
		assertNotNull(labelIsSet.getSpecification().getBodyExpression());
		assertMatchingContextVariables(oper, labelIsSet);
	}
	
	public void test_initAndDerConstraints() {
		helper.setContext(apple);
		
		try {
			EObject anApple = fruitFactory.create(apple);
			anApple.eSet(apple_label, "Foo"); //$NON-NLS-1$
			
			assertEquals("Foo", evaluate(helper, anApple, "self.name")); //$NON-NLS-1$ //$NON-NLS-2$
			
			anApple.eUnset(apple_label);
			
			assertEquals("", evaluate(helper, anApple, "self.name")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (ParserException e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
    
    /**
     * Tests that we get a proper ParserException from parsing an operation
     * context declaration that is missing the classifier (qualified) name.
     */
    public void test_operationContextWithoutClassifierName_182286() {
        try {
            ocl.parse(new OCLInput(
                "context label(s : String) : \n" + //$NON-NLS-1$
                "  pre: true" //$NON-NLS-1$
                ));
        } catch (ParserException e) {
            // success
            System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        } catch (RuntimeException e) {
            fail("Got runtime exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that a constraint can reference an operation defined in a package
     * context earlier in the OCL document.
     */
    public void test_dependenciesOnDefExpressions_packageContext_176109() {
        try {
            ocl.parse(new OCLInput(
                "package ecore context EClassifier \n" + //$NON-NLS-1$
                "def: isHappy() : Boolean = true \n" + //$NON-NLS-1$
                "endpackage \n" + //$NON-NLS-1$
                "package ecore context ETypedElement \n" + //$NON-NLS-1$
                "inv: eType <> null implies eType.isHappy() \n" + //$NON-NLS-1$
                "endpackage \n" //$NON-NLS-1$
                ));
        } catch (ParserException e) {
            fail("Should not have failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that a constraint can reference an operation defined in a classifier
     * context earlier in the OCL document.
     */
    public void test_dependenciesOnDefExpressions_classifierContext_176109() {
        try {
            ocl.parse(new OCLInput(
                "package ecore \n" + //$NON-NLS-1$
                "context EClassifier \n" + //$NON-NLS-1$
                "def: isHappy() : Boolean = true \n" + //$NON-NLS-1$
                "context ETypedElement \n" + //$NON-NLS-1$
                "inv: eType <> null implies eType.isHappy() \n" + //$NON-NLS-1$
                "endpackage \n" //$NON-NLS-1$
                ));
        } catch (ParserException e) {
            fail("Should not have failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    /**
     * Tests that a constraint can reference an operation defined ahead of it in
     * the same classifier context.
     */
    public void test_dependenciesOnDefExpressions_withinClassifierContext_176109() {
        try {
            ocl.parse(new OCLInput(
                "package ecore \n" + //$NON-NLS-1$
                "context EClassifier \n" + //$NON-NLS-1$
                "def: isHappy() : Boolean = true \n" + //$NON-NLS-1$
                "inv: self.isHappy() \n" + //$NON-NLS-1$
                "endpackage \n" //$NON-NLS-1$
                ));
        } catch (ParserException e) {
            fail("Should not have failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
	
	//
	// Framework methods
	//
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		constraints = new java.util.HashMap<String, Constraint>();
		
		URL url = new URL(
				"platform:/plugin/org.eclipse.ocl.ecore.tests/model/test_constraints.ocl"); //$NON-NLS-1$
		InputStream is = url.openStream();
		List<Constraint> parsed = ocl.parse(new OCLInput(is));
		is.close();
		
		for (Constraint ct : parsed) {
            validate(ct);
			constraints.put(ct.getName(), ct);
		}
	}
	
	Constraint getConstraint(String name) {
		Constraint result = constraints.get(name);
		assertNotNull("Did not find constraint " + name, result); //$NON-NLS-1$
		return result;
	}
	
	void assertMatchingContextVariables(EClassifier context, Constraint constraint) {
		ExpressionInOCL spec = (ExpressionInOCL) constraint.getSpecification();
		EcoreEnvironment env = (EcoreEnvironment) ocl.getEnvironment();
		
		Variable<EClassifier, EParameter> selfVar = spec.getContextVariable();
		assertNotNull(selfVar);
		assertEquals(Environment.SELF_VARIABLE_NAME, selfVar.getName());
		assertEquals(selfVar.getType(), env.getUMLReflection().getOCLType(context));
	}
	
	void assertMatchingContextVariables(EOperation operation, Constraint constraint) {
		ExpressionInOCL spec = (ExpressionInOCL) constraint.getSpecification();
		EcoreEnvironment env = (EcoreEnvironment) ocl.getEnvironment();
		
		if (operation.getEContainingClass() != null) {
			Variable<EClassifier, EParameter> selfVar = spec.getContextVariable();
			assertNotNull(selfVar);
			assertEquals(Environment.SELF_VARIABLE_NAME, selfVar.getName());
			assertEquals(selfVar.getType(), env.getUMLReflection().getOCLType(operation.getEContainingClass()));
		}
		
		if ((operation.getEType() != null)
				&& !UMLReflection.PRECONDITION.equals(constraint.getStereotype())) {
			
			Variable<EClassifier, EParameter> resultVar = spec.getResultVariable();
			assertNotNull(resultVar);
			assertEquals(Environment.RESULT_VARIABLE_NAME, resultVar.getName());
			assertEquals(resultVar.getType(), env.getUMLReflection().getOCLType(operation));
		}
		
		EList<EParameter> parms = operation.getEParameters();
		EList<Variable<EClassifier, EParameter>> vars = spec.getParameterVariable();
		
		assertEquals(parms.size(), vars.size());
		for (int i = 0; i < parms.size(); i++) {
			Variable<EClassifier, EParameter> var = vars.get(i);
			EParameter parm = parms.get(i);
			
			assertEquals(var.getType(), env.getUMLReflection().getOCLType(parm));
		}
	}
}
