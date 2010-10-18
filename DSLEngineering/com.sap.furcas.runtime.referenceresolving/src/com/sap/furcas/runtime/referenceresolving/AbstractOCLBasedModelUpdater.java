package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.trigger.AdapterForExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;

public class AbstractOCLBasedModelUpdater implements OCLBasedModelUpdater {
    private final EStructuralFeature propertyToUpdate;
    private final OppositeEndFinder oppositeEndFinder;
    private final ExpressionWithContext triggerExpression;

    protected AbstractOCLBasedModelUpdater(EStructuralFeature propertyToUpdate, OppositeEndFinder oppositeEndFinder, ExpressionWithContext triggerExpression) {
        super();
        this.propertyToUpdate = propertyToUpdate;
        this.oppositeEndFinder = oppositeEndFinder;
        this.triggerExpression = triggerExpression;
    }

    /**
     * This default implementation re-evaluates the {@link #triggerExpression} on each element reported as
     * affected and sets the {@link #getPropertyToUpdate() property} to update by this updater to the evaluation result.
     */
    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects, OppositeEndFinder oppositeEndFinder) {
        OCL ocl = OCLWithHiddenOpposites.newInstance(oppositeEndFinder);
        for (EObject eo : affectedContextObjects) {
            Object newValue = ocl.evaluate(eo, triggerExpression.getExpression());
            eo.eSet(getPropertyToUpdate(), newValue);
        }
    }

    protected OppositeEndFinder getOppositeEndFinder() {
        return oppositeEndFinder;
    }

    public EStructuralFeature getPropertyToUpdate() {
        return propertyToUpdate;
    }

    /**
     * Creates one adapter for each expression returned from {@link #getTriggerExpressionsWithContext()} and
     * {@link #getTriggerExpressionsWithoutContext()}. For the former, the context element 
     */
    @Override
    public Collection<AdapterForExpression> getAdapters(OppositeEndFinder oppositeEndFinder, ActivationOption impactAnalysisConfiguration) throws ParserException {
        Collection<AdapterForExpression> result = new LinkedList<AdapterForExpression>();
        for (ExpressionWithContext expWithContext : getTriggerExpressionsWithContext()) {
            result.add(new AdapterForExpression(this, expWithContext.getExpression(),
                triggerExpression.getContext(), expWithContext.isNotifyNewContextElements(), oppositeEndFinder, impactAnalysisConfiguration));
        }
        for (OCLExpression expWithoutContext : getTriggerExpressionsWithoutContext()) {
            result.add(new AdapterForExpression(this, expWithoutContext,
            /* notifyNewContextElements */false, oppositeEndFinder, impactAnalysisConfiguration));
        }
        return result;
    }

    /**
     * Notifications will be received by the adapters returned from {@link #getAdapters(OppositeEndFinder, ActivationOption)}
     * for the expressions returned by this method. They won't receive notifications for new context elements being created.
     */
    protected Collection<OCLExpression> getTriggerExpressionsWithoutContext() throws ParserException {
        return Collections.emptySet();
    }

    protected Collection<ExpressionWithContext> getTriggerExpressionsWithContext() {
        if (triggerExpression == null) {
            return Collections.emptySet();
        } else {
            return Collections.singleton(triggerExpression);
        }
    }

}
