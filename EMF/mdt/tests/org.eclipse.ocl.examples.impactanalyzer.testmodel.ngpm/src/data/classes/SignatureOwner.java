/**
 * <copyright>
 * </copyright>
 *
 * $Id: SignatureOwner.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.classes;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.SignatureOwner#getOwnedSignatures <em>Owned Signatures</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getSignatureOwner()
 * @model
 * @generated
 */
public interface SignatureOwner extends NamedElement {
	/**
     * Returns the value of the '<em><b>Owned Signatures</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.MethodSignature}.
     * It is bidirectional and its opposite is '{@link data.classes.MethodSignature#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Signatures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Signatures</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSignatureOwner_OwnedSignatures()
     * @see data.classes.MethodSignature#getOwner
     * @model opposite="owner" containment="true" resolveProxies="true"
     * @generated
     */
	EList<MethodSignature> getOwnedSignatures();

} // SignatureOwner
