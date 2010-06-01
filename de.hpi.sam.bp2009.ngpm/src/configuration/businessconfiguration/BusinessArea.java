/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.BusinessArea#getBusinessPackage <em>Business Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.businessconfiguration.BusinessconfigurationPackage#getBusinessArea()
 * @model
 * @generated
 */
public interface BusinessArea extends ConfigurationElement {
	/**
	 * Returns the value of the '<em><b>Business Package</b></em>' containment reference list.
	 * The list contents are of type {@link configuration.businessconfiguration.BusinessPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Business Package</em>' containment reference list.
	 * @see configuration.businessconfiguration.BusinessconfigurationPackage#getBusinessArea_BusinessPackage()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
	 * @generated
	 */
	EList<BusinessPackage> getBusinessPackage();

} // BusinessArea
