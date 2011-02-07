/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractAction.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.status_and_action.design;

import modelmanagement.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action.design.AbstractAction#isIsAgent <em>Is Agent</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.AbstractAction#isIsPreconditionFixed <em>Is Precondition Fixed</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action.design.DesignPackage#getAbstractAction()
 * @model abstract="true"
 * @generated
 */
public interface AbstractAction extends NamedElement {
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
     * @see behavioral.status_and_action.design.DesignPackage#getAbstractAction_IsAgent()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsAgent();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.design.AbstractAction#isIsAgent <em>Is Agent</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Agent</em>' attribute.
     * @see #isIsAgent()
     * @generated
     */
	void setIsAgent(boolean value);

	/**
     * Returns the value of the '<em><b>Is Precondition Fixed</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Precondition Fixed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Is Precondition Fixed</em>' attribute.
     * @see #setIsPreconditionFixed(boolean)
     * @see behavioral.status_and_action.design.DesignPackage#getAbstractAction_IsPreconditionFixed()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isIsPreconditionFixed();

	/**
     * Sets the value of the '{@link behavioral.status_and_action.design.AbstractAction#isIsPreconditionFixed <em>Is Precondition Fixed</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Precondition Fixed</em>' attribute.
     * @see #isIsPreconditionFixed()
     * @generated
     */
	void setIsPreconditionFixed(boolean value);

} // AbstractAction
