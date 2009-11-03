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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.oslo.ocl20.semantics.bridge.BridgePackage;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.DefinedClass;
import org.oslo.ocl20.semantics.bridge.DefinedOperation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Defined Operation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.DefinedOperationImpl#getClass_ <em>Class</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.DefinedOperationImpl#getRaisedException <em>
 * Raised Exception</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DefinedOperationImpl extends OperationImpl implements DefinedOperation {
	/**
	 * The cached value of the '{@link #getRaisedException() <em>Raised Exception</em>}' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRaisedException()
	 * @generated
	 * @ordered
	 */
	protected EList raisedException;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DefinedOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return BridgePackage.Literals.DEFINED_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefinedClass getClass_() {
		if (eContainerFeatureID != BridgePackage.DEFINED_OPERATION__CLASS)
			return null;
		return (DefinedClass) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetClass(DefinedClass newClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newClass, BridgePackage.DEFINED_OPERATION__CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setClass(DefinedClass newClass) {
		if (newClass != eInternalContainer()
		        || (eContainerFeatureID != BridgePackage.DEFINED_OPERATION__CLASS && newClass != null)) {
			if (EcoreUtil.isAncestor(this, newClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newClass != null)
				msgs = ((InternalEObject) newClass).eInverseAdd(this, BridgePackage.DEFINED_CLASS__OWNED_OPERATION,
				    DefinedClass.class, msgs);
			msgs = basicSetClass(newClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BridgePackage.DEFINED_OPERATION__CLASS, newClass,
			    newClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getRaisedException() {
		if (raisedException == null) {
			raisedException = new EObjectResolvingEList(Classifier.class, this,
			    BridgePackage.DEFINED_OPERATION__RAISED_EXCEPTION);
		}
		return raisedException;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BridgePackage.DEFINED_OPERATION__CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetClass((DefinedClass) otherEnd, msgs);
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
			case BridgePackage.DEFINED_OPERATION__CLASS:
				return basicSetClass(null, msgs);
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
			case BridgePackage.DEFINED_OPERATION__CLASS:
				return eInternalContainer().eInverseRemove(this, BridgePackage.DEFINED_CLASS__OWNED_OPERATION,
				    DefinedClass.class, msgs);
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
			case BridgePackage.DEFINED_OPERATION__CLASS:
				return getClass_();
			case BridgePackage.DEFINED_OPERATION__RAISED_EXCEPTION:
				return getRaisedException();
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
			case BridgePackage.DEFINED_OPERATION__CLASS:
				setClass((DefinedClass) newValue);
				return;
			case BridgePackage.DEFINED_OPERATION__RAISED_EXCEPTION:
				getRaisedException().clear();
				getRaisedException().addAll((Collection) newValue);
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
			case BridgePackage.DEFINED_OPERATION__CLASS:
				setClass((DefinedClass) null);
				return;
			case BridgePackage.DEFINED_OPERATION__RAISED_EXCEPTION:
				getRaisedException().clear();
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
			case BridgePackage.DEFINED_OPERATION__CLASS:
				return getClass_() != null;
			case BridgePackage.DEFINED_OPERATION__RAISED_EXCEPTION:
				return raisedException != null && !raisedException.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // DefinedOperationImpl
