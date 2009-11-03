/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.BridgePackage;
import org.oslo.ocl20.semantics.bridge.DefinedClass;
import org.oslo.ocl20.semantics.bridge.DefinedOperation;
import org.oslo.ocl20.semantics.bridge.DefinedPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Defined Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.DefinedClassImpl#getOwnedOperation <em>Owned
 * Operation</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.DefinedClassImpl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DefinedClassImpl extends ClassifierImpl implements DefinedClass {
	/**
	 * The cached value of the '{@link #getOwnedOperation() <em>Owned Operation</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOwnedOperation()
	 * @generated
	 * @ordered
	 */
	protected EList ownedOperation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DefinedClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return BridgePackage.Literals.DEFINED_CLASS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getOwnedOperation() {
		if (ownedOperation == null) {
			ownedOperation = new EObjectContainmentWithInverseEList(DefinedOperation.class, this,
			    BridgePackage.DEFINED_CLASS__OWNED_OPERATION, BridgePackage.DEFINED_OPERATION__CLASS);
		}
		return ownedOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefinedPackage getPackage() {
		if (eContainerFeatureID != BridgePackage.DEFINED_CLASS__PACKAGE)
			return null;
		return (DefinedPackage) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPackage(DefinedPackage newPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newPackage, BridgePackage.DEFINED_CLASS__PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPackage(DefinedPackage newPackage) {
		if (newPackage != eInternalContainer()
		        || (eContainerFeatureID != BridgePackage.DEFINED_CLASS__PACKAGE && newPackage != null)) {
			if (EcoreUtil.isAncestor(this, newPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPackage != null)
				msgs = ((InternalEObject) newPackage).eInverseAdd(this, BridgePackage.DEFINED_PACKAGE__OWNED_TYPE,
				    DefinedPackage.class, msgs);
			msgs = basicSetPackage(newPackage, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BridgePackage.DEFINED_CLASS__PACKAGE, newPackage,
			    newPackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((OclVisitor) visitor).visit(this, data);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BridgePackage.DEFINED_CLASS__OWNED_OPERATION:
				return ((InternalEList) getOwnedOperation()).basicAdd(otherEnd, msgs);
			case BridgePackage.DEFINED_CLASS__PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackage((DefinedPackage) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BridgePackage.DEFINED_CLASS__OWNED_OPERATION:
				return ((InternalEList) getOwnedOperation()).basicRemove(otherEnd, msgs);
			case BridgePackage.DEFINED_CLASS__PACKAGE:
				return basicSetPackage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case BridgePackage.DEFINED_CLASS__PACKAGE:
				return eInternalContainer().eInverseRemove(this, BridgePackage.DEFINED_PACKAGE__OWNED_TYPE,
				    DefinedPackage.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BridgePackage.DEFINED_CLASS__OWNED_OPERATION:
				return getOwnedOperation();
			case BridgePackage.DEFINED_CLASS__PACKAGE:
				return getPackage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BridgePackage.DEFINED_CLASS__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection) newValue);
				return;
			case BridgePackage.DEFINED_CLASS__PACKAGE:
				setPackage((DefinedPackage) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case BridgePackage.DEFINED_CLASS__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case BridgePackage.DEFINED_CLASS__PACKAGE:
				setPackage((DefinedPackage) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BridgePackage.DEFINED_CLASS__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case BridgePackage.DEFINED_CLASS__PACKAGE:
				return getPackage() != null;
		}
		return super.eIsSet(featureID);
	}

} // DefinedClassImpl
