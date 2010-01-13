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
 * A representation of the model object '<em><b>Model Change Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent#getSourceObject <em>Source Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getModelChangeEvent()
 * @model
 * @generated
 */
public interface ModelChangeEvent extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the EObject that cause the event.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Object</em>' reference.
	 * @see #setSourceObject(EObject)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getModelChangeEvent_SourceObject()
	 * @model
	 * @generated
	 */
	EObject getSourceObject();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent#getSourceObject <em>Source Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Object</em>' reference.
	 * @see #getSourceObject()
	 * @generated
	 */
	void setSourceObject(EObject value);

} // ModelChangeEvent
