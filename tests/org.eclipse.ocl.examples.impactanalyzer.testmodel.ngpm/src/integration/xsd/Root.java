/**
 * <copyright>
 * </copyright>
 *
 * $Id: Root.java,v 1.1 2011/02/07 17:21:37 auhl Exp $
 */
package integration.xsd;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.xsd.Root#getId <em>Id</em>}</li>
 *   <li>{@link integration.xsd.Root#getAnno <em>Anno</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.xsd.XsdPackage#getRoot()
 * @model abstract="true"
 * @generated
 */
public interface Root extends EObject {
	/**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see integration.xsd.XsdPackage#getRoot_Id()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getId();

	/**
     * Sets the value of the '{@link integration.xsd.Root#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
	void setId(String value);

	/**
     * Returns the value of the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anno</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Anno</em>' reference.
     * @see #setAnno(Annotation)
     * @see integration.xsd.XsdPackage#getRoot_Anno()
     * @model
     * @generated
     */
	Annotation getAnno();

	/**
     * Sets the value of the '{@link integration.xsd.Root#getAnno <em>Anno</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Anno</em>' reference.
     * @see #getAnno()
     * @generated
     */
	void setAnno(Annotation value);

} // Root
