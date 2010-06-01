/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement;


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
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Packages</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference.
	 * @see #setOwnedPackages(modelmanagement.Package)
	 * @see modelmanagement.ModelmanagementPackage#getPackageOwner_OwnedPackages()
	 * @model containment="true"
	 * @generated
	 */
	modelmanagement.Package getOwnedPackages();

	/**
	 * Sets the value of the '{@link modelmanagement.PackageOwner#getOwnedPackages <em>Owned Packages</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Packages</em>' containment reference.
	 * @see #getOwnedPackages()
	 * @generated
	 */
	void setOwnedPackages(modelmanagement.Package value);

} // PackageOwner
