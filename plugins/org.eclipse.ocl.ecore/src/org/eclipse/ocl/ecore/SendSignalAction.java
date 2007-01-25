/**
 * <copyright>
 * </copyright>
 *
 * $Id: SendSignalAction.java,v 1.1 2007/01/25 18:29:09 cdamus Exp $
 */
package org.eclipse.ocl.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Send Signal Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.SendSignalAction#getSignal <em>Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.ecore.EcorePackage#getSendSignalAction()
 * @model
 * @generated
 */
public interface SendSignalAction extends EObject {
    /**
     * Returns the value of the '<em><b>Signal</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signal</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Signal</em>' reference.
     * @see #setSignal(EClass)
     * @see org.eclipse.ocl.ecore.EcorePackage#getSendSignalAction_Signal()
     * @model required="true"
     * @generated
     */
    EClass getSignal();

    /**
     * Sets the value of the '{@link org.eclipse.ocl.ecore.SendSignalAction#getSignal <em>Signal</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Signal</em>' reference.
     * @see #getSignal()
     * @generated
     */
    void setSignal(EClass value);

} // SendSignalAction
