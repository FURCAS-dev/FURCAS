/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResourceDescriptorImpl.java,v 1.1 2009/09/30 13:04:49 jkohnlein Exp $
 */
package org.eclipse.emf.index.ecore.emfindex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;

import org.eclipse.emf.index.ecore.emfindex.EmfindexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl#getIndexedVersion <em>Indexed Version</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl#getEObjectDescriptors <em>EObject Descriptors</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl#getEReferenceDescriptors <em>EReference Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDescriptorImpl extends AbstractBaseDescriptorImpl implements ResourceDescriptor {
	/**
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected URI uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexedVersion() <em>Indexed Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexedVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long INDEXED_VERSION_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getIndexedVersion() <em>Indexed Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexedVersion()
	 * @generated
	 * @ordered
	 */
	protected long indexedVersion = INDEXED_VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEObjectDescriptors() <em>EObject Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEObjectDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<EObjectDescriptor> eObjectDescriptors;

	/**
	 * The cached value of the '{@link #getEReferenceDescriptors() <em>EReference Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReferenceDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<EReferenceDescriptor> eReferenceDescriptors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfindexPackage.Literals.RESOURCE_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getURI() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setURI(URI newURI) {
		URI oldURI = uri;
		uri = newURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.RESOURCE_DESCRIPTOR__URI, oldURI, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getIndexedVersion() {
		return indexedVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexedVersion(long newIndexedVersion) {
		long oldIndexedVersion = indexedVersion;
		indexedVersion = newIndexedVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.RESOURCE_DESCRIPTOR__INDEXED_VERSION, oldIndexedVersion, indexedVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerDescriptor getContainer() {
		if (eContainerFeatureID() != EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER) return null;
		return (ContainerDescriptor)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(ContainerDescriptor newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(ContainerDescriptor newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, EmfindexPackage.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS, ContainerDescriptor.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObjectDescriptor> getEObjectDescriptors() {
		if (eObjectDescriptors == null) {
			eObjectDescriptors = new EObjectContainmentWithInverseEList<EObjectDescriptor>(EObjectDescriptor.class, this, EmfindexPackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS, EmfindexPackage.EOBJECT_DESCRIPTOR__RESOURCE_DESCRIPTOR);
		}
		return eObjectDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReferenceDescriptor> getEReferenceDescriptors() {
		if (eReferenceDescriptors == null) {
			eReferenceDescriptors = new EObjectContainmentWithInverseEList<EReferenceDescriptor>(EReferenceDescriptor.class, this, EmfindexPackage.RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS, EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR);
		}
		return eReferenceDescriptors;
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
			case EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((ContainerDescriptor)otherEnd, msgs);
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEObjectDescriptors()).basicAdd(otherEnd, msgs);
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEReferenceDescriptors()).basicAdd(otherEnd, msgs);
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
			case EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER:
				return basicSetContainer(null, msgs);
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS:
				return ((InternalEList<?>)getEObjectDescriptors()).basicRemove(otherEnd, msgs);
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS:
				return ((InternalEList<?>)getEReferenceDescriptors()).basicRemove(otherEnd, msgs);
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
			case EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER:
				return eInternalContainer().eInverseRemove(this, EmfindexPackage.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS, ContainerDescriptor.class, msgs);
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
			case EmfindexPackage.RESOURCE_DESCRIPTOR__URI:
				return getURI();
			case EmfindexPackage.RESOURCE_DESCRIPTOR__INDEXED_VERSION:
				return getIndexedVersion();
			case EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER:
				return getContainer();
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS:
				return getEObjectDescriptors();
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS:
				return getEReferenceDescriptors();
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
			case EmfindexPackage.RESOURCE_DESCRIPTOR__URI:
				setURI((URI)newValue);
				return;
			case EmfindexPackage.RESOURCE_DESCRIPTOR__INDEXED_VERSION:
				setIndexedVersion((Long)newValue);
				return;
			case EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER:
				setContainer((ContainerDescriptor)newValue);
				return;
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS:
				getEObjectDescriptors().clear();
				getEObjectDescriptors().addAll((Collection<? extends EObjectDescriptor>)newValue);
				return;
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS:
				getEReferenceDescriptors().clear();
				getEReferenceDescriptors().addAll((Collection<? extends EReferenceDescriptor>)newValue);
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
			case EmfindexPackage.RESOURCE_DESCRIPTOR__URI:
				setURI(URI_EDEFAULT);
				return;
			case EmfindexPackage.RESOURCE_DESCRIPTOR__INDEXED_VERSION:
				setIndexedVersion(INDEXED_VERSION_EDEFAULT);
				return;
			case EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER:
				setContainer((ContainerDescriptor)null);
				return;
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS:
				getEObjectDescriptors().clear();
				return;
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS:
				getEReferenceDescriptors().clear();
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
			case EmfindexPackage.RESOURCE_DESCRIPTOR__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case EmfindexPackage.RESOURCE_DESCRIPTOR__INDEXED_VERSION:
				return indexedVersion != INDEXED_VERSION_EDEFAULT;
			case EmfindexPackage.RESOURCE_DESCRIPTOR__CONTAINER:
				return getContainer() != null;
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS:
				return eObjectDescriptors != null && !eObjectDescriptors.isEmpty();
			case EmfindexPackage.RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS:
				return eReferenceDescriptors != null && !eReferenceDescriptors.isEmpty();
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
		result.append(" (URI: ");
		result.append(uri);
		result.append(", indexedVersion: ");
		result.append(indexedVersion);
		result.append(')');
		return result.toString();
	}

} //ResourceDescriptorImpl
