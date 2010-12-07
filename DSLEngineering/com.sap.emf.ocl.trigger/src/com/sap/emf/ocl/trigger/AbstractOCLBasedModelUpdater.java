package com.sap.emf.ocl.trigger;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.util.EcoreEnvironmentFactoryWithScopedExtentMap;

public class AbstractOCLBasedModelUpdater extends AbstractTriggerable implements OCLBasedModelUpdater {
    private final EStructuralFeature propertyToUpdate;
    private final OppositeEndFinder oppositeEndFinder;

    protected AbstractOCLBasedModelUpdater(EStructuralFeature propertyToUpdate, OppositeEndFinder oppositeEndFinder,
            ExpressionWithContext triggerExpression, boolean notifyOnNewContextElements) {
        super(Collections.singleton(triggerExpression), null, notifyOnNewContextElements);
        this.propertyToUpdate = propertyToUpdate;
        this.oppositeEndFinder = oppositeEndFinder;
    }

    /**
     * This default implementation re-evaluates the {@link #triggerExpression} on each element reported as affected and
     * sets the {@link #getPropertyToUpdate() property} to update by this updater to the evaluation result.
     */
    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects,
            OppositeEndFinder oppositeEndFinder) {
        OCL ocl = OCL.newInstance(new EcoreEnvironmentFactoryWithScopedExtentMap(oppositeEndFinder));
        for (EObject eo : affectedContextObjects) {
            Object newValue = ocl.evaluate(eo, expression);
            eo.eSet(getPropertyToUpdate(), newValue);
        }
    }

    protected OppositeEndFinder getOppositeEndFinder() {
        return oppositeEndFinder;
    }

    public EStructuralFeature getPropertyToUpdate() {
        return propertyToUpdate;
    }

}
