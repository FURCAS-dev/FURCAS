/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration.experimental;

import configuration.businessconfiguration.ValueSet;

import data.classes.AssociationEnd;

import modelmanagement.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.experimental.ConfigurationEntity#getPickList <em>Pick List</em>}</li>
 *   <li>{@link configuration.businessconfiguration.experimental.ConfigurationEntity#getConfigurableItem <em>Configurable Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see configuration.businessconfiguration.experimental.ExperimentalPackage#getConfigurationEntity()
 * @model
 * @generated
 */
public interface ConfigurationEntity extends NamedElement {
	/**
     * Returns the value of the '<em><b>Pick List</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pick List</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Pick List</em>' reference.
     * @see #setPickList(ValueSet)
     * @see configuration.businessconfiguration.experimental.ExperimentalPackage#getConfigurationEntity_PickList()
     * @model
     * @generated
     */
	ValueSet getPickList();

	/**
     * Sets the value of the '{@link configuration.businessconfiguration.experimental.ConfigurationEntity#getPickList <em>Pick List</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pick List</em>' reference.
     * @see #getPickList()
     * @generated
     */
	void setPickList(ValueSet value);

	/**
     * Returns the value of the '<em><b>Configurable Item</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurable Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Configurable Item</em>' reference.
     * @see #setConfigurableItem(AssociationEnd)
     * @see configuration.businessconfiguration.experimental.ExperimentalPackage#getConfigurationEntity_ConfigurableItem()
     * @model required="true"
     * @generated
     */
	AssociationEnd getConfigurableItem();

	/**
     * Sets the value of the '{@link configuration.businessconfiguration.experimental.ConfigurationEntity#getConfigurableItem <em>Configurable Item</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configurable Item</em>' reference.
     * @see #getConfigurableItem()
     * @generated
     */
	void setConfigurableItem(AssociationEnd value);

} // ConfigurationEntity
