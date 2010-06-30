package com.sap.emf.ocl.hiddenopposites;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;

public class OCLWithHiddenOpposites extends OCL {

	protected OCLWithHiddenOpposites(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		super(env);
	}

	protected OCLWithHiddenOpposites(
			EcoreEnvironmentFactoryWithHiddenOpposites envFactory,
			Resource resource) {
		super(envFactory, resource);
	}

	protected OCLWithHiddenOpposites(EcoreEnvironmentFactoryWithHiddenOpposites envFactory) {
		super(envFactory);
	}

	@Override
	public Helper createOCLHelper() {
		return new OCLHelperWithOppositesImpl(super.createOCLHelper());
	}
	
	

}
