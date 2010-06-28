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
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.Property#getName <em>Name</em>}</li>
 *   <li>{@link TCS.Property#getPropertyArgs <em>Property Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends SequenceElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see TCS.TCSPackage#getProperty_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link TCS.Property#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Property Args</b></em>' containment reference list.
	 * The list contents are of type {@link TCS.PropertyArg}.
	 * It is bidirectional and its opposite is '{@link TCS.PropertyArg#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Args</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Args</em>' containment reference list.
	 * @see TCS.TCSPackage#getProperty_PropertyArgs()
	 * @see TCS.PropertyArg#getProperty
	 * @model opposite="property" containment="true"
	 * @generated
	 */
	EList<PropertyArg> getPropertyArgs();

} // Property
