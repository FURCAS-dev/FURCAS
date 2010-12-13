/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nested Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.NestedTypeDefinition#getOp <em>Op</em>}</li>
 *   <li>{@link data.classes.NestedTypeDefinition#getType <em>Type</em>}</li>
 *   <li>{@link data.classes.NestedTypeDefinition#getOwnedTypeDefinition <em>Owned Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getNestedTypeDefinition()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL NestedIsAlwaysMany='self.isMany()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NestedIsAlwaysMany'"
 * @generated
 */
public interface NestedTypeDefinition extends TypeDefinition {
	/**
     * Returns the value of the '<em><b>Op</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Only for syntax mapping issues, hopefully disappearing again in the future. It holds the operator that syntactically introduced this nested type definition, such as "[" or "*".
     * <!-- end-model-doc -->
     * @return the value of the '<em>Op</em>' attribute.
     * @see #setOp(String)
     * @see data.classes.ClassesPackage#getNestedTypeDefinition_Op()
     * @model unique="false" ordered="false"
     * @generated
     */
	String getOp();

	/**
     * Sets the value of the '{@link data.classes.NestedTypeDefinition#getOp <em>Op</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Op</em>' attribute.
     * @see #getOp()
     * @generated
     */
	void setOp(String value);

	/**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(TypeDefinition)
     * @see data.classes.ClassesPackage#getNestedTypeDefinition_Type()
     * @model required="true"
     * @generated
     */
	TypeDefinition getType();

	/**
     * Sets the value of the '{@link data.classes.NestedTypeDefinition#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
	void setType(TypeDefinition value);

	/**
     * Returns the value of the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Type Definition</em>' containment reference.
     * @see #setOwnedTypeDefinition(TypeDefinition)
     * @see data.classes.ClassesPackage#getNestedTypeDefinition_OwnedTypeDefinition()
     * @model containment="true" resolveProxies="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='owningNestedTypeDefinition'"
     * @generated
     */
	TypeDefinition getOwnedTypeDefinition();

	/**
     * Sets the value of the '{@link data.classes.NestedTypeDefinition#getOwnedTypeDefinition <em>Owned Type Definition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owned Type Definition</em>' containment reference.
     * @see #getOwnedTypeDefinition()
     * @generated
     */
	void setOwnedTypeDefinition(TypeDefinition value);

} // NestedTypeDefinition
