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
 * $Id: ValidationTest.java,v 1.2 2007/02/14 14:45:48 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.UMLReflection;


/**
 * Tests the validation of OCL expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ValidationTest extends AbstractTestSuite {

	public ValidationTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(ValidationTest.class,
			"Expression Validation Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that operation calls may only invoke query operations. 
	 */
	public void test_callNonQueryOperation_136778() {
		// newApple() is not a query operation
		OCLExpression<EClassifier> expr = parseConstraintUnvalidated(
				"package ocltest context Apple " + //$NON-NLS-1$
				"inv: Apple.allInstances()->includes(self.newApple()) " + //$NON-NLS-1$
				"endpackage"); //$NON-NLS-1$
		
		try {
			ocl.validate(expr);
			fail("Should not have successfully validated"); //$NON-NLS-1$
		} catch (SemanticException e) {
			// success
			System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
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

		public EcoreEnvironment createEnvironment() {
			return new CustomFruitEnvironment(this);
		}

		public EcoreEnvironment createEnvironment(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			return new CustomFruitEnvironment(this, parent);
		}
	}
	
	private class CustomFruitEnvironment extends EcoreEnvironment {
		public CustomFruitEnvironment(CustomFruitEnvironmentFactory factory) {
			super(EPackage.Registry.INSTANCE);
			
			setFactory(factory);
			setContextPackage(fruitPackage);
		}
		
		public CustomFruitEnvironment(
				CustomFruitEnvironmentFactory factory,
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			super(parent);
			
			setFactory(factory);
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
