/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmfindexFactoryImpl.java,v 1.2 2009/10/02 12:20:10 jkohnlein Exp $
 */
package org.eclipse.emf.index.ecore.emfindex.impl;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;
import org.eclipse.emf.index.ecore.emfindex.EmfindexFactory;
import org.eclipse.emf.index.ecore.emfindex.EmfindexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmfindexFactoryImpl extends EFactoryImpl implements EmfindexFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmfindexFactory init() {
		try {
			EmfindexFactory theEmfindexFactory = (EmfindexFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emfindex/1.0"); 
			if (theEmfindexFactory != null) {
				return theEmfindexFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EmfindexFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfindexFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EmfindexPackage.CONTAINER_DESCRIPTOR: return (EObject)createContainerDescriptor();
			case EmfindexPackage.RESOURCE_DESCRIPTOR: return (EObject)createResourceDescriptor();
			case EmfindexPackage.EOBJECT_DESCRIPTOR: return (EObject)createEObjectDescriptor();
			case EmfindexPackage.EREFERENCE_DESCRIPTOR: return (EObject)createEReferenceDescriptor();
			case EmfindexPackage.USER_DATA_ENTRY: return (EObject)createUserDataEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EmfindexPackage.EURI:
				return createEURIFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EmfindexPackage.EURI:
				return convertEURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerDescriptor createContainerDescriptor() {
		ContainerDescriptorImpl containerDescriptor = new ContainerDescriptorImpl();
		return containerDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDescriptor createResourceDescriptor() {
		ResourceDescriptorImpl resourceDescriptor = new ResourceDescriptorImpl();
		return resourceDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectDescriptor createEObjectDescriptor() {
		EObjectDescriptorImpl eObjectDescriptor = new EObjectDescriptorImpl();
		return eObjectDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReferenceDescriptor createEReferenceDescriptor() {
		EReferenceDescriptorImpl eReferenceDescriptor = new EReferenceDescriptorImpl();
		return eReferenceDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createUserDataEntry() {
		UserDataEntryImpl userDataEntry = new UserDataEntryImpl();
		return userDataEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createEURIFromString(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfindexPackage getEmfindexPackage() {
		return (EmfindexPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EmfindexPackage getPackage() {
		return EmfindexPackage.eINSTANCE;
	}

} //EmfindexFactoryImpl
