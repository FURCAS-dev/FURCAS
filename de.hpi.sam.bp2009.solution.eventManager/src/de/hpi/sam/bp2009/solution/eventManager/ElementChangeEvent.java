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
 * A representation of the model object '<em><b>Element Change Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent#getChangedClass <em>Changed Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getElementChangeEvent()
 * @model abstract="true"
 * @generated
 */
public interface ElementChangeEvent extends ModelChangeEvent {

	/**
	 * Returns the value of the '<em><b>Changed Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changed Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changed Class</em>' reference.
	 * @see #setChangedClass(EClass)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getElementChangeEvent_ChangedClass()
	 * @model
	 * @generated
	 */
	EClass getChangedClass();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent#getChangedClass <em>Changed Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Changed Class</em>' reference.
	 * @see #getChangedClass()
	 * @generated
	 */
	void setChangedClass(EClass value);
} // ElementChangeEvent
