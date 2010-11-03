package com.sap.emf.ocl.attributegrammar.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;

/**
 * Handles change notifications that are relevant for a specific {@link OCLExpression} which defines
 * the value for a {@link EStructuralFeature feature}. When an event has occurred, the set of objects
 * potentially affected by the change is computed and the expression is re-evaluated for each of them.
 * The resulting value is then assigned to the respective feature.
 * 
 * @author Axel Uhl
 */
public class UpdateListener extends AdapterImpl {
    private final EStructuralFeature feature;
    private final OCLExpression oclExpression;
    private final ImpactAnalyzer impactAnalyzer;
    private final OCL ocl;

    public UpdateListener(EStructuralFeature feature, OCLExpression oclExpression, ImpactAnalyzer impactAnalyzer,
            OCL ocl) {
        this.feature = feature;
        this.oclExpression = oclExpression;
        this.impactAnalyzer = impactAnalyzer;
        this.ocl = ocl;
    }

    @Override
    public void notifyChanged(Notification notification) {
        Collection<EObject> contextObjects = impactAnalyzer.getContextObjects(notification);
        for (EObject contextObject : contextObjects) {
            Object newValue = ocl.evaluate(contextObject, oclExpression);
            contextObject.eSet(feature, newValue);
        }
    }
}
