/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

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
 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderFactory
 * @model kind="package"
 * @generated
 */
public interface ScopeProviderPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scopeProvider"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.solution.scopeProvider"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "solution.scopeProvider"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScopeProviderPackage eINSTANCE = de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl <em>Project Based Scope Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderPackageImpl#getProjectBasedScopeProvider()
	 * @generated
	 */
	int PROJECT_BASED_SCOPE_PROVIDER = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider <em>Scope Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderPackageImpl#getScopeProvider()
	 * @generated
	 */
	int SCOPE_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>In Memory Resources</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_PROVIDER__IN_MEMORY_RESOURCES = 0;

	/**
	 * The number of structural features of the '<em>Scope Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_PROVIDER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>In Memory Resources</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_BASED_SCOPE_PROVIDER__IN_MEMORY_RESOURCES = SCOPE_PROVIDER__IN_MEMORY_RESOURCES;

	/**
	 * The feature id for the '<em><b>Initial Projects</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_BASED_SCOPE_PROVIDER__INITIAL_PROJECTS = SCOPE_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Based Scope Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_BASED_SCOPE_PROVIDER_FEATURE_COUNT = SCOPE_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderPackageImpl#getURI()
	 * @generated
	 */
	int URI = 2;


	/**
	 * The meta object id for the '<em>IProject</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IProject
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderPackageImpl#getIProject()
	 * @generated
	 */
	int IPROJECT = 3;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider <em>Project Based Scope Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Based Scope Provider</em>'.
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider
	 * @generated
	 */
	EClass getProjectBasedScopeProvider();

	/**
	 * Returns the meta object for the attribute list '{@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#getInitialProjects <em>Initial Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Initial Projects</em>'.
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#getInitialProjects()
	 * @see #getProjectBasedScopeProvider()
	 * @generated
	 */
	EAttribute getProjectBasedScopeProvider_InitialProjects();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider <em>Scope Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scope Provider</em>'.
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider
	 * @generated
	 */
	EClass getScopeProvider();

	/**
	 * Returns the meta object for the attribute list '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getInMemoryResources <em>In Memory Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>In Memory Resources</em>'.
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getInMemoryResources()
	 * @see #getScopeProvider()
	 * @generated
	 */
	EAttribute getScopeProvider_InMemoryResources();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IProject <em>IProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IProject</em>'.
	 * @see org.eclipse.core.resources.IProject
	 * @model instanceClass="org.eclipse.core.resources.IProject"
	 * @generated
	 */
	EDataType getIProject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScopeProviderFactory getScopeProviderFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl <em>Project Based Scope Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl
		 * @see de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderPackageImpl#getProjectBasedScopeProvider()
		 * @generated
		 */
		EClass PROJECT_BASED_SCOPE_PROVIDER = eINSTANCE.getProjectBasedScopeProvider();

		/**
		 * The meta object literal for the '<em><b>Initial Projects</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_BASED_SCOPE_PROVIDER__INITIAL_PROJECTS = eINSTANCE.getProjectBasedScopeProvider_InitialProjects();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider <em>Scope Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider
		 * @see de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderPackageImpl#getScopeProvider()
		 * @generated
		 */
		EClass SCOPE_PROVIDER = eINSTANCE.getScopeProvider();

		/**
		 * The meta object literal for the '<em><b>In Memory Resources</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOPE_PROVIDER__IN_MEMORY_RESOURCES = eINSTANCE.getScopeProvider_InMemoryResources();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

		/**
		 * The meta object literal for the '<em>IProject</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IProject
		 * @see de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderPackageImpl#getIProject()
		 * @generated
		 */
		EDataType IPROJECT = eINSTANCE.getIProject();

	}

} //ScopeProviderPackage
