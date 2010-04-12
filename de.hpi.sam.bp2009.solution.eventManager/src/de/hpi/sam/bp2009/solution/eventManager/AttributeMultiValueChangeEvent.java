/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Multi Value Change Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.AttributeMultiValueChangeEvent#isAdd <em>Add</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getAttributeMultiValueChangeEvent()
 * @model
 * @generated
 */
public interface AttributeMultiValueChangeEvent extends AttributeValueChangeEvent {

	/**
	 * Returns the value of the '<em><b>Add</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add</em>' attribute.
	 * @see #setAdd(boolean)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getAttributeMultiValueChangeEvent_Add()
	 * @model
	 * @generated
	 */
	boolean isAdd();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeMultiValueChangeEvent#isAdd <em>Add</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add</em>' attribute.
	 * @see #isAdd()
	 * @generated
	 */
	void setAdd(boolean value);
} // AttributeMultiValueChangeEvent
