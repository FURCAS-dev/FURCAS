/**
 * <copyright>
 *
 * Copyright (c) 2007, 2008 IBM Corporation and others.
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
 * $Id: OCLHelperImpl.java,v 1.4 2008/04/17 19:38:14 cdamus Exp $
 */

package org.eclipse.ocl.ecore;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;


/**
 * Implementation of the {@link OCL.Helper} convenience interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
class OCLHelperImpl implements OCL.Helper {
    private final OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> delegate;

    OCLHelperImpl(OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> delegate) {
        this.delegate = delegate;
    }

    public OCL getOCL() {
        return (OCL) delegate.getOCL();
    }
    
    public Environment<?, EClassifier, EOperation, EStructuralFeature, ?, ?, ?, ?, ?, Constraint, ?, ?> getEnvironment() {
        return delegate.getEnvironment();
    }
    
    public Constraint createConstraint(ConstraintKind kind, String expression)
        throws ParserException {
        return delegate.createConstraint(kind, expression);
    }
    
    public Constraint createBodyCondition(String expression)
        throws ParserException {
        return delegate.createBodyCondition(expression);
    }

    public Constraint createDerivedValueExpression(String expression)
        throws ParserException {
        return delegate.createDerivedValueExpression(expression);
    }

    public Constraint createInitialValueExpression(String expression)
        throws ParserException {
        return delegate.createInitialValueExpression(expression);
    }

    public Constraint createInvariant(String expression)
        throws ParserException {
        return delegate.createInvariant(expression);
    }

    public Constraint createPostcondition(String expression)
        throws ParserException {
        return delegate.createPostcondition(expression);
    }

    public Constraint createPrecondition(String expression)
        throws ParserException {
        return delegate.createPrecondition(expression);
    }

    public OCLExpression createQuery(String expression)
        throws ParserException {
        return (OCLExpression) delegate.createQuery(expression);
    }

    public EStructuralFeature defineAttribute(String defExpression)
        throws ParserException {
        return delegate.defineAttribute(defExpression);
    }

    public EOperation defineOperation(String defExpression)
        throws ParserException {
        return delegate.defineOperation(defExpression);
    }

    public EStructuralFeature getContextAttribute() {
        return delegate.getContextAttribute();
    }

    public EClassifier getContextClassifier() {
        return delegate.getContextClassifier();
    }

    public EOperation getContextOperation() {
        return delegate.getContextOperation();
    }

    public List<Choice> getSyntaxHelp(ConstraintKind constraintType, String txt) {
        return delegate.getSyntaxHelp(constraintType, txt);
    }

    public boolean isValidating() {
        return delegate.isValidating();
    }

    public void setContext(EClassifier context) {
        delegate.setContext(context);
    }

    public void setAttributeContext(EClassifier context, EStructuralFeature property) {
        delegate.setAttributeContext(context, property);
    }

    public void setOperationContext(EClassifier context, EOperation operation) {
        delegate.setOperationContext(context, operation);
    }

    public void setInstanceContext(Object instance) {
        delegate.setInstanceContext(instance);
    }
    
    public void setInstanceOperationContext(Object instance,
            EOperation operation) {
        delegate.setInstanceOperationContext(instance, operation);
    }
    
    public void setInstanceAttributeContext(Object instance,
            EStructuralFeature property) {
        delegate.setInstanceAttributeContext(instance, property);
    }
    
    public void setValidating(boolean validating) {
        delegate.setValidating(validating);
    }
    
    public Diagnostic getProblems() {
    	return delegate.getProblems();
    }
}
