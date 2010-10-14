package com.sap.emf.ocl.hiddenopposites;

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

import com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite;

public interface EvaluationVisitorWithHiddenOpposites extends
		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter,
		EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>,
		VisitorWithHiddenOpposite<Object> {

}
