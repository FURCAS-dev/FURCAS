/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmfindexPackage.java,v 1.2 2009/10/02 12:20:10 jkohnlein Exp $
 */
package org.eclipse.emf.index.ecore.emfindex;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.emf.index.ecore.emfindex.EmfindexFactory
 * @model kind="package"
 * @generated
 */
public interface EmfindexPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "emfindex";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emfindex/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "emfindex";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmfindexPackage eINSTANCE = org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.AbstractBaseDescriptorImpl <em>Abstract Base Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.AbstractBaseDescriptorImpl
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getAbstractBaseDescriptor()
	 * @generated
	 */
	int ABSTRACT_BASE_DESCRIPTOR = 0;

	/**
	 * The feature id for the '<em><b>User Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BASE_DESCRIPTOR__USER_DATA = 0;

	/**
	 * The number of structural features of the '<em>Abstract Base Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.ContainerDescriptorImpl <em>Container Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.ContainerDescriptorImpl
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getContainerDescriptor()
	 * @generated
	 */
	int CONTAINER_DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>User Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_DESCRIPTOR__USER_DATA = ABSTRACT_BASE_DESCRIPTOR__USER_DATA;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_DESCRIPTOR__NAME = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Container Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_DESCRIPTOR_FEATURE_COUNT = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl <em>Resource Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getResourceDescriptor()
	 * @generated
	 */
	int RESOURCE_DESCRIPTOR = 2;

	/**
	 * The feature id for the '<em><b>User Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR__USER_DATA = ABSTRACT_BASE_DESCRIPTOR__USER_DATA;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR__URI = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Indexed Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR__INDEXED_VERSION = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR__CONTAINER = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>EObject Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>EReference Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Resource Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR_FEATURE_COUNT = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.EObjectDescriptorImpl <em>EObject Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.EObjectDescriptorImpl
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getEObjectDescriptor()
	 * @generated
	 */
	int EOBJECT_DESCRIPTOR = 3;

	/**
	 * The feature id for the '<em><b>User Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_DESCRIPTOR__USER_DATA = ABSTRACT_BASE_DESCRIPTOR__USER_DATA;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_DESCRIPTOR__NAME = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_DESCRIPTOR__FRAGMENT = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_DESCRIPTOR__ECLASS = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Descriptor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>EObject Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_DESCRIPTOR_FEATURE_COUNT = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl <em>EReference Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getEReferenceDescriptor()
	 * @generated
	 */
	int EREFERENCE_DESCRIPTOR = 4;

	/**
	 * The feature id for the '<em><b>User Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_DESCRIPTOR__USER_DATA = ABSTRACT_BASE_DESCRIPTOR__USER_DATA;

	/**
	 * The feature id for the '<em><b>Source Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_DESCRIPTOR__SOURCE_FRAGMENT = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_DESCRIPTOR__EREFERENCE = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_DESCRIPTOR__TARGET_FRAGMENT = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Resource URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_DESCRIPTOR__TARGET_RESOURCE_URI = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target EObject Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_DESCRIPTOR__TARGET_EOBJECT_DESCRIPTOR = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Source Resource Descriptor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>EReference Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_DESCRIPTOR_FEATURE_COUNT = ABSTRACT_BASE_DESCRIPTOR_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.UserDataEntryImpl <em>User Data Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.UserDataEntryImpl
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getUserDataEntry()
	 * @generated
	 */
	int USER_DATA_ENTRY = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DATA_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DATA_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>User Data Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DATA_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>EURI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getEURI()
	 * @generated
	 */
	int EURI = 6;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfindex.BaseDescriptor <em>Abstract Base Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Base Descriptor</em>'.
	 * @see org.eclipse.emf.emfindex.BaseDescriptor
	 * @model instanceClass="org.eclipse.emf.emfindex.BaseDescriptor"
	 * @generated
	 */
	EClass getAbstractBaseDescriptor();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.emf.emfindex.BaseDescriptor#getUserData <em>User Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>User Data</em>'.
	 * @see org.eclipse.emf.emfindex.BaseDescriptor#getUserData()
	 * @see #getAbstractBaseDescriptor()
	 * @generated
	 */
	EReference getAbstractBaseDescriptor_UserData();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfindex.ContainerDescriptor <em>Container Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Descriptor</em>'.
	 * @see org.eclipse.emf.emfindex.ContainerDescriptor
	 * @model instanceClass="org.eclipse.emf.emfindex.ContainerDescriptor" superTypes="org.eclipse.emf.index.ecore.emfindex.AbstractBaseDescriptor"
	 * @generated
	 */
	EClass getContainerDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfindex.ContainerDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfindex.ContainerDescriptor#getName()
	 * @see #getContainerDescriptor()
	 * @generated
	 */
	EAttribute getContainerDescriptor_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfindex.ContainerDescriptor#getResourceDescriptors <em>Resource Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Descriptors</em>'.
	 * @see org.eclipse.emf.emfindex.ContainerDescriptor#getResourceDescriptors()
	 * @see #getContainerDescriptor()
	 * @generated
	 */
	EReference getContainerDescriptor_ResourceDescriptors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfindex.ResourceDescriptor <em>Resource Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Descriptor</em>'.
	 * @see org.eclipse.emf.emfindex.ResourceDescriptor
	 * @model instanceClass="org.eclipse.emf.emfindex.ResourceDescriptor" superTypes="org.eclipse.emf.index.ecore.emfindex.AbstractBaseDescriptor"
	 * @generated
	 */
	EClass getResourceDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfindex.ResourceDescriptor#getURI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URI</em>'.
	 * @see org.eclipse.emf.emfindex.ResourceDescriptor#getURI()
	 * @see #getResourceDescriptor()
	 * @generated
	 */
	EAttribute getResourceDescriptor_URI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfindex.ResourceDescriptor#getIndexedVersion <em>Indexed Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indexed Version</em>'.
	 * @see org.eclipse.emf.emfindex.ResourceDescriptor#getIndexedVersion()
	 * @see #getResourceDescriptor()
	 * @generated
	 */
	EAttribute getResourceDescriptor_IndexedVersion();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.emfindex.ResourceDescriptor#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.eclipse.emf.emfindex.ResourceDescriptor#getContainer()
	 * @see #getResourceDescriptor()
	 * @generated
	 */
	EReference getResourceDescriptor_Container();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfindex.ResourceDescriptor#getEObjectDescriptors <em>EObject Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EObject Descriptors</em>'.
	 * @see org.eclipse.emf.emfindex.ResourceDescriptor#getEObjectDescriptors()
	 * @see #getResourceDescriptor()
	 * @generated
	 */
	EReference getResourceDescriptor_EObjectDescriptors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfindex.ResourceDescriptor#getEReferenceDescriptors <em>EReference Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EReference Descriptors</em>'.
	 * @see org.eclipse.emf.emfindex.ResourceDescriptor#getEReferenceDescriptors()
	 * @see #getResourceDescriptor()
	 * @generated
	 */
	EReference getResourceDescriptor_EReferenceDescriptors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfindex.EObjectDescriptor <em>EObject Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Descriptor</em>'.
	 * @see org.eclipse.emf.emfindex.EObjectDescriptor
	 * @model instanceClass="org.eclipse.emf.emfindex.EObjectDescriptor" superTypes="org.eclipse.emf.index.ecore.emfindex.AbstractBaseDescriptor"
	 * @generated
	 */
	EClass getEObjectDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfindex.EObjectDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfindex.EObjectDescriptor#getName()
	 * @see #getEObjectDescriptor()
	 * @generated
	 */
	EAttribute getEObjectDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfindex.EObjectDescriptor#getFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fragment</em>'.
	 * @see org.eclipse.emf.emfindex.EObjectDescriptor#getFragment()
	 * @see #getEObjectDescriptor()
	 * @generated
	 */
	EAttribute getEObjectDescriptor_Fragment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfindex.EObjectDescriptor#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClass</em>'.
	 * @see org.eclipse.emf.emfindex.EObjectDescriptor#getEClass()
	 * @see #getEObjectDescriptor()
	 * @generated
	 */
	EReference getEObjectDescriptor_EClass();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.emfindex.EObjectDescriptor#getResourceDescriptor <em>Resource Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource Descriptor</em>'.
	 * @see org.eclipse.emf.emfindex.EObjectDescriptor#getResourceDescriptor()
	 * @see #getEObjectDescriptor()
	 * @generated
	 */
	EReference getEObjectDescriptor_ResourceDescriptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfindex.EReferenceDescriptor <em>EReference Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EReference Descriptor</em>'.
	 * @see org.eclipse.emf.emfindex.EReferenceDescriptor
	 * @model instanceClass="org.eclipse.emf.emfindex.EReferenceDescriptor" superTypes="org.eclipse.emf.index.ecore.emfindex.AbstractBaseDescriptor"
	 * @generated
	 */
	EClass getEReferenceDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfindex.EReferenceDescriptor#getSourceFragment <em>Source Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Fragment</em>'.
	 * @see org.eclipse.emf.emfindex.EReferenceDescriptor#getSourceFragment()
	 * @see #getEReferenceDescriptor()
	 * @generated
	 */
	EAttribute getEReferenceDescriptor_SourceFragment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfindex.EReferenceDescriptor#getEReference <em>EReference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference</em>'.
	 * @see org.eclipse.emf.emfindex.EReferenceDescriptor#getEReference()
	 * @see #getEReferenceDescriptor()
	 * @generated
	 */
	EReference getEReferenceDescriptor_EReference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfindex.EReferenceDescriptor#getTargetFragment <em>Target Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Fragment</em>'.
	 * @see org.eclipse.emf.emfindex.EReferenceDescriptor#getTargetFragment()
	 * @see #getEReferenceDescriptor()
	 * @generated
	 */
	EAttribute getEReferenceDescriptor_TargetFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfindex.EReferenceDescriptor#getTargetResourceURI <em>Target Resource URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Resource URI</em>'.
	 * @see org.eclipse.emf.emfindex.EReferenceDescriptor#getTargetResourceURI()
	 * @see #getEReferenceDescriptor()
	 * @generated
	 */
	EAttribute getEReferenceDescriptor_TargetResourceURI();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfindex.EReferenceDescriptor#getTargetEObjectDescriptor <em>Target EObject Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target EObject Descriptor</em>'.
	 * @see org.eclipse.emf.emfindex.EReferenceDescriptor#getTargetEObjectDescriptor()
	 * @see #getEReferenceDescriptor()
	 * @generated
	 */
	EReference getEReferenceDescriptor_TargetEObjectDescriptor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.emfindex.EReferenceDescriptor#getSourceResourceDescriptor <em>Source Resource Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source Resource Descriptor</em>'.
	 * @see org.eclipse.emf.emfindex.EReferenceDescriptor#getSourceResourceDescriptor()
	 * @see #getEReferenceDescriptor()
	 * @generated
	 */
	EReference getEReferenceDescriptor_SourceResourceDescriptor();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>User Data Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Data Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getUserDataEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getUserDataEntry()
	 * @generated
	 */
	EAttribute getUserDataEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getUserDataEntry()
	 * @generated
	 */
	EAttribute getUserDataEntry_Value();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>EURI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EURI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getEURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EmfindexFactory getEmfindexFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.AbstractBaseDescriptorImpl <em>Abstract Base Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.AbstractBaseDescriptorImpl
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getAbstractBaseDescriptor()
		 * @generated
		 */
		EClass ABSTRACT_BASE_DESCRIPTOR = eINSTANCE.getAbstractBaseDescriptor();

		/**
		 * The meta object literal for the '<em><b>User Data</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_BASE_DESCRIPTOR__USER_DATA = eINSTANCE.getAbstractBaseDescriptor_UserData();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.ContainerDescriptorImpl <em>Container Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.ContainerDescriptorImpl
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getContainerDescriptor()
		 * @generated
		 */
		EClass CONTAINER_DESCRIPTOR = eINSTANCE.getContainerDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER_DESCRIPTOR__NAME = eINSTANCE.getContainerDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Resource Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS = eINSTANCE.getContainerDescriptor_ResourceDescriptors();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl <em>Resource Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getResourceDescriptor()
		 * @generated
		 */
		EClass RESOURCE_DESCRIPTOR = eINSTANCE.getResourceDescriptor();

		/**
		 * The meta object literal for the '<em><b>URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_DESCRIPTOR__URI = eINSTANCE.getResourceDescriptor_URI();

		/**
		 * The meta object literal for the '<em><b>Indexed Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_DESCRIPTOR__INDEXED_VERSION = eINSTANCE.getResourceDescriptor_IndexedVersion();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DESCRIPTOR__CONTAINER = eINSTANCE.getResourceDescriptor_Container();

		/**
		 * The meta object literal for the '<em><b>EObject Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS = eINSTANCE.getResourceDescriptor_EObjectDescriptors();

		/**
		 * The meta object literal for the '<em><b>EReference Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS = eINSTANCE.getResourceDescriptor_EReferenceDescriptors();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.EObjectDescriptorImpl <em>EObject Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.EObjectDescriptorImpl
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getEObjectDescriptor()
		 * @generated
		 */
		EClass EOBJECT_DESCRIPTOR = eINSTANCE.getEObjectDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOBJECT_DESCRIPTOR__NAME = eINSTANCE.getEObjectDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOBJECT_DESCRIPTOR__FRAGMENT = eINSTANCE.getEObjectDescriptor_Fragment();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_DESCRIPTOR__ECLASS = eINSTANCE.getEObjectDescriptor_EClass();

		/**
		 * The meta object literal for the '<em><b>Resource Descriptor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR = eINSTANCE.getEObjectDescriptor_ResourceDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl <em>EReference Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getEReferenceDescriptor()
		 * @generated
		 */
		EClass EREFERENCE_DESCRIPTOR = eINSTANCE.getEReferenceDescriptor();

		/**
		 * The meta object literal for the '<em><b>Source Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREFERENCE_DESCRIPTOR__SOURCE_FRAGMENT = eINSTANCE.getEReferenceDescriptor_SourceFragment();

		/**
		 * The meta object literal for the '<em><b>EReference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREFERENCE_DESCRIPTOR__EREFERENCE = eINSTANCE.getEReferenceDescriptor_EReference();

		/**
		 * The meta object literal for the '<em><b>Target Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREFERENCE_DESCRIPTOR__TARGET_FRAGMENT = eINSTANCE.getEReferenceDescriptor_TargetFragment();

		/**
		 * The meta object literal for the '<em><b>Target Resource URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EREFERENCE_DESCRIPTOR__TARGET_RESOURCE_URI = eINSTANCE.getEReferenceDescriptor_TargetResourceURI();

		/**
		 * The meta object literal for the '<em><b>Target EObject Descriptor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREFERENCE_DESCRIPTOR__TARGET_EOBJECT_DESCRIPTOR = eINSTANCE.getEReferenceDescriptor_TargetEObjectDescriptor();

		/**
		 * The meta object literal for the '<em><b>Source Resource Descriptor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR = eINSTANCE.getEReferenceDescriptor_SourceResourceDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.index.ecore.emfindex.impl.UserDataEntryImpl <em>User Data Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.UserDataEntryImpl
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getUserDataEntry()
		 * @generated
		 */
		EClass USER_DATA_ENTRY = eINSTANCE.getUserDataEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_DATA_ENTRY__KEY = eINSTANCE.getUserDataEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_DATA_ENTRY__VALUE = eINSTANCE.getUserDataEntry_Value();

		/**
		 * The meta object literal for the '<em>EURI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.eclipse.emf.index.ecore.emfindex.impl.EmfindexPackageImpl#getEURI()
		 * @generated
		 */
		EDataType EURI = eINSTANCE.getEURI();

	}

} //EmfindexPackage
