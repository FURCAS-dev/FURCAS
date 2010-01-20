/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.ContainerFilter#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getContainerFilter()
 * @model
 * @generated
 */
public interface ContainerFilter extends EventFilter {

	/**
	 * Returns the value of the '<em><b>Filters</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filters</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filters</em>' reference.
	 * @see #setFilters(EventFilter)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getContainerFilter_Filters()
	 * @model
	 * @generated
	 */
	EventFilter getFilters();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.ContainerFilter#getFilters <em>Filters</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filters</em>' reference.
	 * @see #getFilters()
	 * @generated
	 */
	void setFilters(EventFilter value);
} // ContainerFilter
