/**
 * <copyright>
 * </copyright>
 *
 * $Id: Annotation.java,v 1.1 2011/02/07 17:21:37 auhl Exp $
 */
package integration.xsd;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.Annotation#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link integration.xsd.Annotation#getAppInfo <em>App Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject {
	/**
     * Returns the value of the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documentation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Documentation</em>' attribute.
     * @see #setDocumentation(String)
     * @see integration.xsd.XsdPackage#getAnnotation_Documentation()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getDocumentation();

	/**
     * Sets the value of the '{@link integration.xsd.Annotation#getDocumentation <em>Documentation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Documentation</em>' attribute.
     * @see #getDocumentation()
     * @generated
     */
	void setDocumentation(String value);

	/**
     * Returns the value of the '<em><b>App Info</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>App Info</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>App Info</em>' attribute.
     * @see #setAppInfo(String)
     * @see integration.xsd.XsdPackage#getAnnotation_AppInfo()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getAppInfo();

	/**
     * Sets the value of the '{@link integration.xsd.Annotation#getAppInfo <em>App Info</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>App Info</em>' attribute.
     * @see #getAppInfo()
     * @generated
     */
	void setAppInfo(String value);

} // Annotation
