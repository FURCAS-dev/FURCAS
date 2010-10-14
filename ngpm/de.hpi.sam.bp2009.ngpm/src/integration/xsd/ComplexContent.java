/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.ComplexContent#isMixed <em>Mixed</em>}</li>
 *   <li>{@link integration.xsd.ComplexContent#getContentModel <em>Content Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getComplexContent()
 * @model
 * @generated
 */
public interface ComplexContent extends AbstractContent {
	/**
     * Returns the value of the '<em><b>Mixed</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Mixed</em>' attribute.
     * @see #setMixed(boolean)
     * @see integration.xsd.XsdPackage#getComplexContent_Mixed()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isMixed();

	/**
     * Sets the value of the '{@link integration.xsd.ComplexContent#isMixed <em>Mixed</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mixed</em>' attribute.
     * @see #isMixed()
     * @generated
     */
	void setMixed(boolean value);

	/**
     * Returns the value of the '<em><b>Content Model</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Content Model</em>' reference.
     * @see #setContentModel(Containable)
     * @see integration.xsd.XsdPackage#getComplexContent_ContentModel()
     * @model
     * @generated
     */
	Containable getContentModel();

	/**
     * Sets the value of the '{@link integration.xsd.ComplexContent#getContentModel <em>Content Model</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Content Model</em>' reference.
     * @see #getContentModel()
     * @generated
     */
	void setContentModel(Containable value);

} // ComplexContent
