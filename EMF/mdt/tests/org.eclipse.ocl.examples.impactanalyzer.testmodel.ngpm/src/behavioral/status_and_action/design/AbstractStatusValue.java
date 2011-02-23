/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractStatusValue.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.status_and_action.design;

import modelmanagement.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Status Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action.design.AbstractStatusValue#isIsInitial <em>Is Initial</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.AbstractStatusValue#isIsInhibiting <em>Is Inhibiting</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.AbstractStatusValue#isIsStateGuarded <em>Is State Guarded</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action.design.DesignPackage#getAbstractStatusValue()
 * @model abstract="true"
 * @generated
 */
public interface AbstractStatusValue extends NamedElement {
	/**
     * Returns the value of the '<em><b>Is Initial</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Is Initial</em>' attribute.
     * @see #setIsInitial(boolean)
     * @see behavioral.status_and_action.design.DesignPackage#getAbstractStatusValue_IsInitial()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsInitial();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.design.AbstractStatusValue#isIsInitial <em>Is Initial</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Initial</em>' attribute.
     * @see #isIsInitial()
     * @generated
     */
	void setIsInitial(boolean value);

	/**
     * Returns the value of the '<em><b>Is Inhibiting</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Inhibiting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Is Inhibiting</em>' attribute.
     * @see #setIsInhibiting(boolean)
     * @see behavioral.status_and_action.design.DesignPackage#getAbstractStatusValue_IsInhibiting()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsInhibiting();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.design.AbstractStatusValue#isIsInhibiting <em>Is Inhibiting</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Inhibiting</em>' attribute.
     * @see #isIsInhibiting()
     * @generated
     */
	void setIsInhibiting(boolean value);

	/**
     * Returns the value of the '<em><b>Is State Guarded</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is State Guarded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Is State Guarded</em>' attribute.
     * @see #setIsStateGuarded(boolean)
     * @see behavioral.status_and_action.design.DesignPackage#getAbstractStatusValue_IsStateGuarded()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsStateGuarded();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.design.AbstractStatusValue#isIsStateGuarded <em>Is State Guarded</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is State Guarded</em>' attribute.
     * @see #isIsStateGuarded()
     * @generated
     */
	void setIsStateGuarded(boolean value);

} // AbstractStatusValue
