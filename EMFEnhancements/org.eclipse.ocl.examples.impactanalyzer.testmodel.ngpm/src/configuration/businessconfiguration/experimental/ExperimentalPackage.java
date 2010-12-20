/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration.experimental;

import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see configuration.businessconfiguration.experimental.ExperimentalFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ExperimentalPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "experimental";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/configuration/businessconfiguration/experimental.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "configuration.businessconfiguration.experimental";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ExperimentalPackage eINSTANCE = configuration.businessconfiguration.experimental.impl.ExperimentalPackageImpl.init();

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.experimental.impl.PackageUseImpl <em>Package Use</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.experimental.impl.PackageUseImpl
     * @see configuration.businessconfiguration.experimental.impl.ExperimentalPackageImpl#getPackageUse()
     * @generated
     */
	int PACKAGE_USE = 0;

	/**
     * The feature id for the '<em><b>Package </b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_USE__PACKAGE_ = 0;

	/**
     * The feature id for the '<em><b>Setting</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_USE__SETTING = 1;

	/**
     * The number of structural features of the '<em>Package Use</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_USE_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.experimental.impl.ConfigurationEntityImpl <em>Configuration Entity</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.experimental.impl.ConfigurationEntityImpl
     * @see configuration.businessconfiguration.experimental.impl.ExperimentalPackageImpl#getConfigurationEntity()
     * @generated
     */
	int CONFIGURATION_ENTITY = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_ENTITY__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_ENTITY__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Pick List</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_ENTITY__PICK_LIST = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Configurable Item</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_ENTITY__CONFIGURABLE_ITEM = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Configuration Entity</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_ENTITY_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.experimental.impl.ConfigurationSettingImpl <em>Configuration Setting</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.experimental.impl.ConfigurationSettingImpl
     * @see configuration.businessconfiguration.experimental.impl.ExperimentalPackageImpl#getConfigurationSetting()
     * @generated
     */
	int CONFIGURATION_SETTING = 2;

	/**
     * The feature id for the '<em><b>Entity</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_SETTING__ENTITY = 0;

	/**
     * The feature id for the '<em><b>Value</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_SETTING__VALUE = 1;

	/**
     * The number of structural features of the '<em>Configuration Setting</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_SETTING_FEATURE_COUNT = 2;


	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.experimental.PackageUse <em>Package Use</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Package Use</em>'.
     * @see configuration.businessconfiguration.experimental.PackageUse
     * @generated
     */
	EClass getPackageUse();

	/**
     * Returns the meta object for the reference '{@link configuration.businessconfiguration.experimental.PackageUse#getPackage_ <em>Package </em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Package </em>'.
     * @see configuration.businessconfiguration.experimental.PackageUse#getPackage_()
     * @see #getPackageUse()
     * @generated
     */
	EReference getPackageUse_Package_();

	/**
     * Returns the meta object for the reference list '{@link configuration.businessconfiguration.experimental.PackageUse#getSetting <em>Setting</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Setting</em>'.
     * @see configuration.businessconfiguration.experimental.PackageUse#getSetting()
     * @see #getPackageUse()
     * @generated
     */
	EReference getPackageUse_Setting();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.experimental.ConfigurationEntity <em>Configuration Entity</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configuration Entity</em>'.
     * @see configuration.businessconfiguration.experimental.ConfigurationEntity
     * @generated
     */
	EClass getConfigurationEntity();

	/**
     * Returns the meta object for the reference '{@link configuration.businessconfiguration.experimental.ConfigurationEntity#getPickList <em>Pick List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Pick List</em>'.
     * @see configuration.businessconfiguration.experimental.ConfigurationEntity#getPickList()
     * @see #getConfigurationEntity()
     * @generated
     */
	EReference getConfigurationEntity_PickList();

	/**
     * Returns the meta object for the reference '{@link configuration.businessconfiguration.experimental.ConfigurationEntity#getConfigurableItem <em>Configurable Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Configurable Item</em>'.
     * @see configuration.businessconfiguration.experimental.ConfigurationEntity#getConfigurableItem()
     * @see #getConfigurationEntity()
     * @generated
     */
	EReference getConfigurationEntity_ConfigurableItem();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.experimental.ConfigurationSetting <em>Configuration Setting</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configuration Setting</em>'.
     * @see configuration.businessconfiguration.experimental.ConfigurationSetting
     * @generated
     */
	EClass getConfigurationSetting();

	/**
     * Returns the meta object for the reference '{@link configuration.businessconfiguration.experimental.ConfigurationSetting#getEntity <em>Entity</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Entity</em>'.
     * @see configuration.businessconfiguration.experimental.ConfigurationSetting#getEntity()
     * @see #getConfigurationSetting()
     * @generated
     */
	EReference getConfigurationSetting_Entity();

	/**
     * Returns the meta object for the reference '{@link configuration.businessconfiguration.experimental.ConfigurationSetting#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Value</em>'.
     * @see configuration.businessconfiguration.experimental.ConfigurationSetting#getValue()
     * @see #getConfigurationSetting()
     * @generated
     */
	EReference getConfigurationSetting_Value();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	ExperimentalFactory getExperimentalFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.experimental.impl.PackageUseImpl <em>Package Use</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.experimental.impl.PackageUseImpl
         * @see configuration.businessconfiguration.experimental.impl.ExperimentalPackageImpl#getPackageUse()
         * @generated
         */
		EClass PACKAGE_USE = eINSTANCE.getPackageUse();

		/**
         * The meta object literal for the '<em><b>Package </b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE_USE__PACKAGE_ = eINSTANCE.getPackageUse_Package_();

		/**
         * The meta object literal for the '<em><b>Setting</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE_USE__SETTING = eINSTANCE.getPackageUse_Setting();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.experimental.impl.ConfigurationEntityImpl <em>Configuration Entity</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.experimental.impl.ConfigurationEntityImpl
         * @see configuration.businessconfiguration.experimental.impl.ExperimentalPackageImpl#getConfigurationEntity()
         * @generated
         */
		EClass CONFIGURATION_ENTITY = eINSTANCE.getConfigurationEntity();

		/**
         * The meta object literal for the '<em><b>Pick List</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONFIGURATION_ENTITY__PICK_LIST = eINSTANCE.getConfigurationEntity_PickList();

		/**
         * The meta object literal for the '<em><b>Configurable Item</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONFIGURATION_ENTITY__CONFIGURABLE_ITEM = eINSTANCE.getConfigurationEntity_ConfigurableItem();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.experimental.impl.ConfigurationSettingImpl <em>Configuration Setting</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.experimental.impl.ConfigurationSettingImpl
         * @see configuration.businessconfiguration.experimental.impl.ExperimentalPackageImpl#getConfigurationSetting()
         * @generated
         */
		EClass CONFIGURATION_SETTING = eINSTANCE.getConfigurationSetting();

		/**
         * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONFIGURATION_SETTING__ENTITY = eINSTANCE.getConfigurationSetting_Entity();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONFIGURATION_SETTING__VALUE = eINSTANCE.getConfigurationSetting_Value();

	}

} //ExperimentalPackage
