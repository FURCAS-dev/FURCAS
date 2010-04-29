/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.expressions.OCLExpression;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;

public interface FilterSynthesis{
    
    /**
     * Obtains the event filter for the expression passed to the constructor. When an event matches the filter, the
     * value of the expression may have changed for one or more evaluation contexts. To determine a superset of those
     * context elements for which the value may have changed, feed the event and the {@link OCLExpression} holding the
     * expression and its context into
     * {@link ImpactAnalyzer#getContextObjects(de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent, OCLExpression, org.eclipse.emf.ecore.EClass)}.
     * @return the filter matching all relevant events 
     */
    public EventFilter getSynthesisedFilter();

    public Set<OperationCallExp> getCallsOf(OCLExpression<EClassifier> rootExpression);
    
}//FilterSynthesis