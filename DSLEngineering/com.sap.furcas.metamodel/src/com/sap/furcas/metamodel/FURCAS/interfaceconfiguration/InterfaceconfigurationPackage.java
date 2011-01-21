/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.interfaceconfiguration;

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
 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface InterfaceconfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "interfaceconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://interfaceconfiguration/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "interfaceconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InterfaceconfigurationPackage eINSTANCE = com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.InterfaceconfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.ConfigurationImpl
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.InterfaceconfigurationPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__BINDINGS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.BindingImpl
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.InterfaceconfigurationPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 1;

	/**
	 * The feature id for the '<em><b>Requireing Syntax</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__REQUIREING_SYNTAX = 0;

	/**
	 * The feature id for the '<em><b>Providing Syntax</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__PROVIDING_SYNTAX = 1;

	/**
	 * The feature id for the '<em><b>Required Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__REQUIRED_TEMPLATE = 2;

	/**
	 * The feature id for the '<em><b>Provided Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__PROVIDED_TEMPLATE = 3;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__MODE = 4;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 5;


	/**
	 * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration#getBindings()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Bindings();

	/**
	 * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getRequireingSyntax <em>Requireing Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Requireing Syntax</em>'.
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getRequireingSyntax()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_RequireingSyntax();

	/**
	 * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getProvidingSyntax <em>Providing Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Providing Syntax</em>'.
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getProvidingSyntax()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_ProvidingSyntax();

	/**
	 * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getRequiredTemplate <em>Required Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Template</em>'.
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getRequiredTemplate()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_RequiredTemplate();

	/**
	 * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getProvidedTemplate <em>Provided Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Template</em>'.
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getProvidedTemplate()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_ProvidedTemplate();

	/**
	 * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getMode()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Mode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InterfaceconfigurationFactory getInterfaceconfigurationFactory();

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
		 * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.ConfigurationImpl
		 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.InterfaceconfigurationPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__BINDINGS = eINSTANCE.getConfiguration_Bindings();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();

		/**
		 * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.BindingImpl
		 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.InterfaceconfigurationPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Requireing Syntax</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__REQUIREING_SYNTAX = eINSTANCE.getBinding_RequireingSyntax();

		/**
		 * The meta object literal for the '<em><b>Providing Syntax</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__PROVIDING_SYNTAX = eINSTANCE.getBinding_ProvidingSyntax();

		/**
		 * The meta object literal for the '<em><b>Required Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__REQUIRED_TEMPLATE = eINSTANCE.getBinding_RequiredTemplate();

		/**
		 * The meta object literal for the '<em><b>Provided Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__PROVIDED_TEMPLATE = eINSTANCE.getBinding_ProvidedTemplate();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING__MODE = eINSTANCE.getBinding_Mode();

	}

} //InterfaceconfigurationPackage
