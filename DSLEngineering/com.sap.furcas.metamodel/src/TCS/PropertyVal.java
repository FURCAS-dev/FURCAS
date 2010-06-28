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
 * A representation of the model object '<em><b>Property Val</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.PropertyVal#getPropertyName <em>Property Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getPropertyVal()
 * @model
 * @generated
 */
public interface PropertyVal extends Value {
	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute list.
	 * @see TCS.TCSPackage#getPropertyVal_PropertyName()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	EList<String> getPropertyName();

} // PropertyVal
