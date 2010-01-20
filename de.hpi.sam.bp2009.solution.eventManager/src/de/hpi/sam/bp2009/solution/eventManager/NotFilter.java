/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotFilter#getFilter <em>Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotFilter()
 * @model
 * @generated
 */
public interface NotFilter extends EventFilter {

	/**
	 * Returns the value of the '<em><b>Filter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter</em>' reference.
	 * @see #setFilter(EventFilter)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotFilter_Filter()
	 * @model
	 * @generated
	 */
	EventFilter getFilter();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.NotFilter#getFilter <em>Filter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' reference.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(EventFilter value);
} // NotFilter
