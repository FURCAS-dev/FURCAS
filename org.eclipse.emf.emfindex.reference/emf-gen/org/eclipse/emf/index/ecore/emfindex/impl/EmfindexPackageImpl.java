/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmfindexPackageImpl.java,v 1.4 2009/10/02 12:20:10 jkohnlein Exp $
 */
package org.eclipse.emf.index.ecore.emfindex.impl;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.emfindex.BaseDescriptor;
import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;
import org.eclipse.emf.index.ecore.emfindex.EmfindexFactory;
import org.eclipse.emf.index.ecore.emfindex.EmfindexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmfindexPackageImpl extends EPackageImpl implements EmfindexPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractBaseDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eReferenceDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDataEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType euriEDataType = null;

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
	 * @see org.eclipse.emf.index.ecore.emfindex.EmfindexPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EmfindexPackageImpl() {
		super(eNS_URI, EmfindexFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EmfindexPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EmfindexPackage init() {
		if (isInited) return (EmfindexPackage)EPackage.Registry.INSTANCE.getEPackage(EmfindexPackage.eNS_URI);

		// Obtain or create and register package
		EmfindexPackageImpl theEmfindexPackage = (EmfindexPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EmfindexPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EmfindexPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEmfindexPackage.createPackageContents();

		// Initialize created meta-data
		theEmfindexPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEmfindexPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EmfindexPackage.eNS_URI, theEmfindexPackage);
		return theEmfindexPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractBaseDescriptor() {
		return abstractBaseDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractBaseDescriptor_UserData() {
		return (EReference)abstractBaseDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerDescriptor() {
		return containerDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContainerDescriptor_Name() {
		return (EAttribute)containerDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainerDescriptor_ResourceDescriptors() {
		return (EReference)containerDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceDescriptor() {
		return resourceDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDescriptor_URI() {
		return (EAttribute)resourceDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDescriptor_IndexedVersion() {
		return (EAttribute)resourceDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDescriptor_Container() {
		return (EReference)resourceDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDescriptor_EObjectDescriptors() {
		return (EReference)resourceDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDescriptor_EReferenceDescriptors() {
		return (EReference)resourceDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEObjectDescriptor() {
		return eObjectDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEObjectDescriptor_Name() {
		return (EAttribute)eObjectDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEObjectDescriptor_Fragment() {
		return (EAttribute)eObjectDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectDescriptor_EClass() {
		return (EReference)eObjectDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectDescriptor_ResourceDescriptor() {
		return (EReference)eObjectDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEReferenceDescriptor() {
		return eReferenceDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEReferenceDescriptor_SourceFragment() {
		return (EAttribute)eReferenceDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEReferenceDescriptor_EReference() {
		return (EReference)eReferenceDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEReferenceDescriptor_TargetFragment() {
		return (EAttribute)eReferenceDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEReferenceDescriptor_TargetResourceURI() {
		return (EAttribute)eReferenceDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEReferenceDescriptor_TargetEObjectDescriptor() {
		return (EReference)eReferenceDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEReferenceDescriptor_SourceResourceDescriptor() {
		return (EReference)eReferenceDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDataEntry() {
		return userDataEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserDataEntry_Key() {
		return (EAttribute)userDataEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserDataEntry_Value() {
		return (EAttribute)userDataEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEURI() {
		return euriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfindexFactory getEmfindexFactory() {
		return (EmfindexFactory)getEFactoryInstance();
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
		abstractBaseDescriptorEClass = createEClass(ABSTRACT_BASE_DESCRIPTOR);
		createEReference(abstractBaseDescriptorEClass, ABSTRACT_BASE_DESCRIPTOR__USER_DATA);

		containerDescriptorEClass = createEClass(CONTAINER_DESCRIPTOR);
		createEAttribute(containerDescriptorEClass, CONTAINER_DESCRIPTOR__NAME);
		createEReference(containerDescriptorEClass, CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS);

		resourceDescriptorEClass = createEClass(RESOURCE_DESCRIPTOR);
		createEAttribute(resourceDescriptorEClass, RESOURCE_DESCRIPTOR__URI);
		createEAttribute(resourceDescriptorEClass, RESOURCE_DESCRIPTOR__INDEXED_VERSION);
		createEReference(resourceDescriptorEClass, RESOURCE_DESCRIPTOR__CONTAINER);
		createEReference(resourceDescriptorEClass, RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS);
		createEReference(resourceDescriptorEClass, RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS);

		eObjectDescriptorEClass = createEClass(EOBJECT_DESCRIPTOR);
		createEAttribute(eObjectDescriptorEClass, EOBJECT_DESCRIPTOR__NAME);
		createEAttribute(eObjectDescriptorEClass, EOBJECT_DESCRIPTOR__FRAGMENT);
		createEReference(eObjectDescriptorEClass, EOBJECT_DESCRIPTOR__ECLASS);
		createEReference(eObjectDescriptorEClass, EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR);

		eReferenceDescriptorEClass = createEClass(EREFERENCE_DESCRIPTOR);
		createEAttribute(eReferenceDescriptorEClass, EREFERENCE_DESCRIPTOR__SOURCE_FRAGMENT);
		createEReference(eReferenceDescriptorEClass, EREFERENCE_DESCRIPTOR__EREFERENCE);
		createEAttribute(eReferenceDescriptorEClass, EREFERENCE_DESCRIPTOR__TARGET_FRAGMENT);
		createEAttribute(eReferenceDescriptorEClass, EREFERENCE_DESCRIPTOR__TARGET_RESOURCE_URI);
		createEReference(eReferenceDescriptorEClass, EREFERENCE_DESCRIPTOR__TARGET_EOBJECT_DESCRIPTOR);
		createEReference(eReferenceDescriptorEClass, EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR);

		userDataEntryEClass = createEClass(USER_DATA_ENTRY);
		createEAttribute(userDataEntryEClass, USER_DATA_ENTRY__KEY);
		createEAttribute(userDataEntryEClass, USER_DATA_ENTRY__VALUE);

		// Create data types
		euriEDataType = createEDataType(EURI);
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

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		containerDescriptorEClass.getESuperTypes().add(this.getAbstractBaseDescriptor());
		resourceDescriptorEClass.getESuperTypes().add(this.getAbstractBaseDescriptor());
		eObjectDescriptorEClass.getESuperTypes().add(this.getAbstractBaseDescriptor());
		eReferenceDescriptorEClass.getESuperTypes().add(this.getAbstractBaseDescriptor());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractBaseDescriptorEClass, BaseDescriptor.class, "AbstractBaseDescriptor", IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractBaseDescriptor_UserData(), this.getUserDataEntry(), null, "userData", null, 0, -1, BaseDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(abstractBaseDescriptorEClass, theEcorePackage.getEString(), "getUserData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(abstractBaseDescriptorEClass, null, "setUserData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(containerDescriptorEClass, ContainerDescriptor.class, "ContainerDescriptor", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContainerDescriptor_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ContainerDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainerDescriptor_ResourceDescriptors(), this.getResourceDescriptor(), this.getResourceDescriptor_Container(), "resourceDescriptors", null, 0, -1, ContainerDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceDescriptorEClass, ResourceDescriptor.class, "ResourceDescriptor", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceDescriptor_URI(), this.getEURI(), "URI", null, 1, 1, ResourceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceDescriptor_IndexedVersion(), theEcorePackage.getELong(), "indexedVersion", null, 0, 1, ResourceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDescriptor_Container(), this.getContainerDescriptor(), this.getContainerDescriptor_ResourceDescriptors(), "container", null, 0, 1, ResourceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDescriptor_EObjectDescriptors(), this.getEObjectDescriptor(), this.getEObjectDescriptor_ResourceDescriptor(), "eObjectDescriptors", null, 0, -1, ResourceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDescriptor_EReferenceDescriptors(), this.getEReferenceDescriptor(), this.getEReferenceDescriptor_SourceResourceDescriptor(), "eReferenceDescriptors", null, 0, -1, ResourceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectDescriptorEClass, EObjectDescriptor.class, "EObjectDescriptor", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEObjectDescriptor_Name(), theEcorePackage.getEString(), "name", null, 0, 1, EObjectDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEObjectDescriptor_Fragment(), theEcorePackage.getEString(), "fragment", null, 1, 1, EObjectDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectDescriptor_EClass(), theEcorePackage.getEClass(), null, "eClass", null, 1, 1, EObjectDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectDescriptor_ResourceDescriptor(), this.getResourceDescriptor(), this.getResourceDescriptor_EObjectDescriptors(), "resourceDescriptor", null, 0, 1, EObjectDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eObjectDescriptorEClass, this.getEURI(), "getFragmentURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eObjectDescriptorEClass, theEcorePackage.getEObject(), "createProxy", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eReferenceDescriptorEClass, EReferenceDescriptor.class, "EReferenceDescriptor", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEReferenceDescriptor_SourceFragment(), theEcorePackage.getEString(), "sourceFragment", null, 1, 1, EReferenceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEReferenceDescriptor_EReference(), theEcorePackage.getEReference(), null, "eReference", null, 1, 1, EReferenceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEReferenceDescriptor_TargetFragment(), theEcorePackage.getEString(), "targetFragment", null, 1, 1, EReferenceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEReferenceDescriptor_TargetResourceURI(), this.getEURI(), "targetResourceURI", null, 0, 1, EReferenceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEReferenceDescriptor_TargetEObjectDescriptor(), this.getEObjectDescriptor(), null, "targetEObjectDescriptor", null, 0, 1, EReferenceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEReferenceDescriptor_SourceResourceDescriptor(), this.getResourceDescriptor(), this.getResourceDescriptor_EReferenceDescriptors(), "sourceResourceDescriptor", null, 0, 1, EReferenceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eReferenceDescriptorEClass, this.getEURI(), "getTargetFragmentURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eReferenceDescriptorEClass, this.getEURI(), "getSourceFragmentURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(userDataEntryEClass, Map.Entry.class, "UserDataEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserDataEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserDataEntry_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(euriEDataType, URI.class, "EURI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EmfindexPackageImpl
