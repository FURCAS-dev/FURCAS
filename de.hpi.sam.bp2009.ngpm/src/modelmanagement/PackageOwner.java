/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelmanagement.PackageOwner#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelmanagement.ModelmanagementPackage#getPackageOwner()
 * @model
 * @generated
 */
public interface PackageOwner extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference list.
	 * The list contents are of type {@link modelmanagement.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Packages</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference list.
	 * @see modelmanagement.ModelmanagementPackage#getPackageOwner_OwnedPackages()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<modelmanagement.Package> getOwnedPackages();

} // PackageOwner
