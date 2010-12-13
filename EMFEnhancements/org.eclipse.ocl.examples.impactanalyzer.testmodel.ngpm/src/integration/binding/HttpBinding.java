/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.binding;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Makes a function invokable through an HTTP requiest. A URL pattern can be specified that describes how URLs are to be matched and if/how parameter values are to be extracted from the URL.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.binding.HttpBinding#getUrlPattern <em>Url Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.binding.BindingPackage#getHttpBinding()
 * @model abstract="true"
 * @generated
 */
public interface HttpBinding extends Binding {
	/**
     * Returns the value of the '<em><b>Url Pattern</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Url Pattern</em>' containment reference.
     * @see #setUrlPattern(UrlPattern)
     * @see integration.binding.BindingPackage#getHttpBinding_UrlPattern()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
	UrlPattern getUrlPattern();

	/**
     * Sets the value of the '{@link integration.binding.HttpBinding#getUrlPattern <em>Url Pattern</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Url Pattern</em>' containment reference.
     * @see #getUrlPattern()
     * @generated
     */
	void setUrlPattern(UrlPattern value);

} // HttpBinding
