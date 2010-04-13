/**
 * <copyright>
 * </copyright>
 *
 * $Id: EObjectDescriptorImpl.java,v 1.3 2009/10/01 08:14:55 jkohnlein Exp $
 */
package org.eclipse.emf.index.ecore.emfindex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;

import org.eclipse.emf.index.ecore.emfindex.EmfindexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EObject Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.EObjectDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.EObjectDescriptorImpl#getFragment <em>Fragment</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.EObjectDescriptorImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.EObjectDescriptorImpl#getResourceDescriptor <em>Resource Descriptor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EObjectDescriptorImpl extends AbstractBaseDescriptorImpl implements EObjectDescriptor {
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
	 * The default value of the '{@link #getFragment() <em>Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected static final String FRAGMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFragment() <em>Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected String fragment = FRAGMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEClass() <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected EClass eClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObjectDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfindexPackage.Literals.EOBJECT_DESCRIPTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.EOBJECT_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFragment() {
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFragment(String newFragment) {
		String oldFragment = fragment;
		fragment = newFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.EOBJECT_DESCRIPTOR__FRAGMENT, oldFragment, fragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClass() {
		if (eClass != null && eClass.eIsProxy()) {
			InternalEObject oldEClass = (InternalEObject)eClass;
			eClass = (EClass)eResolveProxy(oldEClass);
			if (eClass != oldEClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfindexPackage.EOBJECT_DESCRIPTOR__ECLASS, oldEClass, eClass));
			}
		}
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetEClass() {
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEClass(EClass newEClass) {
		EClass oldEClass = eClass;
		eClass = newEClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.EOBJECT_DESCRIPTOR__ECLASS, oldEClass, eClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDescriptor getResourceDescriptor() {
		if (eContainerFeatureID() != EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR) return null;
		return (ResourceDescriptor)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceDescriptor(ResourceDescriptor newResourceDescriptor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResourceDescriptor, EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceDescriptor(ResourceDescriptor newResourceDescriptor) {
		if (newResourceDescriptor != eInternalContainer() || (eContainerFeatureID() != EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR && newResourceDescriptor != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newResourceDescriptor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResourceDescriptor != null)
				msgs = ((InternalEObject)newResourceDescriptor).eInverseAdd(this, EmfindexPackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS, ResourceDescriptor.class, msgs);
			msgs = basicSetResourceDescriptor(newResourceDescriptor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR, newResourceDescriptor, newResourceDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getFragmentURI() {
		return getResourceDescriptor().getURI().appendFragment(fragment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject createProxy() {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) getEClass().getEPackage().getEFactoryInstance().create(getEClass());
		proxy.eSetProxyURI(getFragmentURI());
		return proxy;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResourceDescriptor((ResourceDescriptor)otherEnd, msgs);
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
			case EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR:
				return basicSetResourceDescriptor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR:
				return eInternalContainer().eInverseRemove(this, EmfindexPackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS, ResourceDescriptor.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfindexPackage.EOBJECT_DESCRIPTOR__NAME:
				return getName();
			case EmfindexPackage.EOBJECT_DESCRIPTOR__FRAGMENT:
				return getFragment();
			case EmfindexPackage.EOBJECT_DESCRIPTOR__ECLASS:
				if (resolve) return getEClass();
				return basicGetEClass();
			case EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR:
				return getResourceDescriptor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfindexPackage.EOBJECT_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case EmfindexPackage.EOBJECT_DESCRIPTOR__FRAGMENT:
				setFragment((String)newValue);
				return;
			case EmfindexPackage.EOBJECT_DESCRIPTOR__ECLASS:
				setEClass((EClass)newValue);
				return;
			case EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR:
				setResourceDescriptor((ResourceDescriptor)newValue);
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
			case EmfindexPackage.EOBJECT_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmfindexPackage.EOBJECT_DESCRIPTOR__FRAGMENT:
				setFragment(FRAGMENT_EDEFAULT);
				return;
			case EmfindexPackage.EOBJECT_DESCRIPTOR__ECLASS:
				setEClass((EClass)null);
				return;
			case EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR:
				setResourceDescriptor((ResourceDescriptor)null);
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
			case EmfindexPackage.EOBJECT_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmfindexPackage.EOBJECT_DESCRIPTOR__FRAGMENT:
				return FRAGMENT_EDEFAULT == null ? fragment != null : !FRAGMENT_EDEFAULT.equals(fragment);
			case EmfindexPackage.EOBJECT_DESCRIPTOR__ECLASS:
				return eClass != null;
			case EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR:
				return getResourceDescriptor() != null;
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
		result.append(", fragment: ");
		result.append(fragment);
		result.append(')');
		return result.toString();
	}

	
	
} //EObjectDescriptorImpl
