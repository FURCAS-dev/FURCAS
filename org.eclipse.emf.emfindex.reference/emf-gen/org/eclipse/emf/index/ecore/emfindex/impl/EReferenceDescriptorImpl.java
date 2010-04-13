/**
 * <copyright>
 * </copyright>
 *
 * $Id: EReferenceDescriptorImpl.java,v 1.1 2009/09/30 13:04:49 jkohnlein Exp $
 */
package org.eclipse.emf.index.ecore.emfindex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;

import org.eclipse.emf.index.ecore.emfindex.EmfindexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EReference Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl#getSourceFragment <em>Source Fragment</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl#getEReference <em>EReference</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl#getTargetFragment <em>Target Fragment</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl#getTargetResourceURI <em>Target Resource URI</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl#getTargetEObjectDescriptor <em>Target EObject Descriptor</em>}</li>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl#getSourceResourceDescriptor <em>Source Resource Descriptor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EReferenceDescriptorImpl extends AbstractBaseDescriptorImpl implements EReferenceDescriptor {
	/**
	 * The default value of the '{@link #getSourceFragment() <em>Source Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFragment()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_FRAGMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceFragment() <em>Source Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFragment()
	 * @generated
	 * @ordered
	 */
	protected String sourceFragment = SOURCE_FRAGMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEReference() <em>EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference()
	 * @generated
	 * @ordered
	 */
	protected EReference eReference;

	/**
	 * The default value of the '{@link #getTargetFragment() <em>Target Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFragment()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_FRAGMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetFragment() <em>Target Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFragment()
	 * @generated
	 * @ordered
	 */
	protected String targetFragment = TARGET_FRAGMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetResourceURI() <em>Target Resource URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetResourceURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI TARGET_RESOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetResourceURI() <em>Target Resource URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetResourceURI()
	 * @generated
	 * @ordered
	 */
	protected URI targetResourceURI = TARGET_RESOURCE_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetEObjectDescriptor() <em>Target EObject Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEObjectDescriptor()
	 * @generated
	 * @ordered
	 */
	protected EObjectDescriptor targetEObjectDescriptor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EReferenceDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfindexPackage.Literals.EREFERENCE_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceFragment() {
		return sourceFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceFragment(String newSourceFragment) {
		String oldSourceFragment = sourceFragment;
		sourceFragment = newSourceFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_FRAGMENT, oldSourceFragment, sourceFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEReference() {
		if (eReference != null && eReference.eIsProxy()) {
			InternalEObject oldEReference = (InternalEObject)eReference;
			eReference = (EReference)eResolveProxy(oldEReference);
			if (eReference != oldEReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfindexPackage.EREFERENCE_DESCRIPTOR__EREFERENCE, oldEReference, eReference));
			}
		}
		return eReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetEReference() {
		return eReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference(EReference newEReference) {
		EReference oldEReference = eReference;
		eReference = newEReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.EREFERENCE_DESCRIPTOR__EREFERENCE, oldEReference, eReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetFragment() {
		return targetFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetFragment(String newTargetFragment) {
		String oldTargetFragment = targetFragment;
		targetFragment = newTargetFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_FRAGMENT, oldTargetFragment, targetFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getTargetResourceURI() {
		return targetResourceURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetResourceURI(URI newTargetResourceURI) {
		URI oldTargetResourceURI = targetResourceURI;
		targetResourceURI = newTargetResourceURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_RESOURCE_URI, oldTargetResourceURI, targetResourceURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectDescriptor getTargetEObjectDescriptor() {
		if (targetEObjectDescriptor != null && ((EObject)targetEObjectDescriptor).eIsProxy()) {
			InternalEObject oldTargetEObjectDescriptor = (InternalEObject)targetEObjectDescriptor;
			targetEObjectDescriptor = (EObjectDescriptor)eResolveProxy(oldTargetEObjectDescriptor);
			if (targetEObjectDescriptor != oldTargetEObjectDescriptor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_EOBJECT_DESCRIPTOR, oldTargetEObjectDescriptor, targetEObjectDescriptor));
			}
		}
		return targetEObjectDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectDescriptor basicGetTargetEObjectDescriptor() {
		return targetEObjectDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetEObjectDescriptor(EObjectDescriptor newTargetEObjectDescriptor) {
		EObjectDescriptor oldTargetEObjectDescriptor = targetEObjectDescriptor;
		targetEObjectDescriptor = newTargetEObjectDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_EOBJECT_DESCRIPTOR, oldTargetEObjectDescriptor, targetEObjectDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDescriptor getSourceResourceDescriptor() {
		if (eContainerFeatureID() != EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR) return null;
		return (ResourceDescriptor)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceResourceDescriptor(ResourceDescriptor newSourceResourceDescriptor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSourceResourceDescriptor, EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceResourceDescriptor(ResourceDescriptor newSourceResourceDescriptor) {
		if (newSourceResourceDescriptor != eInternalContainer() || (eContainerFeatureID() != EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR && newSourceResourceDescriptor != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newSourceResourceDescriptor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSourceResourceDescriptor != null)
				msgs = ((InternalEObject)newSourceResourceDescriptor).eInverseAdd(this, EmfindexPackage.RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS, ResourceDescriptor.class, msgs);
			msgs = basicSetSourceResourceDescriptor(newSourceResourceDescriptor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR, newSourceResourceDescriptor, newSourceResourceDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getTargetFragmentURI() {
		return getTargetResourceURI().appendFragment(targetFragment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getSourceFragmentURI() {
		return getSourceResourceDescriptor().getURI().appendFragment(sourceFragment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSourceResourceDescriptor((ResourceDescriptor)otherEnd, msgs);
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
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR:
				return basicSetSourceResourceDescriptor(null, msgs);
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
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR:
				return eInternalContainer().eInverseRemove(this, EmfindexPackage.RESOURCE_DESCRIPTOR__EREFERENCE_DESCRIPTORS, ResourceDescriptor.class, msgs);
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
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_FRAGMENT:
				return getSourceFragment();
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__EREFERENCE:
				if (resolve) return getEReference();
				return basicGetEReference();
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_FRAGMENT:
				return getTargetFragment();
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_RESOURCE_URI:
				return getTargetResourceURI();
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_EOBJECT_DESCRIPTOR:
				if (resolve) return getTargetEObjectDescriptor();
				return basicGetTargetEObjectDescriptor();
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR:
				return getSourceResourceDescriptor();
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
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_FRAGMENT:
				setSourceFragment((String)newValue);
				return;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__EREFERENCE:
				setEReference((EReference)newValue);
				return;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_FRAGMENT:
				setTargetFragment((String)newValue);
				return;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_RESOURCE_URI:
				setTargetResourceURI((URI)newValue);
				return;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_EOBJECT_DESCRIPTOR:
				setTargetEObjectDescriptor((EObjectDescriptor)newValue);
				return;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR:
				setSourceResourceDescriptor((ResourceDescriptor)newValue);
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
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_FRAGMENT:
				setSourceFragment(SOURCE_FRAGMENT_EDEFAULT);
				return;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__EREFERENCE:
				setEReference((EReference)null);
				return;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_FRAGMENT:
				setTargetFragment(TARGET_FRAGMENT_EDEFAULT);
				return;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_RESOURCE_URI:
				setTargetResourceURI(TARGET_RESOURCE_URI_EDEFAULT);
				return;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_EOBJECT_DESCRIPTOR:
				setTargetEObjectDescriptor((EObjectDescriptor)null);
				return;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR:
				setSourceResourceDescriptor((ResourceDescriptor)null);
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
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_FRAGMENT:
				return SOURCE_FRAGMENT_EDEFAULT == null ? sourceFragment != null : !SOURCE_FRAGMENT_EDEFAULT.equals(sourceFragment);
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__EREFERENCE:
				return eReference != null;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_FRAGMENT:
				return TARGET_FRAGMENT_EDEFAULT == null ? targetFragment != null : !TARGET_FRAGMENT_EDEFAULT.equals(targetFragment);
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_RESOURCE_URI:
				return TARGET_RESOURCE_URI_EDEFAULT == null ? targetResourceURI != null : !TARGET_RESOURCE_URI_EDEFAULT.equals(targetResourceURI);
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__TARGET_EOBJECT_DESCRIPTOR:
				return targetEObjectDescriptor != null;
			case EmfindexPackage.EREFERENCE_DESCRIPTOR__SOURCE_RESOURCE_DESCRIPTOR:
				return getSourceResourceDescriptor() != null;
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
		result.append(" (sourceFragment: ");
		result.append(sourceFragment);
		result.append(", targetFragment: ");
		result.append(targetFragment);
		result.append(", targetResourceURI: ");
		result.append(targetResourceURI);
		result.append(')');
		return result.toString();
	}

} //EReferenceDescriptorImpl
