/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssociationEndSignatureImplementation.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.classes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association End Signature Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.AssociationEndSignatureImplementation#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getAssociationEndSignatureImplementation()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt='(self.implements_.owner.oclIsKindOf(SapClass) and\r\n    self.implements_.owner.oclAsType(SapClass).conformsTo(self.end.otherEnd().type.clazz))\r\n  or   (self.implements_.owner.oclIsKindOf(TypeAdapter) and\r\n    self.implements_.owner.oclAsType(TypeAdapter).adapted.conformsTo(self.end.otherEnd().type.clazz))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt'"
 * @generated
 */
public interface AssociationEndSignatureImplementation extends SignatureImplementation {
	/**
     * Returns the value of the '<em><b>End</b></em>' reference.
     * It is bidirectional and its opposite is '{@link data.classes.AssociationEnd#getSignatureImplementations <em>Signature Implementations</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>End</em>' reference.
     * @see #setEnd(AssociationEnd)
     * @see data.classes.ClassesPackage#getAssociationEndSignatureImplementation_End()
     * @see data.classes.AssociationEnd#getSignatureImplementations
     * @model opposite="signatureImplementations" required="true"
     * @generated
     */
	AssociationEnd getEnd();

	/**
     * Sets the value of the '{@link data.classes.AssociationEndSignatureImplementation#getEnd <em>End</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>End</em>' reference.
     * @see #getEnd()
     * @generated
     */
	void setEnd(AssociationEnd value);

} // AssociationEndSignatureImplementation
