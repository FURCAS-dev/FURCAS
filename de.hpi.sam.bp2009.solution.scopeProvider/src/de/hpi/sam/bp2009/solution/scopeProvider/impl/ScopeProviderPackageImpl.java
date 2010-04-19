/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider.impl;

import de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderFactory;
import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderPackage;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.query2.QueryContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScopeProviderPackageImpl extends EPackageImpl implements ScopeProviderPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectBasedScopeProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopeProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iProjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType queryContextEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ScopeProviderPackageImpl() {
		super(eNS_URI, ScopeProviderFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ScopeProviderPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ScopeProviderPackage init() {
		if (isInited) return (ScopeProviderPackage)EPackage.Registry.INSTANCE.getEPackage(ScopeProviderPackage.eNS_URI);

		// Obtain or create and register package
		ScopeProviderPackageImpl theScopeProviderPackage = (ScopeProviderPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ScopeProviderPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ScopeProviderPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theScopeProviderPackage.createPackageContents();

		// Initialize created meta-data
		theScopeProviderPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScopeProviderPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ScopeProviderPackage.eNS_URI, theScopeProviderPackage);
		return theScopeProviderPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectBasedScopeProvider() {
		return projectBasedScopeProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectBasedScopeProvider_InitialProjects() {
		return (EAttribute)projectBasedScopeProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopeProvider() {
		return scopeProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIProject() {
		return iProjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getQueryContext() {
		return queryContextEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeProviderFactory getScopeProviderFactory() {
		return (ScopeProviderFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		projectBasedScopeProviderEClass = createEClass(PROJECT_BASED_SCOPE_PROVIDER);
		createEAttribute(projectBasedScopeProviderEClass, PROJECT_BASED_SCOPE_PROVIDER__INITIAL_PROJECTS);

		scopeProviderEClass = createEClass(SCOPE_PROVIDER);

		// Create data types
		uriEDataType = createEDataType(URI);
		iProjectEDataType = createEDataType(IPROJECT);
		queryContextEDataType = createEDataType(QUERY_CONTEXT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		projectBasedScopeProviderEClass.getESuperTypes().add(this.getScopeProvider());

		// Initialize classes and features; add operations and parameters
		initEClass(projectBasedScopeProviderEClass, ProjectBasedScopeProvider.class, "ProjectBasedScopeProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getProjectBasedScopeProvider_InitialProjects(), this.getIProject(), "initialProjects", null, 1, -1, ProjectBasedScopeProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(projectBasedScopeProviderEClass, null, "setupForEObjects", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEObject(), "initialObjects", 1, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(projectBasedScopeProviderEClass, null, "setupForResources", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEResource(), "initialResources", 1, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(projectBasedScopeProviderEClass, null, "setupForResourceSets", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEResourceSet(), "initialResourceSets", 1, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(projectBasedScopeProviderEClass, ecorePackage.getEObject(), "getForwardScopeAsEObjects", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(projectBasedScopeProviderEClass, this.getIProject(), "getForwardScopeAsProjects", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(projectBasedScopeProviderEClass, ecorePackage.getEResource(), "getForwardScopeAsResources", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(projectBasedScopeProviderEClass, this.getURI(), "getForwardScopeAsURIs", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(projectBasedScopeProviderEClass, ecorePackage.getEObject(), "getBackwardScopeAsEObjects", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(projectBasedScopeProviderEClass, this.getIProject(), "getBackwardScopeAsProjects", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(projectBasedScopeProviderEClass, ecorePackage.getEResource(), "getBackwardScopeAsResources", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(projectBasedScopeProviderEClass, this.getURI(), "getBackwardScopeAsURIs", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(scopeProviderEClass, ScopeProvider.class, "ScopeProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = addEOperation(scopeProviderEClass, null, "setupForEObjects", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEObject(), "initialObjects", 1, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(scopeProviderEClass, null, "setupForResources", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEResource(), "initialResources", 1, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(scopeProviderEClass, null, "setupForResourceSets", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEResourceSet(), "initialResourceSets", 1, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(scopeProviderEClass, ecorePackage.getEObject(), "getForwardScopeAsEObjects", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(scopeProviderEClass, this.getURI(), "getForwardScopeAsURIs", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(scopeProviderEClass, ecorePackage.getEObject(), "getBackwardScopeAsEObjects", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(scopeProviderEClass, this.getURI(), "getBackwardScopeAsURIs", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(scopeProviderEClass, null, "setInMemoryResources", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEResource(), "resources", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(scopeProviderEClass, ecorePackage.getEResource(), "getInMemoryResources", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(scopeProviderEClass, this.getQueryContext(), "getForwardScopeAsQueryContext", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(scopeProviderEClass, this.getQueryContext(), "getBackwardScopeAsQueryContext", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iProjectEDataType, IProject.class, "IProject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(queryContextEDataType, QueryContext.class, "QueryContext", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //ScopeProviderPackageImpl
