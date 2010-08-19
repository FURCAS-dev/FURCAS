/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.binding;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Url Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Assumes that a static, fixed URL base is used to identify the binding. Parameter values are expected to follow in the query part of the URL (everything following the "?" character) in regular URL format (name1=value1&name2=value2...). Multiple occurrences of the same name create a multi-object for the respective parameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.binding.SimpleUrlPattern#getBaseUrl <em>Base Url</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.binding.BindingPackage#getSimpleUrlPattern()
 * @model
 * @generated
 */
public interface SimpleUrlPattern extends UrlPattern {
	/**
     * Returns the value of the '<em><b>Base Url</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Base Url</em>' attribute.
     * @see #setBaseUrl(String)
     * @see integration.binding.BindingPackage#getSimpleUrlPattern_BaseUrl()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getBaseUrl();

	/**
     * Sets the value of the '{@link integration.binding.SimpleUrlPattern#getBaseUrl <em>Base Url</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Url</em>' attribute.
     * @see #getBaseUrl()
     * @generated
     */
	void setBaseUrl(String value);

} // SimpleUrlPattern
