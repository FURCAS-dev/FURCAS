package com.sap.emf.ocl.trigger;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * Used to notify a {@link Triggerable} about which expression may have changed its value for
 * which elements.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface AffectedContextObjectsForExpression {
    OCLExpression getExpression();
    Collection<EObject> getAffectedObjects();
}
