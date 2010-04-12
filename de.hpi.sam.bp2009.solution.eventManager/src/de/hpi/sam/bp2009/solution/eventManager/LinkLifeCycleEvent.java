/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Life Cycle Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent#getChangedReference <em>Changed Reference</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent#getCorrespondingObject <em>Corresponding Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getLinkLifeCycleEvent()
 * @model abstract="true"
 * @generated
 */
public interface LinkLifeCycleEvent extends ElementChangeEvent {

	/**
	 * Returns the value of the '<em><b>Changed Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changed Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changed Reference</em>' reference.
	 * @see #setChangedReference(EReference)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getLinkLifeCycleEvent_ChangedReference()
	 * @model
	 * @generated
	 */
	EReference getChangedReference();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent#getChangedReference <em>Changed Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Changed Reference</em>' reference.
	 * @see #getChangedReference()
	 * @generated
	 */
	void setChangedReference(EReference value);

	/**
	 * Returns the value of the '<em><b>Corresponding Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corresponding Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corresponding Object</em>' reference.
	 * @see #setCorrespondingObject(EObject)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getLinkLifeCycleEvent_CorrespondingObject()
	 * @model
	 * @generated
	 */
	EObject getCorrespondingObject();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent#getCorrespondingObject <em>Corresponding Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Corresponding Object</em>' reference.
	 * @see #getCorrespondingObject()
	 * @generated
	 */
	void setCorrespondingObject(EObject value);
} // LinkLifeCycleEvent
