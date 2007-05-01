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
 * $Id: AbstractVisitorTest.java,v 1.1 2007/05/01 15:25:06 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

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

/**
 * Tests the {@link AbstractVisitor} class.
 *
 * @author Christian W. Damus (cwdamus)
 */
public class AbstractVisitorTest
	extends AbstractTestSuite {

	public AbstractVisitorTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(AbstractVisitorTest.class, "AbstractVisitor Tests"); //$NON-NLS-1$
	}
    
    /**
     * Tests that the results of handle/visit methods are percolated to the
     * root of the recursive visitation.
     */
    public void test_visitResults() {
        OCLExpression<EClassifier> expression = parse(
            "package ocltest context Apple " + //$NON-NLS-1$
            "inv: Apple.allInstances()->select(label->notEmpty())->forAll(" + //$NON-NLS-1$
            "a1, a2 | a1 <> a2 implies a1.label <> a2.label) " + //$NON-NLS-1$
            "endpackage"); //$NON-NLS-1$
        
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

    //
    // Framework methods
    //
    
    private static class TestVisitor<T> extends AbstractVisitor<T,
        EClassifier, EOperation, EStructuralFeature, EEnumLiteral,
        EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
        
        public TestVisitor() {
            super();
        }
        
        public TestVisitor(T initialValue) {
            super(initialValue);
        }
    }
}
