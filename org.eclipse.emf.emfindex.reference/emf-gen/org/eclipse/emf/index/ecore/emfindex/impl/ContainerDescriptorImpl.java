/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContainerDescriptorImpl.java,v 1.1 2009/09/30 13:04:49 jkohnlein Exp $
 */
package org.eclipse.emf.index.ecore.emfindex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;

import org.eclipse.emf.index.ecore.emfindex.EmfindexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.ContainerDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.ContainerDescriptorImpl#getResourceDescriptors <em>Resource Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainerDescriptorImpl extends AbstractBaseDescriptorImpl implements ContainerDescriptor {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourceDescriptors() <em>Resource Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceDescriptor> resourceDescriptors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfindexPackage.Literals.CONTAINER_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.CONTAINER_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceDescriptor> getResourceDescriptors() {
		if (resourceDescriptors == null) {
			resourceDescriptors = new EObjectContainmentWithInverseEList<ResourceDescriptor>(ResourceDescriptor.class, this, EmfindexPackage.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS, EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER);
		}
		return resourceDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfindexPackage.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResourceDescriptors()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfindexPackage.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS:
				return ((InternalEList<?>)getResourceDescriptors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfindexPackage.CONTAINER_DESCRIPTOR__NAME:
				return getName();
			case EmfindexPackage.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS:
				return getResourceDescriptors();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfindexPackage.CONTAINER_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case EmfindexPackage.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS:
				getResourceDescriptors().clear();
				getResourceDescriptors().addAll((Collection<? extends ResourceDescriptor>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfindexPackage.CONTAINER_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmfindexPackage.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS:
				getResourceDescriptors().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfindexPackage.CONTAINER_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmfindexPackage.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS:
				return resourceDescriptors != null && !resourceDescriptors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ContainerDescriptorImpl
