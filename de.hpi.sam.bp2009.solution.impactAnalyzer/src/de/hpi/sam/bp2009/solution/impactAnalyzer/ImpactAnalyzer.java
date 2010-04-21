/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;


public interface ImpactAnalyzer {

	/**
	 * Creates a filter for the given OCL expression, which matches all relevant events for the given expression
	 * @param query the expression to create the filter for
	 * @param cls the context of the expression
	 * @return the filter matching all relevant events
	 */
	EventFilter createFilterForQuery(OCLExpression expression, EClass context);


	/**
	 * Calculates all context objects for an event, which should be starting point of the evaluation of the given query
	 * @param event the event to calculate for
	 * @param query the query which should be reevaluated
	 * @param cls the context of the query
	 * @return all relevant context objects
	 */
	Collection<EObject> getContextObjects(ModelChangeEvent event, OCLExpression expression, EClass context);

} // ImpactAnalyzer
