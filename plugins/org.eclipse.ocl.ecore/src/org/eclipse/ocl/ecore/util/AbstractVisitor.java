package org.eclipse.ocl.ecore.util;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OppositePropertyCallExp;
import org.eclipse.ocl.utilities.VisitorExtension;


/**
 * Mixes in the {@link VisitorExtension} interface and provides a default implementation for
 * {@link OppositePropertyCallExp}.
 * 
 * @since 3.1
 */
public class AbstractVisitor<T>
		extends
		org.eclipse.ocl.utilities.AbstractVisitor<
		T, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint>
		implements VisitorExtension<
		T, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint> {
	/**
	 * Visits the opposite property-call source. No qualifiers are visited as
	 * these calls are not expected for UML but only for Ecore. Returns the
	 * result of
	 * {@link #handleOppositePropertyCallExp(OppositePropertyCallExp, Object)}.
	 * 
	 * @since 3.1
	 */
	public T visitOppositePropertyCallExp(OppositePropertyCallExp<EClassifier, EStructuralFeature> callExp) {
        T sourceResult = safeVisit(callExp.getSource());
        return handleOppositePropertyCallExp(callExp, sourceResult);
	}
    
    /**
     * Visits the specified opposite property call with the results of visiting
     * its source and qualifiers (if any).  Note that in the case of a opposite property
     * call expression as a qualifier of an association class call, the
     * opposite property call does not have a source and, therefore, the
     * <code>sourceResult</tt> will be <code>null</code> in that case.
     * 
     * @param callExp the opposite property call expression
     * @param sourceResult the result of visiting the expression's source
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitOppositePropertyCallExp(OppositePropertyCallExp)
     * @since 3.1
     */
    protected T handleOppositePropertyCallExp(OppositePropertyCallExp<EClassifier, EStructuralFeature> callExp,
            T sourceResult) {
        return result;
    }
    
}
