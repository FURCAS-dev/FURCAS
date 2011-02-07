/**
 * <copyright>
 * </copyright>
 *
 * $Id: Attribute.java,v 1.1 2011/02/07 17:21:37 auhl Exp $
 */
package integration.xsd;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.Attribute#getUse <em>Use</em>}</li>
 *   <li>{@link integration.xsd.Attribute#getVal <em>Val</em>}</li>
 *   <li>{@link integration.xsd.Attribute#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends NamedElement {
	/**
     * Returns the value of the '<em><b>Use</b></em>' attribute.
     * The literals are from the enumeration {@link integration.xsd.AttUseType}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Use</em>' attribute.
     * @see integration.xsd.AttUseType
     * @see #setUse(AttUseType)
     * @see integration.xsd.XsdPackage#getAttribute_Use()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	AttUseType getUse();

	/**
     * Sets the value of the '{@link integration.xsd.Attribute#getUse <em>Use</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Use</em>' attribute.
     * @see integration.xsd.AttUseType
     * @see #getUse()
     * @generated
     */
	void setUse(AttUseType value);

	/**
     * Returns the value of the '<em><b>Val</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Val</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Val</em>' attribute.
     * @see #setVal(String)
     * @see integration.xsd.XsdPackage#getAttribute_Val()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getVal();

	/**
     * Sets the value of the '{@link integration.xsd.Attribute#getVal <em>Val</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Val</em>' attribute.
     * @see #getVal()
     * @generated
     */
	void setVal(String value);

	/**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(SimpleType)
     * @see integration.xsd.XsdPackage#getAttribute_Type()
     * @model required="true"
     * @generated
     */
	SimpleType getType();

	/**
     * Sets the value of the '{@link integration.xsd.Attribute#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
	void setType(SimpleType value);

} // Attribute
