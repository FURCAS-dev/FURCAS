/**
 * <copyright>
 * </copyright>
 *
 * $Id: BindingPackage.java,v 1.1 2011/02/07 17:21:38 auhl Exp $
 */
package integration.binding;

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
 * <!-- begin-model-doc -->
 * Defines structures that can be used to bind functions to ports through which these functions can be invoked.
 * <!-- end-model-doc -->
 * @see integration.binding.BindingFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface BindingPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "binding";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/integration/binding.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "integration.binding";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	BindingPackage eINSTANCE = integration.binding.impl.BindingPackageImpl.init();

	/**
     * The meta object id for the '{@link integration.binding.impl.BindingImpl <em>Binding</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.binding.impl.BindingImpl
     * @see integration.binding.impl.BindingPackageImpl#getBinding()
     * @generated
     */
	int BINDING = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINDING__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINDING__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Function</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINDING__FUNCTION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Binding</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINDING_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.binding.impl.HttpBindingImpl <em>Http Binding</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.binding.impl.HttpBindingImpl
     * @see integration.binding.impl.BindingPackageImpl#getHttpBinding()
     * @generated
     */
	int HTTP_BINDING = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_BINDING__NAME = BINDING__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_BINDING__DESCRIPTION = BINDING__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Function</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_BINDING__FUNCTION = BINDING__FUNCTION;

	/**
     * The feature id for the '<em><b>Url Pattern</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_BINDING__URL_PATTERN = BINDING_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Http Binding</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.binding.impl.HttpGetBindingImpl <em>Http Get Binding</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.binding.impl.HttpGetBindingImpl
     * @see integration.binding.impl.BindingPackageImpl#getHttpGetBinding()
     * @generated
     */
	int HTTP_GET_BINDING = 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_GET_BINDING__NAME = HTTP_BINDING__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_GET_BINDING__DESCRIPTION = HTTP_BINDING__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Function</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_GET_BINDING__FUNCTION = HTTP_BINDING__FUNCTION;

	/**
     * The feature id for the '<em><b>Url Pattern</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_GET_BINDING__URL_PATTERN = HTTP_BINDING__URL_PATTERN;

	/**
     * The number of structural features of the '<em>Http Get Binding</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_GET_BINDING_FEATURE_COUNT = HTTP_BINDING_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link integration.binding.impl.HttpPutBindingImpl <em>Http Put Binding</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.binding.impl.HttpPutBindingImpl
     * @see integration.binding.impl.BindingPackageImpl#getHttpPutBinding()
     * @generated
     */
	int HTTP_PUT_BINDING = 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_PUT_BINDING__NAME = HTTP_BINDING__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_PUT_BINDING__DESCRIPTION = HTTP_BINDING__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Function</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_PUT_BINDING__FUNCTION = HTTP_BINDING__FUNCTION;

	/**
     * The feature id for the '<em><b>Url Pattern</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_PUT_BINDING__URL_PATTERN = HTTP_BINDING__URL_PATTERN;

	/**
     * The number of structural features of the '<em>Http Put Binding</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HTTP_PUT_BINDING_FEATURE_COUNT = HTTP_BINDING_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link integration.binding.impl.UrlPatternImpl <em>Url Pattern</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.binding.impl.UrlPatternImpl
     * @see integration.binding.impl.BindingPackageImpl#getUrlPattern()
     * @generated
     */
	int URL_PATTERN = 4;

	/**
     * The number of structural features of the '<em>Url Pattern</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int URL_PATTERN_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link integration.binding.impl.SimpleUrlPatternImpl <em>Simple Url Pattern</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.binding.impl.SimpleUrlPatternImpl
     * @see integration.binding.impl.BindingPackageImpl#getSimpleUrlPattern()
     * @generated
     */
	int SIMPLE_URL_PATTERN = 5;

	/**
     * The feature id for the '<em><b>Base Url</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_URL_PATTERN__BASE_URL = URL_PATTERN_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Simple Url Pattern</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_URL_PATTERN_FEATURE_COUNT = URL_PATTERN_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.binding.impl.RestUrlPatternImpl <em>Rest Url Pattern</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.binding.impl.RestUrlPatternImpl
     * @see integration.binding.impl.BindingPackageImpl#getRestUrlPattern()
     * @generated
     */
	int REST_URL_PATTERN = 6;

	/**
     * The number of structural features of the '<em>Rest Url Pattern</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REST_URL_PATTERN_FEATURE_COUNT = URL_PATTERN_FEATURE_COUNT + 0;


	/**
     * Returns the meta object for class '{@link integration.binding.Binding <em>Binding</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Binding</em>'.
     * @see integration.binding.Binding
     * @generated
     */
	EClass getBinding();

	/**
     * Returns the meta object for the containment reference '{@link integration.binding.Binding#getFunction <em>Function</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Function</em>'.
     * @see integration.binding.Binding#getFunction()
     * @see #getBinding()
     * @generated
     */
	EReference getBinding_Function();

	/**
     * Returns the meta object for class '{@link integration.binding.HttpBinding <em>Http Binding</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Http Binding</em>'.
     * @see integration.binding.HttpBinding
     * @generated
     */
	EClass getHttpBinding();

	/**
     * Returns the meta object for the containment reference '{@link integration.binding.HttpBinding#getUrlPattern <em>Url Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Url Pattern</em>'.
     * @see integration.binding.HttpBinding#getUrlPattern()
     * @see #getHttpBinding()
     * @generated
     */
	EReference getHttpBinding_UrlPattern();

	/**
     * Returns the meta object for class '{@link integration.binding.HttpGetBinding <em>Http Get Binding</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Http Get Binding</em>'.
     * @see integration.binding.HttpGetBinding
     * @generated
     */
	EClass getHttpGetBinding();

	/**
     * Returns the meta object for class '{@link integration.binding.HttpPutBinding <em>Http Put Binding</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Http Put Binding</em>'.
     * @see integration.binding.HttpPutBinding
     * @generated
     */
	EClass getHttpPutBinding();

	/**
     * Returns the meta object for class '{@link integration.binding.UrlPattern <em>Url Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Url Pattern</em>'.
     * @see integration.binding.UrlPattern
     * @generated
     */
	EClass getUrlPattern();

	/**
     * Returns the meta object for class '{@link integration.binding.SimpleUrlPattern <em>Simple Url Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Url Pattern</em>'.
     * @see integration.binding.SimpleUrlPattern
     * @generated
     */
	EClass getSimpleUrlPattern();

	/**
     * Returns the meta object for the attribute '{@link integration.binding.SimpleUrlPattern#getBaseUrl <em>Base Url</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Url</em>'.
     * @see integration.binding.SimpleUrlPattern#getBaseUrl()
     * @see #getSimpleUrlPattern()
     * @generated
     */
	EAttribute getSimpleUrlPattern_BaseUrl();

	/**
     * Returns the meta object for class '{@link integration.binding.RestUrlPattern <em>Rest Url Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rest Url Pattern</em>'.
     * @see integration.binding.RestUrlPattern
     * @generated
     */
	EClass getRestUrlPattern();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	BindingFactory getBindingFactory();

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
         * The meta object literal for the '{@link integration.binding.impl.BindingImpl <em>Binding</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.binding.impl.BindingImpl
         * @see integration.binding.impl.BindingPackageImpl#getBinding()
         * @generated
         */
		EClass BINDING = eINSTANCE.getBinding();

		/**
         * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BINDING__FUNCTION = eINSTANCE.getBinding_Function();

		/**
         * The meta object literal for the '{@link integration.binding.impl.HttpBindingImpl <em>Http Binding</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.binding.impl.HttpBindingImpl
         * @see integration.binding.impl.BindingPackageImpl#getHttpBinding()
         * @generated
         */
		EClass HTTP_BINDING = eINSTANCE.getHttpBinding();

		/**
         * The meta object literal for the '<em><b>Url Pattern</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference HTTP_BINDING__URL_PATTERN = eINSTANCE.getHttpBinding_UrlPattern();

		/**
         * The meta object literal for the '{@link integration.binding.impl.HttpGetBindingImpl <em>Http Get Binding</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.binding.impl.HttpGetBindingImpl
         * @see integration.binding.impl.BindingPackageImpl#getHttpGetBinding()
         * @generated
         */
		EClass HTTP_GET_BINDING = eINSTANCE.getHttpGetBinding();

		/**
         * The meta object literal for the '{@link integration.binding.impl.HttpPutBindingImpl <em>Http Put Binding</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.binding.impl.HttpPutBindingImpl
         * @see integration.binding.impl.BindingPackageImpl#getHttpPutBinding()
         * @generated
         */
		EClass HTTP_PUT_BINDING = eINSTANCE.getHttpPutBinding();

		/**
         * The meta object literal for the '{@link integration.binding.impl.UrlPatternImpl <em>Url Pattern</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.binding.impl.UrlPatternImpl
         * @see integration.binding.impl.BindingPackageImpl#getUrlPattern()
         * @generated
         */
		EClass URL_PATTERN = eINSTANCE.getUrlPattern();

		/**
         * The meta object literal for the '{@link integration.binding.impl.SimpleUrlPatternImpl <em>Simple Url Pattern</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.binding.impl.SimpleUrlPatternImpl
         * @see integration.binding.impl.BindingPackageImpl#getSimpleUrlPattern()
         * @generated
         */
		EClass SIMPLE_URL_PATTERN = eINSTANCE.getSimpleUrlPattern();

		/**
         * The meta object literal for the '<em><b>Base Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SIMPLE_URL_PATTERN__BASE_URL = eINSTANCE.getSimpleUrlPattern_BaseUrl();

		/**
         * The meta object literal for the '{@link integration.binding.impl.RestUrlPatternImpl <em>Rest Url Pattern</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.binding.impl.RestUrlPatternImpl
         * @see integration.binding.impl.BindingPackageImpl#getRestUrlPattern()
         * @generated
         */
		EClass REST_URL_PATTERN = eINSTANCE.getRestUrlPattern();

	}

} //BindingPackage
