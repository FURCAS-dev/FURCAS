package com.sap.emf.ocl.hiddenopposites;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.parser.ValidationVisitor;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.util.TypeUtil;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite;

public class ValidationVisitorWithHiddenOpposite
        extends
        ValidationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
        implements VisitorWithHiddenOpposite<Boolean> {

    private Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env;

    /**
     * Obtains an instance of the validation visitor that validates against the specified environment, which presumably
     * was used in parsing the OCL in the first place.
     * 
     * @param environment
     *            an OCL environment (must no be <code>null</code>)
     * 
     * @return a validation visitor instance for the specified environment
     */
    public static ValidationVisitorWithHiddenOpposite getInstance(
	    Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment) {
	if (environment == null) {
	    throw new NullPointerException();
	}
	return new ValidationVisitorWithHiddenOpposite(environment);
    }

    protected ValidationVisitorWithHiddenOpposite(
	    Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment) {
	super(environment);
	env = environment;
    }

    public Boolean visitOppositePropertyCallExp(OppositePropertyCallExp pc) {
	EReference property = pc.getReferredOppositeProperty();
	OCLExpression<EClassifier> source = pc.getSource();
	EClassifier type = pc.getType();

	if (property == null) {
	    String message = OCLMessages.bind(OCLMessages.NullProperty_ERROR_, pc.toString());
	    return validatorError(pc, message, "visitPropertyCallExp");//$NON-NLS-1$
	}

	if (source == null) {
	    String message = OCLMessages.bind(OCLMessages.NullNavigationSource_ERROR_, pc.toString());
	    return validatorError(pc, message, "visitPropertyCallExp");//$NON-NLS-1$
	}
	if (type == null) {
	    String message = OCLMessages.bind(OCLMessages.NullNavigationType_ERROR_, pc.toString());
	    return validatorError(pc, message, "visitPropertyCallExp");//$NON-NLS-1$
	}

	if (visitFeatureCallExp(pc)) {
	    return Boolean.TRUE;
	}

	source.accept(this);

	EClassifier refType = TypeUtil.getPropertyType(env, source.getType(), property);

	if (!pc.getQualifier().isEmpty() && (refType instanceof CollectionType<?, ?>)) {
	    // qualifying the navigation results in a non-collection
	    // type
	    @SuppressWarnings("unchecked")
	    CollectionType<EClassifier, EOperation> ct = (CollectionType<EClassifier, EOperation>) refType;

	    refType = ct.getElementType();
	}

	return Boolean.valueOf(TypeUtil.exactTypeMatch(env, refType, type));
    }

    /**
     * Applies well-formedness rules for model property calls in general. This includes checking that "@pre" notation is
     * only used in a postcondition constraint.
     * 
     * @param exp
     *            the model property call expression to validate
     * 
     * @Return true if validation must terminate due to an error
     */
    private Boolean visitFeatureCallExp(FeatureCallExp<EClassifier> exp) {
	if (exp.isMarkedPre()) {
	    // check for a postcondition constraint
	    if (!env.isInPostcondition(exp)) {
		String message = OCLMessages.AtPreInPostcondition_ERROR_;
		return validatorError(exp, message, "visitFeatureCallExp");//$NON-NLS-1$
	    }
	}

	// check for static access to non-static features
	if (exp.getSource() != null) {
	    OCLExpression<EClassifier> source = exp.getSource();

	    if (source.getType() instanceof TypeType<?, ?>) {
		@SuppressWarnings("unchecked")
		TypeType<EClassifier, ?> typeType = (TypeType<EClassifier, ?>) source.getType();

		Object feature = null;

		if (exp instanceof OperationCallExp) {
		    feature = ((OperationCallExp) exp).getReferredOperation();

		    // operation must either be defined by the TypeType
		    // (e.g., allInstances()) or be a static operation of
		    // the referred classifier
		    if (!(typeType.oclOperations().contains(feature) || isStatic(feature))) {
			String message = OCLMessages.bind(OCLMessages.NonStaticOperation_ERROR_,
			        ((EOperation) feature).getName());
			return validatorError(exp, message, "visitFeatureCallExp");//$NON-NLS-1$
		    }
		} else if (exp instanceof PropertyCallExp) {
		    feature = ((PropertyCallExp) exp).getReferredProperty();

		    // property must be a static attribute of
		    // the referred classifier
		    if (!isStatic(feature)) {
			String message = OCLMessages.bind(OCLMessages.NonStaticAttribute_ERROR_,
			        ((PropertyCallExp) feature).getName());
			return validatorError(exp, message, "visitFeatureCallExp");//$NON-NLS-1$
		    }
		}
	    }
	}
	return Boolean.FALSE;
    }

    private boolean isStatic(Object feature) {
	return (env.getUMLReflection() != null) && env.getUMLReflection().isStatic(feature);
    }
}
