/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.EnumerationTemplate#isAutomatic <em>Automatic</em>}</li>
 *   <li>{@link TCS.EnumerationTemplate#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getEnumerationTemplate()
 * @model
 * @generated
 */
public interface EnumerationTemplate extends Template {
	/**
	 * Returns the value of the '<em><b>Automatic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Automatic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automatic</em>' attribute.
	 * @see #setAutomatic(boolean)
	 * @see TCS.TCSPackage#getEnumerationTemplate_Automatic()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isAutomatic();

	/**
	 * Sets the value of the '{@link TCS.EnumerationTemplate#isAutomatic <em>Automatic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Automatic</em>' attribute.
	 * @see #isAutomatic()
	 * @generated
	 */
	void setAutomatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link TCS.EnumLiteralMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see TCS.TCSPackage#getEnumerationTemplate_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumLiteralMapping> getMappings();

} // EnumerationTemplate
