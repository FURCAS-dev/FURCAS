/**
 * <copyright>
 * </copyright>
 *
 * $Id: Package.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package modelmanagement;

import configuration.businessconfiguration.experimental.ConfigurationEntity;

import data.classes.Association;
import data.classes.SapClass;

import data.generics.ClassParameterization;

import integration.binding.Binding;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Packages own and structure the model content. Higher-level concepts such as process components, applications or deployment units should not inherit from Package but instead own packages that contain their implementation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelmanagement.Package#getAssociations <em>Associations</em>}</li>
 *   <li>{@link modelmanagement.Package#getClasses <em>Classes</em>}</li>
 *   <li>{@link modelmanagement.Package#getParameterizedClasses <em>Parameterized Classes</em>}</li>
 *   <li>{@link modelmanagement.Package#getOwner <em>Owner</em>}</li>
 *   <li>{@link modelmanagement.Package#getConfigurability <em>Configurability</em>}</li>
 *   <li>{@link modelmanagement.Package#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelmanagement.ModelmanagementPackage#getPackage()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL DistinctClassNamesPerPackage='self.classes->forAll( i, j | i <> j implies i.name <> j.name )' NoCyclicOwnership='not self.hasOwnershipCycle(Set{})'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='DistinctClassNamesPerPackage NoCyclicOwnership'"
 * @generated
 */
public interface Package extends PackageOwner {
	/**
     * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.Association}.
     * It is bidirectional and its opposite is '{@link data.classes.Association#getPackage_ <em>Package </em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Associations</em>' containment reference list.
     * @see modelmanagement.ModelmanagementPackage#getPackage_Associations()
     * @see data.classes.Association#getPackage_
     * @model opposite="package_" containment="true" resolveProxies="true"
     * @generated
     */
	EList<Association> getAssociations();

	/**
     * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.SapClass}.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getPackage_ <em>Package </em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Classes</em>' containment reference list.
     * @see modelmanagement.ModelmanagementPackage#getPackage_Classes()
     * @see data.classes.SapClass#getPackage_
     * @model opposite="package_" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SapClass> getClasses();

	/**
     * Returns the value of the '<em><b>Parameterized Classes</b></em>' containment reference list.
     * The list contents are of type {@link data.generics.ClassParameterization}.
     * It is bidirectional and its opposite is '{@link data.generics.ClassParameterization#getPackage_ <em>Package </em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameterized Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parameterized Classes</em>' containment reference list.
     * @see modelmanagement.ModelmanagementPackage#getPackage_ParameterizedClasses()
     * @see data.generics.ClassParameterization#getPackage_
     * @model opposite="package_" containment="true" resolveProxies="true"
     * @generated
     */
	EList<ClassParameterization> getParameterizedClasses();

	/**
     * Returns the value of the '<em><b>Owner</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link modelmanagement.PackageOwner#getOwnedPackages <em>Owned Packages</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owner</em>' container reference.
     * @see #setOwner(PackageOwner)
     * @see modelmanagement.ModelmanagementPackage#getPackage_Owner()
     * @see modelmanagement.PackageOwner#getOwnedPackages
     * @model opposite="ownedPackages"
     * @generated
     */
	PackageOwner getOwner();

	/**
     * Sets the value of the '{@link modelmanagement.Package#getOwner <em>Owner</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owner</em>' container reference.
     * @see #getOwner()
     * @generated
     */
	void setOwner(PackageOwner value);

	/**
     * Returns the value of the '<em><b>Configurability</b></em>' containment reference list.
     * The list contents are of type {@link configuration.businessconfiguration.experimental.ConfigurationEntity}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurability</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Configurability</em>' containment reference list.
     * @see modelmanagement.ModelmanagementPackage#getPackage_Configurability()
     * @model containment="true" resolveProxies="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='package_'"
     * @generated
     */
	EList<ConfigurationEntity> getConfigurability();

	/**
     * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
     * The list contents are of type {@link integration.binding.Binding}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Bindings</em>' containment reference list.
     * @see modelmanagement.ModelmanagementPackage#getPackage_Bindings()
     * @model containment="true" resolveProxies="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='package_'"
     * @generated
     */
	EList<Binding> getBindings();

	/**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @model unique="false" required="true" ordered="false" pksMany="true" pksOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if pks->includes(self) then\n    true\n  else\n    if self.owner->isEmpty() then\n      false\n    else\n      if self.owner.oclIsKindOf(Package) then\n        self.owner.oclAsType(Package).hasOwnershipCycle(pks->including(self))\n      else\n        false\n      endif\n    endif\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
  boolean hasOwnershipCycle(EList<Package> pks);

} // Package
