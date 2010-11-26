package org.eclipse.ocl.ecore.internal.helper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.parser.OCLAnalyzer;
import org.eclipse.ocl.ecore.parser.ValidationVisitor;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.utilities.Visitor;

public class HelperUtil
		extends
		org.eclipse.ocl.internal.helper.HelperUtil<EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> {
	
	@Override
	protected Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getValidationVisitor(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		return ValidationVisitor.getInstance(env);
	}

	/** Not publicly visible */
	protected HelperUtil() {
	}

	@Override
	protected OCLAnalyzer createOCLAnalyzer(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			String prefix, String text) {
		return new OCLAnalyzer(env, (prefix + '\n' + text));
	}

	/**
	 * Creates an {@link OCLHelper} for the specified EMF metamodel.  The
	 * factory creates OCL environments (with the packages, classifiers, states,
	 * etc.) from the instances of the metaclasses that mimic OCL/UML
	 * classifiers.
	 * <p>
	 * The new helper validates the OCL expressions that it parses.
	 * </p>
	 * 
	 * @param ocl the metamodel-specific OCL environment	
	 * 
	 * @return the new OCL helper
	 */
	public static OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint>
	createOCLHelper(OCL<EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> ocl) {
		return new OCLHelperImpl(ocl);
	}

}
