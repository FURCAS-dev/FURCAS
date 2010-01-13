/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#getFilterMatcher <em>Filter Matcher</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#getFilterCriterion <em>Filter Criterion</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventFilter()
 * @model abstract="true"
 * @generated
 */
public interface EventFilter extends EObject {
	/**
	 * Returns the value of the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Matcher</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Matcher</em>' reference.
	 * @see #setFilterMatcher(FilterMatcher)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventFilter_FilterMatcher()
	 * @model
	 * @generated
	 */
	FilterMatcher getFilterMatcher();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#getFilterMatcher <em>Filter Matcher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Matcher</em>' reference.
	 * @see #getFilterMatcher()
	 * @generated
	 */
	void setFilterMatcher(FilterMatcher value);

	/**
	 * Returns the value of the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Criterion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Criterion</em>' attribute.
	 * @see #setFilterCriterion(Object)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventFilter_FilterCriterion()
	 * @model
	 * @generated
	 */
	Object getFilterCriterion();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#getFilterCriterion <em>Filter Criterion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Criterion</em>' attribute.
	 * @see #getFilterCriterion()
	 * @generated
	 */
	void setFilterCriterion(Object value);

} // EventFilter
