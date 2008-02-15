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
 * $Id: OCLDocumentTest.java,v 1.3 2008/02/15 05:20:16 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;


/**
 * Tests support for parsing OCL documents.
 *
 * @author Christian W. Damus (cdamus)
 */
public class OCLDocumentTest extends AbstractTestSuite {

	private Package instancePackage;
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
		
		InstanceSpecification anApple = instantiate(instancePackage, apple);
		setValue(anApple, fruit_color, color_black);
		setValue(anApple, apple_label, "Foo"); //$NON-NLS-1$
		
		// this constraint actually uses the derivation of the Fruit::name
		//    property, defined in the Apple context  :-)
		assertFalse(ocl.check(anApple, notFoo));
		assertFalse(ocl.check(anApple, notBlack));
		
		setValue(anApple, fruit_color, color_red);
		setValue(anApple, apple_label, "Bar"); //$NON-NLS-1$
		
		assertTrue(ocl.check(anApple, notFoo));
		assertTrue(ocl.check(anApple, notBlack));
	}
	
	public void test_multipleDefExpressions() {
		assertMatchingContextVariables(fruit, getConstraint("property_helper")); //$NON-NLS-1$
		assertMatchingContextVariables(fruit, getConstraint("operation_helper")); //$NON-NLS-1$
		
		InstanceSpecification anApple = instantiate(instancePackage, apple);
		setValue(anApple, fruit_color, color_black);
		setValue(anApple, apple_label, "Foo"); //$NON-NLS-1$
		
		InstanceSpecification anotherApple = instantiate(instancePackage, apple);
		setValue(anotherApple, fruit_color, color_red);
		setValue(anotherApple, apple_label, "Bar"); //$NON-NLS-1$
		
		Set<EObject> apples = new java.util.HashSet<EObject>();
		apples.add(anApple);
		apples.add(anotherApple);
		Map<Class, Set<EObject>> extentMap = new java.util.HashMap<Class, Set<EObject>>();
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
		
		InstanceSpecification anApple = instantiate(instancePackage, apple);
		setValue(anApple, fruit_color, color_black);
		setValue(anApple, apple_label, "Foo"); //$NON-NLS-1$
		
		// this constraint actually uses the derivation of the Fruit::name
		//    property, defined in the Apple context  :-)
		assertFalse(ocl.check(anApple, notFoo));
		assertFalse(ocl.check(anApple, notBlack));
		
		setValue(anApple, fruit_color, color_red);
		setValue(anApple, apple_label, "Bar"); //$NON-NLS-1$
		
		assertTrue(ocl.check(anApple, notFoo));
		assertTrue(ocl.check(anApple, notBlack));
		
		setValue(anApple, fruit_color, color_black);
		setValue(anApple, apple_label, "Foo"); //$NON-NLS-1$
		
		InstanceSpecification anotherApple = instantiate(instancePackage, apple);
		setValue(anotherApple, fruit_color, color_red);
		setValue(anotherApple, apple_label, "Bar"); //$NON-NLS-1$
		
		Set<EObject> apples = new java.util.HashSet<EObject>();
		apples.add(anApple);
		apples.add(anotherApple);
		Map<Class, Set<EObject>> extentMap = new java.util.HashMap<Class, Set<EObject>>();
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
		Constraint labelIsChanged = getConstraint("label_is_changed"); //$NON-NLS-1$
		Constraint labelIsSet = getConstraint("label_is_set"); //$NON-NLS-1$
		
		assertEquals(1, textNotNull.getConstrainedElements().size());
		Operation oper = (Operation) textNotNull.getConstrainedElements().get(0);
		assertNotNull(oper);
		assertTrue(textNotNull.getKeywords().contains(UMLReflection.PRECONDITION));
		assertNotNull(getBodyExpression(textNotNull));
		assertMatchingContextVariables(oper, textNotNull);
		
		assertEquals(1, textNotLabel.getConstrainedElements().size());
		assertSame(oper, textNotLabel.getConstrainedElements().get(0));
		assertTrue(textNotLabel.getKeywords().contains(UMLReflection.PRECONDITION));
		assertNotNull(getBodyExpression(textNotLabel));
		assertMatchingContextVariables(oper, textNotLabel);
		
		assertEquals(1, labelIsChanged.getConstrainedElements().size());
		assertSame(oper, labelIsChanged.getConstrainedElements().get(0));
		assertTrue(labelIsChanged.getKeywords().contains(UMLReflection.POSTCONDITION));
		assertNotNull(getBodyExpression(labelIsChanged));
		assertMatchingContextVariables(oper, labelIsChanged);
		
		assertEquals(1, labelIsSet.getConstrainedElements().size());
		assertSame(oper, labelIsSet.getConstrainedElements().get(0));
		assertTrue(labelIsSet.getKeywords().contains(UMLReflection.POSTCONDITION));
		assertNotNull(getBodyExpression(labelIsSet));
		assertMatchingContextVariables(oper, labelIsSet);
	}
	
	public void test_initAndDerConstraints() {
		helper.setContext(apple);
		
		try {
			InstanceSpecification anApple = instantiate(instancePackage, apple);
			setValue(anApple, apple_label, "Foo"); //$NON-NLS-1$
			
			assertEquals("Foo", evaluate(helper, anApple, "self.name")); //$NON-NLS-1$ //$NON-NLS-2$
			
			clearValue(anApple, apple_label);
			
			assertEquals("", evaluate(helper, anApple, "self.name")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (ParserException e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	//
	// Framework methods
	//
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		instancePackage = umlf.createPackage();
		constraints = new java.util.HashMap<String, Constraint>();
		
		URL url = new URL(
				"platform:/plugin/org.eclipse.ocl.uml.tests/model/test_constraints.ocl"); //$NON-NLS-1$
		InputStream is = url.openStream();
		List<Constraint> parsed = ocl.parse(new OCLInput(is));
		is.close();
		
		for (Constraint ct : parsed) {
            validate(ct);
			constraints.put(ct.getName(), ct);
		}
	}
	
	@Override
	protected void tearDown() throws Exception {
	    unload(instancePackage);
	    instancePackage = null;
	    
	    unload(constraints.values());
	    constraints = null;
	    
	    super.tearDown();
	}
	
	Constraint getConstraint(String name) {
		Constraint result = constraints.get(name);
		assertNotNull("Did not find constraint " + name, result); //$NON-NLS-1$
		return result;
	}
	
	void assertMatchingContextVariables(Classifier context, Constraint constraint) {
		ExpressionInOCL spec = (ExpressionInOCL) constraint.getSpecification();
		UMLEnvironment env = (UMLEnvironment) ocl.getEnvironment();
		
		Variable<Classifier, Parameter> selfVar = spec.getContextVariable();
		assertNotNull(selfVar);
		assertEquals(Environment.SELF_VARIABLE_NAME, selfVar.getName());
		assertEquals(selfVar.getType(), env.getUMLReflection().getOCLType(context));
	}
	
	void assertMatchingContextVariables(Operation operation, Constraint constraint) {
		ExpressionInOCL spec = (ExpressionInOCL) constraint.getSpecification();
		UMLEnvironment env = (UMLEnvironment) ocl.getEnvironment();
		
		if (operation.getClass_() != null) {
			Variable<Classifier, Parameter> selfVar = spec.getContextVariable();
			assertNotNull(selfVar);
			assertEquals(Environment.SELF_VARIABLE_NAME, selfVar.getName());
			assertEquals(selfVar.getType(),
                env.getUMLReflection().getOCLType(operation.getClass_()));
		}
		
		if ((operation.getType() != null)
				&& !constraint.getKeywords().contains(UMLReflection.PRECONDITION)) {
			Variable<Classifier, Parameter> resultVar = spec.getResultVariable();
			assertNotNull(resultVar);
			assertEquals(Environment.RESULT_VARIABLE_NAME, resultVar.getName());
			assertEquals(resultVar.getType(),
                env.getUMLReflection().getOCLType(operation));
		}
		
		EList<Parameter> parms = new BasicEList.FastCompare<Parameter> (operation.getOwnedParameters());
		for (Iterator<Parameter> iter = parms.iterator(); iter.hasNext();) {
			if (iter.next().getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
				iter.remove();  // filter out return results
			}
		}
		EList<Variable<Classifier, Parameter>> vars = spec.getParameterVariable();
		
		assertEquals(parms.size(), vars.size());
		for (int i = 0; i < parms.size(); i++) {
			Variable<Classifier, Parameter> var = vars.get(i);
			Parameter parm = parms.get(i);
			
			assertEquals(var.getType(), env.getUMLReflection().getOCLType(parm));
		}
	}
}
