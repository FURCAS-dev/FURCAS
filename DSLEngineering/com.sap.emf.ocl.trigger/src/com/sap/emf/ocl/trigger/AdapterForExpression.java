package com.sap.emf.ocl.trigger;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

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
    private final OppositeEndFinder oppositeEndFinder;

    /**
     * With this constructor, the expression must contain a <code>self</code> occurrence that allows us to infer the context type.
     * 
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     */
    public AdapterForExpression(Triggerable triggerableToNotify, OCLExpression expression, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, ActivationOption configuration) {
        this.triggerableToNotify = triggerableToNotify;
        this.expression = expression;
        this.impactAnalyzer = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, notifyOnNewContextElements, oppositeEndFinder, configuration);
        this.oppositeEndFinder = oppositeEndFinder;
    }

    /**
     * A non-<code>null</code> context must be provided if this constructor is used. Should the <code>expression</code> contain an
     * occurrence of <code>self</code>, its type must be the same as <code>context</code>.
     * 
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     */
    public AdapterForExpression(Triggerable triggerableToNotify, OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, ActivationOption configuration) {
        if (context == null) {
            throw new IllegalArgumentException("This constructor expects a non-null context type for expression "+expression);
        }
        this.triggerableToNotify = triggerableToNotify;
        this.expression = expression;
        this.impactAnalyzer = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expression, context, notifyOnNewContextElements, oppositeEndFinder, configuration);
        this.oppositeEndFinder = oppositeEndFinder;
    }
    
    private ImpactAnalyzer getImpactAnalyzer() {
        return impactAnalyzer;
    }
    
    public EventFilter getEventFilter() {
        return impactAnalyzer.createFilterForExpression();
    }
    
    @Override
    public void notifyChanged(Notification msg) {
        ImpactAnalyzer ia = getImpactAnalyzer();
        Collection<EObject> affectedContextObjects = ia.getContextObjects(msg);
        triggerableToNotify.notify(expression, affectedContextObjects, oppositeEndFinder);
    }

}
