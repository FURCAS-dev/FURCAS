/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.NativeImpl;
import data.classes.PlatformSpecificImplementation;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Native Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.NativeImplImpl#getPlatformSpecificImplementaiton <em>Platform Specific Implementaiton</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NativeImplImpl extends SignatureImplementationImpl implements NativeImpl {
	/**
     * The cached value of the '{@link #getPlatformSpecificImplementaiton() <em>Platform Specific Implementaiton</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPlatformSpecificImplementaiton()
     * @generated
     * @ordered
     */
	protected EList<PlatformSpecificImplementation> platformSpecificImplementaiton;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NativeImplImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.NATIVE_IMPL;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PlatformSpecificImplementation> getPlatformSpecificImplementaiton() {
        if (platformSpecificImplementaiton == null) {
            platformSpecificImplementaiton = new EObjectContainmentEList.Resolving<PlatformSpecificImplementation>(PlatformSpecificImplementation.class, this, ClassesPackage.NATIVE_IMPL__PLATFORM_SPECIFIC_IMPLEMENTAITON);
        }
        return platformSpecificImplementaiton;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ClassesPackage.NATIVE_IMPL__PLATFORM_SPECIFIC_IMPLEMENTAITON:
                return ((InternalEList<?>)getPlatformSpecificImplementaiton()).basicRemove(otherEnd, msgs);
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
            case ClassesPackage.NATIVE_IMPL__PLATFORM_SPECIFIC_IMPLEMENTAITON:
                return getPlatformSpecificImplementaiton();
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
            case ClassesPackage.NATIVE_IMPL__PLATFORM_SPECIFIC_IMPLEMENTAITON:
                getPlatformSpecificImplementaiton().clear();
                getPlatformSpecificImplementaiton().addAll((Collection<? extends PlatformSpecificImplementation>)newValue);
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
            case ClassesPackage.NATIVE_IMPL__PLATFORM_SPECIFIC_IMPLEMENTAITON:
                getPlatformSpecificImplementaiton().clear();
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
            case ClassesPackage.NATIVE_IMPL__PLATFORM_SPECIFIC_IMPLEMENTAITON:
                return platformSpecificImplementaiton != null && !platformSpecificImplementaiton.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //NativeImplImpl
