/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.context_drivers;

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
 * <!-- begin-model-doc -->
 * An interesting extensibility construct to be looked at closer.
 * <!-- end-model-doc -->
 * @see configuration.context_drivers.Context_driversFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface Context_driversPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "context_drivers";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///configuration/context_drivers.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "configuration.context_drivers";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	Context_driversPackage eINSTANCE = configuration.context_drivers.impl.Context_driversPackageImpl.init();

	/**
     * The meta object id for the '{@link configuration.context_drivers.impl.ContextCategoryImpl <em>Context Category</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.context_drivers.impl.ContextCategoryImpl
     * @see configuration.context_drivers.impl.Context_driversPackageImpl#getContextCategory()
     * @generated
     */
	int CONTEXT_CATEGORY = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY__NAME = 0;

	/**
     * The feature id for the '<em><b>Root Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY__ROOT_VALUE = 1;

	/**
     * The feature id for the '<em><b>Category Configuration</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY__CATEGORY_CONFIGURATION = 2;

	/**
     * The number of structural features of the '<em>Context Category</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_FEATURE_COUNT = 3;

	/**
     * The meta object id for the '{@link configuration.context_drivers.impl.ContextCategoryValueImpl <em>Context Category Value</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.context_drivers.impl.ContextCategoryValueImpl
     * @see configuration.context_drivers.impl.Context_driversPackageImpl#getContextCategoryValue()
     * @generated
     */
	int CONTEXT_CATEGORY_VALUE = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_VALUE__NAME = CONTEXT_CATEGORY__NAME;

	/**
     * The feature id for the '<em><b>Root Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_VALUE__ROOT_VALUE = CONTEXT_CATEGORY__ROOT_VALUE;

	/**
     * The feature id for the '<em><b>Category Configuration</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_VALUE__CATEGORY_CONFIGURATION = CONTEXT_CATEGORY__CATEGORY_CONFIGURATION;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_VALUE__VALUE = CONTEXT_CATEGORY_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Context</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_VALUE__CONTEXT = CONTEXT_CATEGORY_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Included Values Configuration</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_VALUE__INCLUDED_VALUES_CONFIGURATION = CONTEXT_CATEGORY_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_VALUE__CHILDREN = CONTEXT_CATEGORY_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_VALUE__PARENT = CONTEXT_CATEGORY_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Excluded Values Configuration</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_VALUE__EXCLUDED_VALUES_CONFIGURATION = CONTEXT_CATEGORY_FEATURE_COUNT + 5;

	/**
     * The number of structural features of the '<em>Context Category Value</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_CATEGORY_VALUE_FEATURE_COUNT = CONTEXT_CATEGORY_FEATURE_COUNT + 6;

	/**
     * The meta object id for the '{@link configuration.context_drivers.impl.ContextualElementImpl <em>Contextual Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.context_drivers.impl.ContextualElementImpl
     * @see configuration.context_drivers.impl.Context_driversPackageImpl#getContextualElement()
     * @generated
     */
	int CONTEXTUAL_ELEMENT = 2;

	/**
     * The feature id for the '<em><b>Contextual Element Configuration</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION = 0;

	/**
     * The number of structural features of the '<em>Contextual Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXTUAL_ELEMENT_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link configuration.context_drivers.impl.ContexConfigurationImpl <em>Contex Configuration</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see configuration.context_drivers.impl.ContexConfigurationImpl
     * @see configuration.context_drivers.impl.Context_driversPackageImpl#getContexConfiguration()
     * @generated
     */
	int CONTEX_CONFIGURATION = 3;

	/**
     * The feature id for the '<em><b>Category</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEX_CONFIGURATION__CATEGORY = 0;

	/**
     * The feature id for the '<em><b>Included Values</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEX_CONFIGURATION__INCLUDED_VALUES = 1;

	/**
     * The feature id for the '<em><b>Configured Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEX_CONFIGURATION__CONFIGURED_ELEMENT = 2;

	/**
     * The feature id for the '<em><b>Excluded Values</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEX_CONFIGURATION__EXCLUDED_VALUES = 3;

	/**
     * The number of structural features of the '<em>Contex Configuration</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEX_CONFIGURATION_FEATURE_COUNT = 4;


	/**
     * Returns the meta object for class '{@link configuration.context_drivers.ContextCategory <em>Context Category</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Context Category</em>'.
     * @see configuration.context_drivers.ContextCategory
     * @generated
     */
	EClass getContextCategory();

	/**
     * Returns the meta object for the attribute '{@link configuration.context_drivers.ContextCategory#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see configuration.context_drivers.ContextCategory#getName()
     * @see #getContextCategory()
     * @generated
     */
	EAttribute getContextCategory_Name();

	/**
     * Returns the meta object for the containment reference '{@link configuration.context_drivers.ContextCategory#getRootValue <em>Root Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Root Value</em>'.
     * @see configuration.context_drivers.ContextCategory#getRootValue()
     * @see #getContextCategory()
     * @generated
     */
	EReference getContextCategory_RootValue();

	/**
     * Returns the meta object for the reference list '{@link configuration.context_drivers.ContextCategory#getCategoryConfiguration <em>Category Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Category Configuration</em>'.
     * @see configuration.context_drivers.ContextCategory#getCategoryConfiguration()
     * @see #getContextCategory()
     * @generated
     */
	EReference getContextCategory_CategoryConfiguration();

	/**
     * Returns the meta object for class '{@link configuration.context_drivers.ContextCategoryValue <em>Context Category Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Context Category Value</em>'.
     * @see configuration.context_drivers.ContextCategoryValue
     * @generated
     */
	EClass getContextCategoryValue();

	/**
     * Returns the meta object for the attribute '{@link configuration.context_drivers.ContextCategoryValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see configuration.context_drivers.ContextCategoryValue#getValue()
     * @see #getContextCategoryValue()
     * @generated
     */
	EAttribute getContextCategoryValue_Value();

	/**
     * Returns the meta object for the container reference '{@link configuration.context_drivers.ContextCategoryValue#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Context</em>'.
     * @see configuration.context_drivers.ContextCategoryValue#getContext()
     * @see #getContextCategoryValue()
     * @generated
     */
	EReference getContextCategoryValue_Context();

	/**
     * Returns the meta object for the reference list '{@link configuration.context_drivers.ContextCategoryValue#getIncludedValuesConfiguration <em>Included Values Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Included Values Configuration</em>'.
     * @see configuration.context_drivers.ContextCategoryValue#getIncludedValuesConfiguration()
     * @see #getContextCategoryValue()
     * @generated
     */
	EReference getContextCategoryValue_IncludedValuesConfiguration();

	/**
     * Returns the meta object for the containment reference list '{@link configuration.context_drivers.ContextCategoryValue#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Children</em>'.
     * @see configuration.context_drivers.ContextCategoryValue#getChildren()
     * @see #getContextCategoryValue()
     * @generated
     */
	EReference getContextCategoryValue_Children();

	/**
     * Returns the meta object for the container reference '{@link configuration.context_drivers.ContextCategoryValue#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parent</em>'.
     * @see configuration.context_drivers.ContextCategoryValue#getParent()
     * @see #getContextCategoryValue()
     * @generated
     */
	EReference getContextCategoryValue_Parent();

	/**
     * Returns the meta object for the reference list '{@link configuration.context_drivers.ContextCategoryValue#getExcludedValuesConfiguration <em>Excluded Values Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Excluded Values Configuration</em>'.
     * @see configuration.context_drivers.ContextCategoryValue#getExcludedValuesConfiguration()
     * @see #getContextCategoryValue()
     * @generated
     */
	EReference getContextCategoryValue_ExcludedValuesConfiguration();

	/**
     * Returns the meta object for class '{@link configuration.context_drivers.ContextualElement <em>Contextual Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Contextual Element</em>'.
     * @see configuration.context_drivers.ContextualElement
     * @generated
     */
	EClass getContextualElement();

	/**
     * Returns the meta object for the containment reference list '{@link configuration.context_drivers.ContextualElement#getContextualElementConfiguration <em>Contextual Element Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Contextual Element Configuration</em>'.
     * @see configuration.context_drivers.ContextualElement#getContextualElementConfiguration()
     * @see #getContextualElement()
     * @generated
     */
	EReference getContextualElement_ContextualElementConfiguration();

	/**
     * Returns the meta object for class '{@link configuration.context_drivers.ContexConfiguration <em>Contex Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Contex Configuration</em>'.
     * @see configuration.context_drivers.ContexConfiguration
     * @generated
     */
	EClass getContexConfiguration();

	/**
     * Returns the meta object for the reference '{@link configuration.context_drivers.ContexConfiguration#getCategory <em>Category</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Category</em>'.
     * @see configuration.context_drivers.ContexConfiguration#getCategory()
     * @see #getContexConfiguration()
     * @generated
     */
	EReference getContexConfiguration_Category();

	/**
     * Returns the meta object for the reference list '{@link configuration.context_drivers.ContexConfiguration#getIncludedValues <em>Included Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Included Values</em>'.
     * @see configuration.context_drivers.ContexConfiguration#getIncludedValues()
     * @see #getContexConfiguration()
     * @generated
     */
	EReference getContexConfiguration_IncludedValues();

	/**
     * Returns the meta object for the container reference '{@link configuration.context_drivers.ContexConfiguration#getConfiguredElement <em>Configured Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Configured Element</em>'.
     * @see configuration.context_drivers.ContexConfiguration#getConfiguredElement()
     * @see #getContexConfiguration()
     * @generated
     */
	EReference getContexConfiguration_ConfiguredElement();

	/**
     * Returns the meta object for the reference list '{@link configuration.context_drivers.ContexConfiguration#getExcludedValues <em>Excluded Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Excluded Values</em>'.
     * @see configuration.context_drivers.ContexConfiguration#getExcludedValues()
     * @see #getContexConfiguration()
     * @generated
     */
	EReference getContexConfiguration_ExcludedValues();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	Context_driversFactory getContext_driversFactory();

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
         * The meta object literal for the '{@link configuration.context_drivers.impl.ContextCategoryImpl <em>Context Category</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.context_drivers.impl.ContextCategoryImpl
         * @see configuration.context_drivers.impl.Context_driversPackageImpl#getContextCategory()
         * @generated
         */
		EClass CONTEXT_CATEGORY = eINSTANCE.getContextCategory();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CONTEXT_CATEGORY__NAME = eINSTANCE.getContextCategory_Name();

		/**
         * The meta object literal for the '<em><b>Root Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXT_CATEGORY__ROOT_VALUE = eINSTANCE.getContextCategory_RootValue();

		/**
         * The meta object literal for the '<em><b>Category Configuration</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXT_CATEGORY__CATEGORY_CONFIGURATION = eINSTANCE.getContextCategory_CategoryConfiguration();

		/**
         * The meta object literal for the '{@link configuration.context_drivers.impl.ContextCategoryValueImpl <em>Context Category Value</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.context_drivers.impl.ContextCategoryValueImpl
         * @see configuration.context_drivers.impl.Context_driversPackageImpl#getContextCategoryValue()
         * @generated
         */
		EClass CONTEXT_CATEGORY_VALUE = eINSTANCE.getContextCategoryValue();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CONTEXT_CATEGORY_VALUE__VALUE = eINSTANCE.getContextCategoryValue_Value();

		/**
         * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXT_CATEGORY_VALUE__CONTEXT = eINSTANCE.getContextCategoryValue_Context();

		/**
         * The meta object literal for the '<em><b>Included Values Configuration</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXT_CATEGORY_VALUE__INCLUDED_VALUES_CONFIGURATION = eINSTANCE.getContextCategoryValue_IncludedValuesConfiguration();

		/**
         * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXT_CATEGORY_VALUE__CHILDREN = eINSTANCE.getContextCategoryValue_Children();

		/**
         * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXT_CATEGORY_VALUE__PARENT = eINSTANCE.getContextCategoryValue_Parent();

		/**
         * The meta object literal for the '<em><b>Excluded Values Configuration</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXT_CATEGORY_VALUE__EXCLUDED_VALUES_CONFIGURATION = eINSTANCE.getContextCategoryValue_ExcludedValuesConfiguration();

		/**
         * The meta object literal for the '{@link configuration.context_drivers.impl.ContextualElementImpl <em>Contextual Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.context_drivers.impl.ContextualElementImpl
         * @see configuration.context_drivers.impl.Context_driversPackageImpl#getContextualElement()
         * @generated
         */
		EClass CONTEXTUAL_ELEMENT = eINSTANCE.getContextualElement();

		/**
         * The meta object literal for the '<em><b>Contextual Element Configuration</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION = eINSTANCE.getContextualElement_ContextualElementConfiguration();

		/**
         * The meta object literal for the '{@link configuration.context_drivers.impl.ContexConfigurationImpl <em>Contex Configuration</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see configuration.context_drivers.impl.ContexConfigurationImpl
         * @see configuration.context_drivers.impl.Context_driversPackageImpl#getContexConfiguration()
         * @generated
         */
		EClass CONTEX_CONFIGURATION = eINSTANCE.getContexConfiguration();

		/**
         * The meta object literal for the '<em><b>Category</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEX_CONFIGURATION__CATEGORY = eINSTANCE.getContexConfiguration_Category();

		/**
         * The meta object literal for the '<em><b>Included Values</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEX_CONFIGURATION__INCLUDED_VALUES = eINSTANCE.getContexConfiguration_IncludedValues();

		/**
         * The meta object literal for the '<em><b>Configured Element</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEX_CONFIGURATION__CONFIGURED_ELEMENT = eINSTANCE.getContexConfiguration_ConfiguredElement();

		/**
         * The meta object literal for the '<em><b>Excluded Values</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEX_CONFIGURATION__EXCLUDED_VALUES = eINSTANCE.getContexConfiguration_ExcludedValues();

	}

} //Context_driversPackage
