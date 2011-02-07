/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractStatusVariable.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.status_and_action.design;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Status Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action.design.AbstractStatusVariable#isIsAgent <em>Is Agent</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.AbstractStatusVariable#isIsStateGuarded <em>Is State Guarded</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.AbstractStatusVariable#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action.design.DesignPackage#getAbstractStatusVariable()
 * @model abstract="true"
 * @generated
 */
public interface AbstractStatusVariable extends NamedElement {
	/**
     * Returns the value of the '<em><b>Is Agent</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Agent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Is Agent</em>' attribute.
     * @see #setIsAgent(boolean)
     * @see behavioral.status_and_action.design.DesignPackage#getAbstractStatusVariable_IsAgent()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsAgent();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.design.AbstractStatusVariable#isIsAgent <em>Is Agent</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Agent</em>' attribute.
     * @see #isIsAgent()
     * @generated
     */
	void setIsAgent(boolean value);

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
     * @see behavioral.status_and_action.design.DesignPackage#getAbstractStatusVariable_IsStateGuarded()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsStateGuarded();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.design.AbstractStatusVariable#isIsStateGuarded <em>Is State Guarded</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is State Guarded</em>' attribute.
     * @see #isIsStateGuarded()
     * @generated
     */
	void setIsStateGuarded(boolean value);

	/**
     * Returns the value of the '<em><b>Values</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action.design.AbstractStatusValue}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Values</em>' containment reference list.
     * @see behavioral.status_and_action.design.DesignPackage#getAbstractStatusVariable_Values()
     * @model containment="true" resolveProxies="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='variable'"
     * @generated
     */
	EList<AbstractStatusValue> getValues();

} // AbstractStatusVariable
