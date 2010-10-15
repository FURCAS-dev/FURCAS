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
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;

/**
 * The Impact Analyzer (IA) analyzes the impact of {@link Notification}s on a single {@link OCLExpression} in the sense that it
 * determines those context objects of the expression for which the expression's evaluation result may have changed because of the
 * change indicated by the notification. Imagine this as "spreadsheet" functionality for models: model changes can be propagated
 * efficiently, even for large to huge models. Possible application areas include OCL constraint re-evaluation after model changes
 * as well as attribute grammars based on OCL.
 * <p>
 * 
 * The interaction with the IA typically happens in two steps. First call {@link #createFilterForExpression()}. This
 * returns an {@link EventFilter} which can be used to register a listener in the {@link EventManager}. The subscriber will then
 * be supplied with all relevant {@link Notification}s relevant to the supplied {@link OCLExpression}.
 * <p>
 * 
 * Once a relevant <code>Notification</code> occurs it can be passed to the IA by calling {@link #getContextObjects(Notification)}
 * which returns a set of {@link EObject}s for which the expression's value may have changed due to the change notification. These
 * context objects can be used to instruct the evaluator to evaluate affected <code>OCLExpressions</code> for a certain set of
 * instances.
 * <p>
 * 
 * The impact analyzer has a few configuration options, affecting the choice of implementation. We currently
 * use those to tune and performance-benchmark variants and flavors of the implementation. If you find that
 * the default configuration doesn't work well for your case, you may try different configuration options.
 * See {@link OptimizationActivation} and {@link ActivationOption} for details.
 * 
 */
public interface ImpactAnalyzer {

	/**
	 * Creates a filter for the given OCL expression, which matches at least all events
	 * that cause the expression to change its value on one or more context elements.
	 * Note that also events may be matched that don't actually lead to a change. The
	 * filter synthesis is "conservative" in this sense.
	 * @return the filter matching all relevant events
	 */
	EventFilter createFilterForExpression();

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
}
