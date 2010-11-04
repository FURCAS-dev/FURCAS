package com.sap.emf.ocl.hiddenopposites;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;

import com.sap.emf.oppositeendfinder.ExtentMap;
import com.sap.emf.oppositeendfinder.OppositeEndFinder;

public class EvaluationEnvironmentWithHiddenOppositesImpl extends EcoreEvaluationEnvironment implements
        EvaluationEnvironmentWithHiddenOpposites {

    private final OppositeEndFinder oppositeEndFinder;
    private final OppositePropertyNavigator oppositePropertyNavigator;

    public EvaluationEnvironmentWithHiddenOppositesImpl(OppositeEndFinder oppositeEndFinder) {
	super();
	this.oppositeEndFinder = oppositeEndFinder;
	oppositePropertyNavigator = new OppositePropertyNavigator(oppositeEndFinder);
    }

    public EvaluationEnvironmentWithHiddenOppositesImpl(
	    EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
	super(parent);
	oppositeEndFinder = ((EvaluationEnvironmentWithHiddenOppositesImpl) parent).oppositeEndFinder;
        oppositePropertyNavigator = new OppositePropertyNavigator(oppositeEndFinder);
    }

    public Object navigateOppositeProperty(EStructuralFeature property, Object target) throws IllegalArgumentException {
	return oppositePropertyNavigator.navigateOppositeProperty(property, target);
    }

    /**
     * In the case of the "hidden opposites" OCL environment, an instance of the {@link ExtentMap} class is used. Is bases its
     * <code>allInstances</code> computations on the {@link OppositeEndFinder} passed to the constructor of this object. See
     * {@link OppositeEndFinder#getAllInstancesSeenBy(EClass, org.eclipse.emf.common.notify.Notifier)}.
     */
    @Override
    public Map<EClass, Set<EObject>> createExtentMap(Object object) {
        EObject context = null;
        if (object instanceof EObject) {
            context = (EObject) object;
        }
        return new ExtentMap(context, oppositeEndFinder);
    }
}
