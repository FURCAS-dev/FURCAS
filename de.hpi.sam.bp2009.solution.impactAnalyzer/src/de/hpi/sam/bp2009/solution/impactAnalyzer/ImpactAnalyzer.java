/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

/**
 * 
 * The Impact Analyzer (IA) analyzes the impact of {@link Notification}s on
 * a single {@link OCLExpression}.
 * <p>
 * The interaction with the IA typically happens in two steps. First call
 * {@link #createFilterForExpression(boolean)}.
 * This returns an {@link EventFilter} which can be used to register a listener
 * in the {@link EventManager}. The subscriber will then be supplied with all
 * relevant {@link Notification}s relevant to the supplied {@link OCLExpression}.
 * <p>
 * Once a relevant <code>Notification</code> occurs it can be passed to the IA
 * by calling {@link #getContextObjects(Notification)} which returns a
 * set of {@link EObject}s for which the expression's value may have changed due to the
 * change notification. These context objects can be used to instruct the evaluator to
 * evaluate affected <code>OCLExpressions</code> for a certain set of instances.
 * 
 */
public interface ImpactAnalyzer {

	/**
	 * Creates a filter for the given OCL expression, which matches at least all events
	 * that cause the expression to change its value on one or more context elements.
	 * Note that also events may be matched that don't actually lead to a change. The
	 * filter synthesis is "conservative" in this sense.
	 * @param notifyNewContextElements
	 *            The analyzer can be parameterized during construction such
	 *            that it either registers for creation events on the context
	 *            type or not. Registering for element creation on the context
	 *            type is useful for invariants / constraints because when a new
	 *            element is created, validating the constraint may be useful.
	 *            For other use cases, registering for element creation may not
	 *            be so useful. For example, when a type inferencer defines its
	 *            rules using OCL, it only wants to receive <em>update</em>
	 *            events after the element has been fully initialized from those
	 *            OCL expressions. In those cases, some framework may be
	 *            responsible for the initial evaluation of those OCL
	 *            expressions on new element, and therefore, context element
	 *            creation events are not of interest.
	 * 
	 * @return the filter matching all relevant events
	 */
	EventFilter createFilterForExpression(boolean notifyNewContextElements);

	/**
	 * For a change notification <tt>event</tt> calculates a superset of the set of context objects
	 * for which <tt>expression</tt> may have changed its value due to the changed indicated by the event.
	 * As implies by "superset," the result set may contain context elements for which the expression's
	 * value may happen to not have changed.
	 * 
	 * @param event
	 *            the event to calculate for
	 * @return all relevant context objects
	 */
	Collection<EObject> getContextObjects(Notification event);
} // ImpactAnalyzer
