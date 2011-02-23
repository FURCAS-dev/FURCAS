/**
 * <copyright>
 * </copyright>
 *
 * $Id: SignatureImplementation.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.classes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A signature can be implemented by a block (this would be a "method" in the classical sense) or, e.g., by an association navigation or by a link set manipulation statement.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.SignatureImplementation#getImplements_ <em>Implements </em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getSignatureImplementation()
 * @model abstract="true"
 * @generated
 */
public interface SignatureImplementation extends EObject {
	/**
     * Returns the value of the '<em><b>Implements </b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.MethodSignature#getImplementation <em>Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements </em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Implements </em>' container reference.
     * @see #setImplements_(MethodSignature)
     * @see data.classes.ClassesPackage#getSignatureImplementation_Implements_()
     * @see data.classes.MethodSignature#getImplementation
     * @model opposite="implementation"
     * @generated
     */
	MethodSignature getImplements_();

	/**
     * Sets the value of the '{@link data.classes.SignatureImplementation#getImplements_ <em>Implements </em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Implements </em>' container reference.
     * @see #getImplements_()
     * @generated
     */
	void setImplements_(MethodSignature value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A block implements either a FunctionSignature or a MethodSignature. Two different associations connect the Block with the respective Signature subclasses. This operation is a convenience that chooses the one or the other, depending on which one is filled.
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsKindOf(FunctionSignatureImplementation) then\n    if self.oclAsType(FunctionSignatureImplementation).functionSignature->notEmpty() then\n      self.oclAsType(FunctionSignatureImplementation).functionSignature\n    else\n      self.implements_\n    endif\n  else\n    self.implements_\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	Signature getImplementedSignature();

} // SignatureImplementation
