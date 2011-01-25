/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation and others.
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
 * $Id: ValidationTest.java,v 1.8 2011/01/25 10:43:36 auhl Exp $
 */

package org.eclipse.ocl.ecore.tests;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.UMLReflection;


/**
 * Tests the validation of OCL expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ValidationTest extends AbstractTestSuite {
	
	/**
	 * Tests that operation calls may only invoke query operations. 
	 */
	public void test_callNonQueryOperation_136778() {
		// newApple() is not a query operation
		OCLExpression<EClassifier> expr = parseConstraintUnvalidated(
				"package ocltest context Apple " +
				"inv: Apple.allInstances()->includes(self.newApple()) " +
				"endpackage");
		
		try {
			ocl.validate(expr);
			fail("Should not have successfully validated");
		} catch (SemanticException e) {
			// success
			System.out.println("Got expected exception: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests that only one problem is reported for a sequence of call
	 * expressions on an unrecognized variable (<tt>simpleNameCS</tt>).
	 */
	public void test_callExpOnUnrecognizedVariable_226083() {
		helper.setContext(apple);
		
		try {
			helper.createInvariant(
				"noSuchVariable.noSuchProperty->includes(self.noSuchOperation())");
			fail("Should not have successfully parsed");
		} catch (SemanticException e) {
			// success: semantic parse failed (not concrete parse)
			Diagnostic diagnostic = e.getDiagnostic();
			assertNotNull(diagnostic);
			assertEquals(Diagnostic.ERROR, diagnostic.getSeverity());
			
			// the problem reported is the unrecognized 'noSuchVariable'
			assertTrue(diagnostic.getMessage().contains("noSuchVariable"));
			
			// there is no complaint about the 'noSuchProperty' but there
			// is a complaint about 'noSuchOperation'
			boolean found = false;
			for (Diagnostic child : diagnostic.getChildren()) {
				assertFalse(child.getMessage().contains("noSuchProperty"));
				found = found || child.getMessage().contains("noSuchOperation");
			}
		} catch (ParserException e) {
			fail("Wrong kind of parse failure: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Tests that only one problem is reported for an iterator expression
	 * on an unparseable source expression.
	 */
	public void test_bodyOfUnrcognizableIteratorSource_226083() {
		helper.setContext(apple);
		
		try {
			helper.createInvariant(
				"Set{noSuchVariable}->forAll(e | e.noSuchOperation())");
			fail("Should not have successfully parsed");
		} catch (SemanticException e) {
			// success: semantic parse failed (not concrete parse)
			Diagnostic diagnostic = e.getDiagnostic();
			assertNotNull(diagnostic);
			assertEquals(Diagnostic.ERROR, diagnostic.getSeverity());
			
			// the problem reported is the unrecognized 'noSuchVariable'
			assertTrue(diagnostic.getMessage().contains("noSuchVariable"));
			
			// only one problem was reported, not two (the noSuchOperation
			// operation was not attempted)
			assertEquals(0, diagnostic.getChildren().size());
		} catch (ParserException e) {
			fail("Wrong kind of parse failure: " + e.getLocalizedMessage());
		}
	}

	//
	// Fixture methods
	//
	

	@Override
	protected OCL createOCL() {
		return OCL.newInstance(new CustomFruitEnvironmentFactory());
	}
	
	private class CustomFruitEnvironmentFactory extends EcoreEnvironmentFactory {

		public CustomFruitEnvironmentFactory() {
			super(resourceSet.getPackageRegistry());
		}

		@Override
        public EcoreEnvironment createEnvironment() {
			return new CustomFruitEnvironment(this);
		}

		@Override
        public EcoreEnvironment createEnvironment(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			return new CustomFruitEnvironment(this, parent);
		}
	}
	
	private class CustomFruitEnvironment extends EcoreEnvironment {
		public CustomFruitEnvironment(CustomFruitEnvironmentFactory factory) {
			super(factory, null);
			setContextPackage(fruitPackage);
		}
		
		public CustomFruitEnvironment(
				CustomFruitEnvironmentFactory factory,
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			super(parent);
		}
		
        
        @Override
        public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
            return new UMLReflectionImpl() {
        		@Override
        		public boolean isQuery(EOperation operation) {
        			return operation != apple_newApple;
        		}};
        }
	}
}
