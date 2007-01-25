/**
 * <copyright>
 * </copyright>
 *
 * $Id: MessageType.java,v 1.1 2007/01/25 18:24:36 cdamus Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.MessageType#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.MessageType#getReferredSignal <em>Referred Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.types.TypesPackage#getMessageType()
 * @model
 * @generated
 */
public interface MessageType<C, O, P> extends PredefinedType<O> {
	String SINGLETON_NAME = "OclMessage"; //$NON-NLS-1$

	/**
     * Returns the value of the '<em><b>Referred Operation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Operation</em>' reference.
     * @see #setReferredOperation(O)
     * @see org.eclipse.ocl.types.TypesPackage#getMessageType_ReferredOperation()
     * @model
     * @generated
     */
	O getReferredOperation();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.types.MessageType#getReferredOperation <em>Referred Operation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Operation</em>' reference.
     * @see #getReferredOperation()
     * @generated
     */
	void setReferredOperation(O value);

	/**
     * Returns the value of the '<em><b>Referred Signal</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Signal</em>' reference.
     * @see #setReferredSignal(C)
     * @see org.eclipse.ocl.types.TypesPackage#getMessageType_ReferredSignal()
     * @model
     * @generated
     */
	C getReferredSignal();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.types.MessageType#getReferredSignal <em>Referred Signal</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Signal</em>' reference.
     * @see #getReferredSignal()
     * @generated
     */
	void setReferredSignal(C value);

	/**
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @model type="java.lang.Object"
     * @generated
     */
	EList<P> oclProperties();

} // MessageType
