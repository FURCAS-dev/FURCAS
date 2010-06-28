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
 * A representation of the model object '<em><b>Create In PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.CreateInPArg#getPropertyName <em>Property Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getCreateInPArg()
 * @model
 * @generated
 */
public interface CreateInPArg extends PropertyArg {
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
	 * @see TCS.TCSPackage#getCreateInPArg_PropertyName()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<String> getPropertyName();

} // CreateInPArg
