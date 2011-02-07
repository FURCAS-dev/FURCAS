/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleType.java,v 1.1 2011/02/07 17:21:37 auhl Exp $
 */
package integration.xsd;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.SimpleType#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getSimpleType()
 * @model
 * @generated
 */
public interface SimpleType extends AbstractType {
	/**
     * Returns the value of the '<em><b>Content</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Content</em>' reference.
     * @see #setContent(SimpleContent)
     * @see integration.xsd.XsdPackage#getSimpleType_Content()
     * @model required="true"
     * @generated
     */
	SimpleContent getContent();

	/**
     * Sets the value of the '{@link integration.xsd.SimpleType#getContent <em>Content</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Content</em>' reference.
     * @see #getContent()
     * @generated
     */
	void setContent(SimpleContent value);

} // SimpleType
