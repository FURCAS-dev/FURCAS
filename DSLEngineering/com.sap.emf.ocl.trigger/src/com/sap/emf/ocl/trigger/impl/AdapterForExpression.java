package com.sap.emf.ocl.trigger.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.trigger.Triggerable;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;


/**
 * Acts as change listener specific to one {@link OCLExpression}, knowing which {@link Triggerable} to inform after
 * having computed the affected elements.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class AdapterForExpression extends AdapterImpl {
    private final Triggerable triggerableToNotify;
    private final OCLExpression expression;
    private final ImpactAnalyzer impactAnalyzer;
    
    AdapterForExpression(Triggerable triggerableToNotify, OCLExpression expression, EClass context, OppositeEndFinder oppositeEndFinder, ActivationOption configuration) {
        this.triggerableToNotify = triggerableToNotify;
        this.expression = expression;
        this.impactAnalyzer = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, context, oppositeEndFinder, configuration);
    }
    
    private ImpactAnalyzer getImpactAnalyzer() {
        return impactAnalyzer;
    }
    
    public EventFilter getEventFilter(boolean notifyNewContextElements) {
        return impactAnalyzer.createFilterForExpression(notifyNewContextElements);
    }
    
    @Override
    public void notifyChanged(Notification msg) {
        ImpactAnalyzer ia = getImpactAnalyzer();
        Collection<EObject> affectedContextObjects = ia.getContextObjects(msg);
        triggerableToNotify.notify(expression, affectedContextObjects);
    }
    
}
