/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.impl;

import abapmapping.AbapClassImplementationAnnotation;
import abapmapping.AbapClassKind;
import abapmapping.AbapmappingPackage;

import abapmapping.abapdictionary.AbapType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abap Class Implementation Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link abapmapping.impl.AbapClassImplementationAnnotationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link abapmapping.impl.AbapClassImplementationAnnotationImpl#getAbapType <em>Abap Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbapClassImplementationAnnotationImpl extends EObjectImpl implements AbapClassImplementationAnnotation {
	/**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected static final AbapClassKind KIND_EDEFAULT = AbapClassKind.BO_AND_ROOT_NODE;

	/**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected AbapClassKind kind = KIND_EDEFAULT;

	/**
     * The cached value of the '{@link #getAbapType() <em>Abap Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAbapType()
     * @generated
     * @ordered
     */
	protected AbapType abapType;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AbapClassImplementationAnnotationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AbapmappingPackage.Literals.ABAP_CLASS_IMPLEMENTATION_ANNOTATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapClassKind getKind() {
        return kind;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setKind(AbapClassKind newKind) {
        AbapClassKind oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__KIND, oldKind, kind));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapType getAbapType() {
        if (abapType != null && abapType.eIsProxy()) {
            InternalEObject oldAbapType = (InternalEObject)abapType;
            abapType = (AbapType)eResolveProxy(oldAbapType);
            if (abapType != oldAbapType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__ABAP_TYPE, oldAbapType, abapType));
            }
        }
        return abapType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapType basicGetAbapType() {
        return abapType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAbapType(AbapType newAbapType) {
        AbapType oldAbapType = abapType;
        abapType = newAbapType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__ABAP_TYPE, oldAbapType, abapType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__KIND:
                return getKind();
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__ABAP_TYPE:
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
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__KIND:
                setKind((AbapClassKind)newValue);
                return;
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__ABAP_TYPE:
                setAbapType((AbapType)newValue);
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
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__KIND:
                setKind(KIND_EDEFAULT);
                return;
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__ABAP_TYPE:
                setAbapType((AbapType)null);
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
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__KIND:
                return kind != KIND_EDEFAULT;
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION__ABAP_TYPE:
                return abapType != null;
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
        result.append(" (kind: ");
        result.append(kind);
        result.append(')');
        return result.toString();
    }

} //AbapClassImplementationAnnotationImpl
