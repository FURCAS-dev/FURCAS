package com.sap.emf.ocl.trigger;

import java.util.Collection;

import org.eclipse.ocl.ecore.OCLExpression;

/**
 * A callback that wants to get triggered when one of the expressions returned from {@link #getTriggerExpressions()} may
 * have changed its value on some object observed by the {@link TriggerManager}.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface Triggerable {
    Collection<OCLExpression> getTriggerExpressions();
    void notify(Collection<AffectedContextObjectsForExpression> changes);
}
