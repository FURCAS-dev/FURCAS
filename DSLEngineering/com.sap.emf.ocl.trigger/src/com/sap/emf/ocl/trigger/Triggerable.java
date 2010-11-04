package com.sap.emf.ocl.trigger;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.oppositeendfinder.OppositeEndFinder;

/**
 * A callback that wants to get triggered when one of the {@link OCLExpression}s returned from
 * {@link #getTriggerExpressionsWithContext()} or {@link #getTriggerExpressionsWithoutContext()} changes its value
 * for any context object observed by the {@link TriggerManager}(s) with which this {@link Triggerable} is registered.
 * Implementing classes can choose whether they want to also be informed about new context elements being added to
 * the scope observed by returning a boolean value from {@link #notifyOnNewContextElements()}.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface Triggerable {
    void notify(OCLExpression expression, Collection<EObject> affectedContextObjects, OppositeEndFinder oppositeEndFinder);

    /**
     * The {@link #notify(OCLExpression, Collection, OppositeEndFinder)} operation will be called when any of the
     * {@link OCLExpression expressions} returned by this method may have changed its value anywhere in the scope observed by the
     * {@link TriggerManager} with which this {@link Triggerable} gets {@link TriggerManager#register(Triggerable) registered}.
     * They receive notifications also for new context elements being created if {@link #notifyOnNewContextElements} returns
     * <code>true</code>.
     * 
     * @return a non-<code>null</code> collection
     */
    Collection<OCLExpression> getTriggerExpressionsWithoutContext();

    /**
     * The {@link #notify(OCLExpression, Collection, OppositeEndFinder)} operation will be called when any of the
     * {@link OCLExpression expressions} returned by this method may have changed its value anywhere in the scope observed by the
     * {@link TriggerManager} with which this {@link Triggerable} gets {@link TriggerManager#register(Triggerable) registered}.
     * They receive notifications also for new context elements being created if {@link #notifyOnNewContextElements} returns
     * <code>true</code>.<p>
     * 
     * As compared to {@link #getTriggerExpressionsWithoutContext()}, the collection returned by this method specifies
     * expressions together with their contexts. It is necessary to specify a context type if the expression does not
     * contain a <code>self</code> reference from which the context type can automatically be inferred.
     * 
     * @return a non-<code>null</code> collection
     */
    Collection<ExpressionWithContext> getTriggerExpressionsWithContext();
    
    /**
     * If <code>true</code> is returned, {@link #notify(OCLExpression, Collection, OppositeEndFinder)} will also be called
     * if for any context type of any of the expressions returned from {@link #getTriggerExpressionsWithContext()} or
     * {@link #getTriggerExpressionsWithoutContext()} (or any of the context type's subtypes) a new element is added to
     * the resource set observed by the {@link TriggerManager} with which this {@link Triggerable} is registered.
     */
    boolean notifyOnNewContextElements();
}
