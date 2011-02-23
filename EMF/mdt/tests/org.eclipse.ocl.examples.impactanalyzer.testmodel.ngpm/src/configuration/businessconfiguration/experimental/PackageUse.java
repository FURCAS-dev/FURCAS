/**
 * <copyright>
 * </copyright>
 *
 * $Id: PackageUse.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package configuration.businessconfiguration.experimental;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Use</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Tells a set of components and how they are wired such that for each required interface there are components configured that provide an implementation of that interface. For the outermost components all of the configuration parameters it exposes are defined or defaulted. These configuration settings transitively map through to the innermost components.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.experimental.PackageUse#getPackage_ <em>Package </em>}</li>
 *   <li>{@link configuration.businessconfiguration.experimental.PackageUse#getSetting <em>Setting</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.businessconfiguration.experimental.ExperimentalPackage#getPackageUse()
 * @model
 * @generated
 */
public interface PackageUse extends EObject {
	/**
     * Returns the value of the '<em><b>Package </b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package </em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Package </em>' reference.
     * @see #setPackage_(modelmanagement.Package)
     * @see configuration.businessconfiguration.experimental.ExperimentalPackage#getPackageUse_Package_()
     * @model required="true"
     * @generated
     */
	modelmanagement.Package getPackage_();

	/**
     * Sets the value of the '{@link configuration.businessconfiguration.experimental.PackageUse#getPackage_ <em>Package </em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Package </em>' reference.
     * @see #getPackage_()
     * @generated
     */
	void setPackage_(modelmanagement.Package value);

	/**
     * Returns the value of the '<em><b>Setting</b></em>' reference list.
     * The list contents are of type {@link configuration.businessconfiguration.experimental.ConfigurationSetting}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setting</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Setting</em>' reference list.
     * @see configuration.businessconfiguration.experimental.ExperimentalPackage#getPackageUse_Setting()
     * @model
     * @generated
     */
	EList<ConfigurationSetting> getSetting();

} // PackageUse
