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
 * A representation of the model object '<em><b>Composition Hierarchy Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.CompositionHierarchyFilter#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getCompositionHierarchyFilter()
 * @model
 * @generated
 */
public interface CompositionHierarchyFilter extends EventFilter {

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(EObject)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getCompositionHierarchyFilter_Root()
	 * @model
	 * @generated
	 */
	EObject getRoot();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.CompositionHierarchyFilter#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(EObject value);
} // CompositionHierarchyFilter
