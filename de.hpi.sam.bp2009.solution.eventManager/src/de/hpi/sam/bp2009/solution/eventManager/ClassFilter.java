/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.ClassFilter#getWantedClass <em>Wanted Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getClassFilter()
 * @model
 * @generated
 */
public interface ClassFilter extends EventFilter {

	/**
	 * Returns the value of the '<em><b>Wanted Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wanted Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wanted Class</em>' reference.
	 * @see #setWantedClass(EClass)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getClassFilter_WantedClass()
	 * @model
	 * @generated
	 */
	EClass getWantedClass();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.ClassFilter#getWantedClass <em>Wanted Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wanted Class</em>' reference.
	 * @see #getWantedClass()
	 * @generated
	 */
	void setWantedClass(EClass value);
} // ClassFilter
