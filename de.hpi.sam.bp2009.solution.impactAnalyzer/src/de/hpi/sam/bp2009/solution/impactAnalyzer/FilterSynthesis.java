/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.expressions.OCLExpression;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;

public interface FilterSynthesis{
    
    /**
     * Obtains the event filter for the expression passed to the constructor. When an event matches the filter, the
     * value of the expression may have changed for one or more evaluation contexts. To determine a superset of those
     * context elements for which the value may have changed, feed the event into
     * {@link ImpactAnalyzer#getAllContextObjects(Notification)}.
     * @return the filter matching all relevant events 
     */
    public EventFilter getSynthesisedFilter();

    /**
     * Returns all the calls to the operation whose body is <tt>operationBody</tt> that are reachable
     * from the root expression analyzed by this {@link FilterSynthesis}. If no such calls exist,
     * an empty set is returned.
     */
    public Set<OperationCallExp> getCallsOf(OCLExpression<EClassifier> rootExpression);
    
}//FilterSynthesis