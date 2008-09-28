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
 *   Zeligsoft - Bug 248869
 *
 * </copyright>
 *
 * $Id: OperationConstraintsTest.java,v 1.6 2008/09/28 17:34:22 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collections;
import java.util.Iterator;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.VariableExp;


/**
 * Tests support for operation constraints (pre/post/body).
 *
 * @author Christian W. Damus (cdamus)
 */
public class OperationConstraintsTest extends AbstractTestSuite {

	public OperationConstraintsTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(OperationConstraintsTest.class,
			"Operation Constraints"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a very simple precondition, with a package and operation context.
	 */
	public void test_simplePrecondition() {
		parseConstraint(
			"package ocltest context Fruit::ripen(color : Color) : Boolean " + //$NON-NLS-1$
			"pre: color <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a very simple postcondition, with a package and operation context
	 * and using the "self" variable to disambiguate the name "color".
	 */
	public void test_simplePostcondition() {
		parseConstraint(
			"package ocltest context Fruit::ripen(color : Color) : Boolean " + //$NON-NLS-1$
			"post: self.color = color " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a postcondition containing the "@pre" construct.
	 */
	public void test_postcondition_atPre() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"post: color <> color@pre implies color = c " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a postcondition containing the "@pre" construct on an operation call.
	 */
	public void test_postcondition_atPre_operation() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"post: preferredColor() <> preferredColor@pre() implies color = c " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests availability of the special "result" variable in postconditions.
	 */
	public void test_postcondition_result() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"post: result implies color <> color@pre " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that in case of multiple constraints, each defines its own namespace
	 * for local variables (we don't get errors on multiple declarations).
	 */
	public void test_namespaces() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"pre notBlack: let ok : Boolean = c <> Color::black in " + //$NON-NLS-1$
			"  ok " + //$NON-NLS-1$
			"pre different: let ok : Boolean = c <> color in " + //$NON-NLS-1$
			"  ok " + //$NON-NLS-1$
			"body: let b : Boolean = c <> color in " + //$NON-NLS-1$
			"  b implies color <> Color::black " + //$NON-NLS-1$
			"post worked: result implies color <> color@pre " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Checks that we correctly reject illegal use of "@pre" in precondition
	 * constraints.
	 */
	public void test_illegalUseOfAtPre_precondition() {
		AssertionFailedError err = null;
		
		try {
			parseConstraint(
				"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
				"pre: c <> color@pre " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have succeeded in validating illegal @pre", err); //$NON-NLS-1$
	}
	
	/**
	 * Checks that we correctly reject illegal use of "@pre" in invariant
	 * constraints.
	 */
	public void test_illegalUseOfAtPre_invariant() {
		AssertionFailedError err = null;
		
		try {
			parseConstraint(
				"package ocltest context Fruit " + //$NON-NLS-1$
				"inv: color@pre <> Color::black " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			// success
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have succeeded in validating illegal @pre", err); //$NON-NLS-1$
	}
	
	/**
	 * Checks that we correctly reject illegal use of "@pre" in postcondition
	 * constraints (where the "@pre" is not used on a model property expression).
	 */
	public void test_illegalUseOfAtPre_postcondition() {
		AssertionFailedError err = null;
		
		try {
			parseConstraint(
				"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
				"post: let oldColor : Color = color in c <> oldColor@pre " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull("Should not have succeeded in validating illegal @pre", err); //$NON-NLS-1$
	}
	
	/**
	 * Tests that local variables correctly hide attributes of the context
	 * classifier. 
	 */
	public void test_variablesHidingAttributes() {
		parseConstraint(
			"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
			"pre: let color : Boolean = (c = self.color) in " + //$NON-NLS-1$
			"  color implies c <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that parameters are in the same scope as local variables (cannot
	 * use same names). 
	 */
	public void test_parametersAreLocalVariables() {
		AssertionFailedError err = null;
		
		try {
			parseConstraint(
				"package ocltest context Fruit::ripen(c : Color) : Boolean " + //$NON-NLS-1$
				"pre: color : Boolean = (c = self.color) in " + //$NON-NLS-1$
				"  color implies c <> Color::black " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(err);
	}
	
	/**
	 * Tests that body conditions are correctly checked for conformance to the
	 * operation type. 
	 */
	public void test_bodyConditionConformance() {
		AssertionFailedError err = null;
		
		try {
			// try a scenario with no common supertype
			parseConstraint(
				"package ocltest context Fruit::preferredColor() : Color " + //$NON-NLS-1$
				"body: result = (if true then 'red' else 'brown' endif) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(err);
		err = null;
		
		try {
			// try a scenario with a common supertype
			parseConstraint(
				"package ocltest context Apple::newApple() : Apple " + //$NON-NLS-1$
				"body: result = self.newFruit() " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(err);
		err = null;
		
		try {
			// this scenario is OK
			parseConstraint(
				"package ocltest context Apple::newFruit() : Fruit " + //$NON-NLS-1$
				"body: result = self.newApple() " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.err.println("Got unexpected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNull(err);
	}
	
	/**
	 * Tests that body conditions are not allowed for void operations. 
	 */
	public void test_bodyConditionVoidOperation() {
		AssertionFailedError err = null;
		
		try {
			parseConstraint(
				"package ocltest context Apple::label(newLabel : String) : " + //$NON-NLS-1$
				"body: result = (if true then 'Spy' else 'Spartan' endif) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		} catch (AssertionFailedError e) {
			err = e;
			System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(err);
	}
	
	/**
	 * Tests that when a parameter name (or any other local variable, for that
	 * matter) coincides with an attribute name, we correctly distinguish
	 * references to the variable from references to the attribute.
	 */
	public void test_parameterNameCoincidesWithAttributeName_140008() {
		EOperation foo = EcoreFactory.eINSTANCE.createEOperation();
		foo.setName("foo"); //$NON-NLS-1$
		EParameter parm = EcoreFactory.eINSTANCE.createEParameter();
		parm.setName("str"); //$NON-NLS-1$
		parm.setEType(EcorePackage.Literals.ESTRING);
		foo.getEParameters().add(parm);
		foo.setEType(EcorePackage.Literals.ESTRING);
		apple.getEOperations().add(foo);
		EAttribute myStr = EcoreFactory.eINSTANCE.createEAttribute();
		myStr.setName("str"); //$NON-NLS-1$
		myStr.setEType(EcorePackage.Literals.ESTRING);
		apple.getEStructuralFeatures().add(myStr);
		
		try {
			OCLExpression<EClassifier> expr = parseConstraint(
				"package ocltest context Apple::foo(str : String) : String " + //$NON-NLS-1$
				"body: result = (if str = self.str then '' else str endif) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
			
			int propertyCalls = 0;
			int variableCalls = 0;
			for (Iterator<?> iter = EcoreUtil.getAllContents(Collections.singleton(expr)); iter.hasNext();) {
				Object next = iter.next();
				if (next instanceof PropertyCallExp) {
					@SuppressWarnings("unchecked")
					PropertyCallExp<EClassifier, EStructuralFeature> pc =
						(PropertyCallExp<EClassifier, EStructuralFeature>) next;
					
					if ("str".equals(pc.getReferredProperty().getName())) { //$NON-NLS-1$
						propertyCalls++;
					}
				} else if (next instanceof VariableExp) {
					@SuppressWarnings("unchecked")
					VariableExp<EClassifier, EParameter> v =
						(VariableExp<EClassifier, EParameter>) next;
					
					if ("str".equals(v.getReferredVariable().getName())) { //$NON-NLS-1$
						variableCalls++;
					}
				}
			}
			
			assertEquals("property calls", 1, propertyCalls); //$NON-NLS-1$
			assertEquals("variable calls", 2, variableCalls); //$NON-NLS-1$
		} finally {
			apple.getEOperations().remove(foo);
			apple.getEStructuralFeatures().remove(myStr);
		}
	}
	
	/**
	 * Tests that an expression resolves the implicit source of a property call
	 * correctly when the environment has additional variable names such as
	 * parameters that define the same property.  This test parses raw OCL.
	 */
	@SuppressWarnings("unchecked")
	public void test_implicitPropertySourceLookup_raw_151234() {
		OCLExpression<EClassifier> expr = parseConstraint(
			"package ocltest context Apple::setColor(fruit : Fruit, newColor : Color) : " + //$NON-NLS-1$
			"pre: color <> newColor " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$

		assertTrue(expr instanceof OperationCallExp);
		OperationCallExp<EClassifier, EOperation> notEquals =
			(OperationCallExp<EClassifier, EOperation>) expr;
		assertTrue(notEquals.getSource() instanceof PropertyCallExp);
		PropertyCallExp<EClassifier, EStructuralFeature> propertyCall =
			(PropertyCallExp<EClassifier, EStructuralFeature>) notEquals.getSource();
		
		assertTrue(propertyCall.getSource() instanceof VariableExp);
		VariableExp<EClassifier, EParameter> var =
			(VariableExp<EClassifier, EParameter>) propertyCall.getSource();
		
		// we did not resolve against "fruit", which also has a color property
		assertEquals("self", var.getReferredVariable().getName()); //$NON-NLS-1$
		
		// now check the resolution of implicit iterator variables as sources
		expr = parseConstraint(
				"package ocltest context Apple::setColor(fruit : Fruit, newColor : Color) : " + //$NON-NLS-1$
				"pre: Fruit.allInstances()->forAll(color <> newColor) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$

		assertTrue(expr instanceof IteratorExp);
		IteratorExp<EClassifier, EParameter> forAll =
			(IteratorExp<EClassifier, EParameter>) expr;
		assertTrue(forAll.getBody() instanceof OperationCallExp);
		notEquals = (OperationCallExp<EClassifier, EOperation>) forAll.getBody();
		assertTrue(notEquals.getSource() instanceof PropertyCallExp);
		propertyCall = (PropertyCallExp<EClassifier, EStructuralFeature>) notEquals.getSource();
		
		assertTrue(propertyCall.getSource() instanceof VariableExp);
		var = (VariableExp<EClassifier, EParameter>) propertyCall.getSource();
		
		// we did not resolve against "fruit", which also has a color property
		assertTrue(var.getReferredVariable().getName().startsWith("temp")); //$NON-NLS-1$
	}
	
	/**
	 * Tests that an expression resolves the implicit source of a property call
	 * correctly when the environment has additional variable names such as
	 * parameters that define the same property.  This test uses a helper.
	 */
	@SuppressWarnings("unchecked")
	public void test_implicitPropertySourceLookup_helper_151234() {
		try {
			helper.setOperationContext(fruit, fruit_setColor);
			OCLExpression<EClassifier> expr =
				helper.createPrecondition("color <> newColor").getSpecification().getBodyExpression(); //$NON-NLS-1$
	
			assertTrue(expr instanceof OperationCallExp);
			OperationCallExp<EClassifier, EOperation> notEquals =
				(OperationCallExp<EClassifier, EOperation>) expr;
			assertTrue(notEquals.getSource() instanceof PropertyCallExp);
			PropertyCallExp<EClassifier, EStructuralFeature> propertyCall =
				(PropertyCallExp<EClassifier, EStructuralFeature>) notEquals.getSource();
			
			assertTrue(propertyCall.getSource() instanceof VariableExp);
			VariableExp<EClassifier, EParameter> var =
				(VariableExp<EClassifier, EParameter>) propertyCall.getSource();
			
			// we did not resolve against "fruit", which also has a color property
			assertEquals("self", var.getReferredVariable().getName()); //$NON-NLS-1$
			
			// now check the resolution of implicit iterator variables as sources
			expr = helper.createPrecondition(
					"Fruit.allInstances()->forAll(color <> newColor)").getSpecification().getBodyExpression(); //$NON-NLS-1$
	
			assertTrue(expr instanceof IteratorExp);
			IteratorExp<EClassifier, EParameter> forAll = (IteratorExp<EClassifier, EParameter>) expr;
			assertTrue(forAll.getBody() instanceof OperationCallExp);
			notEquals = (OperationCallExp<EClassifier, EOperation>) forAll.getBody();
			assertTrue(notEquals.getSource() instanceof PropertyCallExp);
			propertyCall = (PropertyCallExp<EClassifier, EStructuralFeature>) notEquals.getSource();
			
			assertTrue(propertyCall.getSource() instanceof VariableExp);
			var = (VariableExp<EClassifier, EParameter>) propertyCall.getSource();
			
			// we did not resolve against "fruit", which also has a color property
			assertTrue(var.getReferredVariable().getName().startsWith("temp")); //$NON-NLS-1$
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests that an expression resolves the implicit source of an operation call
	 * correctly when the environment has additional variable names such as
	 * parameters that define the same property.  This test parses raw OCL.
	 */
	@SuppressWarnings("unchecked")
	public void test_implicitOperationSourceLookup_raw_151234() {
		OCLExpression<EClassifier> expr = parseConstraint(
			"package ocltest context Apple::setColor(fruit : Fruit, newColor : Color) : " + //$NON-NLS-1$
			"pre: preferredColor() <> newColor " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$

		assertTrue(expr instanceof OperationCallExp);
		OperationCallExp<EClassifier, EOperation> notEquals =
			(OperationCallExp<EClassifier, EOperation>) expr;
		assertTrue(notEquals.getSource() instanceof OperationCallExp);
		OperationCallExp<EClassifier, EOperation> operationCall =
			(OperationCallExp<EClassifier, EOperation>) notEquals.getSource();
		
		assertTrue(operationCall.getSource() instanceof VariableExp);
		VariableExp<EClassifier, EParameter> var =
			(VariableExp<EClassifier, EParameter>) operationCall.getSource();
		
		// we did not resolve against "fruit", which also has a color property
		assertEquals("self", var.getReferredVariable().getName()); //$NON-NLS-1$
		
		// now check the resolution of implicit iterator variables as sources
		expr = parseConstraint(
				"package ocltest context Apple::setColor(fruit : Fruit, newColor : Color) : " + //$NON-NLS-1$
				"pre: Fruit.allInstances()->forAll(preferredColor() <> newColor) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$

		assertTrue(expr instanceof IteratorExp);
		IteratorExp<EClassifier, EParameter> forAll = (IteratorExp<EClassifier, EParameter>) expr;
		assertTrue(forAll.getBody() instanceof OperationCallExp);
		notEquals = (OperationCallExp<EClassifier, EOperation>) forAll.getBody();
		assertTrue(notEquals.getSource() instanceof OperationCallExp);
		operationCall = (OperationCallExp<EClassifier, EOperation>) notEquals.getSource();
		
		assertTrue(operationCall.getSource() instanceof VariableExp);
		var = (VariableExp<EClassifier, EParameter>) operationCall.getSource();
		
		// we did not resolve against "fruit", which also has a color property
		assertTrue(var.getReferredVariable().getName().startsWith("temp")); //$NON-NLS-1$
	}
	
	/**
	 * Tests that an expression resolves the implicit source of an operation call
	 * correctly when the environment has additional variable names such as
	 * parameters that define the same property.  This test uses a helper.
	 */
	@SuppressWarnings("unchecked")
	public void test_implicitOperationSourceLookup_helper_151234() {
		try {
			helper.setOperationContext(fruit, fruit_setColor);
			OCLExpression<EClassifier> expr = helper.createPrecondition(
					"preferredColor() <> newColor").getSpecification().getBodyExpression(); //$NON-NLS-1$
	
			assertTrue(expr instanceof OperationCallExp);
			OperationCallExp<EClassifier, EOperation> notEquals =
				(OperationCallExp<EClassifier, EOperation>) expr;
			assertTrue(notEquals.getSource() instanceof OperationCallExp);
			OperationCallExp<EClassifier, EOperation> operationCall =
				(OperationCallExp<EClassifier, EOperation>) notEquals.getSource();
			
			assertTrue(operationCall.getSource() instanceof VariableExp);
			VariableExp<EClassifier, EParameter> var =
				(VariableExp<EClassifier, EParameter>) operationCall.getSource();
			
			// we did not resolve against "fruit", which also has a color property
			assertEquals("self", var.getReferredVariable().getName()); //$NON-NLS-1$
			
			// now check the resolution of implicit iterator variables as sources
			expr = helper.createPrecondition(
					"Fruit.allInstances()->forAll(preferredColor() <> newColor)").getSpecification().getBodyExpression(); //$NON-NLS-1$
	
			assertTrue(expr instanceof IteratorExp);
			IteratorExp<EClassifier, EParameter> forAll =
				(IteratorExp<EClassifier, EParameter>) expr;
			assertTrue(forAll.getBody() instanceof OperationCallExp);
			notEquals = (OperationCallExp<EClassifier, EOperation>) forAll.getBody();
			assertTrue(notEquals.getSource() instanceof OperationCallExp);
			operationCall = (OperationCallExp<EClassifier, EOperation>) notEquals.getSource();
			
			assertTrue(operationCall.getSource() instanceof VariableExp);
			var = (VariableExp<EClassifier, EParameter>) operationCall.getSource();
			
			// we did not resolve against "fruit", which also has a color property
			assertTrue(var.getReferredVariable().getName().startsWith("temp")); //$NON-NLS-1$
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
    
    /**
     * Tests that body conditions are correctly checked for conformance to the
     * operation type when they are specified as OCL body expressions, not as
     * UML body constraints. 
     */
    public void test_bodyExpressionConformance_185345() {
        AssertionFailedError err = null;
        
        try {
            // try a scenario with no common supertype
            parseConstraint(
                "package ocltest context Fruit::preferredColor() : Color " + //$NON-NLS-1$
                "body: if true then 'red' else 'brown' endif " + //$NON-NLS-1$
                "endpackage"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            err = e;
            System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        assertNotNull(err);
        err = null;
        
        try {
            // try a scenario with a common supertype
            parseConstraint(
                "package ocltest context Apple::newApple() : Apple " + //$NON-NLS-1$
                "body: self.newFruit() " + //$NON-NLS-1$
                "endpackage"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            err = e;
            System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        assertNotNull(err);
        err = null;
        
        try {
            // this scenario is OK
            parseConstraint(
                "package ocltest context Apple::newFruit() : Fruit " + //$NON-NLS-1$
                "body: self.newApple() " + //$NON-NLS-1$
                "endpackage"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            err = e;
            System.err.println("Got unexpected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        assertNull(err);
    }
    
    /**
     * Tests that OCL body expressions cannot reference the result of the
     * operation. 
     */
    public void test_bodyExpressionResultUsage_185345() {
        AssertionFailedError err = null;
        
        try {
            // not allowed to reference the result variable
            parseConstraint(
                "package ocltest context Apple::preferredLabel(text : String) : String " + //$NON-NLS-1$
                "body: if true then text else result endif " + //$NON-NLS-1$
                "endpackage"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            err = e;
            System.out.println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        assertNotNull(err);
        err = null;
        
        // unless, of course, 'result' is a parameter name
        parseConstraint(
            "package ocltest context Apple::preferredLabel(result : String) : String " + //$NON-NLS-1$
            "body: if true then 'me' else result endif " + //$NON-NLS-1$
            "endpackage"); //$NON-NLS-1$
    }
    
    /**
     * Now that body expressions can be specified as OCL intended, we can use
     * them to evaluate operations at run-time. 
     */
    public void test_bodyExpressionEvaluation_185345() {
        parseConstraint(
            "package ocltest context Fruit::preferredColor() : Color " + //$NON-NLS-1$
            "body: if color = Color::black then Color::red else Color::black endif " + //$NON-NLS-1$
            "endpackage"); //$NON-NLS-1$
        
        OCLExpression<EClassifier> query = parse(
            "package ocltest context Apple " + //$NON-NLS-1$
            "inv: self.preferredColor() " + //$NON-NLS-1$
            "endpackage"); //$NON-NLS-1$
        
        EObject anApple = fruitFactory.create(apple);
        anApple.eSet(fruit_color, color_black);
        
        assertSame(color_red, evaluate(query, anApple));
        
        anApple.eSet(fruit_color, color_green);
        
        assertSame(color_black, evaluate(query, anApple));
    }
}
