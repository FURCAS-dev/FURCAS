package com.sap.emf.ocl.hiddenopposites;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ConstraintKind;

public class OCLHelperWithOppositesImpl implements OCL.Helper {
	private final OCL.Helper delegate;
	
	public OCLHelperWithOppositesImpl(OCL.Helper standardOCLHelper) {
		this.delegate = standardOCLHelper;
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
