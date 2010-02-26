/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model.impl;

import com.sap.tc.moin.repository.mmi.Model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.Model.ModelPackage;
import com.sap.tc.moin.repository.mmi.Model.Reference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.impl.ReferenceImpl#getExposedEnd <em>Exposed End</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.impl.ReferenceImpl#getReferencedEnd <em>Referenced End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends StructuralFeatureImpl implements Reference {
	/**
	 * The cached value of the '{@link #getExposedEnd() <em>Exposed End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExposedEnd()
	 * @generated
	 * @ordered
	 */
	protected AssociationEnd exposedEnd;

	/**
	 * The cached value of the '{@link #getReferencedEnd() <em>Referenced End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedEnd()
	 * @generated
	 * @ordered
	 */
	protected AssociationEnd referencedEnd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd getExposedEnd() {
		if (exposedEnd != null && exposedEnd.eIsProxy()) {
			InternalEObject oldExposedEnd = (InternalEObject)exposedEnd;
			exposedEnd = (AssociationEnd)eResolveProxy(oldExposedEnd);
			if (exposedEnd != oldExposedEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.REFERENCE__EXPOSED_END, oldExposedEnd, exposedEnd));
			}
		}
		return exposedEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd basicGetExposedEnd() {
		return exposedEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExposedEnd(AssociationEnd newExposedEnd) {
		AssociationEnd oldExposedEnd = exposedEnd;
		exposedEnd = newExposedEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REFERENCE__EXPOSED_END, oldExposedEnd, exposedEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd getReferencedEnd() {
		if (referencedEnd != null && referencedEnd.eIsProxy()) {
			InternalEObject oldReferencedEnd = (InternalEObject)referencedEnd;
			referencedEnd = (AssociationEnd)eResolveProxy(oldReferencedEnd);
			if (referencedEnd != oldReferencedEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.REFERENCE__REFERENCED_END, oldReferencedEnd, referencedEnd));
			}
		}
		return referencedEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd basicGetReferencedEnd() {
		return referencedEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedEnd(AssociationEnd newReferencedEnd) {
		AssociationEnd oldReferencedEnd = referencedEnd;
		referencedEnd = newReferencedEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REFERENCE__REFERENCED_END, oldReferencedEnd, referencedEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.REFERENCE__EXPOSED_END:
				if (resolve) return getExposedEnd();
				return basicGetExposedEnd();
			case ModelPackage.REFERENCE__REFERENCED_END:
				if (resolve) return getReferencedEnd();
				return basicGetReferencedEnd();
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
			case ModelPackage.REFERENCE__EXPOSED_END:
				setExposedEnd((AssociationEnd)newValue);
				return;
			case ModelPackage.REFERENCE__REFERENCED_END:
				setReferencedEnd((AssociationEnd)newValue);
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
			case ModelPackage.REFERENCE__EXPOSED_END:
				setExposedEnd((AssociationEnd)null);
				return;
			case ModelPackage.REFERENCE__REFERENCED_END:
				setReferencedEnd((AssociationEnd)null);
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
			case ModelPackage.REFERENCE__EXPOSED_END:
				return exposedEnd != null;
			case ModelPackage.REFERENCE__REFERENCED_END:
				return referencedEnd != null;
		}
		return super.eIsSet(featureID);
	}

} //ReferenceImpl
