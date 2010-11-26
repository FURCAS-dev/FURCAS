package org.eclipse.ocl.ecore.internal.evaluation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OppositePropertyCallExp;
import org.eclipse.ocl.utilities.VisitorExtension;


public class TracingEvaluationVisitor
		extends
		org.eclipse.ocl.internal.evaluation.TracingEvaluationVisitor<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject>
		implements VisitorExtension<Object, 
		EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint> {

	public TracingEvaluationVisitor(EvaluationVisitor<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> decorated) {
		super(decorated);
	}

    /**
     * Delegates to my decorated visitor.
     * @since 3.1
     */
    @SuppressWarnings("unchecked")
	public Object visitOppositePropertyCallExp(OppositePropertyCallExp<EClassifier, EStructuralFeature> callExp) {
    	if (getDelegate() instanceof VisitorExtension) {
    		return ((VisitorExtension<Object, 
    				EClassifier, EOperation, EStructuralFeature,
    				EEnumLiteral, EParameter, EObject,
    				CallOperationAction, SendSignalAction, Constraint>) getDelegate()).visitOppositePropertyCallExp(callExp);
    	} else {
    		return null;
    	}
    }
}
