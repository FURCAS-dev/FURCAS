package org.eclipse.ocl.ecore.internal.helper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.internal.helper.HelperUtil;
import org.eclipse.ocl.internal.helper.OCLSyntaxHelper;


public class OCLHelperImpl
		extends
		org.eclipse.ocl.internal.helper.OCLHelperImpl<EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> {

	OCLHelperImpl(
			OCL<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> ocl) {
		super(ocl);
	}

	@Override
	protected HelperUtil<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createHelperUtil() {
		return new org.eclipse.ocl.ecore.internal.helper.HelperUtil();
	}

	@Override
	protected OCLSyntaxHelper<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createOCLSyntaxHelperInternal() {
		return new org.eclipse.ocl.ecore.internal.helper.OCLSyntaxHelper(getEnvironment());
	}

}
