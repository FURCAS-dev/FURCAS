/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;


public interface ImpactAnalyzer {

	/**
	 * Creates a filter for the given OCL expression, which matches all relevant events for the given expression
	 * @param query the expression to create the filter for
	 * @param cls the context of the expression
	 * @param notifyNewContextElements
	 *            The analyzer can be parameterized during construction such that it either registers for creation
         *            events on the context type or not. Registering for element creation on the context type is useful for
         *            invariants / constraints because when a new element is created, validating the constraint may be
         *            useful. For other use cases, registering for element creation may not be so useful. For example, when
         *            a type inferencer defines its rules using OCL, it only wants to receive <em>update</em> events after
         *            the element has been fully initialized from those OCL expressions. In those cases, some framework may
         *            be responsible for the initial evaluation of those OCL expressions on new element, and therefore,
         *            context element creation events are not of interest.
	 * @return the filter matching all relevant events
	 */
	EventFilter createFilterForQuery(OCLExpression expression, EClass context, boolean notifyNewContextElements);


	/**
	 * Calculates all context objects for an event, which should be starting point of the evaluation of the given query
	 * @param event the event to calculate for
	 * @param query the query which should be reevaluated
	 * @param cls the context of the query
	 * @return all relevant context objects
	 */
	Collection<EObject> getContextObjects(Notification event, OCLExpression expression, EClass context);

} // ImpactAnalyzer
