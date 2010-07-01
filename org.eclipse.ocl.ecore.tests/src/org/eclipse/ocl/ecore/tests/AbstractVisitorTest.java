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
 * $Id: AbstractVisitorTest.java,v 1.5 2009/11/28 17:37:37 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.ExpressionInOCL;

/**
 * Tests the {@link AbstractVisitor} class.
 *
 * @author Christian W. Damus (cwdamus)
 */
@SuppressWarnings("nls")
public class AbstractVisitorTest
	extends AbstractTestSuite {
   
    /**
     * Tests that the results of handle/visit methods are percolated to the
     * root of the recursive visitation.
     */
    public void test_visitResults() {
        OCLExpression<EClassifier> expression = parse(
            "package ocltest context Apple " +
            "inv: Apple.allInstances()->select(label->notEmpty())->forAll(" +
            "a1, a2 | a1 <> a2 implies a1.label <> a2.label) " +
            "endpackage");
        
        TestVisitor<Integer> visitor = new TestVisitor<Integer>(0) {
            @Override
            protected Integer handlePropertyCallExp(
                    PropertyCallExp<EClassifier, EStructuralFeature> callExp,
                    Integer sourceResult, List<Integer> qualifierResults) {
                
                if (callExp.getReferredProperty() == apple_label) {
                    result++;
                }
                
                return result;
            }};
        
        assertEquals((Integer) 3, expression.accept(visitor));
    }
    
    /**
     * Tests that we don't NPE on visiting invariant constraints, which
     * specifications do not have result variables.
     */
    public void test_visitInvariantConstraint_210580() {
        helper.setContext(apple);
        
        try {
            Constraint constraint = helper.createInvariant(
                "Apple.allInstances()->select(label->notEmpty())->forAll(" +
                "a1, a2 | a1 <> a2 implies a1.label <> a2.label)");
            
            assertEquals(this, new TestVisitor<AbstractVisitorTest>(this).visitConstraint(constraint));
        } catch (Exception e) {
            fail("Should not have thrown: " + e.getLocalizedMessage());
        }
    }

    //
    // Framework methods
    //
    
    private static class TestVisitor<T> extends AbstractVisitor<T,
        EClassifier, EOperation, EStructuralFeature, EEnumLiteral,
        EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
        
        @SuppressWarnings("unused")
		public TestVisitor() {
            super();
        }
        
        public TestVisitor(T initialValue) {
            super(initialValue);
        }
        
        @Override
        protected ExpressionInOCL<EClassifier, EParameter> getSpecification(
                Constraint constraint) {
            return constraint.getSpecification();
        }
    }
}
