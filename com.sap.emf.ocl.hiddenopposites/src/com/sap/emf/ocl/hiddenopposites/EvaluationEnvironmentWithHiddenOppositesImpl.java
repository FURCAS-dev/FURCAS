package com.sap.emf.ocl.hiddenopposites;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;

public class EvaluationEnvironmentWithHiddenOppositesImpl extends EcoreEvaluationEnvironment implements
        EvaluationEnvironmentWithHiddenOpposites {

    private final OppositeEndFinder oppositeEndFinder;

    public EvaluationEnvironmentWithHiddenOppositesImpl(OppositeEndFinder oppositeEndFinder) {
	super();
	this.oppositeEndFinder = oppositeEndFinder;
    }

    public EvaluationEnvironmentWithHiddenOppositesImpl(
	    EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
	super(parent);
	oppositeEndFinder = ((EvaluationEnvironmentWithHiddenOppositesImpl) parent).oppositeEndFinder;
    }

    public Object navigateOppositeProperty(EStructuralFeature property, Object target) throws IllegalArgumentException {
	Object result;
	if (property instanceof EReference && ((EReference) property).isContainment()) {
	    result = ((EObject) target).eContainer();
	} else if (oppositeEndFinder == null) {
	    result = null;
	} else {
	    result = oppositeEndFinder.navigateOppositePropertyWithForwardScope(property, (EObject) target);
	}
	return result;
    }

    @Override
    public Map<EClass, Set<EObject>> createExtentMap(Object object) {
        if (object instanceof EObject) {
            return new ExtentMap((EObject) object, oppositeEndFinder);
        } else {
            return Collections.emptyMap();
        }
    }
}
