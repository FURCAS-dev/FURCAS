/**
 * <copyright>
 * </copyright>
 *
 * $Id: PackageOwner.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
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
     * It is bidirectional and its opposite is '{@link modelmanagement.Package#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Packages</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Packages</em>' containment reference list.
     * @see modelmanagement.ModelmanagementPackage#getPackageOwner_OwnedPackages()
     * @see modelmanagement.Package#getOwner
     * @model opposite="owner" containment="true" resolveProxies="true"
     * @generated
     */
	EList<modelmanagement.Package> getOwnedPackages();

} // PackageOwner
