/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataElementImpl.java,v 1.1 2011/02/07 16:43:30 auhl Exp $
 */
package abapmapping.abapdictionary.impl;

import abapmapping.abapdictionary.AbapPrimtiveType;
import abapmapping.abapdictionary.AbapdictionaryPackage;
import abapmapping.abapdictionary.DataElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.impl.DataElementImpl#getAbapType <em>Abap Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataElementImpl extends UnstructuredAbapTypeImpl implements DataElement {
	/**
     * The cached value of the '{@link #getAbapType() <em>Abap Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAbapType()
     * @generated
     * @ordered
     */
	protected AbapPrimtiveType abapType;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DataElementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AbapdictionaryPackage.Literals.DATA_ELEMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapPrimtiveType getAbapType() {
        if (abapType != null && abapType.eIsProxy()) {
            InternalEObject oldAbapType = (InternalEObject)abapType;
            abapType = (AbapPrimtiveType)eResolveProxy(oldAbapType);
            if (abapType != oldAbapType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AbapdictionaryPackage.DATA_ELEMENT__ABAP_TYPE, oldAbapType, abapType));
            }
        }
        return abapType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapPrimtiveType basicGetAbapType() {
        return abapType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAbapType(AbapPrimtiveType newAbapType) {
        AbapPrimtiveType oldAbapType = abapType;
        abapType = newAbapType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.DATA_ELEMENT__ABAP_TYPE, oldAbapType, abapType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case AbapdictionaryPackage.DATA_ELEMENT__ABAP_TYPE:
                if (resolve) return getAbapType();
                return basicGetAbapType();
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
            case AbapdictionaryPackage.DATA_ELEMENT__ABAP_TYPE:
                setAbapType((AbapPrimtiveType)newValue);
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
            case AbapdictionaryPackage.DATA_ELEMENT__ABAP_TYPE:
                setAbapType((AbapPrimtiveType)null);
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
            case AbapdictionaryPackage.DATA_ELEMENT__ABAP_TYPE:
                return abapType != null;
        }
        return super.eIsSet(featureID);
    }

} //DataElementImpl
