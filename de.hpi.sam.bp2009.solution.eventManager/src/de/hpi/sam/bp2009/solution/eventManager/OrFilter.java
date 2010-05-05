/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.OrFilter#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getOrFilter()
 * @model
 * @generated
 */
public interface OrFilter extends EventFilter {

	/**
     * Returns the value of the '<em><b>Filters</b></em>' reference list.
     * The list contents are of type {@link de.hpi.sam.bp2009.solution.eventManager.EventFilter}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filters</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Filters</em>' reference list.
     * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getOrFilter_Filters()
     * @model
     * @generated
     */
	EList<EventFilter> getFilters();
} // OrFilter
