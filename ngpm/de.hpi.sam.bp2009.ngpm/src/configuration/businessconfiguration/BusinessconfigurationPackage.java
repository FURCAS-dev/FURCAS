/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration;

import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see configuration.businessconfiguration.BusinessconfigurationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface BusinessconfigurationPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "businessconfiguration";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///configuration/businessconfiguration.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "configuration.businessconfiguration";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	BusinessconfigurationPackage eINSTANCE = configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl.init();

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.impl.ScopingContextImpl <em>Scoping Context</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.impl.ScopingContextImpl
     * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getScopingContext()
     * @generated
     */
	int SCOPING_CONTEXT = 0;

	/**
     * The number of structural features of the '<em>Scoping Context</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SCOPING_CONTEXT_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.impl.IndustryImpl <em>Industry</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.impl.IndustryImpl
     * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getIndustry()
     * @generated
     */
	int INDUSTRY = 1;

	/**
     * The number of structural features of the '<em>Industry</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INDUSTRY_FEATURE_COUNT = SCOPING_CONTEXT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.impl.CountryImpl <em>Country</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.impl.CountryImpl
     * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getCountry()
     * @generated
     */
	int COUNTRY = 2;

	/**
     * The number of structural features of the '<em>Country</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COUNTRY_FEATURE_COUNT = SCOPING_CONTEXT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.impl.ConfigurationElementImpl <em>Configuration Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.impl.ConfigurationElementImpl
     * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getConfigurationElement()
     * @generated
     */
	int CONFIGURATION_ELEMENT = 3;

	/**
     * The feature id for the '<em><b>Applicable In Context</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT = 0;

	/**
     * The number of structural features of the '<em>Configuration Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_ELEMENT_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.impl.BusinessTopicImpl <em>Business Topic</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.impl.BusinessTopicImpl
     * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getBusinessTopic()
     * @generated
     */
	int BUSINESS_TOPIC = 4;

	/**
     * The feature id for the '<em><b>Applicable In Context</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_TOPIC__APPLICABLE_IN_CONTEXT = CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT;

	/**
     * The feature id for the '<em><b>Business Option</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_TOPIC__BUSINESS_OPTION = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Business Topic</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_TOPIC_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.impl.BusinessPackageImpl <em>Business Package</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.impl.BusinessPackageImpl
     * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getBusinessPackage()
     * @generated
     */
	int BUSINESS_PACKAGE = 5;

	/**
     * The feature id for the '<em><b>Applicable In Context</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_PACKAGE__APPLICABLE_IN_CONTEXT = CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT;

	/**
     * The feature id for the '<em><b>Business Topic</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_PACKAGE__BUSINESS_TOPIC = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Business Package</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_PACKAGE_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.impl.BusinessOptionImpl <em>Business Option</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.impl.BusinessOptionImpl
     * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getBusinessOption()
     * @generated
     */
	int BUSINESS_OPTION = 6;

	/**
     * The feature id for the '<em><b>Applicable In Context</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_OPTION__APPLICABLE_IN_CONTEXT = CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT;

	/**
     * The feature id for the '<em><b>Value Set</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_OPTION__VALUE_SET = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Business Option</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_OPTION_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.impl.BusinessAreaImpl <em>Business Area</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.impl.BusinessAreaImpl
     * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getBusinessArea()
     * @generated
     */
	int BUSINESS_AREA = 7;

	/**
     * The feature id for the '<em><b>Applicable In Context</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_AREA__APPLICABLE_IN_CONTEXT = CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT;

	/**
     * The feature id for the '<em><b>Business Package</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_AREA__BUSINESS_PACKAGE = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Business Area</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_AREA_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.impl.ValueSetImpl <em>Value Set</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.impl.ValueSetImpl
     * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getValueSet()
     * @generated
     */
	int VALUE_SET = 8;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET__OWNED_TYPE_DEFINITION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Extensible</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET__EXTENSIBLE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Configuration Business Option</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET__CONFIGURATION_BUSINESS_OPTION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Entries</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET__ENTRIES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Value Set</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link configuration.businessconfiguration.impl.ValueSetEntryImpl <em>Value Set Entry</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.businessconfiguration.impl.ValueSetEntryImpl
     * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getValueSetEntry()
     * @generated
     */
	int VALUE_SET_ENTRY = 9;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET_ENTRY__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET_ENTRY__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Can Be Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET_ENTRY__CAN_BE_CHANGED = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Can Be Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET_ENTRY__CAN_BE_DELETED = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Value Set</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET_ENTRY__VALUE_SET = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET_ENTRY__VALUE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Value Set Entry</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_SET_ENTRY_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;


	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.ScopingContext <em>Scoping Context</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Scoping Context</em>'.
     * @see configuration.businessconfiguration.ScopingContext
     * @generated
     */
	EClass getScopingContext();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.Industry <em>Industry</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Industry</em>'.
     * @see configuration.businessconfiguration.Industry
     * @generated
     */
	EClass getIndustry();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.Country <em>Country</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Country</em>'.
     * @see configuration.businessconfiguration.Country
     * @generated
     */
	EClass getCountry();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.ConfigurationElement <em>Configuration Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configuration Element</em>'.
     * @see configuration.businessconfiguration.ConfigurationElement
     * @generated
     */
	EClass getConfigurationElement();

	/**
     * Returns the meta object for the reference list '{@link configuration.businessconfiguration.ConfigurationElement#getApplicableInContext <em>Applicable In Context</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Applicable In Context</em>'.
     * @see configuration.businessconfiguration.ConfigurationElement#getApplicableInContext()
     * @see #getConfigurationElement()
     * @generated
     */
	EReference getConfigurationElement_ApplicableInContext();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.BusinessTopic <em>Business Topic</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Business Topic</em>'.
     * @see configuration.businessconfiguration.BusinessTopic
     * @generated
     */
	EClass getBusinessTopic();

	/**
     * Returns the meta object for the containment reference list '{@link configuration.businessconfiguration.BusinessTopic#getBusinessOption <em>Business Option</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Business Option</em>'.
     * @see configuration.businessconfiguration.BusinessTopic#getBusinessOption()
     * @see #getBusinessTopic()
     * @generated
     */
	EReference getBusinessTopic_BusinessOption();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.BusinessPackage <em>Business Package</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Business Package</em>'.
     * @see configuration.businessconfiguration.BusinessPackage
     * @generated
     */
	EClass getBusinessPackage();

	/**
     * Returns the meta object for the containment reference list '{@link configuration.businessconfiguration.BusinessPackage#getBusinessTopic <em>Business Topic</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Business Topic</em>'.
     * @see configuration.businessconfiguration.BusinessPackage#getBusinessTopic()
     * @see #getBusinessPackage()
     * @generated
     */
	EReference getBusinessPackage_BusinessTopic();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.BusinessOption <em>Business Option</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Business Option</em>'.
     * @see configuration.businessconfiguration.BusinessOption
     * @generated
     */
	EClass getBusinessOption();

	/**
     * Returns the meta object for the reference list '{@link configuration.businessconfiguration.BusinessOption#getValueSet <em>Value Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Value Set</em>'.
     * @see configuration.businessconfiguration.BusinessOption#getValueSet()
     * @see #getBusinessOption()
     * @generated
     */
	EReference getBusinessOption_ValueSet();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.BusinessArea <em>Business Area</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Business Area</em>'.
     * @see configuration.businessconfiguration.BusinessArea
     * @generated
     */
	EClass getBusinessArea();

	/**
     * Returns the meta object for the containment reference list '{@link configuration.businessconfiguration.BusinessArea#getBusinessPackage <em>Business Package</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Business Package</em>'.
     * @see configuration.businessconfiguration.BusinessArea#getBusinessPackage()
     * @see #getBusinessArea()
     * @generated
     */
	EReference getBusinessArea_BusinessPackage();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.ValueSet <em>Value Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Set</em>'.
     * @see configuration.businessconfiguration.ValueSet
     * @generated
     */
	EClass getValueSet();

	/**
     * Returns the meta object for the attribute '{@link configuration.businessconfiguration.ValueSet#isExtensible <em>Extensible</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Extensible</em>'.
     * @see configuration.businessconfiguration.ValueSet#isExtensible()
     * @see #getValueSet()
     * @generated
     */
	EAttribute getValueSet_Extensible();

	/**
     * Returns the meta object for the reference '{@link configuration.businessconfiguration.ValueSet#getConfigurationBusinessOption <em>Configuration Business Option</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Configuration Business Option</em>'.
     * @see configuration.businessconfiguration.ValueSet#getConfigurationBusinessOption()
     * @see #getValueSet()
     * @generated
     */
	EReference getValueSet_ConfigurationBusinessOption();

	/**
     * Returns the meta object for the containment reference list '{@link configuration.businessconfiguration.ValueSet#getEntries <em>Entries</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Entries</em>'.
     * @see configuration.businessconfiguration.ValueSet#getEntries()
     * @see #getValueSet()
     * @generated
     */
	EReference getValueSet_Entries();

	/**
     * Returns the meta object for class '{@link configuration.businessconfiguration.ValueSetEntry <em>Value Set Entry</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Set Entry</em>'.
     * @see configuration.businessconfiguration.ValueSetEntry
     * @generated
     */
	EClass getValueSetEntry();

	/**
     * Returns the meta object for the attribute '{@link configuration.businessconfiguration.ValueSetEntry#isCanBeChanged <em>Can Be Changed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Can Be Changed</em>'.
     * @see configuration.businessconfiguration.ValueSetEntry#isCanBeChanged()
     * @see #getValueSetEntry()
     * @generated
     */
	EAttribute getValueSetEntry_CanBeChanged();

	/**
     * Returns the meta object for the attribute '{@link configuration.businessconfiguration.ValueSetEntry#isCanBeDeleted <em>Can Be Deleted</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Can Be Deleted</em>'.
     * @see configuration.businessconfiguration.ValueSetEntry#isCanBeDeleted()
     * @see #getValueSetEntry()
     * @generated
     */
	EAttribute getValueSetEntry_CanBeDeleted();

	/**
     * Returns the meta object for the container reference '{@link configuration.businessconfiguration.ValueSetEntry#getValueSet <em>Value Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Value Set</em>'.
     * @see configuration.businessconfiguration.ValueSetEntry#getValueSet()
     * @see #getValueSetEntry()
     * @generated
     */
	EReference getValueSetEntry_ValueSet();

	/**
     * Returns the meta object for the containment reference '{@link configuration.businessconfiguration.ValueSetEntry#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see configuration.businessconfiguration.ValueSetEntry#getValue()
     * @see #getValueSetEntry()
     * @generated
     */
	EReference getValueSetEntry_Value();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	BusinessconfigurationFactory getBusinessconfigurationFactory();

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
         * The meta object literal for the '{@link configuration.businessconfiguration.impl.ScopingContextImpl <em>Scoping Context</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.impl.ScopingContextImpl
         * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getScopingContext()
         * @generated
         */
		EClass SCOPING_CONTEXT = eINSTANCE.getScopingContext();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.impl.IndustryImpl <em>Industry</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.impl.IndustryImpl
         * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getIndustry()
         * @generated
         */
		EClass INDUSTRY = eINSTANCE.getIndustry();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.impl.CountryImpl <em>Country</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.impl.CountryImpl
         * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getCountry()
         * @generated
         */
		EClass COUNTRY = eINSTANCE.getCountry();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.impl.ConfigurationElementImpl <em>Configuration Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.impl.ConfigurationElementImpl
         * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getConfigurationElement()
         * @generated
         */
		EClass CONFIGURATION_ELEMENT = eINSTANCE.getConfigurationElement();

		/**
         * The meta object literal for the '<em><b>Applicable In Context</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT = eINSTANCE.getConfigurationElement_ApplicableInContext();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.impl.BusinessTopicImpl <em>Business Topic</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.impl.BusinessTopicImpl
         * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getBusinessTopic()
         * @generated
         */
		EClass BUSINESS_TOPIC = eINSTANCE.getBusinessTopic();

		/**
         * The meta object literal for the '<em><b>Business Option</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BUSINESS_TOPIC__BUSINESS_OPTION = eINSTANCE.getBusinessTopic_BusinessOption();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.impl.BusinessPackageImpl <em>Business Package</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.impl.BusinessPackageImpl
         * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getBusinessPackage()
         * @generated
         */
		EClass BUSINESS_PACKAGE = eINSTANCE.getBusinessPackage();

		/**
         * The meta object literal for the '<em><b>Business Topic</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BUSINESS_PACKAGE__BUSINESS_TOPIC = eINSTANCE.getBusinessPackage_BusinessTopic();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.impl.BusinessOptionImpl <em>Business Option</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.impl.BusinessOptionImpl
         * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getBusinessOption()
         * @generated
         */
		EClass BUSINESS_OPTION = eINSTANCE.getBusinessOption();

		/**
         * The meta object literal for the '<em><b>Value Set</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BUSINESS_OPTION__VALUE_SET = eINSTANCE.getBusinessOption_ValueSet();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.impl.BusinessAreaImpl <em>Business Area</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.impl.BusinessAreaImpl
         * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getBusinessArea()
         * @generated
         */
		EClass BUSINESS_AREA = eINSTANCE.getBusinessArea();

		/**
         * The meta object literal for the '<em><b>Business Package</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BUSINESS_AREA__BUSINESS_PACKAGE = eINSTANCE.getBusinessArea_BusinessPackage();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.impl.ValueSetImpl <em>Value Set</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.impl.ValueSetImpl
         * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getValueSet()
         * @generated
         */
		EClass VALUE_SET = eINSTANCE.getValueSet();

		/**
         * The meta object literal for the '<em><b>Extensible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute VALUE_SET__EXTENSIBLE = eINSTANCE.getValueSet_Extensible();

		/**
         * The meta object literal for the '<em><b>Configuration Business Option</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VALUE_SET__CONFIGURATION_BUSINESS_OPTION = eINSTANCE.getValueSet_ConfigurationBusinessOption();

		/**
         * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VALUE_SET__ENTRIES = eINSTANCE.getValueSet_Entries();

		/**
         * The meta object literal for the '{@link configuration.businessconfiguration.impl.ValueSetEntryImpl <em>Value Set Entry</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.businessconfiguration.impl.ValueSetEntryImpl
         * @see configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl#getValueSetEntry()
         * @generated
         */
		EClass VALUE_SET_ENTRY = eINSTANCE.getValueSetEntry();

		/**
         * The meta object literal for the '<em><b>Can Be Changed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute VALUE_SET_ENTRY__CAN_BE_CHANGED = eINSTANCE.getValueSetEntry_CanBeChanged();

		/**
         * The meta object literal for the '<em><b>Can Be Deleted</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute VALUE_SET_ENTRY__CAN_BE_DELETED = eINSTANCE.getValueSetEntry_CanBeDeleted();

		/**
         * The meta object literal for the '<em><b>Value Set</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VALUE_SET_ENTRY__VALUE_SET = eINSTANCE.getValueSetEntry_ValueSet();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VALUE_SET_ENTRY__VALUE = eINSTANCE.getValueSetEntry_Value();

	}

} //BusinessconfigurationPackage
