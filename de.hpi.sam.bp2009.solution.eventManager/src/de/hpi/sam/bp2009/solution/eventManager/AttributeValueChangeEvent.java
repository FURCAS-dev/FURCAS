/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Change Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getChangedAttribute <em>Changed Attribute</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getBefore <em>Before</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getAfter <em>After</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getAttributeValueChangeEvent()
 * @model
 * @generated
 */
public interface AttributeValueChangeEvent extends ElementChangeEvent {

	/**
	 * Returns the value of the '<em><b>Changed Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changed Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changed Attribute</em>' reference.
	 * @see #setChangedAttribute(EAttribute)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getAttributeValueChangeEvent_ChangedAttribute()
	 * @model
	 * @generated
	 */
	EAttribute getChangedAttribute();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getChangedAttribute <em>Changed Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Changed Attribute</em>' reference.
	 * @see #getChangedAttribute()
	 * @generated
	 */
	void setChangedAttribute(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Before</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Before</em>' attribute.
	 * @see #setBefore(Object)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getAttributeValueChangeEvent_Before()
	 * @model
	 * @generated
	 */
	Object getBefore();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getBefore <em>Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Before</em>' attribute.
	 * @see #getBefore()
	 * @generated
	 */
	void setBefore(Object value);

	/**
	 * Returns the value of the '<em><b>After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>After</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>After</em>' attribute.
	 * @see #setAfter(Object)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getAttributeValueChangeEvent_After()
	 * @model
	 * @generated
	 */
	Object getAfter();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getAfter <em>After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>After</em>' attribute.
	 * @see #getAfter()
	 * @generated
	 */
	void setAfter(Object value);
} // AttributeValueChangeEvent
