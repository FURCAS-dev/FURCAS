package org.eclipse.ocl.ecore.internal.helper;

import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EnvironmentWithHiddenOpposites;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.internal.helper.ChoiceImpl;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.osgi.util.NLS;


public class OCLSyntaxHelper
		extends
		org.eclipse.ocl.internal.helper.OCLSyntaxHelper<EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> {

	OCLSyntaxHelper(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		super(env);
	}

	@Override
	protected OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createOCLAnalyzer(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			String newTxt) {
		return new org.eclipse.ocl.ecore.parser.OCLAnalyzer(env, newTxt);
	}

	/**
	 * returns the choices list of structural features for the passed eclass
	 * @param eClass the eclass to get features from 
	 * @return List oclchoices list for structural features
	 */
	protected List<Choice> getPropertyChoices(EClassifier eClass) {
		List<Choice> result = super.getPropertyChoices(eClass);
		for (Entry<String, EStructuralFeature> hiddenOppositeNameAndForwardProperty : ((EnvironmentWithHiddenOpposites) getEnvironment())
			.getHiddenOppositeProperties(eClass).entrySet()) {
			result.add(new ChoiceImpl(hiddenOppositeNameAndForwardProperty
				.getKey(), NLS
				.bind(OCLMessages.HiddenOppositeOf,
					getDescription(hiddenOppositeNameAndForwardProperty
						.getValue())), ChoiceKind.PROPERTY,
				hiddenOppositeNameAndForwardProperty.getValue()));
		}
		return result;
	}
	
}
